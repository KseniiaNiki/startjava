package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private final Player playerOne;
    private final Player playerTwo;

    private final int minValue = Player.MIN_VALUE;
    private final int maxValue = Player.MAX_VALUE;
    private final int attempts = Player.ATTEMPTS;
    private final int randomNumber = getRandomNumber(maxValue, minValue);

    boolean isGameOver = false;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра началась! У каждого игрока по " + attempts + " попыток");
        System.out.println("Угадайте целое число в отрезке [" + minValue + ", " + maxValue + "]: ");
        while (!isGameOver) {
            if (playerOne.hasAttemptsLeft() || playerTwo.hasAttemptsLeft()) {
                makeMove(playerOne, scanner, randomNumber);
                if (playerOne.getAttempts()[playerOne.getAttempts().length - 1] == randomNumber) {
                    endGame(randomNumber, playerOne, playerTwo);
                    return;
                }
                makeMove(playerTwo, scanner, randomNumber);
                if (playerTwo.getAttempts()[playerTwo.getAttempts().length - 1] == randomNumber) {
                    endGame(randomNumber, playerOne, playerTwo);
                    return;
                }
            } else {
                endGame(randomNumber, playerOne, playerTwo);
                return;
            }
        }
    }

    private void makeMove(Player player, Scanner scanner, int randomNumber) {
        System.out.print("Попытка №" + (player.getCurrAttempt() + 1) +
                "\nЧисло вводит " + player.getName() + ": ");
        getValidNumber(scanner, player);
        if (player.getCurrentNumber() == randomNumber) {
            System.out.println(player.getName() + " угадал число " + player.getCurrentNumber() +
                    " с " + (player.getCurrAttempt()) + "-й попытки!");
        } else {
            System.out.println("Ваше число " + ((player.getCurrentNumber() > randomNumber)
                    ? "больше того, что загадал компьютер"
                    : "меньше того, что загадал компьютер"));
        }
        if (!player.hasAttemptsLeft()) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
    }

    private void getValidNumber(Scanner scanner, Player player) {
        int currNumber;
        boolean isValid = false;
        while (!isValid) {
            currNumber = scanner.nextInt();
            isValid = player.addNumber(currNumber);
        }
    }

    private static int getRandomNumber(int maxValue, int minValue) {
        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
    }

    private void endGame(int randomNumber, Player playerOne, Player playerTwo) {
        Player[] players = {playerOne, playerTwo};
        System.out.println("Игра окончена! Загаданное число: " + randomNumber);
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
