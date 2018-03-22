/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syook.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hians
 */
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter pw = response.getWriter()) {
            String sid = request.getParameter("ID");
            int id = Integer.parseInt(sid);
            
                List<String> data = TaskboxDao.getTaskByID(id);
                String Task, Due, Member;
                Task = data.get(0);
                Due = data.get(1);
                Member = data.get(2);
                pw.print("<head> "
                        + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
                        + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>"
                        + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"
                        + "</head>"
                        + "<body>"
                        + "<div class=\"container\">"
                        + "<div class = \"jumbotron\">");
                pw.println("<h2>Update Employee</h2>");
                pw.print("<form action='EditServlet2' method='post'>");
                pw.print("<table class=\"table table-hover\">");
                pw.print("<tr><td>ID</td><td><input type='text' name='ID' class=\"form-control\" value='" + id + "'/></td></tr>");
                pw.print("<tr><td>Task</td><td><input type='text' name='Task' class=\"form-control\" value='" + Task + "'/></td></tr>");
                pw.print("<tr><td>Due</td><td><input type='date' name='Due' class=\"form-control\" value='" + Due + "'/></td></tr>");
                pw.print("<tr><td>Member</td><td><select name=\"Member\" class=\"form-control\">"
                        + "<option value=\""+Member+"\" selected>Assigned to "+Member+"</option>");
                //===============For Member==================
            try {
                Connection con = null;
                ResultSet rs = null;
                PreparedStatement ps = null;
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://E:\\WorK\\Syook\\Syook.mdb");
                ps = con.prepareStatement("SELECT username from TblLogin");
                rs = ps.executeQuery();
                while(rs.next()){
                    String Username = rs.getString("username");
                    pw.print("<option value=\""+Username+"\">"+Username+"</option>");
                }
            }
            catch(Exception err){}
                //Member Ends
                pw.print("</select></td></tr>");
                pw.print("<tr><td></td><td><input type=\"Submit\" class=\"btn btn-success\"/></td></tr>");
                pw.print("</table>");
                pw.print("</form>"
                        + "</div></div>"
                        + "</body>");
            }
        }

    

    private List<String> ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
