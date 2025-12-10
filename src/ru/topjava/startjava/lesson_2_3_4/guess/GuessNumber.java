package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private final Player playerOne;
    private final Player playerTwo;
    boolean isGameOver = false;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        int minValue = Player.MIN_VALUE;
        int maxValue = Player.MAX_VALUE;
        int attempts = Player.ATTEMPTS;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра началась! У каждого игрока по " + attempts + " попыток");
        int randomNumber = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        System.out.println("Угадайте целое число в отрезке [" + minValue + ", " + maxValue + "]: ");
        while (!isGameOver) {
            Player[] players = new Player[] {playerOne, playerTwo};
            if (playerOne.hasAttemptsLeft()) {
                makeMove(playerOne, scanner, randomNumber);
                if (playerOne.getAttempts()[playerOne.getAttempts().length - 1] == randomNumber) {
                    endGame(randomNumber, players);
                    return;
                }
            }
            if (playerTwo.hasAttemptsLeft()) {
                makeMove(playerTwo, scanner, randomNumber);
                if (!playerTwo.hasAttemptsLeft() ||
                        playerTwo.getAttempts()[playerTwo.getAttempts().length - 1] == randomNumber) {
                    endGame(randomNumber, players);
                    return;
                }
            }
        }
    }

    private void makeMove(Player player, Scanner scanner, int randomNumber) {
        System.out.print("Попытка №" + player.getAttemptCount() +
                "\nЧисло вводит " + player.getName() + ": ");
        player.setNumber(scanner);
        if (player.getNumber() == randomNumber) {
            player.addAttempt(player.getNumber());
            System.out.println(player.getName() + " угадал число " + player.getNumber() +
                    " с " + (player.getCurrAttempt()) + "-й попытки!");
            return;
        } else {
            System.out.println("Ваше число " + ((player.getNumber() > randomNumber)
                    ? "больше того, что загадал компьютер"
                    : "меньше того, что загадал компьютер"));
        }
        player.addAttempt(player.getNumber());
        if (!player.hasAttemptsLeft()) {
            System.out.println("У " + player.getName() + " закончились попытки!");
        }
    }

    private void endGame(int randomNumber, Player[] players) {
        System.out.println("Игра окончена! Загаданное число: " + randomNumber);
        printAllAttempts(players);
        for (Player pl : players) {
            pl.clearAttempts();
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
