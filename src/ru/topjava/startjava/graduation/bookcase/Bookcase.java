package ru.topjava.startjava.graduation.bookcase;

import java.time.Year;
import java.util.Arrays;

public class Bookcase {
    private static final int MAX_BOOK_AMOUNT = 10;
    private int booksAmount;
    private final Book[] books = new Book[MAX_BOOK_AMOUNT];
    private int freeShelves = books.length;

    public int getBooksAmount() {
        return booksAmount;
    }

    public int getFreeShelves() {
        return freeShelves;
    }

    public Book[] getAllBooks() {
        return books;
    }

    public void addBook(String author, String title, Year publishedYear) {
        if (booksAmount < books.length) {
            System.out.println("Книга успешно добавлена в Книжный шкаф!\n");
            Book book = new Book(author, title, publishedYear);
            books[booksAmount++] = book;
            freeShelves--;
        } else {
            System.out.println("Книга не может быть сохранена(в шкафу закончилось место)!\n");
        }
    }

    public void findBook(String title) {
        if (isExistByTitle(title)) {
            int bookIndex = getIndex(title);
            System.out.println("Результат поиска: " + books[bookIndex] + "\n");
        } else {
            System.out.println("Книга " + title + " не найдена!\n");
        }
    }

    public void removeBook(String title) {
        if (isExistByTitle(title)) {
            int bookIndex = getIndex(title);
            System.out.println("Книга {" + books[bookIndex].toString() + "} удалена!\n");
            if (bookIndex != booksAmount - 1) {
                System.arraycopy(books, bookIndex + 1, books, bookIndex, books.length - 1);
            }
            books[booksAmount - 1] = null;
            booksAmount--;
            freeShelves++;
        } else {
            System.out.println("Книга " + title + " не удалена!\n");
        }
    }

    private boolean isExistByTitle(String title) {
        for (int i = 0; i < booksAmount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(String title) {
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
        freeShelves = books.length;
        System.out.println("Все книги удалены!\n");
    }
}
