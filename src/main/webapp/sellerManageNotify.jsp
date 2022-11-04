<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Seller Notify</title>
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
                                <a href="sellerNotifyPage">
                                    <i class='bx bxs-bell'></i>
                                    <span class="links_name">Notify</span>
                                </a>
                    </li>
                     <li>
                                <a href="sellerBookAction?action=bookPage1">
                                    <i class='bx bxs-bell'></i>
                                    <span class="links_name">Order</span>
                                </a>
                    </li>
                    <li>
                                <a href="sellerListOrderPage">
                                    <i class='bx bxs-bell'></i>
                                    <span class="links_name">List Order</span>
                                </a>
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
                                <div class="boxtopic">Total Order</div>
                                <div class="number">123,456</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box1'></i>
                                    <span class="text">Up from yesterday</span>
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
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Best - Selling Product</div>
                                <div class="number">123.333</div>
                                <div class="name-product">NameBook</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box4'></i>
                                    <span class="text">Up from yesterday</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="./js/script.js"></script>

    </body>

</html>