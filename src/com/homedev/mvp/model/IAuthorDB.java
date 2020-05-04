package com.homedev.mvp.model;

import com.homedev.mvp.model.entity.Author;

import java.sql.Connection;
import java.util.List;

public interface IAuthorDB {
    void insert(Connection connection, Author author);
    void update(Connection connection, Author author);
    void delete(Connection connection, Author author);

    List<Author> getAll(Connection connection);
    List<Author> getByName(Connection connection, String name);
    Author getById(Connection connection, int id);
}
