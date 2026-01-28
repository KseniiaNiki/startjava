package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private final Player playerOne;
    private final Player playerTwo;

    private final int secretNumber;

    boolean isGameOver = false;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.secretNumber = generateSecretNumber();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра началась! У каждого игрока по " + Player.ATTEMPTS + " попыток");
        System.out.println("Угадайте целое число в отрезке [" + Player.MIN_VALUE + ", " +
                Player.MAX_VALUE + "]: ");
        while (!isGameOver) {
            if (makeMove(playerOne, scanner) || makeMove(playerTwo, scanner) ||
                    !playerTwo.hasAttemptsLeft()) {
                endGame();
                return;
            }
        }
    }

    private boolean makeMove(Player player, Scanner scanner) {
        if (!player.hasAttemptsLeft()) {
            return false;
        }

        printInfoAboutAttempts(player);
        int currNumber = inputAttempt(scanner, player);
        player.addNumber(currNumber);

        if (player.getCurrentNumber() == secretNumber) {
            printInfoGuessNumber(player);
            return true;
        }
        printInfoAboutNumber(player, secretNumber);

        if (!player.hasAttemptsLeft()) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
        return false;
    }

    private static void printInfoAboutAttempts(Player player) {
        System.out.print("Попытка №" + (player.getCurrAttempt() + 1) +
                "\nЧисло вводит " + player.getName() + ": ");
    }

    private static void printInfoGuessNumber(Player player) {
        System.out.println(player.getName() + " угадал число " + player.getCurrentNumber() +
                " с " + (player.getCurrAttempt()) + "-й попытки!");
    }

    private static void printInfoAboutNumber(Player player, int secretNumber) {
        System.out.println("Ваше число " + ((player.getCurrentNumber() > secretNumber)
                ? "больше того, что загадал компьютер"
                : "меньше того, что загадал компьютер"));
    }

    private int inputAttempt(Scanner scanner, Player player) {
        int currNumber = scanner.nextInt();
        while (!player.isValidNumber(currNumber)) {
            System.out.print("Попробуйте еще раз: ");
            currNumber = scanner.nextInt();
        }
        return currNumber;
    }

    private static int generateSecretNumber() {
        return (int) (Math.random() * (Player.MAX_VALUE - Player.MIN_VALUE + 1)) + Player.MIN_VALUE;
    }

    private void endGame() {
        Player[] players = {playerOne, playerTwo};
        System.out.println("Игра окончена! Загаданное число: " + secretNumber);
        printAllAttempts(players);
        for (Player pl : players) {
            pl.clear();
        }
        isGameOver = true;
    }

    private void printAllAttempts(Player[] players) {
        StringBuilder sb = new StringBuilder();
        for (Player pl : players) {
            int[] attempts = pl.getInputNumbers();
            sb.append("Числа игрока ").append(pl.getName()).append(": ");
            for (int i = 0; i < attempts.length; i++) {
                sb.append(attempts[i]);
                if (i < attempts.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
