package ru.topjava.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class NewCalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";

        do {
            if ("yes".equals(answer)) {
                NewCalculator newCalculatorOne = new NewCalculator();
                System.out.print("Введите выражение из трех аргументов, например, 2 * 5: ");
                String mathExpression = scanner.nextLine();
                double result = newCalculatorOne.calculate(mathExpression);
                newCalculatorOne.printCalculationResult(result);
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            answer = scanner.nextLine().toLowerCase();
        } while (!"no".equals(answer));
    }
}
