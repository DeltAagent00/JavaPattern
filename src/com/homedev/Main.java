package com.homedev;

import com.homedev.mvp.model.entity.Author;
import com.homedev.mvp.model.entity.Book;

public class Main {
    public static void main(String[] args) {
        final Author author1 = new Author.Builder()
                .setId(1)
                .setName("name 1")
                .setLastname("last name 1")
                .setSurname("surname 1")
                .setBirthday(1238651)
                .create();

        final Author author2 = new Author.Builder()
                .setId(2)
                .setName("name 2")
                .setLastname("last name 2")
                .setSurname("surname 2")
                .setBirthday(17473092)
                .create();

        final Book book = new Book.Builder()
                .setId(1)
                .setName("book name")
                .setYear(2020)
                .addAuthor(author1)
                .addAuthor(author2)
                .setPages(123)
                .setEdition("book edition")
                .setDescription("book description")
                .create();

        System.out.println(author1);
        System.out.println(author2);
        System.out.println(book);
    }
}
