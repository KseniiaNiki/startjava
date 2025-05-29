public class Calculator {
    private int number1;
    private int number2;
    private char mathOperationSign;

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setMathOperationSign(char mathOperationSign) {
        this.mathOperationSign = mathOperationSign;
    }

    public void calculate() {
        double result = 1.0;
        switch (mathOperationSign) {
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
                }
                result = number1 / number2;
                break;
            case '^':
                if (number2 != 0) {
                    double baseNumber = number2 < 0 ? (1.0 / number1) : number1;
                    int absNumber2 = Math.abs(number2);
                    for (int i = 0; i < absNumber2; i++) {
                        result *= baseNumber;
                    }
                }
                break;
            case '%':
                result = number1 % number2;
                break;
            default:
                System.out.println("Ошибка: операция '" + mathOperationSign + "' не поддерживается");
                return;
        }
        System.out.println(number1 + " " + mathOperationSign + " " + number2 + " = " + result);
    }
}