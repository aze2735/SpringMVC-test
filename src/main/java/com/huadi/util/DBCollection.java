package com.huadi.util;

import java.net.URI;
import java.sql.*;

/**
 * @author jacky
 * @date 2020年 08月25日 16:35:20
 */
public class DBCollection {
    private static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    private static Connection con = null;

    /**
     * 获取连接
     * @return
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
             con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 清理资源
     * @param con
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection con , PreparedStatement ps , ResultSet rs){

        try{
            if(con != null){
                con.close();
            }
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
    public static void main(String[] args) throws ClassNotFoundException {
        Connection con = DBCollection.getConnection();
        System.out.println(con);
    }
}
