/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.employees.EmployeeDAO;
import com.se1611.employees.EmployeeDTO;
import java.io.IOException;
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
import com.se1611.orderDetail.OrderDetailDAO;
import com.se1611.orderDetail.OrderDetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AuthLoginServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalidPage";
    private final String ADMIN_MANAGE_BOOKS_PAGE = "adminManageInforDashboard";
    private final String STAFF_NODIFY_PAGE = "staffNodifyPage";
    private final String SELLER_NOTIFY_PAGE = "sellerNotifyPage";
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
        String url = INVALID_PAGE;
        //get request parameters
        String userId = request.getParameter("txtAccountId");
        String password = request.getParameter("txtPassword");

        try {
            EmployeeDAO dao = new EmployeeDAO();
            EmployeeDTO validEmployee = dao.getAccountByAccoutIdAndPassword(userId, password);
            if (validEmployee != null) {
                if (validEmployee.getRole().equalsIgnoreCase("admin")) {
                    url = ADMIN_MANAGE_BOOKS_PAGE;
                    //create new session
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", validEmployee);
                } else if(validEmployee.getRole().equalsIgnoreCase("staff")) {
                    //login staff screen
                    url = STAFF_NODIFY_PAGE;
                    //create new session
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", validEmployee);
                    session.setAttribute("role",validEmployee.getRole().toUpperCase(Locale.ROOT));
                    session.setAttribute("employee_Id",validEmployee.getEmployee_Id());
                } else if (validEmployee.getRole().equalsIgnoreCase("seller")) {
                    //login seller screen
                    url = SELLER_NOTIFY_PAGE;
                    //create new session
                    HttpSession session = request.getSession(true);
                    session.setAttribute("USER", validEmployee);
                    session.setAttribute("role", validEmployee.getRole().toUpperCase(Locale.ROOT));
                    session.setAttribute("employee_Id", validEmployee.getEmployee_Id());
                    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                    ArrayList<OrderDetailDTO> listOrderDetail = orderDetailDAO.getListOrderDetail();
                    session.setAttribute("LIST_ORDER_DETAIL", listOrderDetail);
                }
            }//end if validAccount is not null
        } catch (SQLException e) {
            log("EmployeeLoginServlet _ SQL_" + e.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger(AuthLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(url);
        }
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
