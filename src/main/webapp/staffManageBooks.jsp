<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

            /*Start CategoryBox*/
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
                color: #17A2B8;
                margin-top: 5px;
                margin-left: 10px;
                width: 115px;
                height: 100%;
                font-size: 18px;
            }
            .left-side .formCategory{
                height: 32px;
            }
            /*End CategoryBox*/

            /*Start Border : Khung border bao quanh book*/
            .border{
                margin-left: 10px;
                margin-bottom: 10px;
                padding: 10px 10px 10px 10px;
                width: 423px;
            }
            /*End Border*/

            /*Start Item List: Weight height font book name, price*/
            .item{
                width: 50%;

            }
            .item img{
                width: 50%;
            }

            .item{
                padding-left: 100px;
            }
            .item img{
                height: 350px;
                width: 400px;
            }
            .item .name{
                font-size: 30px;
                margin-bottom: 0px;
            }
            .item .price{
                font-size:25px;
            }
            .item .viewDetail{
                font-size: 15px;
                height:30px;
                width: 100px;
            }
            /*End Item List*/

            /*Page Start*/
            .page{
                font-size: 30px;
            }
            .page a{
                margin-left: 10px;
                color: #000000 ;
            }
            /*Page End*/
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
                                <span class="name">${sessionScope.USER["fullName"]}</span>
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
                    <a href="staffNodifyPage">
                        <i class='bx bxs-bell'></i>
                        <span class="links_name">Nodify</span>
                    </a>
                </li>
                <li>
                    <a href="staffImportationAction?action=getRequest">
                        <i class='bx bx-notification'></i>
                        <span class="links_name">Request</span>
                    </a>
                </li>
                <li>
                    <a href="staffImportationAction?action=getImportation">
                        <i class='bx bx-add-to-queue'></i>
                        <span class="links_name">Importation</span>
                    </a>
                </li>
                <li>
                    <a type="submit" href="staffBookAction?action=bookPage1">
                        <i class='bx bx-book'></i>
                        <span class="links_name">Books</span>
                    </a>
                </li>
                <li>
                    <a href="staffInventoryAction?action=getInventory">
                        <i class='bx bx-carousel' ></i>
                        <span class="links_name">Inventory</span>
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
                            <form class="formCategory" action="staffBookAction" method="POST">
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
                                        <form action="staffBookAction?action=bookDetail&bookId=${b.book_Id}&categoryId=${b.category}"
                                              method="POST">
                                            <div class="border">
                                            <img src="<c:url value="/images/${b.image_Book}"/>"/><br/>
                                           <p class="name">${b.name}</p> <br/>
                                            <p class="price"><fmt:formatNumber value="${b.price_Book}" type="number"/>
                                                <small style="text-decoration:underline">đ</small>
                                                <p><br/>
                                                    <button class="viewDetail btn btn-info" type="submit">View Detail
                                                    </button>
                                            </div>
                                        </form>

                                    </div>
                                </c:forEach>
                            </div>

                            <%--Start Page--%>
                            <div class="page row">
                                <div class="col-lg-4"></div>
                                <div class="col-lg-4 d-flex justify-content-center">
                                    <a type="submit" href="staffBookAction?action=bookPage1">1</a>
                                    <a type="submit" href="staffBookAction?action=bookPage2">2</a>
                                    <a type="submit" href="staffBookAction?action=bookPage3">3</a>
                                    <a type="submit" href="staffBookAction?action=bookPage4">4</a>
                                    <c:if test="${numLastBook>16}">
                                        <a type="submit" href="staffBookAction?action=bookPage5">5</a>
                                    </c:if>
                                    <c:if test="${numLastBook>20}">
                                        <a type="submit" href="staffBookAction?action=bookPage6">6</a>
                                    </c:if>
                                </div>
                                <div class="col-lg-4"></div>
                            </div>
                            <%-- End Page--%>

                        </div>
                    </div>
                </div>
            </div>

        </section>

        <script src="./js/script.js"></script>

    </body>

</html>