/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.servlets;

import com.se1611.book.BookDAO;
import com.se1611.orders.OrderDAO;
import com.se1611.orders.OrderDTO;
import com.se1611.order.com.se1611.cart.CartDTO;
import com.se1611.orderDetail.OrderDetailDAO;
import com.se1611.orderDetail.OrderDetailDTO;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class AddToCartServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalidPage";
    private final String SELLER_ORDER_PAGE = "sellerOrderPage";
    private final String VIEW_CART_PAGE = "sellerViewCartPage";
    private final String LIST_ORDER_PAGE = "sellerListOrderPage";

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
            throws ServletException, IOException, ClassNotFoundException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INVALID_PAGE;
        //Declace Session
        HttpSession session = request.getSession();
        //Get Action
        String action = request.getParameter("action");

        BookDAO bookDAO = new BookDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        try {
            switch (action) {
                case "addToCart":
                    int bookId = Integer.parseInt(request.getParameter("book_Id_Cart"));
                    float price = bookDAO.getBookById(bookId).getPrice_Book();
                    String book_Name = bookDAO.getBookById(bookId).getName();
                    String image = bookDAO.getBookById(bookId).getImage_Book();

                    LocalDate localDate = LocalDate.now();
                    Date date_to_Order = java.sql.Date.valueOf(localDate);
                    int quantity_Order = Integer.parseInt(request.getParameter("quantity"));
                    float total_Order = quantity_Order * price;
                    CartDTO cartDTO = new CartDTO(bookId, book_Name, quantity_Order, price, image, date_to_Order);
                    if (session.getAttribute("LIST_CART") == null) {
                        ArrayList<CartDTO> listCart = new ArrayList<>();
                        listCart.add(cartDTO);
                        session.setAttribute("LIST_CART", listCart);
                    } else {
                        boolean flag = false;
                        ArrayList<CartDTO> cartList = (ArrayList<CartDTO>) session.getAttribute("LIST_CART");
                        for (CartDTO cartDTO1 : cartList) {
                            if (cartDTO1.getBookId() == bookId) {
                                if (quantity_Order != 0) {
                                    cartDTO1.setQuantity(cartDTO1.getQuantity() + quantity_Order);
                                } else {
                                    cartDTO1.setQuantity(cartDTO1.getQuantity() + 1);
                                }
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false) {
                            cartList.add(cartDTO);
                        }
                        session.setAttribute("LIST_CART", cartList);
                    }
//                    boolean success = orderDAO.createOrder(orderDTO);
//                    if (success){
//                        request.setAttribute("MESSAGE", "Add to DB success");
//                    }else{
//                     request.setAttribute("MESSAGE", "Error");
//                    }
                    url = VIEW_CART_PAGE;
//                    url = ADD_TO_CART_PAGE;
                    break;

                case "viewCart":
                    url = VIEW_CART_PAGE;
                    break;
                case "modifyCart":
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    bookId = Integer.parseInt(request.getParameter("bookId"));

                    ArrayList<CartDTO> cartList = (ArrayList<CartDTO>) session.getAttribute("LIST_CART");
                    for (CartDTO cartDTO1 : cartList) {
                        if (cartDTO1.getBookId() == bookId) {
                            cartDTO1.setQuantity(quantity);
                        }
                    }
                    url = VIEW_CART_PAGE;
                    break;
                case "deleteCart":
                    bookId = Integer.parseInt(request.getParameter("bookId"));
                    cartList = (ArrayList<CartDTO>) session.getAttribute("LIST_CART");
                    for (CartDTO cartDTO1 : cartList) {
                        if (cartDTO1.getBookId() == bookId) {
                            cartList.remove(cartDTO1);
                            session.setAttribute("LIST_CART", cartList);
                            break;
                        }
                    }
                    url = VIEW_CART_PAGE;
                    break;
                case "buyCart":
                    cartList = (ArrayList<CartDTO>) session.getAttribute("LIST_CART");
                    quantity_Order = 0;
                    total_Order = 0;
                    for (CartDTO cartDTO1 : cartList) {
                        quantity_Order = quantity_Order + cartDTO1.getQuantity();
                        total_Order = total_Order + (cartDTO1.getPrice() * cartDTO1.getQuantity());
                    }
                    int employee_Id = (Integer) session.getAttribute("employee_Id");
                    localDate = LocalDate.now();
                    date_to_Order = java.sql.Date.valueOf(localDate);

                    OrderDTO orderDTO = new OrderDTO(employee_Id, date_to_Order, quantity_Order, total_Order);
                    boolean success = orderDAO.createOrder(orderDTO);
                    if (success) {
                        request.setAttribute("MESSAGE", "Add to DB success");
                        OrderDTO getorderDTO = orderDAO.getOrder(employee_Id, orderDTO.getDate_To_Order(), quantity_Order, total_Order);
                        for (CartDTO cartDTO1 : cartList) {
                            OrderDetailDTO orderDetailDTO = new OrderDetailDTO(getorderDTO.getOrder_Id(), cartDTO1.getBookId(), cartDTO1.getQuantity(), cartDTO1.getPrice() * cartDTO1.getQuantity(), true);
                            orderDetailDAO.createOrder(orderDetailDTO);
                        }
                        session.removeAttribute("LIST_CART");
                    } else {
                        request.setAttribute("MESSAGE", "Error");
                    }
                    url = SELLER_ORDER_PAGE;
                    break;
                case "deleteOrderDetail":
                    int orderDetailId = Integer.parseInt(request.getParameter("orderDetailId"));
                    boolean check = orderDetailDAO.updateStatus(orderDetailId);
                    if (check) {
                        orderDetailDAO = new OrderDetailDAO();
                        ArrayList<OrderDetailDTO> listOrderDetail = orderDetailDAO.getListOrderDetail();
                        session.setAttribute("LIST_ORDER_DETAIL", listOrderDetail);
                    }
                    url = LIST_ORDER_PAGE;
                    break;
            }
        } catch (SQLException e) {
            log("BookServlet_SQL_" + e.getMessage());
        } finally {
            // request url;
            request.getRequestDispatcher(url).forward(request, response);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
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
