package ru.topjava.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String answer = "yes";

        do {
            if ("yes".equals(answer)) {
                System.out.print("Введите выражение из трех аргументов, например, 2 * 5: ");
                String mathExpression = scanner.nextLine();
                double result = calculator.calculate(mathExpression);
                printCalculationResult(mathExpression, result);
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            answer = scanner.nextLine().toLowerCase();
        } while (!"no".equals(answer));
    }

    private static void printCalculationResult(String mathExpression, double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            return;
        }

        DecimalFormat df = new DecimalFormat("###.###");
        String formattedResult = df.format(result);
        System.out.println(mathExpression + " = " + formattedResult);
    }
}
