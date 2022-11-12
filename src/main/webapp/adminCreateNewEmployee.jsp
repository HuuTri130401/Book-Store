<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Create New Employee</title>
        <link href="https://fonts.googleapis.com/css?family=Assistant:400,700" rel="stylesheet">
        <link rel="stylesheet" href="./css/signUpForm.css">
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <section class='login' id='login'>
            <div class='head'>
                <h1 class='company'>Phuong Nam Book Store</h1>
            </div>
            <c:set var="createEmpMsg" value="${requestScope.INSERT_EMPLOYEE_MSG}"/>

            <p class='msg'>Welcome to Sign Up</p>
            <div class='form'>
                <form action="adminCreateEmployeeAction" method="POST">
                    <input type="text" placeholder='AccountID' name="txtAccountID" class='text' id='AccountID' required  minlength="4"  maxlength="25"><br>
                    <c:if test="${not empty createEmpMsg}">
                        <span class='text' style="color: red" >${createEmpMsg.account_IdError}</span>
                    </c:if>
                    <input type="password" placeholder='Password' name="txtPassword" class='password' required minlength="5"  maxlength="20"><br>
                    <input type="password" placeholder='Confirm-Password' name="txtConfirmPassword" class='password' required  minlength="5"  maxlength="20"><br>
                    <input type="text" placeholder='Name' name="txtFullName" class='text' required  minlength="3"  maxlength="30"><br>
                    <input type="number" placeholder='Phone' name="txtPhone" class='number' id='phone'><br>
                    <input type="text" placeholder='Address' name="txtAddress" class='text' id='address' minlength="4" maxlength="30" required><br>
                    <table border="0">
                        <tbody class="text">
                            <tr>
                                <td>Gender</td>
                                <td><input type="radio" name="radioGender" class="radio" value="Male" checked="checked"> Male</td>
                                <td><input type="radio" name="radioGender" class="radio" value="Female"> Female</td>
                                <td><input type="radio" name="radioGender" class="radio" value="Other"> Other</td>
                            </tr>
                            <tr>
                                <td>Role</td>
                                <td><input type="radio" name="radioRole" class="radio" value="Seller" checked="checked"> Seller<br/></td>
                                <td><input type="radio" name="radioRole" class="radio" value="Staff"> Staff<br/></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                    <c:if test="${not empty createEmpMsg}">
                        <h3 class='text' style="color: red" >${requestScope.INSERT_EMPLOYEE_MSG.employeeErrorMsg}</h3>
                    </c:if>
                    <div class="wrapper-button">
                        <a href="./adminShowListEmployees" class='btn-login'>Back Manage Employees</a>
                        <input type="submit" class='btn-signup' value="Sign Up"/>
                    </div>       
                </form>

            </div>
        </section>
        <!-- partial -->
        <script  src="./js/LoginForm.js"></script>
    </body>
</html>
