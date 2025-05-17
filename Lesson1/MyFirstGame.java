import java.util.Random;
import java.util.Scanner;

public class MyFirstGame {
    public static void main(String[] args) {
        int minValue = 1;
        int maxValue = 100;
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(minValue, maxValue + 1);
        Scanner scanner = new Scanner(System.in);
        int userNumber = 0;
        while (userNumber != randomNumber) {
            System.out.println("Угадайте целое число в отрезке [1, 100]: ");
            userNumber = scanner.nextInt();
            if (userNumber > randomNumber) {
                System.out.println(userNumber + " больше того, что загадал компьютер");
            } else {
                System.out.println(userNumber + " меньше того, что загадал компьютер");
            }
        }
        if (userNumber == randomNumber) {
            System.out.println("Вы победили!");
        }
    }
}