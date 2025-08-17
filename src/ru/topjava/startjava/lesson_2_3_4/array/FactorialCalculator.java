package ru.topjava.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[] numbers = new int[] {};
        long[] factorials = calculate(numbers);
        showCalculation(factorials, numbers);

        numbers = null;
        factorials = calculate(numbers);
        showCalculation(factorials, numbers);

        numbers = new int[] {8, 0, 9};
        factorials = calculate(numbers);
        showCalculation(factorials, numbers);

        numbers = new int[] {-3, 1, 7, 13};
        factorials = calculate(numbers);
        showCalculation(factorials, numbers);

        numbers = new int[] {-22, -0};
        factorials = calculate(numbers);
        showCalculation(factorials, numbers);
    }

    private static long[] calculate(int... numbers) {
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

    private static void showCalculation(long[] factorials, int... numbers) {
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
}
