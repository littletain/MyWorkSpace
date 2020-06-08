package org.example.dao;

import org.example.domain.User;

import java.sql.*;
import java.util.Properties;

//复写一遍，提升熟练度，无新知识
public class JdbcUserDao1 {
    private static Connection con = null;
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/db1?serverTimezone=UTC";
            String dbUser = "root";
            String dbPassword = "root";
            con = DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static User login(String userName, String password){
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from user where username=? and password=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,"zhangsan");
            pst.setString(2,"123");
            rs = pst.executeQuery();
            if (rs.next()){
                if (rs.getString(2).equals(userName) && rs.getString(3).equals(password)){
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setName(userName);
                    user.setPassword(password);
                    return user;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }
}
