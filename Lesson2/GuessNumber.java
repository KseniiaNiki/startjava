import java.util.Scanner;

public class GuessNumber {
    private int minValue = 1;
    private int maxValue = 100;
    private Player playerOne;
    private Player playerTwo;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        System.out.println("Угадайте целое число в отрезке [" + minValue + ", " + maxValue + "]: ");
        while (true) {
            System.out.print("Ход игрока " + playerOne.getName() + ": ");
            playerOne.setNumber(scanner.nextInt());
            if (playerOne.getNumber() == randomNumber) {
                System.out.println("Победил игрок " + playerOne.getName() + "!");
                break;
            }
            if (playerOne.getNumber() != randomNumber) {
                System.out.println("Ваше число " + ((playerOne.getNumber() > randomNumber)
                        ? "больше того, что загадал компьютер"
                        : "меньше того, что загадал компьютер"));
                System.out.println("Передача хода другому игроку");
            }
            System.out.print("Ход игрока " + playerTwo.getName() + ": ");
            playerTwo.setNumber(scanner.nextInt());
            if (playerTwo.getNumber() == randomNumber) {
                System.out.println("Победил игрок " + playerTwo.getName() + "!");
                break;
            }
            if (playerTwo.getNumber() != randomNumber) {
                System.out.println("Ваше число " + ((playerTwo.getNumber() > randomNumber)
                        ? "больше того, что загадал компьютер"
                        : "меньше того, что загадал компьютер"));
                System.out.println("Передача хода другому игроку");
            }
        }
    }
}