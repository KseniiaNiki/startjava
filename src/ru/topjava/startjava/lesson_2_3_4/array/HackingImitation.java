package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Random;

public class HackingImitation {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";

    public static void main(String[] args) throws InterruptedException {
        animate();
        giveAccess();
    }

    public static void animate() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        for (int i = 0, count = 0; count < 12; i++, count++) {
            if (i == spins.length) {
                i = 0;
            }
            System.out.print("Hacking: " + spins[i] + "\r");
            Thread.sleep(250);
        }
    }

    public static void giveAccess() {
        int min = 0;
        int max = 100;
        Random random = new Random();
        int randomNumber = random.nextInt(min, max);
        System.out.print("Hacking: " + (randomNumber > 70
                ? GREEN + "Access Granted!" + RESET + "\r"
                : RED + "Access Denied!" + RESET + "\r"));
    }
}
