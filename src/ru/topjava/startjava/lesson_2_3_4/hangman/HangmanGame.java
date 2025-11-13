package ru.topjava.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public String chooseWord() {
        String[] words = {"ВЕЛОСИПЕД", "ХОЛОДИЛЬНИК", "КОМПЬЮТЕР", "ДИАГОНАЛЬ", "РАКОВИНА"};
        Random random = new Random();
        int indexOfGuessWord = random.nextInt(words.length);
        return words[indexOfGuessWord];
    }

    public void start(String word) {
        Scanner scanner = new Scanner(System.in);
        int attemptCounter = 6;
        int mistakeCounter = 0;
        String answer = "yes";
        char[] guessWordLetters = word.toCharArray();
        char[] wrongLetters = new char[30];

        char[] guessWordMask = new char[word.length()];
        Arrays.fill(guessWordMask, '*');
        char[] guessedLetters = new char[word.length()];
        Arrays.fill(guessedLetters, '*');

        String[] hangmanParts = new String[6];
        hangmanParts[0] = "_______";
        hangmanParts[1] = "|     |";
        hangmanParts[2] = "|     @";
        hangmanParts[3] = "|    /|\\";
        hangmanParts[4] = "|    / \\";
        hangmanParts[5] = "| GAME OVER!";

        while (answer.equals("yes")) {
            for (int i = 0; i < guessWordLetters.length; i++) {
                System.out.print("Угадайте загаданное слово, вводя по одной букве кириллицы: ");
                char inputLetter = scanner.next().charAt(0);
                scanner.nextLine();
                while ((inputLetter < 'А') ||
                        ((inputLetter > 'п') & (inputLetter < 'р')) ||
                        (inputLetter > 'ё')) {
                    System.out.print("Введён некоректный тип символов! Повторите ввод: ");
                    inputLetter = scanner.next().charAt(0);
                    scanner.nextLine();
                }

                if (guessWordLetters[i] == Character.toUpperCase(inputLetter)) {
                    guessedLetters[i] = Character.toUpperCase(inputLetter);
                    attemptCounter++;
                    if (attemptCounter > 6) {
                        attemptCounter = 6;
                    }
                    if (mistakeCounter > 0) {
                        mistakeCounter--;
                    }
                } else {
                    for (int j = 0; j < mistakeCounter; j++) {
                        System.out.println(hangmanParts[j]);
                    }
                    wrongLetters[i] = Character.toUpperCase(inputLetter);
                    attemptCounter--;
                    mistakeCounter++;
                }

                if (attemptCounter == 0) {
                    System.out.println("Вы проиграли! \nЗагаданное слово - " + word);
                    break;
                }

                System.out.println(Arrays.toString(guessWordMask));
                System.out.println(Arrays.toString(guessedLetters));
                System.out.println("Из 6 попыток осталось " + attemptCounter);
                System.out.println("Введённые ошибочные буквы: " + Arrays.toString(wrongLetters));
            }

            if (Arrays.equals(guessWordMask, guessWordLetters)) {
                System.out.println("Вы выиграли игру!");
                break;
            }

            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            answer = scanner.nextLine().toLowerCase();
            do {
                System.out.print("Введите корректный ответ [yes / no]: ");
                answer = scanner.nextLine().toLowerCase();
            } while (!answer.equals("no") && !answer.equals("yes"));
        }
    }
}
