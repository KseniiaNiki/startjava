package ru.topjava.startjava.lesson_2_3.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setSex("мужской");
        wolfOne.setNickname("Альфа");
        wolfOne.setWeight(70);
        wolfOne.setAge(3);
        wolfOne.setColor("серый");
        System.out.println("Первого волка зовут " + wolfOne.getNickname());
        System.out.println("Его характеристики: " + wolfOne.getSex() + " пол, " + 
                wolfOne.getWeight() + " кг, " + wolfOne.getAge() + " года, " + 
                wolfOne.getColor() + " цвет");
        wolfOne.walk();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}