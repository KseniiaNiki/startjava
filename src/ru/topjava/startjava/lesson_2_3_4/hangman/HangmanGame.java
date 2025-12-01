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
    private int hangmanStep;

    public HangmanGame() {
        Random random = new Random();
        this.attemptsLeft = attempts;
        this.secretWord = words[random.nextInt(words.length)];
        this.guessWordMask = new char[secretWord.length()];
        Arrays.fill(guessWordMask, '*');
        this.guessedLetters = new StringBuilder();
        this.wrongLetters = new StringBuilder();
        this.hangmanStep = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        char[] guessWordLetters = secretWord.toCharArray();
        boolean isGameOver = false;

        while (!isGameOver) {
            System.out.println("Угадываемое слово: " + String.valueOf(guessWordMask));
            System.out.println("Попыток: " + attemptsLeft + " из " + attempts);

            if (!wrongLetters.isEmpty()) {
                System.out.println("Введённые ошибочные буквы: " + wrongLetters);
            }
            char enteredLetter = getLetter(scanner);
            scanner.nextLine();
            String stringLetter = String.valueOf(enteredLetter);

            if (!isCyrillic(enteredLetter)) {
                System.out.println("Ошибка: вводите только кириллические буквы!\n");
                continue;
            }

            if (guessedLetters.toString().contains(stringLetter)) {
                System.out.println("Такая буква уже была введена ранее!\n");
                continue;
            }
            guessedLetters.append(enteredLetter);

            if (secretWord.contains(stringLetter)) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == enteredLetter) {
                        guessWordMask[i] = enteredLetter;
                    }
                }
                if (hangmanStep > 0) {
                    hangmanStep--;
                    attemptsLeft = Math.min(attemptsLeft + 1, attempts);
                }
                displayHangman();
            } else {
                wrongLetters.append(enteredLetter);
                hangmanStep++;
                attemptsLeft--;
                displayHangman();
            }
            
            if (attemptsLeft == 0) {
                System.out.println("Вы проиграли! \nЗагаданное слово - " + secretWord);
                attemptsLeft = 6;
                isGameOver = true;
            } else if (Arrays.equals(guessWordMask, guessWordLetters)) {
                System.out.println("Вы выиграли игру!");
                isGameOver = true;
            }
            System.out.println();
        }
    }

    private static char getLetter(Scanner scanner) {
        System.out.print("Введите букву кириллицы: ");
        return Character.toUpperCase(scanner.next().charAt(0));
    }

    private static boolean isCyrillic(char ch) {
        return (ch >= 'А' && ch <= 'Я') || (ch == 'Ё');
    }

    private void displayHangman() {
        for (int i = 0; i < hangmanStep; i++) {
            System.out.println(gallows[i]);
        }
    }
}
