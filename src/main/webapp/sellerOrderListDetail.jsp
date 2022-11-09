
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Seller Order Detail</title>
        <!-- link file CSS -->
        <link rel="stylesheet" href="./css/adminHomeStyle.css">
        <link rel="stylesheet" href="./css/orderdetail.css">
        <!-- BoxIcon CDN Link -->
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>--%>
        <%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>--%>
        <%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>--%>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:set var="order" value="${requestScope.ORDER}"/>
        <c:set var="category" value="${requestScope.BOOK_CATEGORY}"/>
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
                        <form action="searchBookAction">
                            <div class="search-box">
                                <input type="text" placeholder="Search..." name="txtSearchBookName" value="${param.txtSearchBookName}">
                                <button type="submit"><i class='bx bx-search-alt-2'></i></button>
                            </div>
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
                                    <i class='bx bxs-cart-alt'></i>
                                    <span class="links_name">Order</span>
                                </a>
                    </li>
                    <li>
                                <a href="sellerOrderListAction">
                                    <i class='bx bxs-spreadsheet'></i>
                                    <span class="links_name">List Order</span>
                                </a>
                    </li>
                    <li>
                        <a href="logoutAction">
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
                                <c:set var="empdet" value="${requestScope.EMPLOYEE_DETAILS}"/>
                                <div class="wrapper col-10" style="background-color: #F7F8FC; padding: 30px 33px 30px 45px;" id="maincontent">
                                    <!-- main list -->
                                    <div class="listwrapper">
                                        <!-- list header -->
                                        <div class="listheader row">
                                            <div class="col-2 d-flex justify-content-start align-items-center">
                                                <p style="font-size: 19px; font-weight: 500; padding: 0;">Order ID: ${order.order_Id}</p>
                                            </div>
                                            <div class="col-6 row"></div>
                                            <div class="extended col-4 row d-flex"></div>
                                        </div>
                                        <div class="infor row">
                                            <div class="col">
                                                <p style="font-size: 17px">Employee's fullname</p><br>
                                                <div class="empinfo">${user.fullName}</div>
                                            </div>
                                            <div class="col">
                                                <p style="font-size: 17px">Order date</p><br>
                                                <div class="empinfo">${order.date_To_Order}</div>
                                            </div>
                                        </div>
                                        <div class="infor row">
                                            <div class="col">
                                                <p style="font-size: 17px">Total kind of book</p><br>
                                                <div class="empinfo">${order.quantity_Order}</div>
                                            </div>
                                            <div class="col">
                                                <p style="font-size: 17px">Total price</p><br>
                                                <div class="empinfo">${order.total_Order}</div>
                                            </div>
                                        </div>
                                    </div>
                                            
                                    <div class="separator col-12"></div>
                                    
                                    <div class="listheader row">
                                        <div class="col-2 d-flex justify-content-start align-items-center">
                                            <p style="font-size: 19px; font-weight: 500; padding: 0;">Ordered Books</p>
                                        </div>
                                        <div class="col-6 row"></div>
                                        <div class="extended col-4 row d-flex"></div>
                                    </div>
                                    <table class="table">
                                        <thead class="thead-dark" style="font-size: 15px">
                                        <tr>
                                            <th>No.</th>
                                            <th style="text-align: center">Book ID</th>
                                            <th style="text-align: center">Cover</th>
                                            <th style="text-align: center">Title</th>
                                            <th style="text-align: center">Category</th>
                                            <th style="text-align: center">Quantity</th>
                                            <th style="text-align: center">Unit price</th>
                                            <th style="text-align: center">Total</th>
                                        </tr>
                                        </thead>
                                        <tbody style="font-size: 15px">
                                            <c:forEach var="detail" items="${order.details}" varStatus="counter">
                                                <tr style="height: 92px;" onclick="location.href='sellerOrderDetailAction?orderId=${order.order_Id}';">
                                                    <td> ${counter.count} </td>
                                                    <td style="text-align: center">${detail.bookId}</td>
                                                    <td style="text-align: center">
                                                        <img style="height: 100px;width: 100px" src="<c:url value="/images/${detail.cover}"/>"/>
                                                    </td>
                                                    <td style="text-align: center">${detail.title}</td>
                                                    <td style="text-align: center">
                                                        <c:forEach var="cate" items="${category}">
                                                           <c:if test="${cate.ID == detail.cateId}">
                                                                ${cate.name}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td style="text-align: center">${detail.quantity}</td>
                                                    <td style="text-align: center">${detail.price}</td>
                                                    <td style="text-align: center">${detail.total}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
