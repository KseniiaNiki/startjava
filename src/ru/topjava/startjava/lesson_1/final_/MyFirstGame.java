package ru.topjava.startjava.lesson_1.final_;

import java.util.Random;
import java.util.Scanner;

public class MyFirstGame {
    public static void main(String[] args) {
        int minValue = 1;
        int maxValue = 100;
        Random random = new Random();
        int randomNumber = random.nextInt(minValue, maxValue + 1);
        Scanner scanner = new Scanner(System.in);
        int playerNumber = 0;
        while (playerNumber != randomNumber) {
            System.out.println("Угадайте целое число в отрезке [" + minValue + ", " + maxValue + "]: ");
            playerNumber = scanner.nextInt();
            if (playerNumber > randomNumber) {
                System.out.println(playerNumber + " больше того, что загадал компьютер");
            } else if (playerNumber < randomNumber) {
                System.out.println(playerNumber + " меньше того, что загадал компьютер");
            }
        }
        System.out.println("Вы победили!");
    }
}