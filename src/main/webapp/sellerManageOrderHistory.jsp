<%@ page import="com.se1611.orders.OrderDetailDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seller Order History</title>

    <!-- BoxIcon CDN Link -->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <%--    Link Button CSS--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <!-- link file CSS -->
    <link rel="stylesheet" href="css/sellerManageOrderHistory.css">
</head>

<body>
<div class="header">
    <div class="header-menu">
        <!-- even menu sidebar -->
        <div class="sidebar-button__logo">
            <div class="sidebar-button">
                <i class='bx bx-menu sidebarBtn'></i>
            </div>
            <!-- div of logo -->
            <div class="logo-details">
                <img src="./images/logo.jpg" alt="Logo Phuong Nam Bookstore">
                <span class="logo_name">Book Store</span>
            </div>
        </div>
        <div class="seachbox-profile">
            <div class="wraper_searchbox_profile">
                <div class="search-box">
                    <input type="text" placeholder="Search...">
                    <button type='submit'><i class='bx bx-search-alt-2'></i></button>
                </div>
                <div class="profile_details">
                    <img src="images/admin1.png" alt="image admin">
                    <div class="name_role">
                        <span class="name">${sessionScope.USER["fullName"]}</span>
                        <i class='bx bxs-chevron-down'></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="wrapper-body">
    <div class="sidebar">
        <!-- link in sidebar -->
        <ul class="nav-links">
            <li>
                <a href="sellerNodifyPage">
                    <i class='bx bxs-bell'></i>
                    <span class="links_name">Notify</span>
                </a>
            </li>
            <li>
                <a href="sellerCartAction?action=viewCart">
                    <i class="fa-solid fa-cart-shopping"></i>
                    <span class="links_name">Cart</span>
                </a>
            </li>
            <li>
                <a href="sellerOrderAction?action=getOrder">
                    <i class="fa-solid fa-basket-shopping"></i>
                    <span class="links_name">Order</span>
                </a>
            </li>
            <li>
                <a type="submit" href="sellerBookAction?action=bookPage1">
                    <i class='bx bx-book'></i>
                    <span class="links_name">Books</span>
                </a>
            </li>

            <li>
                <a href="./logoutAction">
                    <i class='bx bx-log-out'></i>
                    <span class="links_name">Log out</span>
                </a>
            </li>
        </ul>
    </div>

    <!-- home content -->
    <div class="home-section">
        <!-- home-content -->
            <div>
                <h2 id="nameTable">LIST HISTORY OF ORDER BOOK</h2>
            </div>
        <%--End Home Content--%>

        <%--  Write   Body Code--%>

        <c:forEach var="i" items="${listOrder}" varStatus="loop">
            <c:if test="${i.status_Order==false}">
                <div class="order">
                        <%--Start Show Item Order--%>
                    <div class="itemOrder">
                        <p id="id"> Order: ${i.order_Id}</p>
                        <div><p id="date">Date: ${i.date_To_Order}</p></div>
                        <div><p id="fullname">Implementer: ${i.fullname}</p></div>
                            <%-- Start button Delete Cart--%>
                        <button id="btnReturn"  data-toggle="modal"
                                data-target="#myModal${loop.index}">
                            <i class="fa-solid fa-rotate-left"></i>
                        </button>
                            <%-- End button Delte Cart--%>
                    </div>
                        <%--End Show Item Order--%>

                    <c:set var="orderId" value="${i.order_Id}"></c:set>
                        <%--Start Show Item Order Detail--%>
                    <c:forEach var="x" items="${listOrderDetail}" varStatus="lop">
                        <%--Start Show Item--%>
                        <c:if test="${x.order_Id==orderId}">
                            <div class="orderDetail">
                                <div class="itemDetail">

                                    <div>
                                        <img style="height: 100px;width: 100px"
                                             src="<c:url value="/images/${x.image_Order}"/>"/>
                                    </div>
                                    <div>
                                        <a href="sellerBookAction?action=bookDetail&bookId=${x.book_Id}&categoryId=${x.category_Id}">
                                                ${x.name_Book_Order}</a><br>
                                        <div class="price">
                                            <p id="quantity">x${x.quantity_Order_Detail}</p>
                                            <p id="total"><fmt:formatNumber type="number"
                                                                            value="${x.total_Order_Detail}"/>
                                                <small style="text-decoration:underline">đ</small></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <%-- End Show Item --%>
                    </c:forEach>
                        <%--End Show Item Order Detail--%>
                    <div class="totalOrder">

                        <p>Total(${i.quantity_Order} Book): </p>
                        <p id="priceOrder"><fmt:formatNumber type="number" value=" ${i.total_Order}"/></p>
                    </div>

                                <%--Return Book Inventory--%>
                            <div class="modal fade" id="myModal${loop.index}">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <header class="head-form mb-0">
                                            <h2>Are You Sure To Return The Order ?</h2>
                                        </header>

                                        <div class="modal-body">
                                                <%--Form --%>
                                            <form action="sellerOrderAction?action=returnOrderDelete" method="POST">
                                                <input type="hidden" name="orderId" value="${i.order_Id}"/>
                                                    <%-- Are You Sure --%>
                                        </div>
                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-danger add">Return</button>
                                            </form>
                                            <button class="btn btn-warning xclose" data-dismiss="modal">Close
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                <%--End Return Book Inventory--%>

                </div>
            </c:if>
        </c:forEach>

    </div>

</div>
<script src="./js/script.js"></script>


<%--Update Book Inventory--%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>

</html>