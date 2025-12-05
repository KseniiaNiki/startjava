package ru.topjava.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class NewCalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewCalculator newCalculatorOne = new NewCalculator();
        String answer = "yes";
        while (answer.equals("yes")) {
            System.out.print("Введите выражение из трех аргументов, например, 2 * 5: ");
            String mathExpression = scanner.nextLine();
            double result = newCalculatorOne.calculate(mathExpression);
            newCalculatorOne.printCalculationResult(result);
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!answer.equals("no") && !answer.equals("yes"));
        }
    }
}
