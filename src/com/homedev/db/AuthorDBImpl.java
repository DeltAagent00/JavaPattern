package com.homedev.db;

import com.homedev.mvp.model.IAuthorDB;
import com.homedev.mvp.model.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorDBImpl implements IAuthorDB {
    private Map<Integer, Author> identityMap = new HashMap<>();

    @Override
    public void insert(Connection connection, Author author) {
        PreparedStatement stat = null;
        String insertSql = "INSERT into authors values(?, ?, ?, ?, ?);";
        try {
            stat = connection.prepareStatement(insertSql);
            stat.setInt(1, author.getId());
            stat.setString(2, author.getName());
            stat.setString(3, author.getLastname());
            stat.setString(4, author.getSurname());
            stat.setLong(5, author.getBirthday());
            stat.executeUpdate();

            identityMap.put(author.getId(), author);
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
    }

    @Override
    public void update(Connection connection, Author author) {
        PreparedStatement stat = null;
        String insertSql = "Update athors SET 'name' = ?, lastname = ?, surname = ?, birthday = ? WHERE id = ?;";
        try {
            stat = connection.prepareStatement(insertSql);
            stat.setString(1, author.getName());
            stat.setString(2, author.getLastname());
            stat.setString(3, author.getSurname());
            stat.setLong(4, author.getBirthday());
            stat.setInt(4, author.getId());
            stat.executeUpdate();

            identityMap.put(author.getId(), author);
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
    }

    @Override
    public void delete(Connection connection, Author author) {
        identityMap.remove(author.getId());

        PreparedStatement stat = null;
        String insertSql = "DELETE from athors WHERE id = ?;";
        try {
            stat = connection.prepareStatement(insertSql);
            stat.setInt(1, author.getId());
            stat.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
    }

    @Override
    public List<Author> getAll(Connection connection) {
        Statement stat = null;
        List<Author> authors = new ArrayList<>();
        try {
            String selectSql = "SELECT * from athors;";
            stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(selectSql);
            while (rs.next()) {
                final Author author = getFromResult(rs);
                authors.add(author);
                identityMap.put(author.getId(), author);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
        return authors;
    }

    @Override
    public List<Author> getByName(Connection connection, String name) {
        PreparedStatement stat = null;
        List<Author> authors = new ArrayList<>();
        try {
            String selectSql = "SELECT * from athors WHERE 'name' = ?;";
            stat = connection.prepareStatement(selectSql);
            stat.setString(1, name);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                final Author author = getFromResult(rs);
                authors.add(author);
                identityMap.put(author.getId(), author);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
        return authors;
    }

    @Override
    public Author getById(Connection connection, int id) {
        if (identityMap.containsKey(id)) {
            return identityMap.get(id);
        }
        Author author = null;
        PreparedStatement stat = null;

        try {
            String selectSql = "SELECT * from athors WHERE id = ?;";
            stat = connection.prepareStatement(selectSql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                author = getFromResult(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
        return author;
    }

    private Author getFromResult(ResultSet rs) throws SQLException {
        return new Author.Builder()
                .setId(rs.getInt(1))
                .setName(rs.getString(2))
                .setLastname(rs.getString(3))
                .setSurname(rs.getString(4))
                .setBirthday(rs.getLong(5))
                .create();
    }
}
