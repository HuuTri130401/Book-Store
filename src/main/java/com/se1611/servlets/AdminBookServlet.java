/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.book.BookDAO;
import com.se1611.book.BookDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
 * @author tuan vu
 */
public class AdminBookServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalidPage";
    private final String BOOK_PAGE = "adminBookPage";
    private final String BOOK_DETAIL_PAGE = "adminBookDetailPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INVALID_PAGE;
        // /lấy Acction Để đưa vào switch vô case chuyển page
        String action = request.getParameter("action");
        // Session
        HttpSession session = request.getSession();
        // Create list save book
        List<BookDTO> list = new ArrayList<>();
        BookDAO dao = new BookDAO();
        // số book cần lấy, 1 page gồm 4 book
        int first = 0;
        int last = 0;
        try {
            switch (action) {
                case "bookPage1":
                    first = 1;
                    last = 4;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = BOOK_PAGE;
                    break;
                case "bookPage2":
                    first = 5;
                    last = 8;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = BOOK_PAGE;
                    break;
                case "bookPage3":
                    first = 9;
                    last = 12;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = BOOK_PAGE;
                    break;
                case "bookPage4":
                    first = 13;
                    last = 16;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = BOOK_PAGE;
                    break;
                    // Page Detail Book khi click vào từng book
                case "bookDetail":
                    String bookId = request.getParameter("bookId");
                    request.setAttribute("bookIdServlet", bookId);
                    url = BOOK_DETAIL_PAGE;
                    break;
            }
        } catch (SQLException e) {
            log("BookServlet_SQL_" + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            // response.sendRedirect(url);
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
