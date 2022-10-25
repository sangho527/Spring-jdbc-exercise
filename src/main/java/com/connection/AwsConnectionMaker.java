package com.connection;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Map;

public class AwsConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        Connection c = (Connection) DriverManager.getConnection(env.get("DB_HOST"),
                env.get("DB_USER"), env.get("DB_PASSWORD"));
//        String dbHost = env.get("DB_HOST");
//        String dbUser = env.get("DB_USER");
//        String dbPassword = env.get("DB_PASSWORD");
        return c;
    }
}

