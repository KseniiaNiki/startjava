package ru.topjava.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        int answer;
        sayHello();
        boolean isProgramOver = false;

        while (!isProgramOver) {
            printMenu();
            answer = readValue(scanner);
            switch (answer) {
                case 1:
                    bookshelf.addBook(scanner);
                    break;
                case 2:
                    System.out.print("Введите название книги, которую хотите найти: ");
                    String titleToFind = scanner.nextLine();
                    bookshelf.findBook(titleToFind);
                    break;
                case 3:
                    System.out.print("Введите название книги, которую хотите удалить: ");
                    String titleToDelete = scanner.nextLine();
                    bookshelf.removeBook(titleToDelete);
                    break;
                case 4:
                    bookshelf.clearBookcase();
                    break;
                case 5:
                    isProgramOver = true;
                    continue;
            }

            System.out.println("Для продолжения работы нажмите клавишу <Enter>");
            scanner.nextLine();
            if (bookshelf.getBooksAmount() > 0) {
                printInfo(bookshelf);
            } else {
                showEmptyBookcase();
            }
        }
    }

    public static void sayHello() throws InterruptedException {
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

    public static void showEmptyBookcase() {
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
    }

    public static void printMenu() {
        String menu = """
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Завершить работу
                """;
        System.out.println(menu);
    }

    public static void printInfo(Bookshelf bookshelf) {
        System.out.println("В шкафу книг - " + bookshelf.getBooksAmount() +
                ", свободно полок - " + bookshelf.getFreeShelves());

        bookshelf.getAllBooks();
    }

    public static int readValue(Scanner scanner) {
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
}
