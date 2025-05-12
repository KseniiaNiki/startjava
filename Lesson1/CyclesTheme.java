import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод ASCII-символов");
        System.out.printf("%-11s%-13s%-25s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i < 48; i++) {
            if (i % 2 == 1) {
                int codePoint = i;
                String name = Character.getName(codePoint);
                System.out.printf("%4d%12c%13s%s%n", i, i, " ", name);
            }
        }
        for (int i = 97; i < 123; i++) {
            if (i % 2 == 0) {
                int codePoint = i;
                String name = Character.getName(codePoint);
                System.out.printf("%4d%12c%13s%s%n", i, i, " ", name);
            }
        }
        
        System.out.println("\n2. Вывод геометрических фигур");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print("-");
            }
            System.out.print(" ");
            for (int j = i; j < 6; j++) {
                System.out.print("*");
            }
            System.out.print(" ");
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("^");
            }
            System.out.println();
        }

        System.out.println("\n3. Вывод таблицы умножения");
        System.out.print("  |");
        for (int i = 2; i < 10; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        System.out.print("--+");
        for (int i = 2; i < 10; i++) {
            System.out.printf("%3s", "---");
        }
        System.out.println();
        for (int i = 2; i < 10; i++) {
            System.out.printf("%d%2s", i, "|");
            for (int j = 2; j < 10; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4. Вывод чисел в несколько строк");
        int numAmount = 0;
        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%3d", i);
            numAmount++;
            if (numAmount == 5) {
                System.out.println();
                numAmount = 0;
            }
        }
        if (numAmount > 0) {
            while (numAmount < 5) {
                System.out.printf("%3d", 0);
                numAmount++;
            }
        }

        System.out.println("\n\n5. Вывод чисел между MIN и MAX");
        int initialNumber1 = 10;
        int initialNumber2 = 5;
        int initialNumber3 = -1;
        int maxNumber = initialNumber1;
        if ((initialNumber2 > initialNumber1) && (initialNumber2 > initialNumber3)) {
            maxNumber = initialNumber2;
        } else if ((initialNumber3 > initialNumber1) && (initialNumber3 > initialNumber2)) {
            maxNumber = initialNumber3;
        }
        int minNumber = initialNumber2;
        if ((initialNumber1 < initialNumber2) && (initialNumber1 < initialNumber3)) {
            minNumber = initialNumber1;
        } else if ((initialNumber3 < initialNumber1) && (initialNumber3 < initialNumber2)) {
            minNumber = initialNumber3;
        }
        System.out.println("Все числа в порядке убывания в интервале (" + minNumber + ", " + 
                maxNumber + "):");
        for (int i = maxNumber; i >= minNumber; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n6. Разные операции над числом");
        int initialNumber = 2234321;
        int reverseNumber = 0;
        while (initialNumber > 0) {
            reverseNumber = reverseNumber * 10 + initialNumber % 10;
            initialNumber /= 10;
        }
        System.out.print(reverseNumber + " - ");
        System.out.print(initialNumber == reverseNumber ? "палиндром " : "не палиндром ");
        int twosCount = 0;
        while (reverseNumber > 0) {
            if ((reverseNumber % 10) == 2) {
                twosCount++;
            }
            reverseNumber /= 10;
        }
        System.out.print(twosCount % 2 == 0 ? "с четным " : "с нечетным ");
        System.out.println("(" + twosCount + ") количеством двоек");

        System.out.println("\n7. Проверка счастливого числа");
        int originalNumber = 101002;
        int firstHalf = originalNumber / 1000;
        int secondHalf = originalNumber % 1000;
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        for (int i = 1; i < 1000; i *= 10) {
            firstHalfSum += firstHalf / i % 10;
            secondHalfSum += secondHalf / i % 10;
        }
        if (firstHalfSum == secondHalfSum) {
            System.out.println(originalNumber + " - счастливое число");
            System.out.print("Сумма цифр ");
            System.out.printf("%03d", secondHalf);
            System.out.println(" = " + secondHalfSum);
            System.out.println("Сумма цифр " + firstHalf + " = " + firstHalfSum);
        }

        System.out.println("\n8. Генератор пароля");
        int minValue = 33;
        int maxValue = 122;
        String password = "";
        Random randomGenerator = new Random();
        for (int i = 0; i < 8; i++) {
            int symbol = randomGenerator.nextInt(maxValue - minValue + 1) + minValue;
            password += (char) symbol;
        }
        System.out.println("Пароль: " + password);

        boolean hasSpecialSymbols = false;
        boolean hasDigits = false;
        boolean hasSmallLetters = false;
        boolean hasCapitalLetters = false;
        for (int i = 0; i < password.length(); i++) {
            int character = password.charAt(i);
            if ((character > 47) && (character < 58)) {
                hasDigits = true;
            } else if ((character > 96) && (character < 123)) {
                hasSmallLetters = true;
            } else if ((character > 64) && (character < 91)) {
                hasCapitalLetters = true;
            } else {
                hasSpecialSymbols = true;
            }
        }
        System.out.print("Надежность: ");
        if ((password.length() >= 8) && hasSmallLetters && hasCapitalLetters && hasSpecialSymbols) {
            System.out.println("Надежный");
        } else if ((password.length() >= 8) && hasCapitalLetters || hasDigits) {
            System.out.println("Средний");
        } else {
            System.out.println("Слабый");
        }
    }
}