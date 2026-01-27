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
        this.secretNumber = generateRandomNumber(Player.MAX_VALUE, Player.MIN_VALUE);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра началась! У каждого игрока по " + Player.ATTEMPTS + " попыток");
        System.out.println("Угадайте целое число в отрезке [" + Player.MIN_VALUE + ", "
                + Player.MAX_VALUE + "]: ");
        while (!isGameOver) {
            if (playerOne.hasAttemptsLeft() || playerTwo.hasAttemptsLeft()) {
                makeMove(playerOne, scanner, secretNumber);
                if (playerOne.getAttempts()[playerOne.getAttempts().length - 1] == secretNumber) {
                    endGame(secretNumber, playerOne, playerTwo);
                    return;
                }
                makeMove(playerTwo, scanner, secretNumber);
                if (playerTwo.getAttempts()[playerTwo.getAttempts().length - 1] == secretNumber) {
                    endGame(secretNumber, playerOne, playerTwo);
                    return;
                }
            } else {
                endGame(secretNumber, playerOne, playerTwo);
                return;
            }
        }
    }

    private void makeMove(Player player, Scanner scanner, int secretNumber) {
        System.out.print("Попытка №" + (player.getCurrAttempt() + 1) +
                "\nЧисло вводит " + player.getName() + ": ");
        int currNumber = inputAttempt(scanner, player);
        player.addAttempt(currNumber);
        if (player.getCurrentNumber() == secretNumber) {
            System.out.println(player.getName() + " угадал число " + player.getCurrentNumber() +
                    " с " + (player.getCurrAttempt()) + "-й попытки!");
        } else {
            System.out.println("Ваше число " + ((player.getCurrentNumber() > secretNumber)
                    ? "больше того, что загадал компьютер"
                    : "меньше того, что загадал компьютер"));
        }
        if (!player.hasAttemptsLeft()) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
    }

    private int inputAttempt(Scanner scanner, Player player) {
        int currNumber = scanner.nextInt();
        while (!player.isValidNumber(currNumber)) {
            System.out.print("Попробуйте еще раз: ");
            currNumber = scanner.nextInt();
        }
        return currNumber;
    }

    private static int generateRandomNumber(int maxValue, int minValue) {
        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

    private void endGame(int secretNumber, Player playerOne, Player playerTwo) {
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
            int[] attempts = pl.getAttempts();
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
