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
        showEmptyBookcase();
        int answer;

        while (true) {
            printMenu();
            answer = inputMenuChoice(scanner);
            if (answer == MAX_CHOICE) break;

            chooseOperation(answer, bookcase, scanner);
            continueWork(scanner);
            if (bookcase.getBooksAmount() > 0) {
                printInfo(bookcase);
            } else {
                showEmptyBookcase();
            }
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
            int value = scanner.nextInt();
            scanner.nextLine();
            if (value < MIN_CHOICE || value > MAX_CHOICE) {
                System.out.println("Ошибка: Неверное значение меню. Допустимые значения: " +
                        MIN_CHOICE + "-" + MAX_CHOICE);
                continue;
            }
            return value;
        }
    }

    private static void chooseOperation(int answer, Bookcase bookcase, Scanner scanner) {
        switch (answer) {
            case 1:
                doBookAddition(bookcase, scanner);
                break;
            case 2:
                doBookFinding(bookcase, scanner);
                break;
            case 3:
                doBookRemoval(bookcase, scanner);
                break;
            case 4:
                doBookcaseClearing(bookcase);
                break;
        }
    }

    private static void doBookAddition(Bookcase bookcase, Scanner scanner) {
        String author = inputAuthor(scanner);
        String title = inputTitle(scanner);
        Year publishedYear = inputYear(scanner);
        if (!bookcase.add(author, title, publishedYear)) {
            System.out.println("Книга не может быть сохранена(в шкафу закончилось место)!\n");
        } else {
            System.out.println("Книга " + title + " успешно добавлена в Книжный шкаф!\n");
        }
    }

    private static String inputAuthor(Scanner scanner) {
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

    private static String inputTitle(Scanner scanner) {
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

    private static Year inputYear(Scanner scanner) {
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

    private static void doBookFinding(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги, которую хотите найти: ");
        String titleToFind = scanner.nextLine();
        if (bookcase.find(titleToFind) == null) {
            System.out.println("Книга " + titleToFind + " не найдена!\n");
        } else {
            System.out.println("Результат поиска: " + bookcase.find(titleToFind) + "\n");
        }
    }

    private static void doBookRemoval(Bookcase bookcase, Scanner scanner) {
        System.out.print("Введите название книги, которую хотите удалить: ");
        String titleToDelete = scanner.nextLine();
        if (!bookcase.remove(titleToDelete)) {
            System.out.println("Книга " + titleToDelete + " не удалена!\n");
        } else {
            System.out.println("Книга " + titleToDelete + " удалена!\n");
        }
    }

    private static void doBookcaseClearing(Bookcase bookcase) {
        bookcase.clearBookcase();
        System.out.println("Все книги удалены!\n");
    }

    private static void continueWork(Scanner scanner) {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>");
        scanner.nextLine();
    }

    private static void printInfo(Bookcase bookcase) {
        System.out.println("В шкафу книг - " + bookcase.getBooksAmount() +
                ", свободно полок - " + bookcase.getFreeShelves());

        showBookcase(bookcase);
    }

    private static void showBookcase(Bookcase bookcase) {
        int maxWidth = getMaxWidth(bookcase);
        String separator = "-".repeat(maxWidth);
        for (int i = 0; i < bookcase.getBooksAmount(); i++) {
            String text = bookcase.getAllBooks()[i].toString();
            int space = maxWidth - text.length();
            String padding = " ".repeat(space);
            System.out.println("|" + text + padding + "|");
            System.out.println("|" + separator + "|");
        }
    }

    private static int getMaxWidth(Bookcase bookcase) {
        int max = 0;
        for (int i = 0; i < bookcase.getBooksAmount(); i++) {
            int length = bookcase.getAllBooks()[i].toString().length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
