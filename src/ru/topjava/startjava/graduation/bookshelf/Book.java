package ru.topjava.startjava.graduation.bookshelf;

import java.time.Year;

public class Book {
    private final String author;
    private final String title;
    private final Year publishedYear;

    public Book(String author, String title, Year publishedYear) {
        this.author = author;
        this.title = title;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " +
                title + ", " +
                publishedYear;
    }
}
