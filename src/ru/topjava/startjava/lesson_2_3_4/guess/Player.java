package ru.topjava.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    protected static final int MIN_VALUE = 1;
    protected static final int MAX_VALUE = 100;
    protected static final int ATTEMPTS = 10;

    private final String name;
    private final int[] numbers;
    private int currAttempt = 0;

    public Player(String name) {
        this.name = name;
        this.numbers = new int[ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public int getCurrNumber() {
        return numbers[currAttempt - 1];
    }

    public boolean addNumber(int number) {
        if (isValidNumber(number)) {
            numbers[currAttempt++] = number;
            return true;
        }
        return false;
    }

    private boolean isValidNumber(int number) {
        if ((number < MIN_VALUE) || (number > MAX_VALUE)) {
            System.out.printf("""
                    Число должно входить в отрезок [%d, %d].
                    """, MIN_VALUE, MAX_VALUE);
            return false;
        }
        return true;
    }

    public void clear() {
        Arrays.fill(numbers, 0, currAttempt, 0);
        currAttempt = 0;
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(numbers, currAttempt);
    }
}
