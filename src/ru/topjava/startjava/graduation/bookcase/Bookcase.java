package ru.topjava.startjava.graduation.bookcase;

import java.time.Year;
import java.util.Arrays;

public class Bookcase {
    private static final int BOOKS_LIMIT = 10;
    private final Book[] books = new Book[BOOKS_LIMIT];
    private int booksAmount;
    private int freeShelves = BOOKS_LIMIT;

    public int getBooksAmount() {
        return booksAmount;
    }

    public int getFreeShelves() {
        return freeShelves;
    }

    public Book[] getAllBooks() {
        return books;
    }

    public boolean add(String author, String title, Year publishedYear) {
        if (booksAmount < BOOKS_LIMIT) {
            Book book = new Book(author, title, publishedYear);
            books[booksAmount++] = book;
            freeShelves--;
            return true;
        }
        return false;
    }

    public Book find(String title) {
        if (isExistByTitle(title)) {
            int bookIndex = getIndex(title);
            return books[bookIndex];
        }
        return null;
    }

    public boolean remove(String title) {
        if (isExistByTitle(title)) {
            int bookIndex = getIndex(title);
            if (bookIndex != booksAmount - 1) {
                System.arraycopy(books, bookIndex + 1, books, bookIndex, booksAmount - (bookIndex + 1));
            }
            books[booksAmount - 1] = null;
            booksAmount--;
            freeShelves++;
            return true;
        }
        return false;
    }

    private boolean isExistByTitle(String title) {
        for (int i = 0; i < booksAmount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(String title) {
        for (int i = 0; i < booksAmount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void clearBookcase() {
        Arrays.fill(books, 0, booksAmount, null);
        booksAmount = 0;
        freeShelves = BOOKS_LIMIT;
    }
}
