package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;

import static ru.topjava.startjava.lesson_2_3_4.array.ArrayTrainingMethods.max;
import static ru.topjava.startjava.lesson_2_3_4.array.ArrayTrainingMethods.min;

public class ArrayTraining {
    public static void main(String[] args) {
        // 1. Сортировка числовых и строковых массивов
        int[] myArray1 = {1789, 2035, 1899, 2013,
                1458, 2458, 1254, 2365,
                1456, 2165, 1457, 2456};
        System.out.println("Original numeric array: " + Arrays.toString(myArray1));
        Arrays.sort(myArray1);
        System.out.println("Sorted numeric array: " + Arrays.toString(myArray1));

        String[] myArray2 = {"Java", "Python", "PHP", "C#", "C Programming", "C++"};
        System.out.println("Original string array: " + Arrays.toString(myArray2));
        Arrays.sort(myArray2);
        System.out.println("Sorted string array: " + Arrays.toString(myArray2));
        System.out.println();

        // 2. Сложение всех значений в массиве
        int[] myArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int x : myArray3) {
            sum += x;
        }
        System.out.println("The sum is " + sum);
        System.out.println();

        // 3. Сетка из нулей 10x10
        int[][] myArray4 = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%2d", myArray4[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // 4. Вычисление среднего значения элементов массива
        int[] myArray5 = {20, 30, 25, 35, -16, 60, -100};
        int sum2 = 0;
        for (int a : myArray5){
            sum2 += a;
        }
        double average = sum2 / myArray5.length;
        System.out.println("Average value of the array elements is: " + average);
        System.out.println();

        // 5. Проверка, содержит ли массив определённое значение
        System.out.println(ArrayTrainingMethods.containDefinedValue(myArray1, 2013));
        System.out.println(ArrayTrainingMethods.containDefinedValue(myArray1, 2015));
        System.out.println();

        // 6. Нахождение индекса элемента в массиве
        ArrayTrainingMethods.hasIndex(myArray5, 25).ifPresent(index -> System.out.println("Index position of 25 is: " + index));
        ArrayTrainingMethods.hasIndex(myArray5, 40).ifPresent(index -> System.out.println("Index position of 40 is: " + index));
        System.out.println();

        // 7. Удаление определённого элемента из массива
        System.out.println("Original Array: " + Arrays.toString(myArray3));
        int removeIndex = 2;
        for (int i = removeIndex; i < myArray3.length - 1; i++) {
            myArray3[i] = myArray3[i + 1];
        }
        System.out.println("After removing the element № " + removeIndex + ": " + Arrays.toString(myArray3));
        System.out.println();

        // 8. Копирование массива с помощью итерации
        int[] newArray = new int[7];
        System.out.println("Source Array : " + Arrays.toString(myArray5));
        for (int i = 0; i < myArray5.length; i++) {
            newArray[i] = myArray5[i];
        }
        System.out.println("New Array: " + Arrays.toString(newArray));
        System.out.println();

        // 9. Вставление элемента в определённое место
        int[] myArray6 = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int indexPosition = 2;
        int newValue = 5;
        System.out.println("Original Array : " + Arrays.toString(myArray6));
        for (int i = myArray6.length - 1; i > indexPosition; i--) {
            myArray6[i] = myArray6[i - 1];
        }
        myArray6[indexPosition] = newValue;
        System.out.println("New Array: " + Arrays.toString(myArray6));
        System.out.println();

        // 10. Нахождение максимального и минимального значения в массиве
        ArrayTrainingMethods.findMaxAndMin(myArray6);
        System.out.println("Original Array: " + Arrays.toString(myArray6));
        System.out.println("Maximum value for the above array = " + max);
        System.out.println("Minimum value for the above array = " + min);
        System.out.println();

