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
        System.out.printf("""
                Угадайте целое число в отрезке [%d, %d]:
                """, Player.MIN_VALUE, Player.MAX_VALUE);
        while (true) {
            if (isGameFinished(scanner)) {
                endGame();
                return;
            }
        }
    }

    private boolean isGameFinished(Scanner scanner) {
        return makeMove(playerOne, scanner) || makeMove(playerTwo, scanner) ||
                !hasAttemptsLeft(playerTwo);
    }

    private boolean makeMove(Player player, Scanner scanner) {
        printInfoAboutAttempts(player);
        inputNumber(scanner, player);

        if (isGuessedNumber(player)) {
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

    private boolean isGuessedNumber(Player player) {
        int playerCurrNumber = player.getCurrNumber();
        if (playerCurrNumber == secretNumber) {
            System.out.printf("""
                    %s угадал число %d с %d-й попытки!
                    """, player.getName(), playerCurrNumber, player.getCurrAttempt());
            return true;
        }
        System.out.println("Ваше число " + ((playerCurrNumber > secretNumber)
                ? "больше того, что загадал компьютер"
                : "меньше того, что загадал компьютер"));
        return false;
    }

    private boolean hasAttemptsLeft(Player player) {
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
