import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык JAVA");
        boolean male = false;
        if (!male) {
            System.out.println("Вы - женщина");
        } else {
            System.out.println("Вы - мужчина");
        }

        int age = 15;
        if (age > 18) {
            System.out.println("Вы несовершеннолетний");
        } else {
            System.out.println("Вы несовершеннолетний");
        }

        double height = 1.9;
        if (height < 1.8) {
            System.out.println("Вы среднего роста");
        } else {
            System.out.println("Вы высокий");
        }

        System.out.println("\n2. Поиск большего числа шагов");
        int stepAmount1 = 10000;
        System.out.println("Сегодня Вы прошли " + stepAmount1 + " шагов");
        int stepAmount2 = 7000;
        System.out.println("Вчера Вы прошли " + stepAmount2 + " шагов");
        if (stepAmount1 > stepAmount2) {
            System.out.println("Сегодня Вы прошли " + stepAmount1 + " шагов, что больше, чем вчера");
        } else if (stepAmount1 < stepAmount2) {
            System.out.println("Вчера Вы прошли " + stepAmount2 + " шагов, что больше, чем сегодня");
        } else {
            System.out.println("Сегодня и вчера Вы прошли одинаковое количество шагов");
        }
        int stepAmount3 = (stepAmount1 + stepAmount2) / 2;
        System.out.println("Среднее число шагов за 2 дня = " + stepAmount3);

        System.out.println("\n3. Проверка количества гостей");
        int guestAmount = -4;
        if (guestAmount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestAmount < 0) {
            System.out.println("Введено неверное количество!");
        } else {
            if (guestAmount % 2 == 0) {
                System.out.print("Записалось " + guestAmount + " гостей. ");
                System.out.println("Можно формировать пары для конкурсов.");
            } else if (guestAmount % 2 == 1) {
                System.out.print("Записалось " + guestAmount + " гостей. ");
                System.out.println("Нужны индивидуальные задания.");
            }
        }

        System.out.println("\n4. Инвентаризация");
        int baseNum = 493;
        int localNum = 573;
        int hundredsBaseNum = baseNum / 100;
        int hundredsLocalNum = localNum / 100;
        int tensBaseNum = baseNum / 10 % 10;
        int tensLocalNum = localNum / 10 % 10;
        int onesBaseNum = baseNum % 10;
        int onesLocalNum = localNum % 10;
        if (baseNum == localNum) {
            System.out.println("[№ " + localNum + " ]: компьютер на 3-м этаже в кабинете 2");
        } else if ((hundredsBaseNum == hundredsLocalNum) || (tensBaseNum == tensLocalNum) || 
                (onesBaseNum == onesLocalNum)) {
            System.out.println("Нет полного совпадения:");
            System.out.println("База данных: [№" + baseNum + "]");
            System.out.println("Фактический: [№" + localNum + "]");
        } else if (baseNum != localNum) {
            System.out.println("[№" + localNum + "]: оборудование не идентифицировано");
        }

        System.out.println("\n5. Определение первого символа никнейма");
        String nickname = "KseniiaNiki";
        char firstChar = nickname.charAt(0);
        if ((firstChar >= 'a') && (firstChar <= 'z')) {
            System.out.println("Имя " + nickname + " начинается с маленькой буквы " + firstChar);
        } else if ((firstChar >= 'A') && (firstChar <= 'Z')) {
            System.out.println("Имя " + nickname + " начинается с большой буквы " + firstChar);
        } else if ((firstChar >= '0') && (firstChar <= '9')) {
            System.out.println("Имя " + nickname + " начинается с цифры " + firstChar);
        } else {
            System.out.println("Имя " + nickname + " начинается с символа " + firstChar);
        }

        if (Character.isLowerCase(firstChar)) {
            System.out.println("Имя " + nickname + " начинается с маленькой буквы " + firstChar);
        } else if (Character.isUpperCase(firstChar)) {
            System.out.println("Имя " + nickname + " начинается с большой буквы " + firstChar);
        } else if (Character.isDigit(firstChar)) {
            System.out.println("Имя " + nickname + " начинается с цифры " + firstChar);
        } else {
            System.out.println("Имя " + nickname + " начинается с символа " + firstChar);
        }

        System.out.println("\n6. Подсчёт начисленных банком %");
        float baseSum = 321123.79f;
        System.out.println("Сумма вклада = " + baseSum);
        float profit;
        float finalSum;
        if (baseSum < 100000) {
            profit = baseSum * 5 / 100;
            System.out.println("Сумма начисленного % = " + profit);
            finalSum = baseSum + profit;
            System.out.println("Итоговая сумма с % = " + finalSum);
        } else if ((baseSum >= 100000) && (baseSum < 300000)) {
            profit = baseSum * 7 / 100;
            System.out.println("Сумма начисленного % = " + profit);
            finalSum = baseSum + profit;
            System.out.println("Итоговая сумма с % = " + finalSum);
        } else if (baseSum >= 300000) {
            profit = baseSum * 10 / 100;
            System.out.println("Сумма начисленного % = " + profit);
            finalSum = baseSum + profit;
            System.out.println("Итоговая сумма с % = " + finalSum);
        }

        var baseSumBd = new BigDecimal("321123.79");
        System.out.println("\nСумма вклада = " + baseSumBd);
        if (baseSumBd.compareTo(BigDecimal.valueOf(100000)) < 0) {
            var rate = new BigDecimal("0.05");
            var profitBd = baseSumBd.multiply(rate).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Сумма начисленного % = " + profitBd);
            var finalSumBd = baseSumBd.add(profitBd).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Итоговая сумма с % = " + finalSumBd);
        } else if ((baseSumBd.compareTo(BigDecimal.valueOf(100000)) >= 0) && 
                (baseSumBd.compareTo(BigDecimal.valueOf(300000)) < 0)) {
            var rate = new BigDecimal("0.07");
            var profitBd = baseSumBd.multiply(rate).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Сумма начисленного % = " + profitBd);
            var finalSumBd = baseSumBd.add(profitBd).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Итоговая сумма с % = " + finalSumBd);
        } else if (baseSumBd.compareTo(BigDecimal.valueOf(300000)) >= 0) {
            var rate = new BigDecimal("0.1");
            var profitBd = baseSumBd.multiply(rate).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Сумма начисленного % = " + profitBd);
            var finalSumBd = baseSumBd.add(profitBd).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Итоговая сумма с % = " + finalSumBd);
        }

        System.out.println("\n7. Определение оценки по предметам");
        int historyRate = 59;
        int itRate = 92;
        int historyGrade = 0;
        int itGrade = 0;
        if (historyRate <= 60) {
            historyGrade = 2;
            System.out.println("История - " + historyGrade);
        } else if ((historyRate > 60) && (historyRate <= 73)) {
            historyGrade = 3;
            System.out.println("История - " + historyGrade);
        } else if ((historyRate > 73) && (historyRate <= 91)) {
            historyGrade = 4;
            System.out.println("История - " + historyGrade);
        } else if (historyRate > 91) {
            historyGrade = 5;
            System.out.println("История - " + historyGrade);
        }
        if (itRate <= 60) {
            itGrade = 2;
            System.out.println("Программирование - " + itGrade);
        } else if ((itRate > 60) && (itRate <= 73)) {
            itGrade = 3;
            System.out.println("Программирование - " + itGrade);
        } else if ((itRate > 73) && (itRate <= 91)) {
            itGrade = 4;
            System.out.println("Программирование - " + itGrade);
        } else if (itRate > 91) {
            itGrade = 5;
            System.out.println("Программирование - " + itGrade);
        }
        double averageGrade = (double) (historyGrade + itGrade) / 2;
        System.out.println("Средний балл оценок по предметам = " + averageGrade);
        double averageRate = (double) (historyRate + itRate) / 2;
        System.out.println("Средний % по предметам = " + averageRate);

        System.out.println("\n8. Расчёт годовой прибыли");
        var monthSale = new BigDecimal("13025.233");
        var monthRent = new BigDecimal("5123.018");
        var monthProductionCost = new BigDecimal("9001.729");
        var monthProfit = monthSale.subtract(monthRent).subtract(monthProductionCost)
                .setScale(3, RoundingMode.HALF_UP);
        var annualProfit = monthProfit.multiply(BigDecimal.valueOf(12))
                .setScale(3, RoundingMode.HALF_UP);
        if (annualProfit.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Прибыль за год: +" + annualProfit + " руб.");
        } else if (annualProfit.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Прибыль за год: " + annualProfit + " руб.");
        } else if (annualProfit.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Прибыль за год: " + annualProfit + " руб.");
        }
    }
}