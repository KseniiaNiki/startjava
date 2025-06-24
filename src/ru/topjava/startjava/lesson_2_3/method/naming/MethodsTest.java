package ru.topjava.startjava.lesson_2_3.method.naming;

public class MethodsTest {
    public static void main(String[] args) {
        doBooleanMethods();
        doNonBooleanMethods();
    }

    public static void doBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println("Вызов boolean-методов:");
        System.out.println(bm.shouldStopProgram());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasAttempts());
        System.out.println(bm.isEmpty());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidPath());
        System.out.println(bm.isExistFile() + "\n");
    }

    public static void doNonBooleanMethods() {
        NonBooleanMethods nonBm = new NonBooleanMethods();
        System.out.println("Вызов не boolean-методов:");
        nonBm.findLongestWord();
        nonBm.chooseMenuItem();
        nonBm.calcAverageGrades();
        nonBm.countUniqueWords();
        nonBm.displayErrorMessage();
        nonBm.synchronizeData();
        nonBm.recoverData();
        nonBm.pauseDownload();
        nonBm.resetSettings();
        nonBm.writeToFile();
        nonBm.convertTemperature();
        nonBm.enterMathExpression();
        nonBm.identifyWinner();
        nonBm.findBookByWriterName();
    }
}