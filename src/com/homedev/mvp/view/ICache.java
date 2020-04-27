package com.homedev.mvp.view;

import com.homedev.mvp.model.entity.Book;

public interface ICache {
    void put(Book book);
    Book getById(int id);
}
