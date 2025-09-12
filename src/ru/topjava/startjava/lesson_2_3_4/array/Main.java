package ru.topjava.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        launchBankingTransactionReverser();
        launchHackingImitation();
        launchFactorialCalculator();
        launchExceedingArrayElementsRemoval();
    }

    private static void launchBankingTransactionReverser() {
        int[] transactions = new int[] {};
        int[] reversed = Arrays.reverse(transactions);
        Console.showTransactions(transactions, reversed);

        transactions = null;
        reversed = Arrays.reverse(transactions);
        Console.showTransactions(transactions, reversed);

        transactions = new int[] {5};
        reversed = Arrays.reverse(transactions);
        Console.showTransactions(transactions, reversed);

        transactions = new int[] {6, 8, 9, 1};
        reversed = Arrays.reverse(transactions);
        Console.showTransactions(transactions, reversed);

        transactions = new int[] {13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverse(transactions);
        Console.showTransactions(transactions, reversed);
    }

    private static void launchHackingImitation() throws InterruptedException {
        int randomNumber = Arrays.generateRandomNumber();
        Console.giveAccess(randomNumber);
    }

    private static void launchFactorialCalculator() {
        int[] numbers = new int[] {};
        long[] factorials = Arrays.calculate(numbers);
        Console.showCalculation(factorials, numbers);

        numbers = null;
        factorials = Arrays.calculate(numbers);
        Console.showCalculation(factorials, numbers);

        numbers = new int[] {8, 0, 9};
        factorials = Arrays.calculate(numbers);
        Console.showCalculation(factorials, numbers);

        numbers = new int[] {-3, 1, 7, 13};
        factorials = Arrays.calculate(numbers);
        Console.showCalculation(factorials, numbers);

        numbers = new int[] {-22, -0};
        factorials = Arrays.calculate(numbers);
        Console.showCalculation(factorials, numbers);
    }

    private static void launchExceedingArrayElementsRemoval() {
        int[] indices = {-1, 15, 0, 14};
        for (int index : indices) {
            float[] modified = Arrays.fillExceedingElementsWithZeros(index);
            Console.showResultOfRemoval(index, original, modified);
        }
    }

    private static void launchSortedSymbolsTriangleOutput() {
    }

    private static void launchUniqueNumbersFiller() {
    }

    private static void launchTypewriterEffect() {
    }
}
