package com.se1611.servlets;

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
        request.setCharacterEncoding("utf-8");
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
        // số order cần lấy, 1 page gồm 4 order
        int first = 1;
        int last = 100;
        //Get ALL order detail list
        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
        request.setAttribute("numLastOrder", listOrderDetail.size());
        try {
            go:
            while (true) {
                switch (action) {
                    case "SearchOrder":
                        String search = request.getParameter("search");
                        //Get List Order Detail
                        listOrderDetail = daoOrderDetail.SearchInforOrderDetail(search);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        //Get Orderid
                        List<Integer> orderIdList = new ArrayList<>();
                        for (int i = 0; i < listOrderDetail.size(); i++) {
                            orderIdList.add(listOrderDetail.get(i).getOrder_Id());
                        }
//                    Get List Order
                        listOrder = daoOrder.SeachInforOrder(orderIdList);
                        session.setAttribute("listOrder", listOrder);
                        request.setAttribute("search", search);
                        url = SELLER_ORDER_PAGE;
                        break;
                    case "SearchOrderHistory":
                        search = request.getParameter("search");
                        //Get List Order Detail
                        listOrderDetail = daoOrderDetail.SearchInforOrderDetail(search);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        //Get Orderid
                        orderIdList = new ArrayList<>();
                        for (int i = 0; i < listOrderDetail.size(); i++) {
                            orderIdList.add(listOrderDetail.get(i).getOrder_Id());
                        }
//                    Get List Order
                        listOrder = daoOrder.SeachInforOrder(orderIdList);
                        session.setAttribute("listOrder", listOrder);
                        request.setAttribute("search", search);
                        url = SELLER_ORDER_HISTORY_PAGE;
                        break;
                    case "getOrder":
                        first = 1;
                        last = 4;
// Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        // Get List Order
                        first = listOrderDetail.get(0).getOrder_Id();
                        last = listOrderDetail.get(listOrderDetail.size() - 1).getOrder_Id();
                        listOrder = daoOrder.GetInforOrder(first, last);
                        session.setAttribute("listOrder", listOrder);
                        url = SELLER_ORDER_PAGE;
                        break;
                    case "getOrder2":
                        first = 5;
                        last = 8;
//                    Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        // Get List Order
                        first = listOrderDetail.get(0).getOrder_Id();
                        last = listOrderDetail.get(listOrderDetail.size() - 1).getOrder_Id();
                        listOrder = daoOrder.GetInforOrder(first, last);
                        session.setAttribute("listOrder", listOrder);
                        url = SELLER_ORDER_PAGE;
                        break;
                    case "getOrder3":
                        first = 9;
                        last = 12;
//                    Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        // Get List Order
                        first = listOrderDetail.get(0).getOrder_Id();
                        last = listOrderDetail.get(listOrderDetail.size() - 1).getOrder_Id();
                        listOrder = daoOrder.GetInforOrder(first, last);
                        session.setAttribute("listOrder", listOrder);
                        url = SELLER_ORDER_PAGE;
                        break;
                    case "historyOrder":
                        first = 1;
                        last = 4;
                        // Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        // Get List Order
                        first = listOrderDetail.get(0).getOrder_Id();
                        last = listOrderDetail.get(listOrderDetail.size() - 1).getOrder_Id();
                        listOrder = daoOrder.GetInforOrder(first, last);
                        session.setAttribute("listOrder", listOrder);
                        url = SELLER_ORDER_HISTORY_PAGE;
                        break;
                    case "historyOrder2":
                        first = 5;
                        last = 8;
                        // Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        // Get List Order
                        first = listOrderDetail.get(0).getOrder_Id();
                        last = listOrderDetail.get(listOrderDetail.size() - 1).getOrder_Id();
                        listOrder = daoOrder.GetInforOrder(first, last);
                        session.setAttribute("listOrder", listOrder);
                        url = SELLER_ORDER_HISTORY_PAGE;
                        break;
                    case "historyOrder3":
                        first = 9;
                        last = 12;
                        // Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
                        session.setAttribute("listOrderDetail", listOrderDetail);
                        // Get List Order
                        first = listOrderDetail.get(0).getOrder_Id();
                        last = listOrderDetail.get(listOrderDetail.size() - 1).getOrder_Id();
                        listOrder = daoOrder.GetInforOrder(first, last);
                        session.setAttribute("listOrder", listOrder);
                        url = SELLER_ORDER_HISTORY_PAGE;
                        break;
                    case "deleteOrder":
                        order_id = Integer.parseInt(request.getParameter("orderId"));
                        int count = Integer.parseInt(request.getParameter("count"));
                        String orderId = request.getParameter("orderId");
                        boolean check = daoOrderDetail.updateStatus(order_id, false);
                        if (check) {
                            request.setAttribute("orderId", orderId);
                            request.setAttribute("count", count);
                            action = "getOrder";
                            continue go;
                        }
                    case "getOrderHistory":
                        //  Get List Order Detail
                        listOrderDetail = daoOrderDetail.GetInforOrderDetail(first, last);
                        session.setAttribute("listOrderDetail", listOrderDetail);
//                    Get List Order
                        listOrder = daoOrder.GetInforOrder(first, last);
                        session.setAttribute("listOrder", listOrder);

                        url = SELLER_ORDER_HISTORY_PAGE;
                        break;
                    case "returnOrderDelete":
                        order_id = Integer.parseInt(request.getParameter("orderId"));
                        count = Integer.parseInt(request.getParameter("count"));
                        orderId = request.getParameter("orderId");
                        if (daoOrderDetail.updateStatus(order_id, true)) {
                            action = "getOrderHistory";
                            request.setAttribute("orderId", orderId);
                            request.setAttribute("count", count);
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
