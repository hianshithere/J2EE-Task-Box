/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syook.work;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hians
 */
public class EditServlet2 extends HttpServlet {

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
            out.println("<title>Servlet EditServlet2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet2 at " + request.getContextPath() + "</h1>");
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

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int ID = Integer.parseInt(request.getParameter("ID"));
        String Task = request.getParameter("Task");
        String Due = request.getParameter("Due");
        String Member = request.getParameter("Member");
        Taskbox e = new Taskbox();
//        int status = TaskboxDao.save(e);
//        System.out.println(ID+" Task "+Task+" Due "+Due);
        HttpSession session  = request.getSession();
        int status = TaskboxDao.update(ID, Task, Due, Member);
        if (status > 0) {
            request.getRequestDispatcher("Main.jsp").include(request, response);
            out.println("<div class = \"container\"<p>Updated sucessfully</p></div>");
        } else {
            request.getRequestDispatcher("Main.jsp").include(request, response);
            out.println("<div class = \"container\"<h3>"+status+" Sorry! unable to update record</h3></div>");
            out.println("data : ");
            out.println("ID = " + ID
                    + "\tTask = " + Task
                    + "\tDue = " + Due);
        }

        out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
