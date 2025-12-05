package ru.topjava.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private final String[] words = {"ВЕЛОСИПЕД", "ХОЛОДИЛЬНИК", "КОМПЬЮТЕР", "ДИАГОНАЛЬ", "РАКОВИНА"};
    private final String[] gallows =
            {"_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"};
    private final int attempts = gallows.length;
    private int attemptsLeft;
    private String secretWord;
    char[] guessWordMask;
    StringBuilder guessedLetters;
    StringBuilder wrongLetters;
    private int currAttempt;

    public HangmanGame() {
        Random random = new Random();
        this.attemptsLeft = attempts;
        this.secretWord = words[random.nextInt(words.length)];
        this.guessWordMask = new char[secretWord.length()];
        Arrays.fill(guessWordMask, '*');
        this.guessedLetters = new StringBuilder();
        this.wrongLetters = new StringBuilder();
        this.currAttempt = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        char[] guessWordLetters = secretWord.toCharArray();
        boolean isGameOver = false;

        while (!isGameOver) {
            printInfo();
            char enteredLetter = enterAndCheckLetter(scanner);
            String stringLetter = String.valueOf(enteredLetter);

            if (secretWord.contains(stringLetter)) {
                findMatching(enteredLetter);
                if (currAttempt > 0) {
                    currAttempt--;
                    attemptsLeft = Math.min(attemptsLeft + 1, attempts);
                }
                displayHangman();
            } else {
                wrongLetters.append(enteredLetter);
                currAttempt++;
                attemptsLeft--;
                displayHangman();
            }

            isGameOver = showGameResult(isGameOver, guessWordLetters);
            System.out.println();
        }
    }

    private void printInfo() {
        System.out.println("Угадываемое слово: " + String.valueOf(guessWordMask));
        System.out.println("Попыток: " + attemptsLeft + " из " + attempts);

        if (!wrongLetters.isEmpty()) {
            System.out.println("Введённые ошибочные буквы: " + wrongLetters);
        }
    }

    private char enterAndCheckLetter(Scanner scanner) {
        System.out.print("Введите букву кириллицы: ");
        char letter = Character.toUpperCase(scanner.next().charAt(0));
        String stringLetter = String.valueOf(letter);
        while (isValid(letter, stringLetter)) {
            printInfo();
            System.out.print("Введите букву кириллицы: ");
            letter = Character.toUpperCase(scanner.next().charAt(0));
            stringLetter = String.valueOf(letter);
        }
        guessedLetters.append(letter);
        return letter;
    }

    private boolean isValid(char enteredLetter, String stringLetter) {
        if (!isCyrillic(enteredLetter)) {
            System.out.println("Ошибка: вводите только кириллические буквы!\n");
            return true;
        }

        if (guessedLetters.toString().contains(stringLetter)) {
            System.out.println("Такая буква уже была введена ранее!\n");
            return true;
        }
        return false;
    }

    private static boolean isCyrillic(char ch) {
        return (ch >= 'А' && ch <= 'Я') || (ch == 'Ё');
    }

    private void findMatching(char enteredLetter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == enteredLetter) {
                guessWordMask[i] = enteredLetter;
            }
        }
    }

    private void displayHangman() {
        for (int i = 0; i < currAttempt; i++) {
            System.out.println(gallows[i]);
        }
    }

    private boolean showGameResult(boolean isGameOver, char[] guessWordLetters) {
        if (attemptsLeft == 0) {
            System.out.println("Вы проиграли! \nЗагаданное слово - " + secretWord);
            attemptsLeft = 6;
            isGameOver = true;
        } else if (Arrays.equals(guessWordMask, guessWordLetters)) {
            System.out.println("Вы выиграли игру!");
            isGameOver = true;
        }
        return isGameOver;
    }
}
