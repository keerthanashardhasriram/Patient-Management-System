package com.pms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   public static Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/pms_db";
    String user = "root";
    String password = "root"; // replace with your MySQL password
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // <--- add this line
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return DriverManager.getConnection(url, user, password);
}


    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
