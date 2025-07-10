package ru.topjava.startjava.lesson_2_3_4.person;

public class Person {
    String sex = "Female";
    String name = "Anna";
    int height = 167;
    int weight = 56;
    int age = 27;

    void walk() {
        System.out.println("Хожу");
    }

    void sit() {
        System.out.println("Сижу");
    }

    void run() {
        System.out.println("Бегу");
    }

    void speak() {
        System.out.println("Говорю");
    }

    void learnJava() {
        System.out.println("Учу Java");
    }
}