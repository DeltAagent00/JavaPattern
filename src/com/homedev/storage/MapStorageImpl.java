package com.homedev.storage;

import com.homedev.mvp.view.ICache;
import com.homedev.mvp.model.entity.Book;
import com.homedev.mvp.view.IStorage;

import java.util.HashMap;
import java.util.Map;

public class MapStorageImpl implements IStorage {
    private final ICache cache;
    private final Map<Integer, Book> db = new HashMap<>();

    public MapStorageImpl(ICache cache) {
        this.cache = cache;
    }

    @Override
    public Book getBookById(int id) {
        Book book = cache.getById(id);
        if (book != null) {
            return book;
        } else {
            return db.get(id);
        }
    }

    @Override
    public void saveOrUpdateBook(Book book) {
        db.put(book.getId(), book);
        cache.put(book);
    }
}
