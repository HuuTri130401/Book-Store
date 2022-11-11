/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.book.BookDAO;
import com.se1611.book.BookDTO;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan vu
 */
public class SellerBookServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalidPage";
    private final String SELLER_BOOK_PAGE = "sellerBookPage";
    private final String SELLER_BOOK_DETAIL_PAGE = "sellerBookDetailPage";
    private final String SELLER_BOOK_CATEGOTY_PAGE = "sellerBookCategoryPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = INVALID_PAGE;
        // /lấy Acction Để đưa vào switch vô case chuyển page
        String action = request.getParameter("action");
        // Session
        HttpSession session = request.getSession();
        // Create list save book

        List<BookDTO> list = new ArrayList<>();
        BookDAO dao = new BookDAO();

        // số book cần lấy, 1 page gồm 4 book
        int first = 1;
        int last = 100;
        int categoryId=1;

        //Lấy all Book in List
        list = dao.getInformationBook(first, last);
        session.setAttribute("numLastBook", list.size());

        //Switch Case
        try {
            switch (action) {
                //Search Book
                case "searchBook":
                    String search=request.getParameter("search");
                    //Search
                    list=dao.SearchBook(1,4,search);
                    session.setAttribute("listBook", list);
                    request.setAttribute("search",search);
                    url = SELLER_BOOK_PAGE;
                    break;
                //Page Book
                case "bookPage1":
                    first = 1;
                    last = 4;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = SELLER_BOOK_PAGE;
                    break;
                case "bookPage2":
                    first = 5;
                    last = 8;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = SELLER_BOOK_PAGE;
                    break;
                case "bookPage3":
                    first = 9;
                    last = 12;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = SELLER_BOOK_PAGE;
                    break;
                case "bookPage4":
                    first = 13;
                    last = 16;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = SELLER_BOOK_PAGE;
                    break;
                case "bookPage5":
                    first = 17;
                    last = 20;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = SELLER_BOOK_PAGE;
                    break;
                case "bookPage6":
                    first = 21;
                    last = 24;
                    list = dao.getInformationBook(first, last);
                    session.setAttribute("listBook", list);
                    url = SELLER_BOOK_PAGE;
                    break;

                // Page Category Book
                case "Romance":
                    //Get all list category book, get quantity category
                    categoryId=1;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("numLastCategory",list.size());
                    //get 1-4 list book category
                    first = 1;
                    last=4;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Romance2":
                    categoryId=1;
                    first = 5;
                    last=8;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Romance3":
                    categoryId=1;
                    first = 9;
                    last=12;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Self-help":
                    //Get all list category book, get quantity category
                    categoryId=2;
                    list= dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("numLastCategory",list.size());
                    //get 1-4 list book category
                    first = 1;
                    last=4;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Self-help2":
                    categoryId=2;
                    first = 5;
                    last=8;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Self-help3":
                    categoryId=2;
                    first = 9;
                    last=12;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Novel":
                    //Get all list category book, get quantity category
                    categoryId=3;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("numLastCategory",list.size());
                    //get 1-4 list book category
                    first = 1;
                    last=4;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Novel2":
                    categoryId=3;
                    first = 5;
                    last=8;
                    list= dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Novel3":
                    categoryId=3;
                    first = 9;
                    last=12;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Fantasy":
                    //Get all list category book, get quantity category
                    categoryId=4;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("numLastCategory",list.size());
                    //get 1-4 list book category
                    first = 1;
                    last=4;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Fantasy2":
                    categoryId=4;
                    first = 5;
                    last=8;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                case "Fantasy3":
                    categoryId=4;
                    first = 9;
                    last=12;
                    list = dao.getCategoryBook(categoryId,first,last);
                    session.setAttribute("listCategoryBook", list);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_CATEGOTY_PAGE;
                    break;
                // Page Detail Book khi click vào từng book
                case "bookDetail":

                    session.setAttribute("listBook", list);
                    String bookId = request.getParameter("bookId");
                    categoryId = Integer.parseInt(request.getParameter("categoryId"));
                    list = dao.getCategoryBook(categoryId,first,last);
                    request.setAttribute("bookIdServlet", bookId);
                    request.setAttribute("nameCategory", list.get(0).getCategoryName());
                    url = SELLER_BOOK_DETAIL_PAGE;
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
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(SellerBookServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(SellerBookServlet.class.getName()).log(Level.SEVERE, null, ex);
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
