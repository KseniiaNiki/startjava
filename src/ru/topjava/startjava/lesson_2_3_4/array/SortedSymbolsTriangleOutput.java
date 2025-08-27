package ru.topjava.startjava.lesson_2_3_4.array;

public class SortedSymbolsTriangleOutput {
    public static void main(String[] args) {
        char start = '0';
        char end = '9';
        int digitStart = start;
        int digitEnd = end;
        boolean directionMarker = true;
        String triangle = makeTriangle(digitStart, digitEnd, directionMarker);
        printTriangle(triangle);

        start = '/';
        end = '!';
        digitStart = start;
        digitEnd = end;
        directionMarker = false;
        triangle = makeTriangle(digitStart, digitEnd, directionMarker);
        printTriangle(triangle);

        start = 'A';
        end = 'J';
        digitStart = start;
        digitEnd = end;
        triangle = makeTriangle(digitStart, digitEnd, directionMarker);
        printTriangle(triangle);
    }

    private static String makeTriangle(int digitStart, int digitEnd, boolean directionMarker) {
        int rows = Math.abs(digitStart - digitEnd) + 1;
        char[] newArray = new char[rows];
        int c = 0;
        for (char ch = (char) digitStart; ch <= (char) digitEnd; ch++) {
            newArray[c++] = ch;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            sb.repeat(" ", rows - i);
            if (!directionMarker) {
                sb.repeat(newArray[rows - i], i * 2 - 1);
            } else {
                sb.repeat(newArray[i - 1], i * 2 - 1);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void printTriangle(String sb) {
        System.out.println(sb);
    }
}
