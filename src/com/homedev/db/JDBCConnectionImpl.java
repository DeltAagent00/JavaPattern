package com.homedev.db;

import com.homedev.mvp.IDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionImpl implements IDBConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_PATH = "jdbc:mysql://localhost/DB";
    private static final String USER = "username";
    private static final String PASS = "password";

    private Connection connection;

    public JDBCConnectionImpl() {
        try {
            registerDriver();
            connection = DriverManager.getConnection(DB_PATH, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.err.println("Error registerDriver: " + e);
        } catch (SQLException e) {
            System.err.println("Error get connection: " + e);
        }
    }

    private void registerDriver() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error close connection: " + e);
        }
    }
}
