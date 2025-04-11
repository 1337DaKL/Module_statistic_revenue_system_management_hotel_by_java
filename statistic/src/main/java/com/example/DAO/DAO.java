package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    protected Connection conn;

    public DAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/statistic_revenue";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công tới MySQL!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
    }
}
