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

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
        .boxDescription {
            border-radius: 15px;
            background-color: rgba(224, 219, 219, 0.68);
            margin-left: 10px;
            margin-top: 30px;
        }

        .description {
            margin-top: 20px;
            font-size: 22px;
            margin-left: 10px;
        }

        .description .text {
            padding-top: 10px;
            font-size: 15px;
        }

        /*End Description*/

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
        /*End Form Add To Inventory*/


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
                        <span class="name">${sessionScope.USER["fullName"]}</span>
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
            <a href="staffNodifyPage">
                <i class='bx bxs-bell'></i>
                <span class="links_name">Nodify</span>
            </a>
        </li>
        <li>
            <a href="./adminManageEmployees.jsp">
                <i class='bx bx-notification'></i>
                <span class="links_name">Request</span>
            </a>
        </li>
        <li>
            <a href="#">
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
                <i class='bx bx-carousel'></i>
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
                    <div class="categoryText">
                        <a style="color: black" href="staffBookAction?action=bookPage1">Category </a> >
                        <a style="color: #17A2B8" href="staffBookAction?action=${nameCategory}"> ${nameCategory}</a>
                    </div>
                    <c:forEach items="${listBook}" var="b">
                        <c:set var="bookId" value="${bookIdServlet}"></c:set>
                        <c:if test="${b.book_Id==bookId}">

                            <%--         Item Book Need Show--%>
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
                                    <button class="inventory btn btn-danger" data-toggle="modal"
                                            data-target="#myModal">Inventory
                                    </button>
                                    <button class="btn btn-info" style="font-size: 30px;">Importation</button>
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
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="./js/script.js"></script>

<%--Form Add to Inventory--%>
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <header class="head-form mb-0">
                <h2 id="header-title">Add Book To Inventory</h2>
            </header>

            <div class="modal-body">
                <%--Form --%>
                <form action="staffInventoryAction?action=insertInventory" method="POST">
                    <%--  ID BOOK Insert To Inventory SQL--%>
                    <input type="hidden" name="book_Id_Inventory" value="${bookIdServlet}"/>
                    <%--  DO Note And Quantity Inventory --%>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-briefcase"></i></span>
                            </div>
                            <select style="font-size: 15px" class="form-control" name="note">
                                <option >Reason</option>
                                <option value="Moldy Book">Moldy Book</option>
                                <option value="Book Lost Team">Book Lost Team</option>
                                <option value="Book Is Bent">Book Is Bent</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-address-book"></i></span>
                            </div>
                            <input type="text" name="quantity" class="form-control input-sm"
                                  style="font-size: 15px" placeholder="Quantity">
                        </div>
                    </div>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer" id="modal-footer">
                <button type="submit" class="btn btn-info add">Add Book</button>
                </form>
                <button class="btn btn-warning xclose" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
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