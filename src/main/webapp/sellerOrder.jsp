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

        <title>Seller Order</title>
        <!-- link file CSS -->
        <link rel="stylesheet" href="./css/adminManageBooksStyle.css">
        <!-- BoxIcon CDN Link -->
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        
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

            /*Start Form Add To Inventory*/
            .modal-dialog{
                margin-top: 200px;

            }
            .input-group{
                height: 40px;
            }
            .form-control{
                height: 40px;
            }
            .add{
                width: 70px;
                height: 28px;
                margin-right: 10px;
                font-size: 15px;
            }

            .head-form{
                color: red;
                font-weight: bold;
                margin: 8px 0px 5px 9px;
            }
            .xclose{
                width: 70px;
                height: 28px;
                margin-right: 10px;
                font-size: 15px;
            }
            /*End Form Add To Order*/
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
                        <form action="searchBookAction">
                            <div class="search-box">
                                <input type="text" placeholder="Search..." name="txtSearchBookName" value="${param.txtSearchBookName}">
                                <button type="submit"><i class='bx bx-search-alt-2'></i></button>
                            </div>
                        </form>
                        
                        <form action="addToCartAction?action=viewCart" method="POST">
                            <button type="submit"></i>View Cart</button>
                            <p style="red">${MESSAGE}</p>
                        </form>
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
                    <a href="sellerNodifyPage">
                        <i class='bx bxs-bell'></i>
                        <span class="links_name">Notify</span>
                    </a>
                </li>
                <li>
                    <a href="sellerOrderPage">
                        <i class='bx bxs-cart-alt'></i>
                        <span class="links_name">Order</span>
                    </a>
                </li>
                <li>
                    <a href="sellerListOrderPage">
                        <i class='bx bxs-spreadsheet'></i>
                        <span class="links_name">List order</span>
                    </a>
                </li>
                
                <li>
                    <a href="logoutAction">
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
                            <c:set var="txtSearch" value="${param.txtSearchBookName}"/>
                            <c:if test="${not empty txtSearch}">
                                <p style="font-size: 18px; padding-left: 24px;">Result for "${txtSearch}" </p>
                                    <table class="table">
                                        <thead class="thead-dark" style="font-size: 15px">
                                            <tr>
                                                <th style="text-align: center">ID</th>
                                                <th style="text-align: center">Cover</th>
                                                <th style="text-align: center">Name</th>
                                                <th style="text-align: center">Author</th>
                                                <th style="text-align: center">Category</th>
                                                <th style="text-align: center">Quantity</th>
                                                <th style="text-align: center">Price</th>
                                                <th style="text-align: center">Add to Order</th>
                                            </tr>
                                        </thead>
                                        <tbody style="font-size: 15px">
                                            <c:set var="bookList" value="${requestScope.BOOK_SEARCH_LIST}"/>
                                            <c:forEach var="book" items="${bookList}">
                                                <c:if test="${book.status==true}">
                                                    <tr>
                                                        <form action="addToCartAction?action=addToCart" method="POST">
                                                        <td style="text-align: center">
                                                            ${book.book_Id}
                                                            <input type="hidden" name="book_Id_Cart" value="${book.book_Id}"/>
                                                        </td>
                                                        <td style="text-align: center">
                                                            <img style="height: 100px;width: 100px" src="<c:url value="/images/${book.image_Book}"/>"/>
                                                        </td>
                                                        <td style="text-align: center">${book.name}</td>
                                                        <td style="text-align: center">${book.author}</td>
                                                        <td style="text-align: center">${book.categoryName}</td>
                                                        <td style="text-align: center">${book.quantity_Book}</td>
                                                        <td style="text-align: center">${book.price_Book}</td>
                                                        <td style="text-align: center">
                                                            <button style="font-size: 30px;border: none" data-toggle="modal" data-target="#myModal">
                                                                <i class="material-icons">add</i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                                
                                                    <div class="modal fade" id="myModal">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <header class="head-form mb-0">
                                                                    <h2>Add Book To Cart</h2>
                                                                </header>
                                                                <div class="modal-body">
                                                                    <%--Form --%>
                                                                    
                                                                    <%--  ID BOOK Insert To Inventory SQL--%>
                                                                    <input type="hidden" name="book_Id_Cart" value="${book.book_Id}"/>
                                                                    <%--  Add Quantity To Cart --%>
                                                                    <div class="form-group">
                                                                        <div class="input-group">
                                                                            <div class="input-group-prepend">
                                                                                <span class="input-group-text"><i class="fa fa-address-book"></i></span>
                                                                            </div>
                                                                            <input type="number" min="1" required="" name="quantity" class="form-control input-sm"
                                                                                                   style="font-size: 15px" placeholder="Quantity">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <!-- Modal footer -->
                                                                <div class="modal-footer" id="modal-footer">
                                                                    <button type="submit" class="btn btn-info add">Add</button>
                                                                    </form>
                                                                    <button class="btn btn-warning xclose" data-dismiss="modal">Close</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:if>
                                
                                <c:if test="${empty txtSearch}">
                                    <form class="formCategory" action="sellerBookAction" method="POST">
                                    </form><br/>
                                    <div class="itemList row">
                                        <c:forEach items="${listBook}" var="b">
                                            <div class="item col-lg-6">
                                                <form action="sellerBookAction?action=bookDetail&bookId=${b.book_Id}&categoryId=${b.category}"
                                                                              method="POST">
                                                    <div class="border">
                                                        <img src="<c:url value="/images/${b.image_Book}"/>"/><br/>
                                                        <p class="name">${b.name}</p> <br/>
                                                        <p class="price"><fmt:formatNumber value="${b.price_Book}" type="number"/>
                                                        <small style="text-decoration:underline">đ</small><p><br/>
                                                        <button class="viewDetail btn btn-info" type="submit">View Detail</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="page row">
                                        <div class="col-lg-4"></div>
                                            <div class="col-lg-4 d-flex justify-content-center" >
                                                <a type="submit" href="sellerBookAction?action=bookPage1">1</a>
                                                <a type="submit" href="sellerBookAction?action=bookPage2">2</a>
                                                <a type="submit" href="sellerBookAction?action=bookPage3">3</a>
                                                <a type="submit" href="sellerBookAction?action=bookPage4">4</a>
                                            </div>
                                        <div class="col-lg-4"></div>
                                    </div>
                                </c:if>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <script src="./js/script.js"></script>


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