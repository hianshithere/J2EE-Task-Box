<%@page import="java.sql.*"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : finishedTask
    Created on : Dec 7, 2017, 10:16:23 AM
    Author     : hians
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finished Task</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body><%
        String username = (String) session.getAttribute("userAdmin");
        if (username == null) {
            request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
            out.println("<h2>Login Please</h2>");
        } else {
        %>
        <div class="container">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container-fluid">
                    <div class"navbar-header">
                         <a class = "navbar-brand" href="Main.jsp"><b>Finished Task  </b></a>
                    </div>
                    <ul class="nav navbar navbar-nav navbar-right">
                        <li><a href="Main.jsp" class="btn btn-default">Home</a></li>
                    </ul>
                </div>
            </nav>
            <div class="container">
                <br><br><br><br><br><br><br>
                <table class="table table-hover">
                    <th>ID</th>
                    <th>Task</th>
                    <th>Due</th>
                    <th>Member</th>
                    <th>Reassign</th>
                    <th>Delete</th>
                        <%
                            Connection connection = null;
                            Statement statement = null;
                            ResultSet resultSet = null;
                            String sql = "SELECT * FROM TblFinishedTask ";
                            try {
                                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                                connection = DriverManager.getConnection("jdbc:ucanaccess://E:\\WorK\\Syook\\Syook.mdb");
                                statement = connection.createStatement();
                                resultSet = statement.executeQuery(sql);
                                while (resultSet.next()) {
                        %>
                    <tr>
                        <td><%=resultSet.getString("ID")%></td>
                        <td><%=resultSet.getString("Task")%></td>
                        <td><%=resultSet.getString("Due")%></td>
                        <td><%=resultSet.getString("Member")%></td>
                        <td><a class="btn btn-danger" href='ReassignServlet?ID=<%=resultSet.getString("ID")%>'>Reassign</a></td>
                        <td ><a class="btn btn-danger" href='DeleteFinish?ID=<%=resultSet.getString("ID")%>'>Delete</a></td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                        }
                    %>
                </table>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>
