/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hians
 */
public class FinishedDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\WorK\\Syook\\Syook.mdb");
            System.out.println("Connection Established !");
        } catch (Exception e) {
        }
        return con;
    }

    public static List From_task(int id) {
        Connection con = getConnection();
        List list = new ArrayList();
        String Statement = "SELECT * FROM task WHERE ID = ?";
        String Task = "", Due = "", Member = "";
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM task WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Task = rs.getString(2);
                Due = rs.getString(3);
                Member = rs.getString(4);
            }
        } catch (Exception ex) {
        }
        list.add(Task);
        list.add(Due);
        list.add(Member);
        return list;
    }

    public static int Finish(int id) {
        Connection con = getConnection();
        List list = From_task(id);
        int status = 0;
        String Task = (String) list.get(0), Due = (String) list.get(1), Member = (String) list.get(2);
        String stmt = "INSERT INTO TblFinishedTask(Task, Due, Member) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, Task);
            ps.setString(2, Due);
            ps.setString(3, Member);
            status = ps.executeUpdate();
        } catch (Exception err) {
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from task where ID=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

}
