package com.solvd.deliverybusiness.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private String file = "src/main/resources/database/db.properties";


    public DatabaseConnection() {
    }

    public Connection createConnection() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(file)));
        String connectionURL = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String psswd = properties.getProperty("db.password");
        return DriverManager.getConnection(connectionURL, user, psswd);
    }
}
