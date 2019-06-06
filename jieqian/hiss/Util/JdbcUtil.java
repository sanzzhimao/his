package com.neusoft.his.Util;

import java.sql.*;

public class JdbcUtil {
    public static final String ORACLEDRIVER="com.mysql.jdbc.Driver";
    public static final String USERNAME="root";
    public static final String PASSWORD="123456";
    public static final String URL="jdbc:mysql://127.0.0.1:3306/his?useUnicode=true&amp;characterEncoding=UTF-8";

    static{
        try {
            Class.forName(ORACLEDRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    public static void transactionController(Connection con){
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void commitTransaction(Connection con){
        try {
            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void rollbackTransaction(Connection con){
        try {
            con.rollback();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void release(Connection con, Statement stmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
