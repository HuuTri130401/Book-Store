/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.bookingRequest.BookingRequestDAO;
import com.se1611.bookingRequest.BookingRequestError;
import java.io.IOException;
import java.sql.Date;
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
public class AdminCreateBookingRequestServlet extends HttpServlet {

    private final String ADMIN_MANAGE_LIST_BOOK_REQUEST = "adminShowListBookingRequest";
    private final String ADMIN_CREATE_BOOK_REQUEST = "adminCreateBookRequestPage";

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
        //GET SITEMAP
        Properties siteMap = (Properties) request.getServletContext().getAttribute("SITE_MAP");
        //getRequest Parameter
        String image = request.getParameter("imgImage");
        String name_Book = request.getParameter("txtBookName");
        int quantity_Request = Integer.parseInt(request.getParameter("txtQuantityBook"));
        float price_Request = Float.parseFloat(request.getParameter("txtPrice"));
        LocalDate date_Request = LocalDate.now();
        String note = request.getParameter("txtNote");
        int status = Integer.parseInt(request.getParameter("radioStatus"));
        boolean status_Book_Request = Boolean.parseBoolean(request.getParameter("radioStatusBook"));

        String url = siteMap.getProperty(ADMIN_CREATE_BOOK_REQUEST);
        boolean errFound = true;

        BookingRequestError bookingErrors = new BookingRequestError();
        try {
            if (quantity_Request < 10 || quantity_Request > 400) {
                errFound = false;
                bookingErrors.setQuantity_RequestError("Quantity must between [10..400] !");
                request.setAttribute("ERROR_INSERT_QUANTITY_BOOKING_MSG", bookingErrors.getQuantity_RequestError());
            }
            if (price_Request < 0) {
                errFound = false;
                bookingErrors.setPrice_RequestError("Price must be > 0 !");
                request.setAttribute("ERROR_INSERT_PRICE_BOOKING_MSG", bookingErrors.getPrice_RequestError());
            }
            if (errFound) {
                BookingRequestDAO bookRequestDAO = new BookingRequestDAO();

                boolean createBookRequest = bookRequestDAO.addNewBookingRequest(image, name_Book, quantity_Request, price_Request, date_Request, note, status, status_Book_Request);
                if (createBookRequest) {
                    url = ADMIN_MANAGE_LIST_BOOK_REQUEST;
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
            } else {
                url = ADMIN_CREATE_BOOK_REQUEST;
                //bookError.setMessageError("Can not Create New Book !");
                request.setAttribute("BOOK_REQUEST_ERROR", "Can not Create New Book Request !");
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            log("AccountCreateNewBookRequest Servlet _ SQLException_ " + e.getMessage());
        } catch (NamingException e) {
            log("AccountCreateNewBookRequest Servlet _ NamingException_ " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            log("AccountCreateNewBookRequest Servlet _ ClassNotFoundException_ " + ex.getMessage());
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
