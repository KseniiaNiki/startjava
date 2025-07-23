package ru.topjava.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankingTransactionReverser {
    public static void main(String[] args) {
        int[] transactions = new int[] {};
        int[] reversed = reverse(transactions);
        showTransactions(transactions, reversed);

        transactions = null;
        reversed = reverse(transactions);
        showTransactions(transactions, reversed);

        transactions = new int[] {5};
        reversed = reverse(transactions);
        showTransactions(transactions, reversed);

        transactions = new int[] {6, 8, 9, 1};
        reversed = reverse(transactions);
        showTransactions(transactions, reversed);

        transactions = new int[] {13, 8, 5, 3, 2, 1, 1};
        reversed = reverse(transactions);
        showTransactions(transactions, reversed);
    }

    private static int[] reverse(int[] transactions) {
        if (transactions == null) {
            return null;
        }

        int[] reversed = Arrays.copyOf(transactions, transactions.length);
        int length = reversed.length;
        for (int r : transactions) {
            reversed[--length] = r;
        }
        return reversed;
    }

    private static void showTransactions(int[] transactions, int[] reversed) {
        if (transactions == null) {
            System.out.println("Ошибка в получении данных(никакой информации не получено)");
            return;
        }
        if (transactions.length == 0) {
            System.out.println("Нет данных по транзакциям(ни одна операция не была выполнена)");
            return;
        }
        System.out.println("Исходные транзакции: " + Arrays.toString(transactions));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
    }
}
