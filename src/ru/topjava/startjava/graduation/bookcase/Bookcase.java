package ru.topjava.startjava.graduation.bookcase;

import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class Bookcase {
    private static final int MAX_BOOK_AMOUNT = 10;
    private static final int MIN_YEAR = 1800;
    private int booksAmount;
    private final Book[] books = new Book[MAX_BOOK_AMOUNT];
    private int freeShelves = books.length;

    public int getBooksAmount() {
        return booksAmount;
    }

    public int getFreeShelves() {
        return freeShelves;
    }

    public void addBook(Scanner scanner) {
        if (booksAmount < books.length) {
            String author = getValidAuthor(scanner);
            String title = getValidTitle(scanner);
            Year publishedYear = getValidYear(scanner);
            System.out.println("Книга успешно добавлена в Книжный шкаф!\n");
            Book book = new Book(author, title, publishedYear);
            books[booksAmount++] = book;
            freeShelves--;
        } else {
            System.out.println("Книга не может быть сохранена(в шкафу закончилось место)!\n");
        }
    }

    private String getValidAuthor(Scanner scanner) {
        System.out.print("Введите ФИО автора книги: ");
        String author = scanner.nextLine();
        boolean isValidAuthor = false;
        while (!isValidAuthor) {
            if (author.isBlank()) {
                System.out.print("Ошибка: неверный формат! Повторите ввод: ");
                author = scanner.nextLine();
                continue;
            }
            isValidAuthor = true;
        }
        return author;
    }

    private String getValidTitle(Scanner scanner) {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        boolean isValidTitle = false;
        while (!isValidTitle) {
            if (title.isBlank()) {
                System.out.print("Ошибка: неверный формат! Повторите ввод: ");
                title = scanner.nextLine();
                continue;
            }
            isValidTitle = true;
        }
        return title;
    }

    private Year getValidYear(Scanner scanner) {
        System.out.print("Введите год издания книги: ");
        int publishedYear = scanner.nextInt();
        scanner.nextLine();
        boolean isValidYear = false;
        while (!isValidYear) {
            int currYear = Year.now().getValue();
            if (publishedYear < MIN_YEAR || publishedYear > currYear) {
                System.out.print("Ошибка: год издания должен быть между 1800 и текущим! Повторите ввод: ");
                publishedYear = scanner.nextInt();
                scanner.nextLine();
                continue;
            }
            isValidYear = true;
        }
        return Year.of(publishedYear);
    }

    public void getAllBooks() {
        int maxWidth = getMaxWidth();
        String separator = "-".repeat(maxWidth);
        for (int i = 0; i < booksAmount; i++) {
            String text = books[i].toString();
            int space = maxWidth - text.length();
            String padding = " ".repeat(space);
            System.out.println("|" + text + padding + "|");
            System.out.println("|" + separator + "|");
        }
    }

    private int getMaxWidth() {
        int max = 0;
        for (int i = 0; i < booksAmount; i++) {
            int length = books[i].toString().length();
            if (length > max) {
                max = length;
            }
        }
        return max;
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
            if (bookIndex != books.length - 1) {
                System.arraycopy(books, bookIndex + 1, books, bookIndex, books.length - 1);
            }
            books[books.length - 1] = null;
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
        Arrays.fill(books, null);
        booksAmount = 0;
        freeShelves = books.length;
    }
}
