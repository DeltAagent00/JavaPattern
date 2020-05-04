package com.homedev.mvp.view;

import com.homedev.mvp.model.entity.Book;

public interface ISubscribeSavedBookListener {
    void onSavedBook(Book book);
}
