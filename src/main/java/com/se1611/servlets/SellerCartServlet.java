package com.se1611.servlets;

import com.se1611.Cart.CartDTO;
import com.se1611.book.BookDAO;
import com.se1611.orders.OrderDAO;
import com.se1611.orders.OrderDTO;
import com.se1611.orders.OrderDetailDAO;
import com.se1611.orders.OrderDetailDTO;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SellerCartServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalidPage";
    private final String SELLER_CART_PAGE = "sellerCartPage";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws NamingException,
            ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = INVALID_PAGE;
        //Declace Session
        HttpSession session = request.getSession();
        //Get Action
        String action = request.getParameter("action");
        //
        BookDAO bookDAO = new BookDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        //Declace biến cục bộ
        LocalDate localDate;
        int bookId = 0;
        int quantity_Order = 0;
        Date date_to_Order;
        float total_Order = 0;
        int count = 0;

        try {
            switch (action) {
                case "addToCart":
                    int orderId = Integer.parseInt(request.getParameter("orderId"));
                    List<Integer> listBookId = new ArrayList<>();
                    while (true) {
                        if (orderId > 0) {
                            List<OrderDetailDTO> list = (List<OrderDetailDTO>) session.getAttribute("listOrderDetail");
                            for (int i = 0; i < list.size(); i++) {
                                if (orderId == list.get(i).getOrder_Id()) {
                                    listBookId.add(list.get(i).getBook_Id());
                                }
                            }
                            orderId = -1;
                        }
                        if (orderId == 0) {
                            bookId = Integer.parseInt(request.getParameter("book_Id_Cart"));
                            quantity_Order = Integer.parseInt(request.getParameter("quantity"));

                        }
                        if (orderId < 0) {
                            if (count == listBookId.size()) {
                                break;
                            }
                            bookId = listBookId.get(count);
                            quantity_Order = 1;
                            count++;
                        }
                        int quantityBook= Integer.parseInt(request.getParameter("quantityBook"));

                        float price = bookDAO.getBookById(bookId).getPrice_Book();
                        String book_Name = bookDAO.getBookById(bookId).getName();
                        String image = bookDAO.getBookById(bookId).getImage_Book();
                        localDate = LocalDate.now();
                        date_to_Order = java.sql.Date.valueOf(localDate);

                        total_Order = quantity_Order * price;
                        CartDTO cartDTO = new CartDTO(bookId, book_Name,quantity_Order, quantityBook, price, image, date_to_Order);
                        if (session.getAttribute("listCart") == null) {
                            ArrayList<CartDTO> listCart = new ArrayList<>();
                            listCart.add(cartDTO);
                            session.setAttribute("listCart", listCart);
                        } else {
                            boolean flag = false;
                            ArrayList<CartDTO> cartList = (ArrayList<CartDTO>) session.getAttribute("listCart");
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
                            session.setAttribute("listCart", cartList);
                        }
                        if(orderId==0) break;
                    }
                    url = SELLER_CART_PAGE;
                    break;

                case "viewCart":
                    url = SELLER_CART_PAGE;
                    break;
                case "modifyCart":
                    int quantity = Integer.parseInt(request.getParameter("quantityUpdate"));
                    bookId = Integer.parseInt(request.getParameter("bookId"));
                    int update =Integer.parseInt(request.getParameter("update"));
                    String nameBook= request.getParameter("nameBook");
                    ArrayList<CartDTO> cartList = (ArrayList<CartDTO>) session.getAttribute("listCart");
                    for (CartDTO cartDTO1 : cartList) {
                        if (cartDTO1.getBookId() == bookId) {
                            cartDTO1.setQuantity(quantity);
                            request.setAttribute("nameBook",nameBook);
                            request.setAttribute("update",update);
                        }
                    }
                    url = SELLER_CART_PAGE;
                    break;
                case "deleteCart":
                    bookId = Integer.parseInt(request.getParameter("bookId"));
                    cartList = (ArrayList<CartDTO>) session.getAttribute("listCart");
                    int counts =Integer.parseInt(request.getParameter("count"));
                    nameBook= request.getParameter("nameBook");
                    for (CartDTO cartDTO1 : cartList) {
                        if (cartDTO1.getBookId() == bookId) {
                            cartList.remove(cartDTO1);
                            session.setAttribute("listCart", cartList);
                            request.setAttribute("nameBook",nameBook);
                            request.setAttribute("count",counts);
                            break;
                        }
                    }
                    url = SELLER_CART_PAGE;
                    break;
                case "buyCart":
                    cartList = (ArrayList<CartDTO>) session.getAttribute("listCart");
                    quantity_Order = 0;
                    total_Order = 0;
                    for (CartDTO cartDTO1 : cartList) {
                        quantity_Order = quantity_Order + cartDTO1.getQuantity();
                        total_Order = total_Order + (cartDTO1.getPrice() * cartDTO1.getQuantity());
                    }
                    int employee_Id = (Integer) session.getAttribute("employee_Id");
                    localDate = LocalDate.now();
                    date_to_Order = java.sql.Date.valueOf(localDate);

                    OrderDTO orderDTO = new OrderDTO(employee_Id, date_to_Order, quantity_Order, total_Order, true);
                    boolean success = orderDAO.createOrder(orderDTO);
                    if (success) {
                        request.setAttribute("MESSAGE", "Add to DB success");
                        OrderDTO getorderDTO = orderDAO.getOrder(employee_Id, orderDTO.getDate_To_Order(), quantity_Order, total_Order);
                        for (CartDTO cartDTO1 : cartList) {
                            OrderDetailDTO orderDetailDTO = new OrderDetailDTO(getorderDTO.getOrder_Id(), cartDTO1.getBookId(), cartDTO1.getQuantity(), cartDTO1.getPrice() * cartDTO1.getQuantity(), true);
                            if (orderDetailDAO.createOrder(orderDetailDTO)) {
                                url = SELLER_CART_PAGE;
                            }
                        }
                        session.removeAttribute("listCart");
                    } else {
                        request.setAttribute("MESSAGE", "Error");
                    }
                    break;
                case "again":

                    break;

            }
        } catch (SQLException | ClassNotFoundException e) {
            log("BookServlet_SQL_" + e.getMessage());
        } finally {
            // request url;
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
