package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.OptionalInt;

public class ArrayTrainingMethods {
    static int max;
    static int min;

    // 5. Проверка, содержит ли массив определённое значение
    public static boolean containDefinedValue(int[] arr, int item) {
        for (int a : arr) {
            if (item == a) {
                return true;
            }
        }
        return false;
    }

    // 6. Нахождение индекса элемента в массиве
    public static OptionalInt hasIndex(int[] arr2, int t) {
        if (arr2 == null) {
            return OptionalInt.empty();
        }
        int len = arr2.length;
        int i = 0;
        while (i < len) {
            if (arr2[i] == t) {
                return OptionalInt.of(i);
            } else {
                i++;
            }
        }
        return OptionalInt.empty();
    }

    // 10. Нахождение максимального и минимального значения в массиве
    public static void findMaxAndMin(int[] arr3) {
        max = arr3[0];
        min = arr3[0];
        int len = arr3.length;
        for (int i = 0; i < len - 1; i++) {
            if (i + 1 > len) {
                if (arr3[i] > max) {
                    max = arr3[i];
                }
                if (arr3[i] < min) {
                    min = arr3[i];
                }
            }
            if (arr3[i] > arr3[i + 1]) {
                if (arr3[i] > max) {
                    max = arr3[i];
                }
                if (arr3[i + 1] < min) {
                    min = arr3[i + 1];
                }
            }
            if (arr3[i] < arr3[i + 1]) {
                if (arr3[i] < min) {
                    min = arr3[i];
                }
                if (arr3[i + 1] > max) {
                    max = arr3[i + 1];
                }
            }
        }
    }

    // 16. Удаление дубликатов из массива
    public static void makeUniqueArray(int[] arr4) {
        System.out.println("Original Array: ");
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i] + " ");
        }
        int uniqueElementsNumb = arr4.length;
        for (int i = 0; i < uniqueElementsNumb; i++) {
            for (int j = i + 1; j < uniqueElementsNumb; j++) {
                if (arr4[i] == arr4[j]) {
                    arr4[j] = arr4[uniqueElementsNumb - 1];
                    uniqueElementsNumb--;
                    j--;
                }
            }
        }
        int[] newArray = Arrays.copyOf(arr4, uniqueElementsNumb);
        System.out.println();
        System.out.println("Array with unique values: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------");
    }

    // 22. Нахождение пары с заданной суммой
    public static void findPair(int[] arr5, int inputNumb) {
        System.out.println("Pairs of elements and their sum: ");
        for (int i = 0; i < arr5.length; i++) {
            for (int j = i + 1; j < arr5.length; j++) {
                if (arr5[i] + arr5[j] == inputNumb) {
                    System.out.println(arr5[i] + " + " + arr5[j] + " = " + inputNumb);
                }
            }
        }
        System.out.println();
    }

    // 23. Проверка, равны ли два массива
    public static void checkArrays(int[] arr6, int[] arr7) {
        boolean isEqual = true;
        if (arr6.length == arr7.length) {
            for (int i = 0; i < arr6.length; i++) {
                if (arr6[i] != arr7[i]) {
                    isEqual = false;
                }
            }
        } else {
            isEqual = false;
        }
        if (isEqual) {
            System.out.println("Two arrays are equal.");
        } else {
            System.out.println("Two arrays are not equal.");
        }
    }
}
