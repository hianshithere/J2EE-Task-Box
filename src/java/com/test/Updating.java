package com.test;

import com.syook.work.Taskbox;
import com.syook.work.TaskboxDao;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Updating {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\WorK\\Syook\\Syook.mdb");
            System.out.println("Connection Established !");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }

    public static int update(int ID, String Task, String Due) {
        int status = 0;
        try {
            Connection con = getConnection();
            String stmt = "UPDATE task SET Task = ?, Due = ? WHERE ID = " + ID;
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, Task);
            ps.setString(2, Due);
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return status;

    }

    public static int save() {
        int status = 0;
        try {
            try (Connection con = getConnection()) {
                String stmt = "INSERT INTO task(Task,Due,Member) VALUES (?,?,?)";
                PreparedStatement ps = con.prepareStatement(stmt);
//            ps.setInt(1, t.getId());
                ps.setString(1, "Some Task");
                ps.setString(2, "Some date");
                ps.setString(3, "Some Member");
                status = ps.executeUpdate();
            }
        } catch (SQLException ex) {
        }
        return status;
    }

    public static List<String> getTaskById(int id) {
        List Tlist = new ArrayList();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM task WHERE ID = "+id);
            String Task = "", Due = "", Member = "";
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Task = rs.getString(2);
                System.out.println(Task);
                Due = rs.getString(3);
                System.out.println(Due);
                Member = rs.getString(4);
                System.out.println(Member);
            }
            Tlist.add(Task);
            Tlist.add(Due);
            Tlist.add(Member);
            con.close();
        } catch (Exception ex) {
           
        }
        return Tlist;
    }

    public static void main(String[] args) throws SQLException {

        List data = getTaskById(44);
        String Task, Due, Member;
        Task = (String) data.get(0);
        Due = (String) data.get(1);
        Member = (String) data.get(2);
        
    }
}
