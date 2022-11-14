/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.bookingRequest.BookingRequestDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class AdminUpdateBookingRequestServlet extends HttpServlet {

    private final String ADMIN_SHOW_LIST_BOOKING_REQUEST = "adminShowListBookingRequest";

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
        //GET SITEMAP
        Properties siteMap = (Properties) request.getServletContext().getAttribute("SITE_MAP");
        //getRequest Parameter
        int request_Id = Integer.parseInt(request.getParameter("txtHiddenRequest_Id"));
        String name_Book = request.getParameter("txtName_Book");
        int quantity_Request = Integer.parseInt(request.getParameter("txtQuantity_Request"));
        float price_Request = Float.parseFloat(request.getParameter("txtPrice_Request"));
        String note = request.getParameter("txtNote");
        int status_Book = Integer.parseInt(request.getParameter("txtStatus"));
        int status = Integer.parseInt(request.getParameter("status"));
        String url = siteMap.getProperty(ADMIN_SHOW_LIST_BOOKING_REQUEST);

        try {
            BookingRequestDAO dao = new BookingRequestDAO();
            dao.updateBookingRequest(request_Id, name_Book,quantity_Request, price_Request, note, status_Book,status);
            request.setAttribute("UPDATE_BOOKING_REQUEST_MSG", "Update Booking Request of:  " + name_Book + " Success");
        } catch (SQLException e) {
            log("Booking Update Servlet _ SQLException_ " + e.getMessage());
        } catch (NamingException e) {
            log("Booking Update Servlet _ NamingException_ " + e.getMessage());
        } finally {
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
