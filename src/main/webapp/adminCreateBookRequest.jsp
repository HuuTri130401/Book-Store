<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Create Booking Request</title>
        <link href="https://fonts.googleapis.com/css?family=Assistant:400,700" rel="stylesheet">
        <link rel="stylesheet" href="./css/signUpForm.css">
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <section class='login' id='login'>
            <div class='head'>
                <h1 class='company'>Phuong Nam Book Store</h1>
            </div>
            <p class='msg'>Create Booking Request</p>
            <div class='form'>
                <form action="adminCreateBookRequestAction" method="POST">
                    <span class='text'>Choose Image: </span><input type="file" name="imgImage" id='Image' required><br>
                    <input type="text" placeholder='Book Name' name="txtBookName" class='text' required><br>
                    <input type="text" placeholder='Quantity' name="txtQuantityBook" class='text' required><br>
                    <input type="text" placeholder='Price' name="txtPrice" class='text' required><br>
                    <!--<span class='text'>Date Create: </span><input type="date" name="txtDate" class='dateImport' required><br>-->
                    <input type="text" placeholder='Note' name="txtNote" class='text'><br>
                    <table border="0">
                        <tbody class="text">
                            <tr>
                                <td>Status</td>
                                <td><input type="radio" name="radioStatus" class="radio" value="1" checked="checked">Proceeding</td>
                            </tr>
                            <tr>
                                <td>Status Of Book</td>
                                <td><input type="radio" name="radioStatusBook" class="radio" value="New" checked="checked">New<br/></td>
                                <td><input type="radio" name="radioStatusBook" class="radio" value="Old">Old<br/></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="wrapper-button">
                        <a href="./adminShowListBookingRequest" class='btn-login'>Back Manage List Booking Request</a>
                        <input type="submit" class='btn-signup' value="Create" />
                    </div>                       
                </form>
                <div>
                    <span class='text' style="color: red" >${requestScope.BOOK_ERROR}</span>
                </div>
            </div>
        </section>
        <!-- partial -->
        <script  src="./js/LoginForm.js"></script>
    </body>
</html>
