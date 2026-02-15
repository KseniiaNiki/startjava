package ru.topjava.startjava.graduation.bookcase;

import java.util.Arrays;

public class Bookcase {
    private static final int BOOKS_LIMIT = 10;
    private final Book[] books = new Book[BOOKS_LIMIT];
    private int booksAmount;
    private int freeShelves = BOOKS_LIMIT;
//    private int maxShelfLength;

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, booksAmount);
    }

    public int getBooksAmount() {
        return booksAmount;
    }

    public int getFreeShelves() {
        return freeShelves;
    }

//    public int getMaxShelfLength() {
//        return maxShelfLength;
//    }

    public boolean add(Book book) {
        if (booksAmount < BOOKS_LIMIT) {
            books[booksAmount++] = book;
            freeShelves--;
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

    private int findIndex(String title) {
        for (int i = 0; i < booksAmount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(String title) {
        int bookIndex = findIndex(title);
        if (bookIndex < 0) {
            return false;
        }
        booksAmount--;
        System.arraycopy(books, bookIndex + 1, books, bookIndex, booksAmount - bookIndex);
        books[booksAmount] = null;
        freeShelves++;
        return true;
    }

//    public int getMaxLength() {
//        int max = 0;
//        for (Book book : getAllBooks()) {
//            int length = book.toString().length();
//            if (length > max) {
//                max = length;
//            }
//        }
//        return max;
//    }

    public void clear() {
        Arrays.fill(books, 0, booksAmount, null);
        booksAmount = 0;
        freeShelves = BOOKS_LIMIT;
    }
}
