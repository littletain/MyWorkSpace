package org.example.dao;

import org.example.domain.User;

import java.sql.*;
import java.util.Properties;

public class JdbcUserDao {
    private static Connection con = null;
    static {
        Properties pro = new Properties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/db1?serverTimezone=UTC";
            String dbusername = "root";
            String dbpassword = "root";
            con = DriverManager.getConnection(url,dbusername,dbpassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public User login(String userName,String password){
        String sql = "select * from user where username=? and password=?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            //index对应的是问号的位置
            pst.setString(1,userName);
            pst.setString(2,password);
            rs = pst.executeQuery();
            //出现空指针异常，也可能是数据库那边出问题了
            if (rs.next()){
                //注意语法细节，getString和getInt的意思是，以String或Int的格式，把第index行读取出来，而不是第index个String类型的数据
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
            if (con != null){
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
