package ru.topjava.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        do {
            HangmanGame game = new HangmanGame();
            if (answer.equals("yes")) {
                game.start();
            }
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            answer = getAnswer(scanner);
        } while (!answer.equals("no"));
    }

    private static String getAnswer(Scanner scanner) {
        String answer = scanner.nextLine().toLowerCase();
        while (!answer.equals("no") && !answer.equals("yes")) {
            System.out.print("Введите корректный ответ [yes/no]: ");
            answer = scanner.nextLine().toLowerCase();
        }
        return answer;
    }
}
