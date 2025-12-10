package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.print("Введите имя первого игрока: ");
        Player playerOne = new Player(scanner.nextLine());
        System.out.print("Введите имя второго игрока: ");
        Player playerTwo = new Player(scanner.nextLine());

        String answer = "yes";

        do {
            if ("yes".equals(answer)) {
                GuessNumber game = new GuessNumber(playerOne, playerTwo);
                game.start();
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            answer = scanner.nextLine().toLowerCase();
        } while (!"no".equals(answer));
    }
}
