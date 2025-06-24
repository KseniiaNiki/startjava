package ru.topjava.startjava.lesson_2_3.robot;

public class Jaeger {
    private String modelName;
    private String mark;
    private String origin;
    private String bodyLanguage;
    private double height;
    private double weight;
    private int speed;
    private int strength;
    private int armor;

    public Jaeger() {
    }

    public Jaeger(String modelName, String mark, String origin, double height, double weight, 
            int speed, int strength, int armor, String bodyLanguage) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
        this.bodyLanguage = bodyLanguage;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setBodyLanguage(String bodyLanguage) {
        this.bodyLanguage = bodyLanguage;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void drift() {
        System.out.println("Нейронная синхронизация");
    }

    public void move() {
        System.out.println("Перемещается");
    }

    public String scanKaiju() {
        return "Сканирование наличия Кайдзю";
    }

    public void usePlasmacaster() {
        System.out.println("Plasmacaster активирован");
    }

    @Override
    public String toString() {
        return "Робот " + modelName + " имеет следующие характеристики: " + "\n" + 
                "марка - " + mark + ", происхождение - " + origin + 
                ", высота - " + height + " метра(ов), вес - " + weight + 
                ", бронь - " + armor + ", язык тела - " + bodyLanguage;
    }
}