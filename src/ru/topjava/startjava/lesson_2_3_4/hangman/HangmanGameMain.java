package ru.topjava.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        String guessWord = game.chooseWord();
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";
        do {
            if (answer.equals("yes")) {
                game.start(guessWord);
            }
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanner.nextLine().toLowerCase();

            while (!answer.equals("no") && !answer.equals("yes")) {
                System.out.print("Введите корректный ответ [yes/no]: ");
                answer = scanner.nextLine().toLowerCase();
            }
        } while (!answer.equals("no"));
    }
}
