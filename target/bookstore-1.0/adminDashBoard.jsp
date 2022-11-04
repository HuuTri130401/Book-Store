<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <img src="./images/admin1.png" alt="image admin">
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
                        <a href="./adminManageInforDashboard">
                            <i class='bx bx-grid-alt'></i>
                            <span class="links_name">Dashboard</span>
                        </a>
                    </li>
                    <li>
                        <a href="./adminShowListEmployees">
                            <i class='bx bx-user'></i>
                            <span class="links_name">Employees</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class='bx bx-home'></i>
                            <span class="links_name">Overview</span>
                        </a>
                    </li>
                    <li>
                        <a type="submit" href="adminBookAction?action=bookPage1">
                            <i class='bx bx-book'></i>
                            <span class="links_name">Books</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class='bx bx-trending-up'></i>
                            <span class="links_name">Statistic</span>
                        </a>
                    </li>
                    <form action="logoutAction">
                        <li>
                            <a type="submit" href="./loginPage">
                                <i class='bx bx-log-out'></i>
                                <span class="links_name">Log out</span>
                            </a>
                        </li>
                    </form>
                </ul>
            </div>

            <!-- home content -->
            <div class="home-section">
                <!-- home-content -->
                <div class="home-content">

                    <div class="overview-boxes">

                        <c:set var="sumOfTotalOrder" value="${requestScope.TOTAL_OF_ORDER}"/>
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Total Order</div>
                                <div class="number">${sumOfTotalOrder}</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box1'></i>
                                    <span class="text">During The Current Year</span>
                                </div>
                            </div>
                        </div>
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Total Sales</div>
                                <div class="number">1.123.000</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box2'></i>
                                    <span class="text">Up from yesterday</span>
                                </div>
                            </div>
                        </div>
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Total Profit</div>
                                <div class="number">400.000</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box3'></i>
                                    <span class="text">Up from yesterday</span>
                                </div>
                            </div>
                        </div>

                        <c:set var="listMostInventoryBook" value="${requestScope.MOST_INVENTORY_BOOK}"/>
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Most Inventory Book</div>
                                <c:forEach var="bookDTO" items="${listMostInventoryBook}">
                                    <div class="number" style="color: red">Quantity: ${bookDTO.quantity_Book}</div>
                                    <div class="name-product">Name: ${bookDTO.name}</div>
                                    <div class="indicator">
                                        <i class='bx bx-up-arrow-alt box4'></i>
                                        <span class="text">Year Of Public: ${bookDTO.year_Of_Public}</span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="./js/script.js"></script>
    </body>

</html>