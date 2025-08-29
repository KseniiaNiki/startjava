package ru.topjava.startjava.lesson_2_3_4.array;

public class SortedSymbolsTriangleOutput {
    public static void main(String[] args) {
        char start = '0';
        char end = '9';
        boolean isAscending = true;
        String triangle = makeTriangle(start, end, isAscending);
        printTriangle(triangle);

        start = '/';
        end = '!';
        isAscending = false;
        triangle = makeTriangle(start, end, isAscending);
        printTriangle(triangle);

        start = 'A';
        end = 'J';
        triangle = makeTriangle(start, end, isAscending);
        printTriangle(triangle);
    }

    private static String makeTriangle(char start, char end, boolean isAscending) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + (int) start + ") > правой (" + (int) end + ")\n");
            return null;
        }

        int rows = Math.abs((int) start - end) + 1;
        char[] symbols = new char[rows];
        int index = 0;
        if (isAscending) {
            for (char i = start; i <= end; i++) {
                symbols[index++] = i;
            }
        } else {
            for (char i = end; i >= start; i--) {
                symbols[index++] = i;
            }
        }

        StringBuilder triangle = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            triangle.repeat(" ", rows - i);
            triangle.repeat(symbols[i - 1], i * 2 - 1);
            triangle.append("\n");
        }
        return triangle.toString();
    }

    private static void printTriangle(String triangle) {
        if (triangle == null) {
            return;
        }
        System.out.println(triangle);
    }
}
