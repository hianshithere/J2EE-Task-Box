/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Task;
import com.Admin.work.AdminDao;
import static com.Task.FinishedDao.getConnection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hians
 */
public class Reassign {
    public static int Move(int id)throws SQLException{
        int status = 0;
        List list = From_Finished(id);
        if(!list.isEmpty()){
          Connection con = AdminDao.getConnection();
        String statement = "INSERT INTO task(Task, Due, Member) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(statement);
        ps.setString(1, (String)list.get(0));
        ps.setString(2, (String)list.get(1));
        ps.setString(3, (String)list.get(2));
        status = ps.executeUpdate();  
        }
        return status;
    }
    public static List From_Finished(int id) {
        Connection con = AdminDao.getConnection();
        List list = new ArrayList();
        String Statement = "SELECT * FROM TblFinishedTask WHERE ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(Statement);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
            }
        } catch (Exception ex) {
        }
        return list;
    }
     public static int delete(int id) {
        int status = 0;
        try {
            Connection con = AdminDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from TblFinishedTask where ID=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
