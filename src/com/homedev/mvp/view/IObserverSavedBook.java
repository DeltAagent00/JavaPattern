package com.homedev.mvp.view;

import com.homedev.mvp.model.entity.Book;

public interface IObserverSavedBook {
    void onBookSaved(Book book);
    void addSubscribe(ISubscribeSavedBookListener subscribe);
    void removeSubscribe(ISubscribeSavedBookListener subscribe);
}
