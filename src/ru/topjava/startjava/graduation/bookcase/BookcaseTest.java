package ru.topjava.startjava.graduation.bookcase;

import java.time.Year;
import java.util.Scanner;

public class BookcaseTest {
    private static final int MIN_YEAR = 1800;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookcase bookcase = new Bookcase();
        sayHello();
        int answer;

        while (true) {
            printMenu();
            answer = readValue(scanner);
            if (answer == 5) break;

            chooseOperation(answer, bookcase, scanner);
            System.out.println("Для продолжения работы нажмите клавишу <Enter>");
            scanner.nextLine();
            if (bookcase.getBooksAmount() > 0) {
                printInfo(bookcase);
            } else {
                showEmptyBookcase();
            }
        }
    }

    private static String getValidAuthor(Scanner scanner) {
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

    private static String getValidTitle(Scanner scanner) {
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

    private static Year getValidYear(Scanner scanner) {
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

        showEmptyBookcase();
    }

    private static void showEmptyBookcase() {
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
    }

    private static void printMenu() {
        String menu = """
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Завершить работу
                """;
        System.out.println(menu);
    }

    private static int readValue(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: Неверное значение меню. Введите число!");
                scanner.nextLine();
                continue;
            }
            int value = scanner.nextInt();
            scanner.nextLine();
            if (value < 1 || value > 5) {
                System.out.println("Ошибка: Неверное значение меню. Допустимые значения: 1-5");
                continue;
            }
            return value;
        }
    }

    private static void chooseOperation(int answer, Bookcase bookcase, Scanner scanner) {
        switch (answer) {
            case 1:
                String author = getValidAuthor(scanner);
                String title = getValidTitle(scanner);
                Year publishedYear = getValidYear(scanner);
                bookcase.addBook(author, title, publishedYear);
                break;
            case 2:
                System.out.print("Введите название книги, которую хотите найти: ");
                String titleToFind = scanner.nextLine();
                bookcase.findBook(titleToFind);
                break;
            case 3:
                System.out.print("Введите название книги, которую хотите удалить: ");
                String titleToDelete = scanner.nextLine();
                bookcase.removeBook(titleToDelete);
                break;
            case 4:
                bookcase.clearBookcase();
                break;
        }
    }

    private static void printInfo(Bookcase bookcase) {
        System.out.println("В шкафу книг - " + bookcase.getBooksAmount() +
                ", свободно полок - " + bookcase.getFreeShelves());

        bookcase.getAllBooks();
    }
}
