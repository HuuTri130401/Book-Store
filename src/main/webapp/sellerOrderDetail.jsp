<%@page import="com.se1611.order.OrderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="viewCart.css">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>Order List Page</h1>
        <br>

        <table border="1px">
            <tr>
                <th>No</th>
                <th>Order Detail ID</th>
                <th>Order ID</th>
                <th>Book ID</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Delete</th>
            </tr>
            <% int count = 0;%>
            <c:forEach items="${sessionScope.LIST_ORDER_DETAIL}" var="order_detail">
                        <form action="addToCartAction?action=deleteOrderDetail" method="POST">
                    <c:if test="${order_detail.status == true}">
                        <tr>
                            <td><%=++count%></td>
                            <td>
                                ${pageScope.order_detail.order_Detail_Id}
                            </td>
                            <td>
                                ${pageScope.order_detail.order_Id}
                            </td>   
                            <td>
                                ${pageScope.order_detail.book_Id}
                            </td>
                            <td>
                                ${pageScope.order_detail.quantity_Order_Detail}
                            </td>
                            <td>
                                ${pageScope.order_detail.total_Order_Detail}
                            </td>

                            <td>
                                <button type="submit">Delete</button>
                                <input type="hidden" name="orderDetailId" value="${pageScope.order_detail.order_Detail_Id}">
                            </td>

                        </tr>
                    </c:if>
                </form>

            </c:forEach>
        </table>
        <a href="sellerBookAction?action=bookPage1">New Order</a>
    </body>
</html>
