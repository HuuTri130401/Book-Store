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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <style>
        body {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }

        /*Start Border : Khung border bao quanh book*/
        .border {
            border-radius: 20px;
            margin-left: 140px;
            margin-bottom: 10px;
            padding: 10px 10px 10px 10px;
            width: 800px;
        }

        /*Start Category*/
        .left-side .categoryText {
            margin-left: 10px;
            font-size: 20px;
            height: 40px;
            color: black;
        }

        /*End Category*/

        /*Start Item List: Weight height font book name, price*/
        .itemList img {
            width: 50%;
            height: 350px;
            width: 400px;
        }

        .item {
            margin-left: 40px;
        }

        .item .name {
            font-size: 35px;
            padding-bottom: 20px;
        }

        .item .price {
            margin-top: 20px;
            font-size: 30px;
            color: #C92127;
        }

        .item .quantity {
            font-size: 25px;
            padding-bottom: 5px;
        }

        .item .author {
            font-size: 25px;
            padding-bottom: 5px;
        }

        .item .yearPublic {
            font-size: 25px;
            padding-bottom: 5px;
        }

        .item .inventory {
            font-size: 30px;
            margin-right: 50px;
        }
        /*End Item List*/

        /*Start Description*/
        .boxDescription{
            border-radius: 15px;
            background-color: rgba(224, 219, 219, 0.68);
            margin-left: 10px;
            margin-top: 30px;
        }
        .description{
            margin-top: 20px;
            font-size: 22px;
            margin-left: 10px;
        }
        .description .text{
            padding-top: 10px;
            font-size: 15px;
        }
        /*End Description*/

    </style>
</head>

<body>
<!--header-->
<header>
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
                    <button type="submit"><i class='bx bx-search-alt-2'></i></button>
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
</header>

<!-- sidebar -->
<nav class="sidebar">
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
                        <i class='bx bx-carousel' ></i>
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
</nav>

<!-- home content -->
<section class="home-section">
    <!-- home-content -->
    <div class="home-content">
        <div class="overview-boxes">
            <div class="box">
                <div class="left-side">
                    <div class="categoryText">
                        <a style="color: black" href="bookAction?action=bookPage1">Category </a> >
                        <a style="color: #17A2B8" href="bookAction?action=${nameCategory}"> ${nameCategory}</a>
                    </div>
                    <c:forEach items="${listBook}" var="b">
                        <form action="">
                        <c:set var="bookId" value="${bookIdServlet}"></c:set>
                        <c:if test="${b.book_Id==bookId}">
<%--                            Item Book Need Show--%>
                            <div class="itemList row">
                                <div class="border col-lg-4">
                                    <img src="<c:url value="/images/${b.image_Book}"/>" class="rounded"/><br/>
                                </div>
                                <div class="item col-lg-5">
                                    <strong class="name">${b.name}</strong><br/>
                                    <p class="price">
                                            <fmt:formatNumber value="${b.price_Book}" type="number"/>
                                        <small style="text-decoration:underline">đ</small>
                                    <p><br/>
                                    <p class="quantity">Quantity: ${b.quantity_Book}</p>
                                    <p class="author">Author: <u>${b.author}</u></p>
                                    <p class="yearPublic">Year Of Public: ${b.year_Of_Public}</p>
                                    <button class="inventory btn btn-outline-danger">Inventory</button>
                                    <button class="btn btn-success" style="font-size: 30px;">Importation</button>
                                </div>
                            </div>
                            <div class="boxDescription">
                            <div class="description">
                                <strong>Information Detail</strong><br>
                                   <p class="text">${b.descriptionBook}</p>
                            </div>
                            </div>
<%--                            End Show Item Book--%>
                        </c:if>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="./js/script.js"></script>

</body>
</html>