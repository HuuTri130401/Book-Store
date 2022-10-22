<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Manage Books</title>
        <!-- link file CSS -->
        <link rel="stylesheet" href="./css/adminManageBooksStyle.css">
        <!-- BoxIcon CDN Link -->
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <style>
            body{
                box-sizing: border-box;
                padding: 0;
                margin: 0;
            }
            .item{
                width: 50%;

            }
            .item img{
                width: 50%;
            }
            .left-side .choice{
                font-size: 15px;
                margin-left: 10px;
                height:25px;
                width: 40px;
            }
            .left-side .categoryText{
                margin-left: 10px;
                font-size: 20px;
                height: 40px;
            }
            .left-side .comboxCategory{
                margin-left: 10px;
                width: 115px;
                height: 100%;
                font-size: 18px;
            }
            .left-side .formCategory{
                height: 32px;
            }
            .item{
                padding-left: 100px;
            }
            .item img{
                height: 250px;
                width: 300px;
            }
            .item .name{
                font-size: 20px;
            }
            .item .price{
                font-size: 20px;
            }
        </style>
    </head>

    <body>

        <header>
            <div class="header-menu">
                <!-- even menu sidebar -->
                <div class="sidebar-button__logo">
                    <div class="sidebar-button">
                        <i class='bx bx-menu sidebarBtn'></i>
                        <!-- <span class="dashboard">Dashboard</span> -->
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
                            <button type="submit"><i class='bx bx-search-alt-2'></i></button>
                        </div>
                        <div class="profile_details">
                            <img src="images/admin1.png" alt="image admin">
                            <div class="name_role">
                                <span class="name">Admin</span>
                                <i class='bx bxs-chevron-down'></i>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </header>

        <nav class="sidebar">

            <!-- link in sidebar -->
            <ul class="nav-links">
                <li>
                    <a href="./adminDashBoard.jsp">
                        <i class='bx bx-grid-alt'></i>
                        <span class="links_name">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="./adminManageEmployees.html">
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
                    <a type="submit" href="bookAction?action=bookPage1">
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
                <li>
                    <a href="login.jsp">
                        <i class='bx bx-log-out'></i>
                        <span class="links_name">Log out</span>
                    </a>
                </li>
            </ul>
        </nav>

        <!-- home content -->
        <section class="home-section">

            <!-- home-content -->
            <div class="home-content">
                <div class="overview-boxes">
                    <div class="box">
                        <div class="left-side">
                            <form class="formCategory" action="bookAction" method="POST">
                                <spam class="categoryText">Category</spam>
                                <select class="comboxCategory" name="action">
                                    <option value="Romance">Romance</option>
                                    <option value="Self-help">Self-help</option>
                                    <option value="Novel">Novel</option>
                                    <option value="Fantasy">Fantasy</option>
                                </select>
                                <button class="choice btn btn-secondary" type="submit">Go</button>
                            </form><br/>
                            <div class="itemList row">
                                <c:forEach items="${listBook}" var="b">
                                    <div class="item col-lg-6">
                                        <form action="bookAction?action=bookDetail&bookId=${b.book_Id}&categoryId=${b.category}" 
                                              method="POST">
                                            <img src="<c:url value="/images/${b.image_Book}"/>"/><br/>
                                           <p class="name">${b.name}</p> <br/>
                                            <p class="price">${b.price_Book}<p ><br/>
                                            <button type="submit">View Detail</button>
                                        </form>
                                    </div>
                                </c:forEach>
                            </div>
                            <a type="submit" href="bookAction?action=bookPage1">First</a>
                            <a type="submit" href="bookAction?action=bookPage1">1</a>
                            <a type="submit" href="bookAction?action=bookPage2">2</a>
                            <a type="submit" href="bookAction?action=bookPage3">3</a>
                            <a type="submit" href="bookAction?action=bookPage4">4</a>
                            <a type="submit" href="bookAction?action=bookPage4">Last Page</a>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <script src="./js/script.js"></script>

    </body>

</html>