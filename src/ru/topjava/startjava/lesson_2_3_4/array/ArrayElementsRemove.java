package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayElementsRemove {
    private static final int MIN = 0;
    private static final int MAX = 14;

    public static void main(String[] args) {
        int[] indices = {-1, 15, 0, 14};
        float[] array = fillRandomNumbers();
        float[] sortedArray = sort(indices, array);
        showNewArray(indices, array, sortedArray);
    }

    private static float[] fillRandomNumbers() {
        Random random = new Random();
        float[] array = new float[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextFloat();
        }
        return array;
    }

    private static float[] sort(int[] indices, float[] array) {
        float[] sortedArray = Arrays.copyOf(array, array.length);
        for (int i : indices) {
            if (i < MIN || i > MAX) {
                return null;
            }

            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[indices[i]]) {
                    sortedArray[j] = 0;
                }
            }
        }
        return sortedArray;
    }

    private static void showNewArray(int[] indices, float[] array, float[] sortedArray) {
        for (int i : indices) {
            if (i < MIN || i > MAX) {
                System.out.println(i + " - ошибочный индекс! Допустимые значения: от " +
                        MIN + " до " + MAX);
                return;
            }

            System.out.println("Исходный массив:");
            int count = 0;
            for (float a : array) {
                System.out.printf("%.3f%s", a, " ");
                count++;
                if (count == 8) {
                    System.out.println();
                }
            }

            System.out.println("\nИзменённый массив:");
            int count2 = 0;
            for (float b : sortedArray) {
                System.out.printf("%.3f%s", b, " ");
                count2++;
                if (count2 == 8) {
                    System.out.println();
                }
            }

            System.out.printf("%s%.3f\n", "\nЗначение из ячейки по переданному индексу:\n", array[indices[i]]);
        }
    }
}
