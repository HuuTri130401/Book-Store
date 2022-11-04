<%@page import="com.se1611.orders.OrderDTO"%>
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
        <h1>Your Cart</h1>
        <a href="sellerBookAction?action=bookPage1">Back to home page</a>
        <br>

        <table border="1px">
            <tr>
                <th>No.</th>
                <th>Images</th>
                <th>Book name</th>
                <th>Date Order</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <% int count = 0;%>
            <c:forEach items="${sessionScope.LIST_CART}" var="cart">
                <form action="addToCartAction?action=modifyCart" method="POST">
                    <tr>
                        <td><%=++count%></td>
                        <td>
                            <img  width="100" height="60" src="images/${pageScope.cart.image}" alt="this_is_book"/>
                        </td>
                        <td>
                            ${pageScope.cart.bookName}
                            <input type="hidden" name="bookName" value="${pageScope.cart.bookName}">
                        </td>   
                        <td>
                            ${pageScope.cart.dateOrder}
                        </td>
                        <td>
                            ${pageScope.cart.price}
                        </td>
                        <td>
                            <input type="number" name="quantity" min="0" value="${pageScope.cart.quantity}">
                        </td>
                        <td>
                            ${pageScope.cart.price*pageScope.cart.quantity}
                            <input type="hidden" name="bookId" value="${pageScope.cart.bookId}">

                        </td>
                        <td>
                            <button type="submit">Update</button>
                            <input type="hidden" name="bookId" value="${pageScope.cart.bookId}">
                        </td>
                        <c:set var="total" value="${total + cart.quantity * cart.price}"></c:set>
                    </form>
                    <form action="addToCartAction?action=deleteCart" method="POST">
                        <td>
                            <button type="submit">Delete</button>
                            <input type="hidden" name="bookId" value="${pageScope.cart.bookId}">
                    </td>
                </form>
            </tr>

        </c:forEach>
    </table>
    <form action="addToCartAction?action=buyCart" method="POST">
        <button type="submit">Buy</button>
    </form>
    <h1>Total: ${total}</h1>
</body>
</html>
