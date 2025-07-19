package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Random;

public class LoadingAnimation {
    public static void animate() throws InterruptedException {
        char[] symbols = {'-', '\\', '|', '/'};
        for (int i = 0; i < 3; i++) {
            for (char s : symbols) {
                System.out.print("Hacking: " + s + "\r");
                Thread.sleep(250);
            }
        }
    }

    public class ConsoleColors {
        public static final String RESET = "\033[0m";
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
    }

    public static void showResult() {
        int min = 0;
        int max = 100;
        Random random = new Random();
        int randomNumber = random.nextInt(min, max);
        if (randomNumber > 70) {
            System.out.print("Hacking: " + ConsoleColors.GREEN + "Access Granted!" + ConsoleColors.RESET + "\r");
        } else {
            System.out.print("Hacking: " + ConsoleColors.RED + "Access Denied!" + ConsoleColors.RESET + "\r");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        animate();
        showResult();
    }
}
