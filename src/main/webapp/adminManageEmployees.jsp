<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Manage Employees</title>
        <!-- link file CSS -->
        <link rel="stylesheet" href="./css/adminManageEmployeesStyle.css">
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
                            <!--SEARCH_EMPLOYEE-->
                            <form action="adminShowListEmployees">
                                <input type="text" placeholder="Search... " name="txtSearch" value="${param.txtSearch}">
                                <button type='submit'><i class='bx bx-search-alt-2'></i></button>
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
                    <div class="overview-tableEmployee">
                        <h2 id="nameTable">LIST OF EMPLOYEES</h2>

                        <c:set var="listEmployees" value="${requestScope.LIST_EMPLOYEES}"/>

                        <c:if test="${not empty listEmployees}">
                            <div class="tableEmployee">
                                <table id="employees">
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>EmployeeID</th>
                                            <th>AccountID</th>
                                            <th>Password</th>
                                            <th>Name</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>Gender</th>
                                            <th>Role</th>
                                            <th>Status</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="employeeDTO" items="${listEmployees}" varStatus="counter">
                                        <form action="adminUpdateEmployeeAction">
                                            <tr>
                                                <td>
                                                    ${counter.count}
                                                </td>
                                                <td>
                                                    ${employeeDTO.employee_Id}
                                                    <input type="hidden" name="txtHiddenEmployee_Id" value="${employeeDTO.employee_Id}"/>
                                                </td>
                                                <td>
                                                    <input type="text" name="txtAccount_Id" value="${employeeDTO.account_Id}" />
                                                </td>
                                                <td>
                                                    <input type="text" name="txtPassword" value="${employeeDTO.password}" />
                                                </td>
                                                <td>
                                                    <input type="text" name="txtFullName" value="${employeeDTO.fullName}" />
                                                </td>
                                                <td>
                                                    <input type="text" name="txtPhone" value="${employeeDTO.phone}" />
                                                </td>
                                                <td>
                                                    <input type="text" name="txtAddress" value="${employeeDTO.address}" />
                                                </td>
                                                <td>
                                                    <input type="text" name="txtGender" value="${employeeDTO.gender}" />
                                                </td>
                                                <td>
                                                    <input type="text" name="txtRole" value="${employeeDTO.role}" />
                                                </td>
                                                <td>
                                                    <input type="text" name="txtStatus_Employee" value="${employeeDTO.status_Employee}" />
                                                </td>
                                                <td>
                                                    <input type="submit" value="Update"/>
                                                </td>
                                                <td>
                                                    <c:url var="urlRewriting" value="adminDeleteEmployeeAction">
                                                        <c:param name="employee_Id" value="${employeeDTO.employee_Id}"/>
                                                    </c:url>
                                                    <a href=${urlRewriting}>Delete</a>
                                                </td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <%--</c:if>--%>
                        </c:if>
                        <c:if test="${empty listEmployees}">
                            <h2 style="margin-top: 10rem ">
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