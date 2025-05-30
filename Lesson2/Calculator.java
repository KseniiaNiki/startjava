public class Calculator {
    private int number1;
    private int number2;
    private char mathOperation;

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setMathOperation(char mathOperation) {
        this.mathOperation = mathOperation;
    }

    public void calculate() {
        double result = 1.0;
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
                    return;
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
                if (number2 == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return;
                }
                result = number1 % number2;
                break;
            default:
                System.out.println("Ошибка: операция '" + mathOperation + "' не поддерживается");
                return;
        }
        System.out.println(number1 + " " + mathOperation + " " + number2 + " = " + result);
    }
}