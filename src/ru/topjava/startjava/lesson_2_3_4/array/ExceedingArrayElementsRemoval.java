package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class ExceedingArrayElementsRemoval {
    private static final int MIN = 0;
    private static final int MAX = 14;

    public static void main(String[] args) {
        int[] indices = {-1, 15, 0, 14};
        for (int index : indices) {
            float[] randomArray = fillRandomNumbers();
            float[] modifiedArray = checkIndexAndElementValue(index, randomArray);
            showArraysAndElementValue(index, randomArray, modifiedArray);
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

    private static float[] checkIndexAndElementValue(int index, float[] randomArray) {
        float[] modifiedArray = Arrays.copyOf(randomArray, randomArray.length);

        if (index < MIN || index > MAX) {
            System.out.println(index + " - ошибочный индекс! Допустимые значения: от " +
                    MIN + " до " + MAX);
            return null;
        }

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] > randomArray[index]) {
                modifiedArray[i] = 0;
            }
        }
        return modifiedArray;
    }

    private static void showArray(float[] array) {
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

    private static void showArraysAndElementValue(int index, float[] randomArray, float[] modifiedArray) {
        if (modifiedArray == null) return;

        System.out.println("Исходный массив:");
        showArray(randomArray);

        System.out.println("Изменённый массив:");
        showArray(modifiedArray);

        System.out.printf("%s%.3f\n", "Значение из ячейки по переданному индексу:\n", randomArray[index]);
    }
}
