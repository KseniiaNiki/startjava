package ru.topjava.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HangmanGame {
    static final int ATTEMPTS = 6;
    private int attemptCounter = 6;
    private int mistakeCounter = 0;
    private String[] gallows = {"_______", "|     |", "|     @", "|    /|\\", "|    / \\", "| GAME OVER!"};

    public String chooseWord() {
        String[] words = {"ВЕЛОСИПЕД", "ХОЛОДИЛЬНИК", "КОМПЬЮТЕР", "ДИАГОНАЛЬ", "РАКОВИНА"};
        Random random = new Random();
        int indexOfGuessWord = random.nextInt(words.length);
        return words[indexOfGuessWord];
    }

    public void start(String word) {
        Scanner scanner = new Scanner(System.in);
        char[] guessWordLetters = word.toCharArray();

        char[] guessWordMask = new char[word.length()];
        Arrays.fill(guessWordMask, '*');
        char[] guessedLetters = new char[word.length()];
        StringBuilder wrongLetters = new StringBuilder();

        for (int i = 0; i < guessWordLetters.length; i++) {
            System.out.print("Угадайте загаданное слово, вводя по одной букве кириллицы: ");
            char inputLetter = scanner.next().charAt(0);
//            String inputLetter = scanner.next();
            scanner.nextLine();
//            Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]{1}");
//            Matcher matcher = pattern.matcher(inputLetter);
//            while (matcher.find() == false) {
//                System.out.print("Введён некорректный тип символов! Повторите ввод: ");
//                inputLetter = scanner.next();
//                scanner.nextLine();
//            }
            while ((inputLetter < 'А') ||
                    ((inputLetter > 'п') && (inputLetter < 'р')) ||
                    (inputLetter > 'ё')) {
                System.out.print("Введён некорректный тип символов! Повторите ввод: ");
                inputLetter = scanner.next().charAt(0);
                scanner.nextLine();
            }

            if (guessWordLetters[i] == Character.toUpperCase(inputLetter)) {
                guessedLetters[i] = Character.toUpperCase(inputLetter);
//                guessedLetters[i] = inputLetter.toUpperCase().charAt(0);
                attemptCounter++;
                if (attemptCounter > 6) {
                    attemptCounter = 6;
                }
                if (mistakeCounter > 0) {
                    mistakeCounter--;
                }
            } else {
                guessedLetters[i] = '*';
                mistakeCounter++;
                for (int j = 0; j < mistakeCounter; j++) {
                    System.out.println(gallows[j]);
                }
                wrongLetters.append(Character.toUpperCase(inputLetter));
                attemptCounter--;
            }

            if (attemptCounter == 0) {
                System.out.println("Вы проиграли! \nЗагаданное слово - " + word);
                attemptCounter = 6;
                mistakeCounter = 0;
                break;
            }

            if (Arrays.equals(guessWordMask, guessWordLetters)) {
                System.out.println("Вы выиграли игру!");
                break;
            }

            printArray(guessWordMask);
            printArray(guessedLetters);
            System.out.println("Из " + ATTEMPTS + " попыток осталось " + attemptCounter);
            System.out.println("Введённые ошибочные буквы: " + wrongLetters);
        }
    }

    public void printArray(char[] array) {
        for (char a : array) {
            System.out.print(a);
        }
        System.out.println();
    }
}
