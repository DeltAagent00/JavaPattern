package com.homedev.mvp.view;

import com.homedev.mvp.model.entity.Book;

public interface IStorage {
    Book getBookById(int id);
    void saveOrUpdateBook(Book book);
}
