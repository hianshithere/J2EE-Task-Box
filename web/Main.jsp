<%-- 
    Document   : Main
    Created on : Nov 21, 2017, 2:56:27 PM
    Author     : hians
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.syook.work.Taskbox" %>
<%@ page import="com.syook.work.TaskboxDao" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Syook-Taskbox</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            if (session.getAttribute("userAdmin") == null) {
                request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
                out.println("<div class = \"container\"><h2>Login First</h2></div>");
            } else {
        %>
        <div class="container">
            <!--
            Add delete update finish
            checkbox on each tasks created,
            when finished delete it from the page and db || send it to a finished tasks page
            add on click of add
            -->
            <br/>
            <br/>
            <%
                out.println("<h2>" + session.getAttribute("userAdmin") + "</h2>");
            %>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class = "navbar-brand" href = "#WebSiteName" >Taskbox Dashboard    </a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="add.jsp" class="btn btn-default" type="submit" name="Add">Add</a> 
                        </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                        <li>
                                <a class="btn btn-default" href="LogoutAdmin?">Logout</a>
                                <!--<a class="btn btn-danger"><input type="submit" value="Logout" class="btn btn-danger"/></a>-->
                        </li>
                        <li></li>
                        <li>
                            <a href="finishedTask.jsp" class="btn btn-default">History</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="container">
                <table class="table table-hover">
                    <th>ID</th>
                    <th>Task</th>
                    <th>Due</th>
                    <th>Member</th>
                    <th>Edit</th>
                    <th>Delete</th>

                    <%
                        Connection connection = null;
                        Statement statement = null;
                        ResultSet resultSet = null;
                        String sql = "Select * from task";
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
                        <td><a class="btn btn-default" href='EditServlet?ID=<%=resultSet.getString("ID")%>'>Edit</a></td>
                        <td ><a class="btn btn-danger" href='Delete?ID=<%=resultSet.getString("ID")%>'>Delete</a></td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                        }
                    %>
                </table>
            </div>
        </div>
        <% }%>
    </body>
</html>

