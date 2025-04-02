// package project_javaswing.src.main.java.com.example.config;
package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/project_java";
    private static final String USER = "root";
    private static final String PASSWORD = "19051009";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Connection to database failed!");
            e.printStackTrace();
            return null;
        }
    }

}
