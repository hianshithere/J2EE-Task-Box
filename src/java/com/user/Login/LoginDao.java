/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.Login;

import java.sql.*;

public class LoginDao {

    public static Connection getLogin() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\WorK\\Syook\\Syook.mdb");
            System.out.println("Connection Established !");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return con;
    }

    public static boolean Validate(String username, String pass) throws SQLException {//(LoginDTO dto)
        boolean status = false;
        Connection con = getLogin();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TblLogin WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        status = rs.next();

        return status;
    }
    /*
        p s bool val(logindto dto){
        if (dto.username =="" && dto.password == "")
        return true;
    
    return false;
    }
    
    */
}
