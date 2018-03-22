<%-- 
    Document   : UserLogin
    Created on : Nov 29, 2017, 10:50:55 AM
    Author     : hians
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Syook-TaskBox User Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .half{
                width: 50%;
                align-items: center;
                align-content: center;
            }
            .aligning{
                float: right;
            }
        </style>
    </head>
    <body>
    <center>
        <div class ="container">
            <div class ="jumbotron half">
                <form  method="post" action="LoginServlet">
                    <h2>User Login</h2>
                    <table class ="table table-hover">
                        <tr>
                            <td><input placeholder ="Username" type="text" name="user" required class="form-control"/>
                        </tr>
                        <tr>
                            <td><input required placeholder ="Password" type="password" name="pwd" class="form-control"/>
                        </tr>
                        <tr>
                            <td><input type="submit" class="btn btn-success aligning" value="Login"/>
                        </tr>
                        <tr>
                            <td><a href="UserReg.jsp">Register ?</a></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </center>
</body>
</html>
