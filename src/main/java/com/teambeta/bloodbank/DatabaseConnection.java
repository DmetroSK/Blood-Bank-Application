package com.teambeta.bloodbank;

import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection(){

        String url = "jdbc:mysql://localhost:3306/blood";
        String user = "root";
        String password = "";

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(url,user,password);


        }
        catch (Exception e) {

            e.printStackTrace();

        }

        return connection;
    }
}
