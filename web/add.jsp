<%-- 
    Document   : add
    Created on : Nov 22, 2017, 12:11:38 PM
    Author     : hians
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddData</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>
            .floatleft{
                float: right;
            }
        </style>
    </head>
    <body>
        <br />
        <br />
        <div class="container-fluid">
            <div class ="jumbotron">
                <form method="post" action="AddServlet">
                    <h2>Add Task</h2>
                    <table class="table">
                        <tr>
                            <td>Task</td>
                            <td><input type = "text" name="Task" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Due</td>
                            <td><input type = "date" name="Due" class="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Member</td>
                            <td>
                                <select class="form-control" name="Member">
                                    <%
                                        try{
                                            Connection con = null;
                                        ResultSet rs = null;
                                        PreparedStatement ps = null;
                                        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                                        con = DriverManager.getConnection("jdbc:ucanaccess://E:\\WorK\\Syook\\Syook.mdb");
                                        ps = con.prepareStatement("SELECT username from TblLogin");
                                        rs = ps.executeQuery();
                                        while(rs.next()){
                                            String username = rs.getString("username");
                                            %>
                                            <option value ="<%=username%>"><%=username%></option>
                                    <%
                                        }
                                        }
                                        catch(SQLException sqle){
                                            
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td></td> 
                            <td><input type = "Submit" Value="Submit" name="Task" class="btn btn-default" /></td>
                        </tr>
                    </table>
                </form>
                <div class="floatleft">
                    <a href="Main.jsp" class="btn btn-danger" type="submit" name="Delete">Home</a>
                </div>
            </div>
        </div>
    </body>
</html>
