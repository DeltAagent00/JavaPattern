package com.homedev.observable;

import com.homedev.mvp.model.entity.Book;
import com.homedev.mvp.view.IObserverSavedBook;
import com.homedev.mvp.view.ISubscribeSavedBookListener;

import java.util.ArrayList;
import java.util.List;

public class ObservableSavedBookImpl implements IObserverSavedBook {
    private List<ISubscribeSavedBookListener> listeners = new ArrayList<>();

    @Override
    public void onBookSaved(Book book) {
        listeners.forEach(iSubscribeSavedBookListener -> {
            iSubscribeSavedBookListener.onSavedBook(book);
        });
    }

    @Override
    public void addSubscribe(ISubscribeSavedBookListener subscribe) {
        listeners.add(subscribe);
    }

    @Override
    public void removeSubscribe(ISubscribeSavedBookListener subscribe) {
        listeners.remove(subscribe);
    }
}
