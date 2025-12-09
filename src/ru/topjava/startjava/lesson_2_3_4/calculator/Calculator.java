package ru.topjava.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private int number1;
    private int number2;
    private char mathOperation;

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public char getMathOperation() {
        return mathOperation;
    }

    public double calculate(String mathExpression) {
        String[] parts = mathExpression.split(" ");
        number1 = Integer.parseInt(parts[0]);
        number2 = Integer.parseInt(parts[2]);
        mathOperation = parts[1].charAt(0);
        switch (mathOperation) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                if (isDoubleNan(number2)) {
                    return Double.NaN;
                }
                return (double) number1 / number2;
            case '^':
                return Math.pow(number1, number2);
            case '%':
                if (isDoubleNan(number2)) {
                    return Double.NaN;
                }
                return Math.floorMod(number1, number2);
            default:
                System.out.println("Ошибка: операция '" + mathOperation + "' не поддерживается");
                return Double.NaN;
        }
    }

    private boolean isDoubleNan(int number) {
        if (number == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            return true;
        }
        return false;
    }
}
