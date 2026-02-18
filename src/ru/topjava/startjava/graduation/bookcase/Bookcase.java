package ru.topjava.startjava.graduation.bookcase;

import java.util.Arrays;

public class Bookcase {
    private static final int BOOKS_LIMIT = 10;
    private final Book[] books = new Book[BOOKS_LIMIT];
    private int booksAmount;
    private int freeShelves = BOOKS_LIMIT;
    private int maxShelfLength;

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, booksAmount);
    }

    public int getBooksAmount() {
        return booksAmount;
    }

    public int getFreeShelves() {
        return freeShelves;
    }

    public int getMaxShelfLength() {
        return maxShelfLength;
    }

    public boolean add(Book book) {
        if (booksAmount < BOOKS_LIMIT) {
            books[booksAmount++] = book;
            freeShelves--;
            checkMaxShelfLength(book.toString().length());
            return true;
        }
        return false;
    }

    public Book find(String title) {
        int bookIndex = findIndex(title);
        if (bookIndex < 0) {
            return null;
        }
        return books[bookIndex];
    }

    public boolean remove(String title) {
        int bookIndex = findIndex(title);
        if (bookIndex < 0) {
            return false;
        }
        final int deletedBookLength = books[bookIndex].toString().length();
        booksAmount--;
        System.arraycopy(books, bookIndex + 1, books, bookIndex, booksAmount - bookIndex);
        books[booksAmount] = null;
        recalculateMaxShelfLength(deletedBookLength);
        freeShelves++;
        return true;
    }

    public void clear() {
        Arrays.fill(books, 0, booksAmount, null);
        booksAmount = 0;
        freeShelves = BOOKS_LIMIT;
    }

    private void checkMaxShelfLength(int bookLength) {
        maxShelfLength = Math.max(bookLength, maxShelfLength);
    }

    private int findIndex(String title) {
        for (int i = 0; i < booksAmount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    private void recalculateMaxShelfLength(int bookLength) {
        if (booksAmount > 0) {
            if (bookLength == maxShelfLength) {
                maxShelfLength = 0;
                for (Book book : getAllBooks()) {
                    checkMaxShelfLength(book.toString().length());
                }
            }
        } else {
            maxShelfLength = 0;
        }
    }
}
