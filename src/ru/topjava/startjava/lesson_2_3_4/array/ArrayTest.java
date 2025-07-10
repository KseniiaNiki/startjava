package ru.topjava.startjava.lesson_2_3_4.array;

public class ArrayTest {
    public static void main(String[] args) {
        int[] numbers = new int[4];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 10;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println();

        int[] numbers1 = {2, 4, 6, 8};
        int sum = 0;
        for (int n : numbers1) {
            sum += n;
        }
        System.out.println(sum);
        for (int i = 0; i < numbers1.length; i++) {
            System.out.println(numbers1[i]);
        }
        String[] strings = new String[3];
        strings[0] = "My";
        strings[1] = "name";
        strings[2] = "is";
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
