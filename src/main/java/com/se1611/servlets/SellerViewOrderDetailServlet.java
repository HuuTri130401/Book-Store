/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.category.CategoryDAO;
import com.se1611.category.CategoryDTO;
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

/**
 *
 * @author chilamha
 */
@WebServlet(name = "SellerViewOrderDetailServlet", urlPatterns = {"/SellerViewOrderDetailServlet"})
public class SellerViewOrderDetailServlet extends HttpServlet {

    private final String ORDER_DETAILS_PAGE = "sellerOrderDetailPage";
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
        String url = ERROR_PAGE;
        String id = request.getParameter("orderId");
        int orderID=0;
        if (id!=null && !id.isEmpty()){
            orderID=Integer.parseInt(id);
        }
        try {
            OrderDAO orderDAO = new OrderDAO();
            
            //get order
            OrderDTO order = orderDAO.getOrderByOrderId(orderID);
            
            //get order details
            OrderDetailDAO orderDetDAO = new OrderDetailDAO();
            int orderId = order.getOrder_Id();
            order.setDetails(orderDetDAO.getOrderDetailsByOrderID(orderId));
            request.setAttribute("ORDER", order);
            
            CategoryDAO categoryDao = new CategoryDAO();
            categoryDao.getAllCategory();
            List<CategoryDTO> categoryDto = categoryDao.getCateList();
            if(categoryDto != null){
                request.setAttribute("BOOK_CATEGORY", categoryDto);
            }
            
            url = ORDER_DETAILS_PAGE;
        } catch (SQLException ex) {
          log("SellerViewOrderDetailServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
          log("SellerViewOrderDetailServlet_NamingException: " + ex.getMessage());
        }
        finally {
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
