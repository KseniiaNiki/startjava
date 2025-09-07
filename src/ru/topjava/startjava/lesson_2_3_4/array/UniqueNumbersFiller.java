package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersFiller {
    public static void main(String[] args) {
        int start = -30;
        int end = -10;
        int numbersPerLine = 23;
        int[] uniqueNumbers = fillUniqueNumbersAsc(start, end, numbersPerLine);
        printUniqueNumbers(uniqueNumbers, numbersPerLine);

        start = 10;
        end = 50;
        numbersPerLine = 10;
        uniqueNumbers = fillUniqueNumbersAsc(start, end, numbersPerLine);
        printUniqueNumbers(uniqueNumbers, numbersPerLine);

        start = -34;
        end = -34;
        numbersPerLine = 1;
        uniqueNumbers = fillUniqueNumbersAsc(start, end, numbersPerLine);
        printUniqueNumbers(uniqueNumbers, numbersPerLine);

        start = -1;
        end = 2;
        numbersPerLine = -3;
        uniqueNumbers = fillUniqueNumbersAsc(start, end, numbersPerLine);
        printUniqueNumbers(uniqueNumbers, numbersPerLine);

        start = 5;
        end = -8;
        numbersPerLine = 2;
        uniqueNumbers = fillUniqueNumbersAsc(start, end, numbersPerLine);
        printUniqueNumbers(uniqueNumbers, numbersPerLine);
    }

    private static int[] fillUniqueNumbersAsc(int start, int end, int numbersPerLine) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }

        if (numbersPerLine < 1) {
            System.out.println("Ошибка: количество чисел в строке не должно быть < 1 (" +
                    numbersPerLine + ")");
            return null;
        }

        int segmentLength = end - start + 1;
        int arrayLength = (int) (segmentLength * 0.75);
        if (arrayLength <= 0) {
            System.out.println("Ошибка: длина массива должна быть > 0 (" + arrayLength + ")");
            return null;
        }

        Random r = new Random();
        int[] uniqueNumbers = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            boolean isUnique;
            int random;
            do {
                random = r.nextInt(start, end + 1);
                isUnique = true;
                for (int j = 0; j < i; j++) {
                    if (uniqueNumbers[j] == random) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
            uniqueNumbers[i] = random;
        }
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static void printUniqueNumbers(int[] uniqueNumbers, int numbersPerLine) {
        if (uniqueNumbers == null) {
            return;
        }

        int count = 0;
        for (int n : uniqueNumbers) {
            System.out.printf("%d%s", n, " ");
            count++;
            if (count == numbersPerLine) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }
}
