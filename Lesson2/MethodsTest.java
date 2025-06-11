public class MethodsTest {
    public static void main(String[] args) {
        invokeBooleanMethods();
        invokeNotBooleanMethods();
        System.out.println("\n" + StaticMethod.getCurrentMethodName());
    }

    public static void invokeBooleanMethods() {
        BooleanMethods booleanMethodsOne = new BooleanMethods();
        System.out.println("Вызов boolean-методов:");
        System.out.println(booleanMethodsOne.shouldStopProgram());
        System.out.println(booleanMethodsOne.hasUniqueDigit());
        System.out.println(booleanMethodsOne.isLetter());
        System.out.println(booleanMethodsOne.hasEqualDigits());
        System.out.println(booleanMethodsOne.hasAttempts());
        System.out.println(booleanMethodsOne.isEmpty());
        System.out.println(booleanMethodsOne.isEvenNumber());
        System.out.println(booleanMethodsOne.isValidPath());
        System.out.println(booleanMethodsOne.isExistFile() + "\n");
    }

    public static void invokeNotBooleanMethods() {
        NotBooleanMethods notBooleanMethodsOne = new NotBooleanMethods();
        System.out.println("Вызов не boolean-методов:");
        notBooleanMethodsOne.findLongestWord();
        notBooleanMethodsOne.chooseMenuItem();
        notBooleanMethodsOne.calculateGradesAverageValue();
        notBooleanMethodsOne.countUniqueWordsAmount();
        notBooleanMethodsOne.displayErrorMessage();
        notBooleanMethodsOne.synchronizeData();
        notBooleanMethodsOne.recoverData();
        notBooleanMethodsOne.pauseDownload();
        notBooleanMethodsOne.resetSettings();
        notBooleanMethodsOne.writeContentsToFile();
        notBooleanMethodsOne.convertTemperature();
        notBooleanMethodsOne.enterMathExpression();
        notBooleanMethodsOne.identifyWinner();
        notBooleanMethodsOne.findBook();
    }
}