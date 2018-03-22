<%-- 
    Document   : AdminLogin
    Created on : Dec 6, 2017, 11:19:47 AM
    Author     : hians
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Admin Login Page</title>
    </head>
    <body>
    <center>
        <div class="container">
            <h2>Admin Login</h2>
            <div class="jumbotron" style="width: 50%;">
                <form action="AdminLogin" method="post">
                    <table class="table table-stripped">
                        <tr>
                            <td><input type="text" name ="userAdmin" placeholder="username" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><input type="password" name = "pwd" placeholder="password" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td><input type="Submit" value="Login" style="float: right" class="btn btn-success"/></td>
                        </tr>
                        <tr>
                            <td><a href="AdminReg.jsp">Register ?</a></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </center>
</body>
</html>
