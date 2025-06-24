package ru.topjava.startjava.lesson_2_3.method.naming;

public class BooleanMethods {
    public boolean shouldStopProgram() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> программа выполняется далее или завершается? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> в проверяемых числах, есть равные цифры? ");
        return true;
    }

    public boolean hasAttempts() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> в игре 'Марио' остались попытки? ");
        return true;
    }

    public boolean isEmpty() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return true;
    }

    public boolean isEvenNumber() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return true;
    }

    public boolean isExistFile() {
        System.out.print(MethodUtils.getCurrentMethodName() + 
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}