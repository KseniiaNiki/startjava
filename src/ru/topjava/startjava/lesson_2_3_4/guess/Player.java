package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    protected static final int MIN_VALUE = 1;
    protected static final int MAX_VALUE = 100;
    protected static final int ATTEMPTS = 10;

    private final String name;
    private final int[] numbers = new int[ATTEMPTS];
    private int currAttempt = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public boolean isValidNumber(int number) {
        if ((number < MIN_VALUE) || (number > MAX_VALUE)) {
            System.out.println("Число должно входить в отрезок [" + MIN_VALUE + ", " + MAX_VALUE + "].");
            System.out.print("Попробуйте еще раз: ");
            return false;
        } else {
            return true;
        }
    }

    public int getCurrentNumber() {
        return numbers[currAttempt - 1];
    }

    public boolean hasAttemptsLeft() {
        return currAttempt < ATTEMPTS;
    }

    public void addAttempt(int number) {
        if (currAttempt < ATTEMPTS) {
            numbers[currAttempt++] = number;
        }
    }

    public int[] getAttempts() {
        return Arrays.copyOf(numbers, currAttempt);
    }

    public void clear() {
        currAttempt = 0;
        Arrays.fill(getAttempts(), 0);
    }
}
