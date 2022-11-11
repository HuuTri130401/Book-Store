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
                        <a href="#">
                            <i class='bx bx-home'></i>
                            <span class="links_name">Overview</span>
                        </a>
                    </li>
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
                        <a href="./adminShowListBookingRequest">
                            <i class='bx bx-import'></i>
                            <span class="links_name">Booking Request</span>
                        </a>
                    </li>
                    <li>
                        <a type="submit" href="adminBookAction?action=bookPage1">
                            <i class='bx bx-book'></i>
                            <span class="links_name">Books</span>
                        </a>
                    </li>
                    <li>
                        <a href="./adminShowListImportations">
                            <i class='bx bxs-report'></i>
                            <span class="links_name">Importation</span>
                        </a>
                    </li>
                    <!--                    <li>
                                            <a href="./adminShowListOrders">
                                                <i class='bx bx-list-ol'></i>
                                                <span class="links_name">Order</span>
                                            </a>
                                        </li>-->
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
                <div class="home-content">

                    <div class="overview-boxes">

                        <c:set var="sumOfTotalOrder" value="${requestScope.TOTAL_OF_ORDER}"/>
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Total Order</div>
                                <div class="number" style="color: #267871;">${sumOfTotalOrder} VNĐ</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box1'></i>
                                    <span class="text">During The Current Year</span>
                                </div>
                            </div>
                        </div>

                        <c:set var="sumTotalMoneyLastMonthBookRequest" value="${requestScope.TOTAL_MONEY_OF_LAST_MONTH}"/>        
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Total Money Of Request</div>
                                <div class="number" style="color: #0d8cba;">${sumTotalMoneyLastMonthBookRequest} VNĐ</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box2'></i>
                                    <span class="text">Money Book Request Last Month</span>
                                </div>
                            </div>
                        </div>

                        <c:set var="totalOfQuantityInventoryCurrentYear" value="${requestScope.TOTAL_QUANTITY_INVENTORY_CURRENT_YEAR}"/>        
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Total Inventory</div>
                                <div class="number"  style="color: #bcd214;">${totalOfQuantityInventoryCurrentYear} Book(s)</div>
                                <div class="indicator">
                                    <i class='bx bx-up-arrow-alt box3'></i>
                                    <span class="text">Inventory Current Year</span>
                                </div>
                            </div>
                        </div>

                        <c:set var="listMostInventoryBook" value="${requestScope.MOST_INVENTORY_BOOK}"/>
                        <div class="box">
                            <div class="left-side">
                                <div class="boxtopic">Most Remaining Books</div>
                                <c:forEach var="bookDTO" items="${listMostInventoryBook}">
                                    <div class="number" style="color: #ed6b15;">${bookDTO.quantity_Book} Book(s)</div>
                                    <div class="name-product">Name: ${bookDTO.name}</div>
                                    <div class="indicator">
                                        <i class='bx bx-up-arrow-alt box4'></i>
                                        <span class="text">Year Of Public: ${bookDTO.year_Of_Public}</span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                    <!-- add chart -->
                    <div class="graphBox">
                        <div class="boxShow">
                            <canvas id="myChart" style="max-height: 440px; width:100%"></canvas>
<!--                            <script>
                                //var xValues = [${requestScope.LIST_SEMESTER_STRING}];
                                //const ctx = document.getElementById('myChart').getContext('2d');
                                //const myChart = new Chart(ctx, {
                                
                                //var xValues = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
                                var xValues = [120, 109, 30, 50, 200, -200, 120, 190, 300, 300, 200, 300];
                                var yValues = [120, 109, 30, 50, 200, -200, 120, 190, 300, 300, 200, 300];
                                
                                new Chart("myChart", {
                                    type: "bar",
                                    data: {
                                        labels: xValues,
                                        datasets: [{
                                                label: '# Statistics For 12 Months',
                                                data: yValues,
                                                backgroundColor: [
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                    '#267871',
                                                ],
                                                borderWidth: 1
                                            }]
                                    },
                                    options: {
                                        legend: {display: true},
                                        responsive: true,
                                    }
                                });
                            </script>-->
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <script src="./js/script.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
        <script src="./js/my_chart.js"></script>
    </body>

</html>