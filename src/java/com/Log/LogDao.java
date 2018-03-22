/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Log;

import com.user.Login.LoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hians
 */
public class LogDao {

   
    static LoginDao connect = new LoginDao();

    public static boolean userAuthentication(String username, String password)throws SQLException {
        boolean status = false;
        Connection con = connect.getLogin();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TblLogin WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        status = rs.next();
        return status;
    }
    public static boolean adminAuthentication(String username, String pass) throws SQLException {
        boolean status = false;
        Connection con = connect.getLogin();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TblAdminLogin WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        status = rs.next();
        return status;
    }
}
