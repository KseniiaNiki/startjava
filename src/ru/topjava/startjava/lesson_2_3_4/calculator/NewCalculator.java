package ru.topjava.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;

public class NewCalculator {
    private int number1;
    private int number2;
    private char mathOperation;

    public double calculate(String mathExpression) {
        String[] partsOfMathExpression = mathExpression.split(" ");
        number1 = Integer.parseInt(partsOfMathExpression[0]);
        number2 = Integer.parseInt(partsOfMathExpression[2]);
        mathOperation = partsOfMathExpression[1].charAt(0);
        double result;
        switch (mathOperation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    result = Double.NaN;
                }
                result = (double) number1 / number2;
                break;
            case '^':
                result = Math.pow(number1, number2);
                break;
            case '%':
                if (number2 == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    result = Double.NaN;
                }
                result = Math.floorMod(number1, number2);
                break;
            default:
                System.out.println("Ошибка: операция '" + mathOperation + "' не поддерживается");
                return Double.NaN;
        }
        return result;
    }

    public void printCalculationResult(double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            return;
        }

        if (result % 1 == 0) {
            System.out.println(number1 + " " + mathOperation + " " + number2 + " = " + (long) result);
        } else {
            String pattern = "###.###";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            String strFormattedNum = decimalFormat.format(result);
            System.out.println(number1 + " " + mathOperation + " " + number2 + " = " + strFormattedNum);
        }
    }
}
