<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- link file CSS -->
    <link rel="stylesheet" href="./css/adminHomeStyle.css">
    <!-- BoxIcon CDN Link -->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>--%>
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
                        <span class="name">${role}</span>
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
                <c:choose>
                    <c:when test="${role=='ADMIN'}">
                        <a href="./adminDashBoard.jsp">
                            <i class='bx bx-grid-alt'></i>
                            <span class="links_name">Dashboard</span>
                        </a>
                    </c:when>
                    <c:when test="${role=='STAFF'}">
                        <a href="staffNodifyPage">
                            <i class='bx bxs-bell'></i>
                            <span class="links_name">Nodify</span>
                        </a>
                    </c:when>
                </c:choose>
            </li>
            <li>
                <c:choose>
                    <c:when test="${role=='ADMIN'}">
                        <a href="./adminManageEmployees.jsp">
                            <i class='bx bx-user'></i>
                            <span class="links_name">Employees</span>
                        </a>
                    </c:when>
                    <c:when test="${role=='STAFF'}">
                        <a href="./adminManageEmployees.jsp">
                            <i class='bx bx-notification'></i>
                            <span class="links_name">Request</span>
                        </a>
                    </c:when>
                </c:choose>
            </li>
            <li>
                <c:choose>
                    <c:when test="${role=='ADMIN'}">
                        <a href="#">
                            <i class='bx bx-home'></i>
                            <span class="links_name">Overview</span>
                        </a>
                    </c:when>
                    <c:when test="${role=='STAFF'}">
                        <a href="#">
                            <i class='bx bx-add-to-queue'></i>
                            <span class="links_name">Importation</span>
                        </a>
                    </c:when>
                </c:choose>

            </li>
            <li>
                <a type="submit" href="bookAction?action=bookPage1">
                    <i class='bx bx-book'></i>
                    <span class="links_name">Books</span>
                </a>
            </li>
            <li>
                <c:choose>
                    <c:when test="${role=='ADMIN'}">
                        <a href="#">
                            <i class='bx bx-trending-up'></i>
                            <span class="links_name">Statistic</span>
                        </a>
                    </c:when>
                    <c:when test="${role=='STAFF'}">
                        <a href="inventoryAction">
                            <i class='bx bx-carousel'></i>
                            <span class="links_name">Inventory</span>
                        </a>
                    </c:when>
                </c:choose>
            </li>
            <li>
                <a href="login.jsp">
                    <i class='bx bx-log-out'></i>
                    <span class="links_name">Log out</span>
                </a>
            </li>
        </ul>
    </div>

    <!-- home content -->
    <div class="home-section">
        <!-- home-content -->
        <div class="home-content">

            <div class="overview-boxes">

                <div class="box">
                    <div class="left-side">
                        <%--                             Write   Body Code--%>
                        <table class="table">
                            <thead class="thead-dark">
                            <tr>
                                <th>Image</th>
                                <th>Name Book</th>
                                <th>Quantity</th>
                                <th>Note</th>
                                <th>Date Inventory</th>
                                <th>Employee Implement</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="i" items="${listInventory}">
<%--                                Start Show Item Inventory--%>
                                <tr>
                                    <td><img style="height: 100px;width: 100px"
                                             src="<c:url value="/images/${i.inventory_Img}"/>"/></td>
                                    <td><a href="bookAction?action=bookDetail&bookId=${i.inventory_Book_Id}&categoryId=${i.inventory_Category_Id}">
                                            ${i.inventory_Name_Book}</a></td>
                                    <td>${i.quantity_Inventory}</td>
                                    <td>${i.note_Inventory}</td>
                                    <td>${i.date_Inventory}</td>
                                    <td>${i.employee_Inventory}</td>
                                </tr>
<%--                                End Show Item Inventory--%>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="./js/script.js"></script>

</body>

</html>