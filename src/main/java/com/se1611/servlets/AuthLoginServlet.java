/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.employees.EmployeeDAO;
import com.se1611.employees.EmployeeDTO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class AuthLoginServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalidPage";
    private final String LOGIN_PAGE = "loginPage";
    private final String ADMIN_MANAGE_BOOKS_PAGE = "adminManageInforDashboard";
    private final String STAFF_NODIFY_PAGE = "staffNodifyPage";
    private final String SELLER_NODIFY_PAGE = "sellerNodifyPage";

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
        request.setCharacterEncoding("utf-8");
        String url = LOGIN_PAGE;
        //get request parameters
        HttpSession sessionLoginFailed=request.getSession();
        String userId = request.getParameter("txtAccountId");
        String password = request.getParameter("txtPassword");
        int count = Integer.parseInt(request.getParameter("countLogin"));
        sessionLoginFailed.setAttribute("countLogin",count);
        try {
            EmployeeDAO dao = new EmployeeDAO();
            //Hashing password
            password=HashingPass(password);
            //Get Account
            EmployeeDTO validEmployee = dao.getAccountByAccoutIdAndPassword(userId, password);
            if (validEmployee != null) {
                if (validEmployee.getRole().equalsIgnoreCase("admin")) {
                    url = ADMIN_MANAGE_BOOKS_PAGE;
                    //create new session
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", validEmployee);
                } else if(validEmployee.getRole().equalsIgnoreCase("staff") && validEmployee.isStatus_Employee() == true) {
                    //login staff screen
                    url = STAFF_NODIFY_PAGE;
                    //create new session
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", validEmployee);
                    session.setAttribute("employee_Id",validEmployee.getEmployee_Id());
                } else if(validEmployee.getRole().equalsIgnoreCase("seller") && validEmployee.isStatus_Employee() == true) {
                    //login seller screen
                    url = SELLER_NODIFY_PAGE;
                    //create new session
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", validEmployee);
                    session.setAttribute("employee_Id",validEmployee.getEmployee_Id());
                } else if(validEmployee.isStatus_Employee() == false){
                    url = INVALID_PAGE;
                    response.sendRedirect(url);
                }
            }//end if validAccount is not null
        } catch (SQLException | NoSuchAlgorithmException e) {
            log("EmployeeLoginServlet _ SQL_" + e.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(AuthLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(url);
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
