import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.print("Введите имя первого игрока: ");
        Player playerOne = new Player(scanner.nextLine());
        System.out.print("Введите имя второго игрока: ");
        Player playerTwo = new Player(scanner.nextLine());

        GuessNumber game = new GuessNumber(playerOne, playerTwo);
        String answer = "yes";
        while (answer.equals("yes")) {
            game.start();
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                answer = scanner.nextLine();
            } while (!answer.equals("no") && !answer.equals("yes"));
        }
    }
}