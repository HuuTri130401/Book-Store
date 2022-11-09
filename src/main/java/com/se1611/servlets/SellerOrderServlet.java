package com.se1611.servlets;

import com.se1611.inventory.InventoryDAO;
import com.se1611.inventory.InventoryDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SellerOrderServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalidPage";
    private final String SELLER_ORDER_PAGE="sellerOrderPage";
    private final String SELLER_ORDER_HISTORY_PAGE="sellerOrderHistoryPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws NamingException,
            ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INVALID_PAGE;
        //Declace Session
        HttpSession session = request.getSession();
        //Get Action
        String action = request.getParameter("action");
        //List Order
        List<OrderDTO> listOrder = new ArrayList<>();
        OrderDAO daoOrder = new OrderDAO();
        //List OrderDetail
        List<OrderDetailDTO> listOrderDetail = new ArrayList<>();
        OrderDetailDAO daoOrderDetail = new OrderDetailDAO();
        //Declace order detail Id
        int order_id;
        try {
            go:
            while (true) {
                switch (action) {
                    case "getOrder":
//                    Get List Order
                        listOrder = daoOrder.GetInforOrder();
                        session.setAttribute("listOrder", listOrder);
//                    Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail();
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        url = SELLER_ORDER_PAGE;
                        break;
                    case "historyOrder":
//                    Get List Order
                        listOrder = daoOrder.GetInforOrder();
                        session.setAttribute("listOrder", listOrder);
//                    Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail();
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        url = SELLER_ORDER_HISTORY_PAGE;
                        break;

                    case "deleteOrder":
                        order_id = Integer.parseInt(request.getParameter("orderId"));
                        boolean check = daoOrderDetail.updateStatus(order_id, false);
                        if (check) {
                            action = "getOrder";
                            continue go;
                        }
                    case "returnOrderDelete":
                        order_id = Integer.parseInt(request.getParameter("orderId"));
                        if (daoOrderDetail.updateStatus(order_id, true)) {
                            action = "getOrder";
                            continue go;
                        }
                }
                break go;
            }
            } catch(SQLException e){
                log("BookServlet_SQL_" + e.getMessage());
            } finally{
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
