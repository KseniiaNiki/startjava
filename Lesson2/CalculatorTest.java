import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculatorOne = new Calculator();
        String answer = "yes";
        while (answer.equals("yes")) {
            System.out.print("Введите первое число: ");
            calculatorOne.setNumber1(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Введите знак математической операции (+, -, *, /, ^, %): ");
            calculatorOne.setMathOperation(scanner.nextLine().charAt(0));
            System.out.print("Введите второе число: ");
            calculatorOne.setNumber2(scanner.nextInt());
            scanner.nextLine();
            calculatorOne.calculate();
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!answer.equals("no") && !answer.equals("yes"));
        }
    }
}