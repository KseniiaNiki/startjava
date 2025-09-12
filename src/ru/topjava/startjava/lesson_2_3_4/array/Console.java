package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private static final String RESET = "\033[0m";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";

    public static void showTransactions(int[] transactions, int[] reversed) {
        if (transactions == null) {
            System.out.println("Ошибка в получении данных(никакой информации не получено)");
            return;
        }
        if (transactions.length == 0) {
            System.out.println("Нет данных по транзакциям(ни одна операция не была выполнена)");
            return;
        }
        System.out.println("Исходные транзакции: " + java.util.Arrays.toString(transactions));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
    }

    public static void giveAccess(int randomNumber) throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        int length = spins.length;
        for (int i = 0; i < length * 3; i++) {
            System.out.print("Hacking: " + spins[i % length] + "\r");
            Thread.sleep(250);
        }

//        int randomNumber = Arrays.generateRandomNumber();
        System.out.print("Hacking: " +
                ((randomNumber > 70) ? (GREEN + "Access Granted!") : (RED + "Access Denied!")) +
                RESET + "\r");
    }

    public static void showCalculation(long[] factorials, int... numbers) {
        if (numbers == null) {
            System.out.println("Ошибка в данных");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Массив нулевой длины");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            long f = factorials[i];
            if (n > 1) {
                sb.append(n).append("! = 1");
                for (int j = 1; j < n; j++) {
                    sb.append(" * ").append(j + 1);
                }
                sb.append(" = ").append(f);
            }

            System.out.println(n < 0 ? "Ошибка: факториал " + n + "! не определен"
                    : (n == 1) || (n == 0) ? n + "! = 1"
                    : sb.toString());
            sb.setLength(0);
        }
    }

    public static void showResultOfRemoval(int index, float[][] arrays) {
        if (index < Arrays.MIN || index > Arrays.MAX) {
            System.out.println(index + " - ошибочный индекс! Допустимые значения: от " +
                    Arrays.MIN + " до " + Arrays.MAX);
            return;
        }

        if (arrays[1][] == null) return;

        System.out.println("Исходный массив:");
        int count = 0;
        for (float o : arrays[0][]) {
            System.out.printf("%.3f%s", o, " ");
            count++;
            if (count == 8) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.println("Изменённый массив:");
        int count2 = 0;
        for (float m : arrays[1][]) {
            System.out.printf("%.3f%s", m, " ");
            count2++;
            if (count2 == 8) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.printf("%s%.3f\n", "Значение из ячейки: ", originalArray[index]);
    }
}
