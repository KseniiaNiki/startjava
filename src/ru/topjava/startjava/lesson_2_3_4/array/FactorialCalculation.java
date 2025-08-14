package ru.topjava.startjava.lesson_2_3_4.array;

public class FactorialCalculation {
    public static void main(String[] args) {
        int[] numbers = new int[] {};
        long[] factorials = getFactorial(numbers);
        showCalculation(factorials, numbers);

        numbers = null;
        factorials = getFactorial(numbers);
        showCalculation(factorials, numbers);

        numbers = new int[] {8, 0, 9};
        factorials = getFactorial(numbers);
        showCalculation(factorials, numbers);

        numbers = new int[] {-3, 1, 7, 13};
        factorials = getFactorial(numbers);
        showCalculation(factorials, numbers);

        numbers = new int[] {-22, -0};
        factorials = getFactorial(numbers);
        showCalculation(factorials, numbers);
    }

    public static long[] getFactorial(int... numbers) {
        if (numbers == null) {
            return null;
        }

        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long factorial = 1;
            if (numbers[i] < 0) {
                continue;
            }
            for (int j = 1; j <= numbers[i]; j++) {
                factorial *= j;
            }

            for (int k = 0; k < factorials.length; k++) {
                factorials[k] = factorial;
            }
        }
        return factorials;
    }

    public static void showCalculation(long[] factorials, int... numbers) {
        if (numbers == null) {
            System.out.println("Никакой информации не получено");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Получен массив нулевой длины");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            StringBuilder sb = new StringBuilder("! = 1");
            if (n > 1) {
                for (int j = 1; j < n; n++)
                    sb.append(" * ").append(j + 1);
            }
            long f = factorials[i];
            System.out.println(n < 0 ? "Ошибка: факториал " + n + "! не определен"
                    : (n == 1) || (n == 0) ? n + "! = 1"
                    : n + sb.toString() + " = " + f);
        }
    }
}