        // 11. Разворот элементов массива в обратном(реверсивном) порядке
        System.out.println("Original numeric array: " + Arrays.toString(myArray1));
        System.out.print("Reverse array: ");
        for (int i = myArray1.length - 1; i >= 0; i--) {
            System.out.print(myArray1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < myArray1.length / 2; i++) {
            int halfArray = myArray1[i];
            myArray1[i] = myArray1[myArray1.length - i - 1];
            myArray1[myArray1.length - i - 1] = halfArray;
        }
        System.out.println("Reverse array: " + Arrays.toString(myArray1));
        System.out.println();

        // 12. Нахождение дубликатов в массиве целых чисел
        int[] myArray7 = {1, 2, 5, 5, 6, 6, 7, 2};
        System.out.println("Original numeric array: " + Arrays.toString(myArray7));
        for (int i = 0; i < myArray7.length - 1; i++) {
            for (int j = i + 1; j < myArray7.length; j++) {
                if ((myArray7[i] == myArray7[j]) && (i != j)) {
                    System.out.println("Duplicate Element: " + myArray7[j]);
                }
            }
        }
        System.out.println();

        // 13. Нахождение дубликатов в массиве строк
        String[] stringArray1 = {"bcd", "abd", "jude", "bcd", "oiu", "gzw", "oiu"};
        System.out.println("Original numeric array: " + Arrays.toString(stringArray1));
        for (int i = 0; i < stringArray1.length - 1; i++) {
            for (int j = i + 1; j < stringArray1.length; j++) {
                if ((stringArray1[i].equals(stringArray1[j])) && (i != j)) {
                    System.out.println("Duplicate Element: " + stringArray1[j]);
                }
            }
        }
        System.out.println();

        // 14. Нахождение общих элементов в двух строковых массивах
        String[] stringArray2 = {"Python", "JAVA", "PHP", "C#", "C++", "SQL"};
        String[] stringArray3 = {"MySQL", "SQL", "SQLite", "Oracle", "PostgreSQL", "DB2", "JAVA"};
        System.out.println("Array1: " + Arrays.toString(stringArray2));
        System.out.println("Array2: " + Arrays.toString(stringArray3));
        String commonElement = "";
        for (int i = 0; i < stringArray2.length; i++) {
            for (int j = 0; j < stringArray3.length; j++) {
                if (stringArray2[i].equals(stringArray3[j])) {
                    commonElement += stringArray2[i] + " ";
                }
            }
        }
        System.out.println("Common element: " + commonElement);
        System.out.println();

        // 5. Нахождение общих элементов в двух целочисленных массивах
        int[] numbers1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] numbers2 = {1, 0, 6, 15, 6, 4, 7, 0};
        System.out.println("Array1: " + Arrays.toString(numbers1));
        System.out.println("Array2: " + Arrays.toString(numbers2));
        for (int i = 0; i < numbers1.length; i++) {
            for (int j = 0; j < numbers2.length; j++) {
                if (numbers1[i] == numbers2[j]) {
                    System.out.println("Common element: " + numbers1[i]);
                }
            }
        }
        System.out.println();

        // 16. Удаление дубликатов из массива
        ArrayTrainingMethods.makeUniqueArray(new int[] {0, 3, -2, 4, 3, 2});
        ArrayTrainingMethods.makeUniqueArray(new int[] {10, 22, 10, 20, 11, 22});

        // 17. Нахождение второго по величине элемента массива
        System.out.println("Original numeric array: " + Arrays.toString(myArray1));
        Arrays.sort(myArray1);
        int index1 = myArray1.length - 1;
        while (myArray1[index1] == myArray1[myArray1.length - 1]) {
            index1--;
        }
        System.out.println("The second largest value: " + myArray1[index1]);
        System.out.println();

        // 18. Нахождение второго наименьшего элемента массива
        System.out.println("Original numeric array: " + Arrays.toString(numbers2));
        Arrays.sort(numbers2);
        int index2 = numbers2[0];
        while (numbers2[index2] == numbers2[0]) {
            index2++;
        }
        System.out.println("The second lowest number is: " + numbers2[index2]);
        System.out.println();

        // 22. Нахождение пары с заданной суммой
        ArrayTrainingMethods.findPair(new int[]{2, 7, 4, -5, 11, 5, 20}, 15);
        ArrayTrainingMethods.findPair(new int[]{14, -15, 9, 16, 25, 45, 12, 8}, 30);

        // 23. Проверка, равны ли два массива
        int[] myArray8 = {2, 5, 7, 9, 11};
        int[] myArray9 = {2, 5, 7, 8, 11};
        int[] myArray10 = {2, 5, 7, 9, 11};
        ArrayTrainingMethods.checkArrays(myArray8, myArray9);
        ArrayTrainingMethods.checkArrays(myArray8, myArray10);
        System.out.println();
    }
}
