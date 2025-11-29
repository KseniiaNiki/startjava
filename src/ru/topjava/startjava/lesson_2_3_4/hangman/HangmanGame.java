package ru.topjava.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private String[] words = {"ВЕЛОСИПЕД", "ХОЛОДИЛЬНИК", "КОМПЬЮТЕР", "ДИАГОНАЛЬ", "РАКОВИНА"};
    private String[] gallows =
            {"_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"};
    private int attempts = gallows.length;
    private int attemptsLeft = attempts;

    public String chooseWord() {
        Random random = new Random();
        int indexOfGuessWord = random.nextInt(words.length);
        return words[indexOfGuessWord];
    }

    public void start(String word) {
        Scanner scanner = new Scanner(System.in);
        char[] guessWordLetters = word.toCharArray();
        char[] guessWordMask = new char[word.length()];
        Arrays.fill(guessWordMask, '*');
        StringBuilder guessedLetters = new StringBuilder();
        StringBuilder wrongLetters = new StringBuilder();
        boolean isGameOver = false;

        while (!isGameOver) {
            System.out.println("Зашифрованное слово: " + String.valueOf(guessWordMask));
            System.out.println("Из " + attempts + " попыток осталось " + attemptsLeft);

            if (!wrongLetters.isEmpty()) {
                System.out.println("Введённые ошибочные буквы: " + wrongLetters);
            }
            System.out.print("Угадайте загаданное слово, вводя по одной букве кириллицы: ");
            char enteredLetter = Character.toUpperCase(scanner.next().charAt(0));
            scanner.nextLine();
            String stringLetter = String.valueOf(enteredLetter);

            if (!isCyrillic(enteredLetter)) {
                System.out.println("Введён некорректный тип символов!");
                continue;
            }

            if (guessedLetters.toString().contains(stringLetter)) {
                System.out.println("Такая буква уже была введена ранее!");
                continue;
            }
            guessedLetters.append(enteredLetter);

            if (word.contains(stringLetter)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == enteredLetter) {
                        guessWordMask[i] = enteredLetter;
                    }
                }
                attemptsLeft++;
                if (attemptsLeft > 6) {
                    attemptsLeft = 6;
                }
            } else {
                attemptsLeft--;
                wrongLetters.append(enteredLetter);
                for (int i = 0; i < (gallows.length - attemptsLeft); i++) {
                    System.out.println(gallows[i]);
                }
                System.out.println();
            }
            
            if (attemptsLeft == 0) {
                System.out.println("Вы проиграли! \nЗагаданное слово - " + word);
                attemptsLeft = 6;
                isGameOver = true;
            } else if (Arrays.equals(guessWordMask, guessWordLetters)) {
                System.out.println("Вы выиграли игру!");
                isGameOver = true;
            }
        }
    }

    private boolean isCyrillic(char ch) {
        return (ch >= 'А' && ch <= 'Я') || (ch == 'Ё');
    }
}
