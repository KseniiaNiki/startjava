import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        byte coresNum = 6;
        System.out.println("Количество ядер = " + coresNum);
        short ramCapacity = 16;
        System.out.println("Объём оперативной памяти = " + ramCapacity);
        int bitDepth = 64;
        System.out.println("Разрядность операционной системы = " + bitDepth);
        long gpuFrequency = 2300;
        System.out.println("Частота графического процессора = " + gpuFrequency);
        float hddSize = 1.5f;
        System.out.println("Ёмкость жесткого диска = " + hddSize);
        double cpuFrequency = 2.5;
        System.out.println("Частота процессора = " + cpuFrequency);
        char osType = 'W';
        System.out.println("Вид операционной системы = " + osType);
        boolean isTurnedOffComputer = false;
        System.out.println("Компьютер выключен = " + isTurnedOffComputer);

        System.out.println("\n2. Расчёт стоимости товара со скидкой");
        double penCost = 105.5;
        double bookCost = 235.83;
        double totalCost = penCost + bookCost;
        double discountPenCost = penCost * 11 / 100;
        double discountBookCost = bookCost * 11 / 100;
        double totalDiscount = discountPenCost + discountBookCost;
        double discountedTotalCost = totalCost - totalDiscount;
        System.out.printf("Общая стоимость товаров без скидки = " + "%.2f", totalCost);
        System.out.printf("\nОбщая сумма скидки = " + "%.4f", totalDiscount);
        System.out.printf("\nОбщая стоимость товаров со скидкой = " + "%.4f", discountedTotalCost);

        System.out.println("\n\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a");
        System.out.println("   J   a a  v   v  a a");
        System.out.println("J  J  aaaaa  V V  aaaaa");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод MIN и MAX значений целых числовых типов");
        byte maxByte = 127;
        System.out.println("Максимально допустимое значение переменной типа byte = " + maxByte);
        maxByte--;
        System.out.println("Значение переменной типа byte после инкремента на 1 = " + maxByte);
        maxByte++;
        System.out.println("Значение переменной типа byte после декремента на 1 = " + maxByte);
        short maxShort = 32767;
        System.out.println("Максимально допустимое значение переменной типа short = " + maxShort);
        maxShort--;
        System.out.println("Значение переменной типа short после инкремента на 1 = " + maxShort);
        maxShort++;
        System.out.println("Значение переменной типа short после декремента на 1 = " + maxShort);
        int maxInt = 2147483647;
        System.out.println("Максимально допустимое значение переменной типа int = " + maxInt);
        maxInt--;
        System.out.println("Значение переменной типа int после инкремента на 1 = " + maxInt);
        maxInt++;
        System.out.println("Значение переменной типа int после декремента на 1 = " + maxInt);
        long maxLong = 9223372036854775807L;
        System.out.println("Максимально допустимое значение переменной типа long = " + maxLong);
        maxLong--;
        System.out.println("Значение переменной типа long после инкремента на 1 = " + maxLong);
        maxLong++;
        System.out.println("Значение переменной типа long после декремента на 1 = " + maxLong);
        char maxChar = 65535;
        System.out.println("Максимально допустимое значение переменной типа char = " + 
                (int) maxChar);
        maxChar--;
        System.out.println("Значение переменной типа char после инкремента на 1 = " + 
                (int) maxChar);
        maxChar++;
        System.out.println("Значение переменной типа char после декремента на 1 = " + 
                (int) maxChar);

        System.out.println("\n5. Перестановка значений переменных");
        int num1 = 2;
        int num2 = 5;
        System.out.println("Исходные значения переменных: первая переменная равна " + num1 + 
                ", вторая переменная равна " + num2);
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("После перестановки с помощью третьей переменной:");
        System.out.println("первая переменная равна " + num1 + ", вторая переменная равна " + num2);
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("После перестановки с помощью арифметических операций:");
        System.out.println("первая переменная равна " + num1 + ", вторая переменная равна " + num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("После перестановки с помощью побитовой операции:");
        System.out.println("первая переменная равна " + num1 + ", вторая переменная равна " + num2);

        System.out.println("\n6. Вывод символов и их кодов");
        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char caret = '^';
        char tilde = '~';
        System.out.println("Согласно таблице символов ASCII:");
        System.out.println("36 = " + dollar);
        System.out.println("42 = " + asterisk);
        System.out.println("64 = " + atSign);
        System.out.println("94 = " + caret);
        System.out.println("126 = " + tilde);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backSlash = '\\';
        char underScore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.println("     " + slash + backSlash);
        System.out.println("    " + slash + "  " + backSlash);
        System.out.println("   " + slash + underScore + leftParenthesis + " " + 
                rightParenthesis + backSlash);
        System.out.println("  " + slash + "      " + backSlash);
        System.out.println(" " + slash + underScore + underScore + underScore + underScore + 
                slash + backSlash + underScore + underScore + backSlash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа");
        int num = 123;
        System.out.println("Число 123 содержит:");
        System.out.println("  сотен - " + num / 100);
        System.out.println("  десятков - " + num / 10 % 10);
        System.out.println("  единиц - " + num % 10);
        System.out.println("Сумма разрядов = " + (num / 100 + num / 10 % 10 + num % 10));
        System.out.println("Произведение разрядов = " + num / 100 * num / 10 % 10 * num % 10);

        System.out.println("\n8. Перевод секунд в часы, минуты и секунды");
        int totalSs = 86399;
        int hh = totalSs / 3600;
        int mm = totalSs % 3600 / 60;
        int ss = totalSs % 60;
        System.out.println(hh + ":" + mm + ":" + ss);

        System.out.println("\n2. * Расчёт стоимости товара со скидкой");
        var penCostBd = new BigDecimal("105.5");
        var bookCostBd = new BigDecimal("235.83");
        var totalCostBd = penCostBd.add(bookCostBd);
        var discountPenCostBd = penCostBd.multiply(BigDecimal.valueOf(0.11))
                .setScale(2, RoundingMode.HALF_UP);
        var discountBookCostBd = bookCostBd.multiply(BigDecimal.valueOf(0.11))
                .setScale(2, RoundingMode.HALF_UP);
        var totalDiscountBd = discountPenCostBd.add(discountBookCostBd)
                .setScale(2, RoundingMode.HALF_UP);
        var discountedTotalCostBd = totalCostBd.subtract(totalDiscountBd)
                .setScale(2, RoundingMode.HALF_UP);
        System.out.printf("Общая стоимость товаров без скидки = " + totalCostBd);
        System.out.printf("\nОбщая сумма скидки = " + totalDiscountBd);
        System.out.printf("\nОбщая стоимость товаров со скидкой = " + discountedTotalCostBd);
    }
}