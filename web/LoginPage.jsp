<%-- 
    Document   : Log
    Created on : Dec 19, 2017, 11:41:20 AM
    Author     : hians
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Syook-Taskbox</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>
            .jumbotron{
                width: 50%;
            }
            .btn{
                float: right;
            }
        </style>
    </head>
    <body>
        <form action="LogServlet" method="post">
            <center>
                <div class="container">
                    <div class="jumbotron">
                        <h2>Login Page</h2>
                        <table class="table table-hover">
                            <tr>
                                <td><input type="text" placeholder="username" name="user" class="form-control"></td>
                            </tr>
                            <tr>
                                <td><input type="password" placeholder="password" name="pwd" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" value="Login" class="btn btn-success"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </center>
        </form>
    </body>
</html>
