<%-- 
    Document   : AdminReg
    Created on : Dec 15, 2017, 5:41:11 PM
    Author     : hians
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Registration</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>.jumbotron{
                background-color: aliceblue;
                width:50%;
            }
            .btn{
                float: right;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <center>
                <h2>Administrator Registration Page</h2>
                <div class="jumbotron">
                    <form action="AdminReg" method="post">
                        <table class="table table-stripped">
                            <tr>
                                <td>Username</td>
                                <td><input type="text" name="username" class="form-control" required/></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="password" class="form-control" required/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Register" class="btn btn-success"/></td>
                            </tr>
                        </table>
                    </form>
                </div>
        </div>
    </center>
</body>
</html>
