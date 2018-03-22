package com.syook.work;

import java.util.*;
import java.sql.*;

/**
 *
 * @author hians
 */
public class TaskboxDao {

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
    public static int save(String Task, String Due, String Member) {
        int status = 0;
        try {
            Connection con = TaskboxDao.getConnection();
            String stmt = "insert into task(Task,Due,Member) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(stmt);
//            ps.setInt(1, t.getId());
            ps.setString(1, Task);
            ps.setString(2, Due);
            ps.setString(3, Member);
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(int ID, String Task, String Due, String Member) {
        int status = 0;
        Taskbox t = new Taskbox();
        try {
            Connection con = TaskboxDao.getConnection();
            String stmt = "UPDATE task SET Task = ?,Due = ?,Member = ? WHERE ID = "+ID;
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, Task);
            ps.setString(2, Due);
            ps.setString(3, Member);
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }
//    public static int update(Taskbox t) {
//        int status = 0;
//        try {
//            Connection con = TaskboxDao.getConnection();
//            String stmt = "update task set Task=?,Due=? where ID=?";
//            PreparedStatement ps = con.prepareStatement(stmt);
//            ps.setInt(1, t.getId());
//            ps.setString(2, t.getTask());
//            ps.setString(3, t.getDue());
//            status = ps.executeUpdate();
//            con.close();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return status;
//    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = TaskboxDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from task where ID=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Taskbox> getAllTask() {
        List<Taskbox> list = new ArrayList<Taskbox>();

        try {
            Connection con = TaskboxDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from task");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Taskbox e = new Taskbox();
                e.setId(rs.getInt(1));
                e.setTask(rs.getString(2));
                e.setDue(rs.getString(3));
                list.add(e);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Taskbox getTaskById(int id){  
        Taskbox e=new Taskbox();  
          
        try{  
            Connection con=TaskboxDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from task where ID = ?");  
            ps.setInt(0,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(0));  
                e.setTask(rs.getString(1));  
                e.setDue(rs.getString(2)); 
                e.setMember(rs.getString(3));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }
        public static List<String> getTaskByID(int id) {
        List Tlist = new ArrayList();
        try {
            Connection con = TaskboxDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM task WHERE ID = "+id);
            String Task = "", Due = "", Member = "";
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Task = rs.getString(2);
                Due = rs.getString(3);
                Member = rs.getString(4);
            }
            Tlist.add(Task);
            Tlist.add(Due);
            Tlist.add(Member);
            con.close();
        } catch (Exception ex) {
           
        }
        return Tlist;
    }
}
