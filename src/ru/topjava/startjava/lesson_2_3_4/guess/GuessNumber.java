package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final Player playerOne;
    private final Player playerTwo;
    private final int secretNumber;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.secretNumber = generateSecretNumber();
    }

    private int generateSecretNumber() {
        Random random = new Random();
        return random.nextInt(Player.MIN_VALUE, Player.MAX_VALUE + 1);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра началась! У каждого игрока по " + Player.ATTEMPTS + " попыток");
        System.out.println("Угадайте целое число в отрезке [" +
                Player.MIN_VALUE + ", " +
                Player.MAX_VALUE + "]: ");
        while (true) {
            if (makeMove(playerOne, scanner) || makeMove(playerTwo, scanner) ||
                    !hasAttemptsLeft(playerTwo)) {
                endGame();
                return;
            }
        }
    }

    private boolean makeMove(Player player, Scanner scanner) {
        printInfoAboutAttempts(player);
        inputNumber(scanner, player);

        if (isGuessedNumber(player, secretNumber)) {
            return true;
        }

        if (!hasAttemptsLeft(player)) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
        return false;
    }

    private void printInfoAboutAttempts(Player player) {
        System.out.print("Попытка №" + (player.getCurrAttempt() + 1) +
                "\nЧисло вводит " + player.getName() + ": ");
    }

    private void inputNumber(Scanner scanner, Player player) {
        int currNumber = scanner.nextInt();
        while (!player.addNumber(currNumber)) {
            System.out.print("Попробуйте еще раз: ");
            currNumber = scanner.nextInt();
        }
    }

    private boolean isGuessedNumber(Player player, int secretNumber) {
        int playerCurrNumber = player.getCurrNumber();
        if (playerCurrNumber == secretNumber) {
            System.out.println(player.getName() + " угадал число " + playerCurrNumber +
                    " с " + (player.getCurrAttempt()) + "-й попытки!");
            return true;
        }
        System.out.println("Ваше число " + ((playerCurrNumber > secretNumber)
                ? "больше того, что загадал компьютер"
                : "меньше того, что загадал компьютер"));
        return false;
    }

    public boolean hasAttemptsLeft(Player player) {
        return player.getCurrAttempt() < Player.ATTEMPTS;
    }

    private void endGame() {
        Player[] players = {playerOne, playerTwo};
        System.out.println("Игра окончена! Загаданное число: " + secretNumber);
        printAllPlayerNumbers(players);
        for (Player pl : players) {
            pl.clear();
        }
    }

    private void printAllPlayerNumbers(Player[] players) {
        StringBuilder sb = new StringBuilder();
        for (Player pl : players) {
            int[] numbers = pl.getEnteredNumbers();
            sb.append("Числа игрока ").append(pl.getName()).append(": ");
            for (int n : numbers) {
                sb.append(n);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
