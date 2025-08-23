package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ExceedingArrayElementsRemoval {
    private static final int MIN = 0;
    private static final int MAX = 14;

    public static void main(String[] args) {
        int[] indices = {-1, 15, 0, 14};
        for (int index : indices) {
            float[] original = fillRandomNumbers();
            float[] modified = fillExceedingElementsWithZeros(index, original);
            showResultOfRemoval(index, original, modified);
        }
    }

    private static float[] fillRandomNumbers() {
        Random random = new Random();
        float[] array = new float[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextFloat();
        }
        return array;
    }

    private static float[] fillExceedingElementsWithZeros(int index, float[] originalArray) {
        float[] modifiedArray = Arrays.copyOf(originalArray, originalArray.length);

        if (index < MIN || index > MAX) {
            System.out.println(index + " - ошибочный индекс! Допустимые значения: от " +
                    MIN + " до " + MAX);
            return null;
        }

        for (int i = 0; i < modifiedArray.length; i++) {
            if (modifiedArray[i] > modifiedArray[index]) {
                modifiedArray[i] = 0;
            }
        }
        return modifiedArray;
    }

    private static void showResultOfRemoval(int index, float[] originalArray, float[] modifiedArray) {
        if (modifiedArray == null) return;

        System.out.println("Исходный массив:");
        printArray(originalArray);

        System.out.println("Изменённый массив:");
        printArray(modifiedArray);

        System.out.printf("%s%.3f\n", "Значение из ячейки: ", originalArray[index]);
    }

    private static void printArray(float[] array) {
        int count = 0;
        for (float a : array) {
            System.out.printf("%.3f%s", a, " ");
            count++;
            if (count == 8) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
