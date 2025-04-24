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
        int todayStepAmount = 10000;
        System.out.println("Сегодня Вы прошли " + todayStepAmount + " шагов");
        int yesterdayStepAmount = 7000;
        System.out.println("Вчера Вы прошли " + yesterdayStepAmount + " шагов");
        if (todayStepAmount > yesterdayStepAmount) {
            System.out.println("Сегодня Вы прошли " + todayStepAmount + " шагов, что больше, чем вчера");
        } else if (todayStepAmount < yesterdayStepAmount) {
            System.out.println("Вчера Вы прошли " + yesterdayStepAmount + " шагов, что больше, чем сегодня");
        } else {
            System.out.println("Сегодня и вчера Вы прошли одинаковое количество шагов");
        }
        int averageStepAmount = (todayStepAmount + yesterdayStepAmount) / 2;
        System.out.println("Среднее число шагов за 2 дня = " + averageStepAmount);

        System.out.println("\n3. Проверка количества гостей");
        int guestAmount = 4;
        if (guestAmount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestAmount < 0) {
            System.out.println("Введено неверное количество!");
        } else {
            System.out.print("Записалось " + guestAmount + " гостей. ");
            if (guestAmount % 2 == 0) {
                System.out.println("Можно формировать пары для конкурсов.");
            } else if (guestAmount % 2 == 1) {
                System.out.println("Нужны индивидуальные задания.");
            }
        }

        System.out.println("\n4. Инвентаризация");
        int dbSerialNum = 223;
        int localNum = 23;
        int hundredsDbSerialNum = dbSerialNum / 100;
        int hundredsLocalNum = localNum / 100;
        int tensDbSerialNum = dbSerialNum / 10 % 10;
        int tensLocalNum = localNum / 10 % 10;
        int onesDbSerialNum = dbSerialNum % 10;
        int onesLocalNum = localNum % 10;
        if (dbSerialNum == localNum) {
            System.out.println("[№" + localNum + "]: компьютер на 3-м этаже в кабинете 2");
        } else if ((hundredsDbSerialNum == hundredsLocalNum) || (tensDbSerialNum == tensLocalNum) ||
                (onesDbSerialNum == onesLocalNum)) {
            System.out.println("Нет полного совпадения:");
            System.out.println("База данных: [№" + dbSerialNum + "]");
            System.out.print("Фактический: [№");
            System.out.print(hundredsDbSerialNum == hundredsLocalNum ? hundredsLocalNum : "_");
            System.out.print(tensDbSerialNum == tensLocalNum ? tensLocalNum : "_");
            System.out.print(onesDbSerialNum == onesLocalNum ? onesLocalNum : "_");
            System.out.println("]");
        } else {
            System.out.println("[№" + localNum + "]: оборудование не идентифицировано");
        }

        System.out.println("\n5. Определение первого символа никнейма");
        String nickname = "KseniiaNiki";
        char firstChar = nickname.charAt(0);
        System.out.print("Имя " + nickname + " начинается с ");
        if ((firstChar >= 'a') && (firstChar <= 'z')) {
            System.out.println("маленькой буквы " + firstChar);
        } else if ((firstChar >= 'A') && (firstChar <= 'Z')) {
            System.out.println("большой буквы " + firstChar);
        } else if ((firstChar >= '0') && (firstChar <= '9')) {
            System.out.println("цифры " + firstChar);
        } else {
            System.out.println("символа " + firstChar);
        }

        System.out.print("Имя " + nickname + " начинается с ");
        if (Character.isLowerCase(firstChar)) {
            System.out.println("маленькой буквы " + firstChar);
        } else if (Character.isUpperCase(firstChar)) {
            System.out.println("большой буквы " + firstChar);
        } else if (Character.isDigit(firstChar)) {
            System.out.println("цифры " + firstChar);
        } else {
            System.out.println("символа " + firstChar);
        }

        System.out.println("\n6. Подсчёт начисленных банком %");
        float deposit = 321123.79f;
        int rate = 10;
        if (deposit < 100000) {
            rate = 5;
        } else if ((deposit >= 100000) && (deposit < 300000)) {
            rate = 7;
        }
        float profit = deposit * rate / 100;
        float finalSum = deposit + profit;
        System.out.println("Сумма вклада = " + deposit);
        System.out.println("Сумма начисленного % = " + profit);
        System.out.println("Итоговая сумма с % = " + finalSum);

        var depositBd = new BigDecimal("321123.79");
        var rateBd = new BigDecimal("0.1");
        if (depositBd.compareTo(BigDecimal.valueOf(100000)) < 0) {
            rateBd = new BigDecimal("0.5");
        } else if ((depositBd.compareTo(BigDecimal.valueOf(100000)) >= 0) && 
                (depositBd.compareTo(BigDecimal.valueOf(300000)) < 0)) {
            rateBd = new BigDecimal("0.7");
        }
        var profitBd = depositBd.multiply(rateBd).setScale(2, RoundingMode.HALF_UP);
        var finalSumBd = depositBd.add(profitBd).setScale(2, RoundingMode.HALF_UP);
        System.out.println("\nСумма вклада = " + depositBd);
        System.out.println("Сумма начисленного % = " + profitBd);
        System.out.println("Итоговая сумма с % = " + finalSumBd);

        System.out.println("\n7. Определение оценки по предметам");
        int historyPercent = 59;
        int historyGrade = 2;
        if ((historyPercent > 60) && (historyPercent <= 73)) {
            historyGrade = 3;
        } else if ((historyPercent > 73) && (historyPercent <= 91)) {
            historyGrade = 4;
        } else if (historyPercent > 91) {
            historyGrade = 5;
        }

        int csPercent = 92;
        int csGrade = 2;
        if ((csPercent > 60) && (csPercent <= 73)) {
            csGrade = 3;
        } else if ((csPercent > 73) && (csPercent <= 91)) {
            csGrade = 4;
        } else if (csPercent > 91) {
            csGrade = 5;
        }

        System.out.println("История - " + historyGrade);
        System.out.println("Программирование - " + csGrade);

        double averageGrade = (double) (historyGrade + csGrade) / 2;
        System.out.println("Средний балл оценок по предметам = " + averageGrade);
        double averagePercent = (double) (historyPercent + csPercent) / 2;
        System.out.println("Средний % по предметам = " + averagePercent);

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
        } else {
            System.out.println("Прибыль за год: " + annualProfit + " руб.");
        }
    }
}