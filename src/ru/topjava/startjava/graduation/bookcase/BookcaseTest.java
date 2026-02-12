package ru.topjava.startjava.graduation.bookcase;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final int MIN_CHOICE = 1;
    private static final int MAX_CHOICE = 5;
    private static final int MIN_YEAR = 1800;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookcase bookcase = new Bookcase();
        sayHello();
        printInfo(bookcase);
        int answer;

        while (true) {
            printMenu();
            answer = inputMenuChoice(scanner);
            if (answer == MAX_CHOICE) break;

            doOperation(answer, bookcase, scanner);
            continueWork(scanner);
            printInfo(bookcase);
        }
    }

    private static void sayHello() throws InterruptedException {
        String greeting = "Добро пожаловать в Книжный шкаф!";
        String[] words = greeting.split(" ");
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void showEmptyBookcase() {
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
    }

    private static void printMenu() {
        System.out.println("""
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Завершить работу
                """);
    }

    private static int inputMenuChoice(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: Неверное значение меню. Введите число!");
                scanner.nextLine();
                continue;
            }
            int menuChoice = scanner.nextInt();
            scanner.nextLine();
            if (menuChoice < MIN_CHOICE || menuChoice > MAX_CHOICE) {
                System.out.println("Ошибка: Неверное значение меню. Допустимые значения: " +
                        MIN_CHOICE + "-" + MAX_CHOICE);
                continue;
            }
            return menuChoice;
        }
    }

    private static void doOperation(int answer, Bookcase bookcase, Scanner scanner) {
        switch (answer) {
            case 1 -> addBook(bookcase, scanner);
            case 2 -> findBook(bookcase, scanner);
            case 3 -> removeBook(bookcase, scanner);
            case 4 -> clearBookcase(bookcase);
        }
    }

    private static void addBook(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите ФИО автора книги: ");
        String author = inputName(scanner);
        System.out.print("Введите название книги: ");
        String title = inputName(scanner);
        Year publishedYear = inputYear(scanner);
        Book book = new Book(author, title, publishedYear);
        if (!bookcase.add(book)) {
            System.out.println("Книга не может быть сохранена(в шкафу закончилось место)!\n");
        } else {
            System.out.println("Книга " + title + " успешно добавлена в Книжный шкаф!\n");
        }
    }

    private static String inputName(Scanner scanner) {
        while (true) {
            String name = scanner.nextLine();
            if (name.isBlank()) {
                System.out.print("Ошибка: неверный формат! Повторите ввод: ");
                continue;
            }
            return name;
        }
    }

    private static Year inputYear(Scanner scanner) {
        System.out.print("Введите год издания книги: ");
        while (true) {
            int publishedYear = scanner.nextInt();
            scanner.nextLine();
            int currYear = Year.now().getValue();
            if (publishedYear < MIN_YEAR || publishedYear > currYear) {
                System.out.print("Ошибка: год издания должен быть между 1800 и текущим! Повторите ввод: ");
                continue;
            }
            return Year.of(publishedYear);
        }
    }

    private static void findBook(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги, которую хотите найти: ");
        String titleToFind = scanner.nextLine();
        Book bookToFind = bookcase.find(titleToFind);
        if (bookToFind == null) {
            System.out.println("Книга " + titleToFind + " не найдена!\n");
        } else {
            System.out.println("Результат поиска: " + bookToFind + "\n");
        }
    }

    private static void removeBook(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги, которую хотите удалить: ");
        String titleToDelete = scanner.nextLine();
        if (!bookcase.remove(titleToDelete)) {
            System.out.println("Книга " + titleToDelete + " не удалена!\n");
        } else {
            System.out.println("Книга " + titleToDelete + " удалена!\n");
        }
    }

    private static void clearBookcase(Bookcase bookcase) {
        bookcase.clear();
        System.out.println("Все книги удалены!\n");
    }

    private static void continueWork(Scanner scanner) {
        do {
            System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        } while (!scanner.nextLine().isEmpty());
    }

    private static void printInfo(Bookcase bookcase) {
        if (bookcase.getBooksAmount() == 0) {
            showEmptyBookcase();
        } else {
            System.out.println("В шкафу книг - " + bookcase.getBooksAmount() +
                    ", свободно полок - " + bookcase.getFreeShelves());

            showBookcase(bookcase);
        }
    }

    private static void showBookcase(Bookcase bookcase) {
        int maxWidth = getMaxWidth(bookcase);
        String separator = "-".repeat(maxWidth);
        for (Book book : bookcase.getAllBooks()) {
            String text = book.toString();
            int space = maxWidth - text.length();
            String padding = " ".repeat(space);
            System.out.println("|" + text + padding + "|");
            System.out.println("|" + separator + "|");
        }
    }

    private static int getMaxWidth(Bookcase bookcase) {
        int max = 0;
        for (Book book : bookcase.getAllBooks()) {
            int length = book.toString().length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
