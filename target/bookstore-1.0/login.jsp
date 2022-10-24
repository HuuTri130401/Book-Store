<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Login Page</title>
        <link href="https://fonts.googleapis.com/css?family=Assistant:400,700" rel="stylesheet">
        <link rel="stylesheet" href="./css/loginFormStyle.css">
    </head>

    <body>
        <!-- partial:index.partial.html -->
        <section class='login' id='login'>
            <div class='head'>
                <h1 class='company'>Phuong Nam Book Store</h1>
            </div>
            <p class='msg'>Welcome to Login</p>
            <div class='form'>
                <form action="loginAction" method="POST">
                    <input type="text" placeholder='Username' class='text' id='username' required name="txtAccountId"><br>
                    <input type="password" placeholder='Password' class='password' name="txtPassword"><br>
                    <input type="submit" class='btn-login' value="Login" />
                    <input type="reset" class="btn-cancel" value="Cancel" />    
                </form>
            </div>
        </section>
        <!-- partial -->
        <script  src="./js/LoginForm.js"></script>
    </body>
   
</html>
