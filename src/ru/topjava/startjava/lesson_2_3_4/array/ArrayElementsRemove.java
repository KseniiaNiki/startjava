package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayElementsRemove {
    private static final int MIN = 0;
    private static final int MAX = 14;

    public static void main(String[] args) {
        int index = -1;
        double[] initialArray = getRandomArray();
        sortAndShowNewArray(index, initialArray);

        index = 15;
        initialArray = getRandomArray();
        sortAndShowNewArray(index, initialArray);

        index = 0;
        initialArray = getRandomArray();
        sortAndShowNewArray(index, initialArray);

        index = 14;
        initialArray = getRandomArray();
        sortAndShowNewArray(index, initialArray);
    }

    private static double[] getRandomArray() {
        Random random = new Random();
        double[] initialArray = new double[15];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = random.nextDouble(1);
        }
        return initialArray;
    }

    private static void sortAndShowNewArray(int index, double[] initialArray) {
        if (index < MIN || index > MAX) {
            System.out.println(index + " - ошибочный индекс! Допустимые значения: от " + MIN +
                    " до " + MAX);
            return;
        }

        double[] sortedArray = Arrays.copyOf(initialArray, initialArray.length);
        for (int i = 0; i < initialArray.length; i++) {
            if (i > index) {
                sortedArray[i] = 0;
            }
        }

        System.out.print("Исходный массив: [ ");
        int count = 0;
        for (double a : initialArray) {
            System.out.printf("%.3f%s", a, " ");
            count++;
            if (count == 8) {
                System.out.println();
            }
        }
        System.out.println("]");

        System.out.print("Изменённый массив: [ ");
        int count2 = 0;
        for (double b : sortedArray) {
            System.out.printf("%.3f%s", b, " ");
            count2++;
            if (count2 == 8) {
                System.out.println();
            }
        }
        System.out.println("]");

        System.out.printf("%s%.3f\n", "Значение из ячейки по переданному индексу = ", initialArray[index]);
    }
}
