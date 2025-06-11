public class BooleanMethods {
    public boolean shouldStopProgram() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> программа выполняется далее или завершается? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetter() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> в проверяемых числах, есть равные цифры? ");
        return true;
    }

    public boolean hasAttempts() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> в игре 'Марио' остались попытки? ");
        return true;
    }

    public boolean isEmpty() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return true;
    }

    public boolean isEvenNumber() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return true;
    }

    public boolean isValidPath() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return true;
    }

    public boolean isExistFile() {
        System.out.print(StaticMethod.getCurrentMethodName() + 
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}