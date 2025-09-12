package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    public static final int MIN = 0;
    public static final int MAX = 14;

    public static int[] reverse(int[] transactions) {
        if (transactions == null) {
            return null;
        }

        int[] reversed = new int[transactions.length];
        int length = reversed.length;
        for (int r : transactions) {
            reversed[--length] = r;
        }
        return reversed;
    }

    public static int generateRandomNumber() {
        int min = 0;
        int max = 100;
        Random random = new Random();
        return random.nextInt(min, max);
    }

    public static long[] calculate(int... numbers) {
        if (numbers == null) {
            return null;
        }

        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long factorial = 1;
            if (numbers[i] < 0) continue;
            for (int j = 1; j <= numbers[i]; j++) {
                factorial *= j;
            }

            factorials[i] = factorial;
        }
        return factorials;
    }

    public static float[][] fillExceedingElementsWithZeros(int index) {
        Random random = new Random();
        float[] originalArray = new float[15];
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = random.nextFloat();
        }

        float[] modifiedArray = java.util.Arrays.copyOf(originalArray, originalArray.length);

        if (index < MIN || index > MAX) {
            return null;
        }

        for (int i = 0; i < modifiedArray.length; i++) {
            if (modifiedArray[i] > modifiedArray[index]) {
                modifiedArray[i] = 0;
            }
        }
        return new float[][] {originalArray, modifiedArray};
    }
}
