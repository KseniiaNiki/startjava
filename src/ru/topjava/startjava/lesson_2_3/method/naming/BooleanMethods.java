package ru.topjava.startjava.lesson_2_.naming;

public class BooleanMethods {
    public boolean shouldStopProgram() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> программа выполняется далее или завершается? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> в проверяемых числах, есть равные цифры? ");
        return true;
    }

    public boolean hasAttempts() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> в игре 'Марио' остались попытки? ");
        return true;
    }

    public boolean isEmpty() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return true;
    }

    public boolean isEvenNumber() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return true;
    }

    public boolean isExistFile() {
        System.out.print(CurrentMethodNameUtil.getCurrentMethodName() + 
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}