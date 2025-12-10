package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    protected static final int MIN_VALUE = 1;
    protected static final int MAX_VALUE = 100;
    protected static final int ATTEMPTS = 10;

    private final String name;
    private int number;
    private final int[] numbers = new int[ATTEMPTS];
    private int attemptCount = 1;
    private int currAttempt = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public void setNumber(Scanner scanner) {
        int currNumber = 0;
        boolean isValid = false;
        while (!isValid) {
            currNumber = scanner.nextInt();
            if ((currNumber < MIN_VALUE) || (currNumber > MAX_VALUE)) {
                System.out.println("Число должно входить в отрезок [" + MIN_VALUE + ", " + MAX_VALUE + "].");
                System.out.print("Попробуйте еще раз: ");
            } else {
                isValid = true;
            }
        }
        this.number = currNumber;
    }

    public void addAttempt(int number) {
        if (currAttempt < ATTEMPTS) {
            numbers[currAttempt++] = number;
            attemptCount++;
        }
    }

    public int[] getAttempts() {
        return Arrays.copyOf(numbers, currAttempt);
    }

    public void clearAttempts() {
        attemptCount = 1;
        currAttempt = 0;
        Arrays.fill(numbers, 0);
    }

    public boolean hasAttemptsLeft() {
        return currAttempt < ATTEMPTS;
    }
}
