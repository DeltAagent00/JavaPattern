package com.homedev.mvp;

import java.sql.Connection;

public interface IDBConnection {
    Connection getConnection();
    void closeConnection();
}
