package com.hrio.java_spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlStarter {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        try {
            Connection conn = DriverManager.getConnection(url, "root", "Hrio123!");
            System.out.println(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
