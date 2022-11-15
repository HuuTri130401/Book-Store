/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.employees.CreateEmployeeError;
import com.se1611.employees.EmployeeDAO;
import com.se1611.employees.EmployeeDTO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AdminCreateNewEmployeeServlet extends HttpServlet {

    private final String ADMIN_MANAGE_LIST_EMPLOYEE = "adminShowListEmployees";
    private final String CREATE_NEW_EMPLOYEE = "adminCreateEmployeePage";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        //GET SITEMAP
        Properties siteMap = (Properties) request.getServletContext().getAttribute("SITE_MAP");
        //getRequest Parameter
        String account_Id = request.getParameter("txtAccountID");
        String password = request.getParameter("txtPassword");
        String confirmPassword = request.getParameter("txtConfirmPassword");
        String fullName = request.getParameter("txtFullName");
        String phone = request.getParameter("txtPhone");
        String address = request.getParameter("txtAddress");
        String gender = request.getParameter("radioGender");
        String role = request.getParameter("radioRole");
        boolean status_Employee = true;

        String url = siteMap.getProperty(CREATE_NEW_EMPLOYEE);
        try {
            CreateEmployeeError employeeErrors = new CreateEmployeeError();
            EmployeeDAO employeeDAO = new EmployeeDAO();
            boolean checkDuplicateAccountId = employeeDAO.checkAcoountDuplicate(account_Id);
            if (checkDuplicateAccountId) {
                employeeErrors.setAccount_IdError("Duplicate AccountID: " + account_Id + "!");
                request.setAttribute("ERROR_ACCOUNT_INSERT_EMPLOYEE_MSG", employeeErrors.getAccount_IdError());
                if (!confirmPassword.trim().equals(password.trim())) {
                    employeeErrors.setConfirmPasswordError("Confirm Password does not match Password");
                    request.setAttribute("ERROR_CONFIRM_INSERT_EMPLOYEE_MSG", employeeErrors.getConfirmPasswordError());
                }
                int count = String.valueOf(phone).length();
                if (count < 10 || count > 11) {
                    employeeErrors.setPhoneError("Phone length has [10 or 11] chars");
                    request.setAttribute("ERROR_PHONE_INSERT_EMPLOYEE_MSG", employeeErrors.getPhoneError());
                }
            } else {
                //Hashing pass
                password = HashingPass(password);
                EmployeeDTO employeeDTO = new EmployeeDTO(account_Id, password, fullName, phone, address, gender, role, status_Employee);
                boolean createEmployee = employeeDAO.addEmployeeAccount(employeeDTO);
                if (createEmployee) {
                    url = ADMIN_MANAGE_LIST_EMPLOYEE;
                    request.setAttribute("INSERT_EMPLOYEE_MSG", "Create New Employee Success !");
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
            }
        } catch (SQLException e) {
            log("Account Create New Employee Servlet _ SQLException_ " + e.getMessage());
        } catch (NamingException e) {
            log("Account Create New Employee Servlet _ NamingException_ " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            log("Account Create New Employee Servlet _ NoSuchAlgorithmException_ " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    protected String HashingPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashByte = md.digest(pass.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashByte) {
            //in theo hex String format,<2 se in số 0 bên phải
            sb.append(String.format("%02x", b));
        }
        pass = sb.toString();
        return pass;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
