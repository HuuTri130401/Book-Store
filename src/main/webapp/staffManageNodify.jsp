<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Staff Notify</title>
        <!-- link file CSS -->
        <link rel="stylesheet" href="./css/Notify.css">
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
                        <a href="staffNodifyPage">
                            <i class='bx bxs-bell'></i>
                            <span class="links_name">Notification</span>
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
                    <div class="home-notify">
                    <p class="notify">NOTIFICATION</p>
                    <div>
                        <p class="text">
                           <strong> 20/11/2022:</strong> Sale 10% các đơn hàng tri ân ngày Nhà Giáo Việt Nam <br/>
                            <strong> 23/11/2022 - 30/11/2022: </strong>Sale Black Friday giảm giá 30% các đơn hàng có giá trị từ 200.000vnd trở lên<br/>
                            <strong>  12/12/2022: </strong>Sale 10% các đơn hàng từ 150.000vnd<br/>
                            <strong>24/12/2022 - 25/12/2022:</strong> Nghĩ Lễ Noel<br/>
                            <strong>  1/1/2022:</strong> Nghĩ tết dương lịch<br/>
                            <strong>18/1/2022: </strong>Lễ tất niên cuối năm<br/>
                            <strong> 21/1/2022 - 25/1/2022:</strong> Nghĩ tết âm lịch</p>
                    </div>
                    </div>
                </div>
            </div>

            <script src="./js/script.js"></script>

    </body>

</html>