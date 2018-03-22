<%-- 
    Document   : MainUser
    Created on : Dec 7, 2017, 10:13:56 AM
    Author     : hians
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Taskbox</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            if (session.getAttribute("user") == null) {
                request.getRequestDispatcher("UserLogin.jsp").include(request, response);
                out.println("<div class =\"container\">Login First</div>");
            } else {
        %>
        <div class="container">
            <!--
            Add delete update finish
            checkbox on each tasks created,
            when finished delete it from the page and db || send it to a finished tasks page
            add on click of add
            -->
            <br/><br/>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class = "navbar-brand" href = "#WebSiteName" >Taskbox Dashboard    </a>
                    </div>
                    <form class="navbar-form" action="Logout" method="get">
                        <div class="form-group">
                            <input type="Submit" value="Logout" class="btn btn-danger"> 
                        </div>
                    </form>
                </div>
            </nav>

            <div class="container">
                <table class="table table-hover">
                    <th>ID</th>
                    <th>Task</th>
                    <th>Due</th>
                    <th>Finish</th>

                    <%
                        Connection connection = null;
                        Statement statement = null;
                        ResultSet resultSet = null;
                        String sql = "SELECT * FROM task WHERE Member = '"+(String)session.getAttribute("user")+"'";
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
                        <td ><a class="btn btn-danger" href='Finished?ID=<%=resultSet.getString("ID")%>'>Finish</a></td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                        }
                    %>
                </table>

            </div>

        </div>
    </div>
    <% }%>
</body>
</html>
