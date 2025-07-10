package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankingTransactionReverse {
    public static void doReverse(int[] transactionSums) {
        if (transactionSums.length == 0) {
            System.out.println("Нет данных по транзакциям(ни одна операция не была выполнена)");
            return;
        }

//        if (transactionSums = null) {
//            System.out.println("Ошибка в получении данных(никакой информации не получено)");
//            return;
//        }

        System.out.println("Исходные транзакции: " + Arrays.toString(transactionSums));

        int[] reversedArray = Arrays.copyOf(transactionSums, transactionSums.length);
        for(int i = 0; i < reversedArray.length / 2; i++) {
            int halfArray = reversedArray[i];
            reversedArray[i] = reversedArray[reversedArray.length - i - 1];
            reversedArray[reversedArray.length - i - 1] = halfArray;
        }
        System.out.println(" В обратном порядке: " + Arrays.toString(reversedArray));
    }

    public static void main(String[] args) {
        doReverse(new int[] {});
//        doReverse(new int[]);
        doReverse(new int[] {5});
        doReverse(new int[] {6, 8, 9, 1});
        doReverse(new int[] {13, 8, 5, 3, 2, 1, 1});
    }
}
