<%-- 
    Document   : login
    Created on : Jun 25, 2022, 5:11:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <style>
            .wrapper {
                position: fixed;
                top: 30%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 20px;
                background-color: antiquewhite;
                border-radius: 5px;
                text-align: center;
            }

            .tableLogin {
                font-size: 16px;
                font-family: Arial, Helvetica, sans-serif;
                width: 80%;
            }

            .button{
                width: 200px;
                min-width: 50px;
                height: 30px;
                border-radius: 5px;
                padding: 10px 20px;
                display: inline-block;
            }

            .button--submit{
                text-align: center;
                width: 70px;
                background-color: #33b249;
            }
            .button--submit:hover{
                background-color: #699570; 
                cursor: pointer;
            }

            .button--reset{
                text-align: center;
                width: 70px;
                background-color: #5adbb5;
            }
        </style>

        <form action="loginAction" method="POST">
            <div class="wrapper">
                <h1>LOGIN</h1>
                <table class="tableLogin">
                    <thead>
                        <tr>
                            <th>User ID </th>
                            <th><input class="txtInput" type="text" name="txtUserID" value="" /></th>
                        </tr>
                        <tr>
                            <th>Password </th>
                            <th><input class="txtInput" type="password" name="txtPassword" value="" /></th>
                        </tr>
                    </thead>
                </table>   
                <div class="button">
                    <input class="button button--submit" type="submit" value="Login" name="btnAction" />
                    <input class="button button--reset" type="reset" value="Reset" />
                </div>
            </div>

        </form>
    </body>
</html>
