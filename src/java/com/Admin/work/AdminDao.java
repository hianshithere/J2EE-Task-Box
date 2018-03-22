package com.Admin.work;

import java.sql.*;

public class AdminDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://E:\\WorK\\Syook\\Syook.mdb");
            //System.out.println("Connection Established !");
        } catch (ClassNotFoundException | SQLException err) {
            err.printStackTrace();
        }
        return con;
    }

    public static boolean Validate(String username, String pass) throws SQLException {
        boolean status = false;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TblAdminLogin WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        status = rs.next();
        return status;
    }
}
//    public static boolean Validate1(Admin a) throws SQLException{
//        String username = a.getUsername();
//        String password = a.getPassword();
//        boolean status = false;
//        Connection con = getConnection();
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM TblAdminLogin WHERE username = ? AND password = ?");
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            status = rs.next();
//            
//           return status;
//    }
//}
