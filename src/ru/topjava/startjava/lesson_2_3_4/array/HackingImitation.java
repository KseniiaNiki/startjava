package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Random;

public class HackingImitation {
    private static final String RESET = "\033[0m";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";

    public static void main(String[] args) throws InterruptedException {
        int hackingResult = hack();
        giveAccess(hackingResult);
    }

    private static int hack() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        int length = spins.length;
        for (int i = 0; i < length * 3; i++) {
            System.out.print("Hacking: " + spins[i % length] + "\r");
            Thread.sleep(250);
        }

        int min = 0;
        int max = 100;
        Random random = new Random();
        return random.nextInt(min, max);
    }

    private static void giveAccess(int randomNumber) {
        System.out.print("Hacking: " +
                ((randomNumber > 70) ? (GREEN + "Access Granted!") : (RED + "Access Denied!")) +
                RESET + "\r");
    }
}
