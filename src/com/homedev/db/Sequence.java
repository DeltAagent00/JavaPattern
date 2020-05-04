package com.homedev.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sequence {
    public static final String NAME = "keys";
    public static final int START = 1;

    public static int nextVal(Connection conn) {
        int result  = 0;
        Statement stat = null;
        try {
            String selectSql = "SELECT nextval('" + NAME + "')";
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(selectSql);
            if (rs.next()) {
                result = rs.getInt(1);
            }
        }
        catch(SQLException e) {
            System.err.println(" Error nextVal: " + e);
        }
        finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            }
            catch (SQLException e) {
                System.err.println("Error close: " + e);
            }
        }
        return result;
    }
}
