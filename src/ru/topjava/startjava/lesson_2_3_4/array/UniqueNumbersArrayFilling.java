package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArrayFilling {
    public static void main(String[] args) {
        int start = -30;
        int end = -10;
        int numbersAmountInString = 23;
        int[] uniqueRandomNumbers = fillArrayWithUniqueNumbers(start, end, numbersAmountInString);
        printUniqueNumbersArray(uniqueRandomNumbers, numbersAmountInString);

        start = 10;
        end = 50;
        numbersAmountInString = 10;
        uniqueRandomNumbers = fillArrayWithUniqueNumbers(start, end, numbersAmountInString);
        printUniqueNumbersArray(uniqueRandomNumbers, numbersAmountInString);

        start = -34;
        end = -34;
        numbersAmountInString = 1;
        uniqueRandomNumbers = fillArrayWithUniqueNumbers(start, end, numbersAmountInString);
        printUniqueNumbersArray(uniqueRandomNumbers, numbersAmountInString);

        start = -1;
        end = 2;
        numbersAmountInString = -3;
        uniqueRandomNumbers = fillArrayWithUniqueNumbers(start, end, numbersAmountInString);
        printUniqueNumbersArray(uniqueRandomNumbers, numbersAmountInString);

        start = 5;
        end = -8;
        numbersAmountInString = 2;
        uniqueRandomNumbers = fillArrayWithUniqueNumbers(start, end, numbersAmountInString);
        printUniqueNumbersArray(uniqueRandomNumbers, numbersAmountInString);
    }

    private static int[] fillArrayWithUniqueNumbers(int start, int end, int numbersAmountInString) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }

        if (numbersAmountInString < 1) {
            System.out.println("Ошибка: количество чисел в строке не должно быть < 1 (" +
                    numbersAmountInString + ")");
            return null;
        }

        int segmentLength = end - start + 1;
        int arrayLength = (int) (segmentLength * 0.75);
        if (arrayLength < 2) {
            System.out.println("Ошибка: длина массива должна быть > 0 (" + arrayLength + ")");
            return null;
        }

        Random random = new Random();
        int[] uniqueRandomNumbers = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            uniqueRandomNumbers[i] = random.nextInt(start, end) + 1;
        }
        for (int i = 0; i < arrayLength; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (uniqueRandomNumbers[i] == uniqueRandomNumbers[j]) {
                    uniqueRandomNumbers[j] = random.nextInt(start, end) + 1;
                }
            }
        }
        Arrays.sort(uniqueRandomNumbers);
        return uniqueRandomNumbers;
    }

    private static void printUniqueNumbersArray(int[] uniqueRandomNumbers, int numbersAmountInString) {
        if (uniqueRandomNumbers == null) {
            return;
        }

        int count = 0;
        for (int n : uniqueRandomNumbers) {
            System.out.printf("%d%s", n, " ");
            count++;
            if (count == numbersAmountInString) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }
}
