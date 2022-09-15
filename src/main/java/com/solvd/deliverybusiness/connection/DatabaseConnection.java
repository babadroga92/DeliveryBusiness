package com.solvd.deliverybusiness.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    String connectionURL = "jdbc:mysql://localhost:3306/deliverybusiness";
    String username = "root";
    String password = "Babadroga_92";
    public DatabaseConnection() {
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(connectionURL, username, password);
    }
}
