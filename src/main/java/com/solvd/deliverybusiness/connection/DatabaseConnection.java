package com.solvd.deliverybusiness.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    String connectionURL = "jdbc:mysql://localhost:3306/deliverybusiness";

    public DatabaseConnection() {
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(connectionURL, "root", "Babadroga_92");
    }
}
