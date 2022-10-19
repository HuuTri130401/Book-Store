<%-- 
    Document   : book
    Created on : Oct 17, 2022, 10:36:07 PM
    Author     : tuan vu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Book</h1>
        <table border="1">
            <thead>
            <th>Name</th>
            <th>Author</th>
            <th>Year Of Public</th>
            <th>Category</th>
            <th>Price</th>
            <th>Quantity</th>
        </thead>
        <tbody>
            <c:forEach items="${listBook}" var="b">
                <tr>
                    <td>${b.book_Id}</td>
                    <td>${b.name}</td>
                    <td>${b.author}</td>
                    <td>${b.year_Of_Public}</td>
                    <td>${b.quantity_Book}</td>
                    <td>${b.price_Book}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
