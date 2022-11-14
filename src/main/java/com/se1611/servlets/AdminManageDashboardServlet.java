/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.book.BookDAO;
import com.se1611.book.BookDTO;
import com.se1611.bookingRequest.BookingRequestDAO;
import com.se1611.bookingRequest.BookingRequestDTO;
import com.se1611.inventory.InventoryDAO;
import com.se1611.orders.OrderDAO;
import com.se1611.orders.OrderDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AdminManageDashboardServlet extends HttpServlet {

    private final String RESULT = "adminDashBoardPage";

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
        //HttpSession session = request.getSession(false);
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(RESULT);
        try {

            //MOST_INVENTORY_BOOK 
            BookDAO bookDAO = new BookDAO();
            List<BookDTO> inventoryBook = bookDAO.getListMostInventoryBook();
            if (!inventoryBook.isEmpty()) {
                request.setAttribute("MOST_INVENTORY_BOOK", inventoryBook);
            }

            //TOTAL_ORDER
            OrderDAO orderDAO = new OrderDAO();
            float sumInOrder = orderDAO.getTotalOrderOfBook();
            //change float to int easy 
            int formatSumInOrder = (int) sumInOrder;
            request.setAttribute("TOTAL_OF_ORDER", formatSumInOrder);

            //TOTAL MONEY LAST MONTH OF BOOK REQUEST
            BookingRequestDAO bookRequestDAO = new BookingRequestDAO();
            float sumTotalMoneyLastMonthBookRequest = bookRequestDAO.getTotalMoneyLastMonthBookRequest();
            //change float to int easy 
            int formatMoney = (int) sumTotalMoneyLastMonthBookRequest;
            request.setAttribute("TOTAL_MONEY_OF_LAST_MONTH", formatMoney);

            //TOTAL OF INVENTORY IN CURRENT YEAR
            InventoryDAO inventoryDAO = new InventoryDAO();
            int totalInventoryCurrenyear = inventoryDAO.getSumInventoryInYear();
            request.setAttribute("TOTAL_QUANTITY_INVENTORY_CURRENT_YEAR", totalInventoryCurrenyear);

            //TOTAL_ORDER_EACH_MONTH
            OrderDAO orderEachMonth = new OrderDAO();
            List<OrderDTO> orderDTO = orderEachMonth.getTotalOrderIn12Months();
            request.setAttribute("TOTAL_ORDER_EACH_MONTH", orderDTO);
            
            //TOTAL BOOKING REQUEST
            BookingRequestDAO bookingRequest = new BookingRequestDAO();
            List<BookingRequestDTO> bookingRequestDTO = bookingRequest.getTotalBookingRequestIn12Months();
            request.setAttribute("TOTAL_BOOKING_REQUEST_EACH_MONTH", bookingRequestDTO);
            
            
        } catch (SQLException e) {
            log("AdminManageListEmployeesServlet_SQL_ " + e.getMessage());
        } catch (NamingException e) {
            log("AdminManageListEmployeesServlet_NamingExceptionNamingException " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

//    public static void main(String[] args)
//            throws NamingException, SQLException {
//        BookDAO dao = new BookDAO();
//        List<BookDTO> list = dao.getListMostInventoryBook();
//        if (!list.isEmpty()) {
//            System.out.println(list);
//        }
//    }


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
