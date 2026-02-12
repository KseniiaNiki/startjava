package ru.topjava.startjava.graduation.bookcase;

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
        return Arrays.copyOf(books, booksAmount);
    }

    public boolean add(Book book) {
        if (booksAmount < BOOKS_LIMIT) {
            books[booksAmount++] = book;
            freeShelves--;
            return true;
        }
        return false;
    }

    public Book find(String title) {
        if (findIndex(title) < 0) {
            return null;
        }
        int bookIndex = findIndex(title);
        return books[bookIndex];
    }

    public boolean remove(String title) {
        if (findIndex(title) < 0) {
            return false;
        }
        int bookIndex = findIndex(title);
        booksAmount--;
        System.arraycopy(books, bookIndex + 1, books, bookIndex, booksAmount - bookIndex);
        books[booksAmount] = null;
        freeShelves++;
        return true;
    }

    public int findIndex(String title) {
        for (int i = 0; i < booksAmount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        Arrays.fill(books, 0, booksAmount, null);
        booksAmount = 0;
        freeShelves = BOOKS_LIMIT;
    }
}
