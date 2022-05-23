package com.he.week12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 86186 on 2022/5/23.
 */

public class DBUtils {
    private static String user="root";
    private static String password="mypassword";

    private static Connection getConn(String dbName){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://192.168.0.104:3306/"+dbName;
            connection= DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    public static ResultSet queryReader(String reader_num){
        ResultSet rs=null;
        Connection connection=getConn("library");
        if(connection!=null){
            try{
                PreparedStatement ps;
                Statement smt=connection.createStatement();
                String sql="select * from readers where reader_number LIKE '%"+reader_num+"%'";
                rs=smt.executeQuery(sql);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return rs;
    }
}
