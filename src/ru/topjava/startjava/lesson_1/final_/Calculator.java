package ru.topjava.startjava.lesson_1.final_;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = 0;
        int number2 = 0;
        System.out.println("Введите два натуральных числа: ");
        char mathOperationSign = ' ';
        int result = 1;
        String tryAgain = "Неверный ввод чисел. Попробуйте снова!";
        if (scanner.hasNextInt()) {
            number1 = scanner.nextInt();
            number2 = scanner.nextInt();
            if ((number1 >= 0) && (number2 >= 0)) {
                System.out.println("Введите знак математической операции: ");
                mathOperationSign = scanner.next().charAt(0);
                if (mathOperationSign == '+') {
                    result = number1 + number2;
                } else if (mathOperationSign == '-') {
                    result = number1 - number2;
                } else if (mathOperationSign == '*') {
                    result = number1 * number2;
                } else if (mathOperationSign == '/') {
                    if (number2 == 0) {
                        System.out.println("На ноль делить нельзя! Попробуйте снова!");
                    }
                    result = number1 / number2;
                } else if (mathOperationSign == '^') {
                    for (int i = number2; i != 0; i--) {
                        result *= number1;
                    }
                } else if (mathOperationSign == '%') {
                    result = number1 % number2;
                } else {
                    System.out.println("Неизвестный знак. Попробуйте снова!");
                    return;
                }
                System.out.println(number1 + " " + mathOperationSign + " " + number2 + " = " + result);
            } else {
                System.out.println(tryAgain);
            }
        } else {
            System.out.println(tryAgain);
        }
    }
}