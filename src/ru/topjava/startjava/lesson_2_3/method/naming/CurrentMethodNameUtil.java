package ru.topjava.startjava.lesson_2_3.method.naming;

public class CurrentMethodNameUtil {
    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}