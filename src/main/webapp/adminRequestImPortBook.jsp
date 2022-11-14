<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Request Import Book</title>
        <!-- link file CSS -->
        <link rel="stylesheet" href="./css/adminRequestImportBook.css">
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
                            <!--SEARCH-BOOK-REQUEST-->
                            <form action="adminShowListBookingRequest">
                                <input type="text" placeholder="Search..." name="txtSearchBookRequest" value="${param.txtSearch}">
                                <button type="submit"><i class='bx bx-search-alt-2'></i></button>
                            </form>
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
                <div class="overview-tableBookRequest">
                    <div class="wraper_addBookingRequest_nameTable">
                        <a href="./adminCreateBookRequestPage" class="addBookingRequest">
                            <i class='bx bx-add-to-queue'></i>
                            <span class="links_name">Add Book Request</span>
                        </a>
                    </div>
                    <hr style="width: 25.7rem;"/>
                    <h2 id="nameTable">LIST OF BOOK REQUEST</h2>
                    <div class="tableBookRequest">
                        <c:set var="listBookingRequest" value="${requestScope.LIST_BOOKING_REQUESTS}"/>
                        <c:if test="${not empty listBookingRequest}">
                            <table id="bookRequest">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>ID</th>
                                        <th>Image</th>
                                        <th>Name</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                        <th>Date</th>
                                        <th>Note</th>
                                        <th>Status</th>
                                        <th>Status_Book</th>
                                        <th>Update</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="bookRequestDTO" items="${listBookingRequest}" varStatus="counter">
                                    <form action="adminUpdateBookRequestAction" method="POST">
                                        <tr>
                                            <td>
                                                ${counter.count}
                                            </td>
                                            <td>
                                                ${bookRequestDTO.request_Id}
                                                <input class="textInforEmployee" type="hidden" name="txtHiddenRequest_Id" value="${bookRequestDTO.request_Id}"/>
                                            </td>
                                            <td>
                                                <img src="./images/${bookRequestDTO.image}" alt="..." id="imageBookRequest">
                                            </td>
                                            <td>
                                                <input class="textInforEmployee" type="text" name="txtName_Book" value="${bookRequestDTO.name_Book}"/>
                                            </td>
                                            <td>
                                                <input class="textInforEmployee" type="text" name="txtQuantity_Request" value="${bookRequestDTO.quantity_Request}"/>
                                            </td>
                                            <td>
                                                <input class="textInforEmployee" type="text" name="txtPrice_Request" value="${bookRequestDTO.price_Request}"/>
                                            </td>
                                            <td>
                                                <input class="textInforEmployee" type="text" name="date_Request" value="${bookRequestDTO.date_Request}"/>
                                            </td>
                                            <td>
                                                <input class="textInforEmployee" type="txtNote" name="" value="${bookRequestDTO.note}"/>
                                            </td>
                                            <td id="statusProcess">
                                                <c:if test="${bookRequestDTO.status == 0}">
                                                    <span style="color: blue;">Hide</span>
                                                </c:if>
                                                <c:if test="${bookRequestDTO.status == 1}">
                                                    <span style="color: #fab804ea;;">Proceeding</span>
                                                </c:if>
                                                <c:if test="${bookRequestDTO.status == 2}">
                                                    <span style="color: green;">Done</span>
                                                </c:if>
                                                <c:if test="${bookRequestDTO.status == 3}">
                                                    <span style="color: red;">Undone</span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <select name="select_StatusBook" class="select_StatusBook
                                                        <c:if test="${bookRequestDTO.status_Book_Request eq 'false'}">
                                                            newBook
                                                        </c:if>
                                                        <c:if test="${bookRequestDTO.status_Book_Request eq 'true'}">
                                                            updateBook
                                                        </c:if>">
                                                    <option class="newBookTmp" 
                                                            <c:if test="${bookRequestDTO.status_Book_Request eq 'true'}">
                                                                selected
                                                            </c:if>
                                                            value="false">
                                                        New 
                                                    </option>
                                                    <option class="updateBookTmp" 
                                                            <c:if test="${bookRequestDTO.status_Book_Request eq 'false'}">
                                                                selected
                                                            </c:if>
                                                            value="true">
                                                        Old
                                                    </option>
                                                </select>
                                            </td>
                                            <td>
                                                <input class="buttonActionUpdate" type="submit" value="Update"/>
                                            </td>
                                        </tr>
                                    </form>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty listBookingRequest}">
                            <h2 style="text-align: center;
                                align-items: center;
                                color: red">
                                CAN NOT FIND THIS RECORD !       
                            </h2>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <script src="./js/script.js"></script>
    </body>
</html>