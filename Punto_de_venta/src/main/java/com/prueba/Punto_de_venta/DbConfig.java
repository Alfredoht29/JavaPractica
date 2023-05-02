package com.prueba.Punto_de_venta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    private static Connection connection = null;
    public static Connection getConnection()throws SQLException {
        if(connection!=null){
            return connection;
        }else{
            String driver= "com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/prueba_java" ;
            String user="user";
            String password="";
            try{
                Class.forName(driver);
                connection= DriverManager.getConnection(url,user,password);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}