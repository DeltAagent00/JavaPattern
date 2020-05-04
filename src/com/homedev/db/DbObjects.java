package com.homedev.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbObjects {
    public static void createObjects(Connection connection) {
        createSequence(connection);
        createTables(connection);
    }

    public static void dropObjects(Connection connection) {
        dropTable(connection);
        dropSequence(connection);
    }

    private static void createTables(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS athors ( id integer PRIMARY KEY, 'name' varchar(128), " +
                    "lastname varchar(128), surname varchar(128), birthday integer);";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "DROP TABLE IF EXISTS athors;";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createSequence(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sqlStr = String.format("CREATE SEQUENCE %s START %d;", Sequence.NAME, Sequence.START);
            statement.execute(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropSequence(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sqlStr = String.format("DROP SEQUENCE IF EXISTS %s;", Sequence.NAME);
            statement.execute(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
