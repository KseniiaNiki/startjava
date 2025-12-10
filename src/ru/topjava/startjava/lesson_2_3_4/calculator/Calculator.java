package ru.topjava.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public double calculate(String mathExpression) {
        String[] parts = mathExpression.split(" ");
        int number1 = Integer.parseInt(parts[0]);
        int number2 = Integer.parseInt(parts[2]);
        char mathOperation = parts[1].charAt(0);
        switch (mathOperation) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                if (isZero(number2)) {
                    return Double.NaN;
                }
                return (double) number1 / number2;
            case '^':
                return Math.pow(number1, number2);
            case '%':
                if (isZero(number2)) {
                    return Double.NaN;
                }
                return Math.floorMod(number1, number2);
            default:
                System.out.println("Ошибка: операция '" + mathOperation + "' не поддерживается");
                return Double.NaN;
        }
    }

    private boolean isZero(int number) {
        if (number == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return true;
        }
        return false;
    }
}
