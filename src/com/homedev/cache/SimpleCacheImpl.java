package com.homedev.cache;

import com.homedev.mvp.model.entity.Book;
import com.homedev.mvp.view.ICache;

import java.util.HashMap;
import java.util.Map;

public class SimpleCacheImpl implements ICache {
    private final Map<Integer, Book> cache = new HashMap<>();

    @Override
    public void put(Book book) {
        cache.put(book.getId(), book);
    }

    @Override
    public Book getById(int id) {
        return cache.get(id);
    }
}
