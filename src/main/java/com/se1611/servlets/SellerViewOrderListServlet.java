/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.category.CategoryDAO;
import com.se1611.category.CategoryDTO;
import com.se1611.employees.EmployeeDTO;
import com.se1611.orderDetail.CustomizedOrderDetailDTO;
import com.se1611.orderDetail.OrderDetailDAO;
import com.se1611.orders.OrderDAO;
import com.se1611.orders.OrderDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chilamha
 */
@WebServlet(name = "SellerViewOrderListServlet", urlPatterns = {"/SellerViewOrderListServlet"})
public class SellerViewOrderListServlet extends HttpServlet {

    private final String ORDER_LIST_PAGE = "sellerOrderListPage";
    //private final String ORDER_LIST_PAGE = "temp.jsp";
    private final String ERROR_PAGE = "errorPage";
    
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
        
        HttpSession session = request.getSession(false);
        EmployeeDTO loggedin = (EmployeeDTO)session.getAttribute("USER");
        int empID=0;
        if (loggedin!=null){
            empID=loggedin.getEmployee_Id();
        }
        String url = ERROR_PAGE;
        try {
            OrderDAO orderDAO = new OrderDAO();
            List<OrderDTO> orderList = orderDAO.getOrderListByEmpID(empID);
            
            for(int i = 0; i < orderList.size(); ++i){
                OrderDetailDAO orderDetDAO = new OrderDetailDAO();
                int orderId = orderList.get(i).getOrder_Id();
                orderList.get(i).setDetails(orderDetDAO.getOrderDetailsByOrderID(orderId));
            }
            request.setAttribute("ORDERLIST", orderList);
            url = ORDER_LIST_PAGE;
        }
        catch(SQLException ex){
            log("SellerViewOrderListServlet_SQL: " + ex.getMessage());
        }
        catch(NamingException ex){
            log("SellerViewOrderListServlet_Naming: " + ex.getMessage());
        }
        finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
