package ru.topjava.startjava.lesson_2_3.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger crimsonTyphoon = new Jaeger();
        crimsonTyphoon.setModelName("Crimson Typhoon");
        crimsonTyphoon.setMark("Mark-4");
        crimsonTyphoon.setOrigin("Китай");
        crimsonTyphoon.setHeight(76.2);
        crimsonTyphoon.setWeight(1722);
        crimsonTyphoon.setSpeed(9);
        crimsonTyphoon.setStrength(8);
        crimsonTyphoon.setArmor(6);
        crimsonTyphoon.setBodyLanguage("Muay Thai triplet");
        System.out.println(crimsonTyphoon);
        crimsonTyphoon.drift();
        crimsonTyphoon.move();
        System.out.println(crimsonTyphoon.scanKaiju());
        crimsonTyphoon.usePlasmacaster();

        Jaeger gipsyDanger = new Jaeger("Gipsy Danger", "Mark-3", "США", 
                79.25, 1980, 7, 8, 6, "Street Fighter");
        System.out.println(gipsyDanger);
        gipsyDanger.drift();
        gipsyDanger.move();
        System.out.println(gipsyDanger.scanKaiju());
        gipsyDanger.usePlasmacaster();
    }
}