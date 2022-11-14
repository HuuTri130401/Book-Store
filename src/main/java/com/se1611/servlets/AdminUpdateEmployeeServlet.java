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
public class AdminUpdateEmployeeServlet extends HttpServlet {

    private final String ADMIN_SHOW_LIST_EMPLOYEES = "adminShowListEmployees";

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
        int employee_Id = Integer.parseInt(request.getParameter("txtHiddenEmployee_Id"));
        String account_Id = request.getParameter("txtHiddenAccount_Id");
        String password = request.getParameter("txtPassword");
        String fullName = request.getParameter("txtFullName");
        String phone = request.getParameter("txtPhone");
        String address = request.getParameter("txtAddress");
        String gender = request.getParameter("txtGender");
        String role = request.getParameter("txtRole");
        boolean status_Employee = Boolean.parseBoolean(request.getParameter("txtStatus_Employee"));

        String url = siteMap.getProperty(ADMIN_SHOW_LIST_EMPLOYEES);

        try {
            CreateEmployeeError employeeErrors = new CreateEmployeeError();
            EmployeeDAO employeeDAO = new EmployeeDAO();
            //Hashing pass
            password = HashingPass(password);
            int count = String.valueOf(phone).length();
            if (count < 10 || count > 11) {
                employeeErrors.setPhoneError("Phone length has [10 or 11] chars");
                request.setAttribute("ERROR_UPDATE_EMPLOYEE_MSG", employeeErrors.getPhoneError());
                url = ADMIN_SHOW_LIST_EMPLOYEES;
            } else {
                boolean createEmployee = employeeDAO.updateEmployeeAccount(employee_Id, account_Id, password, fullName, phone, address, gender, role, status_Employee);
                if (createEmployee) {
                    request.setAttribute("UPDATE_EMPLOYEE_MSG", "Update Employee " + fullName + " Success");
                    url = ADMIN_SHOW_LIST_EMPLOYEES;
                }
            }
        } catch (SQLException e) {
            log("Account Update Servlet _ SQLException_ " + e.getMessage());
        } catch (NamingException | NoSuchAlgorithmException e) {
            log("Account Update Servlet _ NamingException_ " + e.getMessage());
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
