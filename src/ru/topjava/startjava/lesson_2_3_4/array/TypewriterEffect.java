package ru.topjava.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String sentence = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        String[] parts = findShortestAndLongestWords(sentence);
        printWithEffect(parts);
        sentence = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        parts = findShortestAndLongestWords(sentence);
        printWithEffect(parts);
        sentence = null;
        parts = findShortestAndLongestWords(sentence);
        printWithEffect(parts);
        sentence = "";
        parts = findShortestAndLongestWords(sentence);
        printWithEffect(parts);
    }

    private static String[] findShortestAndLongestWords(String sentence) {
        if (sentence == null) {
            System.out.println("Ошибка в получении данных");
            return null;
        }
        if (sentence.isBlank()) {
            System.out.println("Получена пустая строка");
            return null;
        }

        String withoutMarks = sentence.replaceAll("\\pP", "");
        String[] words = withoutMarks.split(" ");

        String shortestWord = words[0];
        String longestWord = words[0];
        int shortIndex = 0;
        int longIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].isBlank()) {
                continue;
            }
            if (words[i].length() < shortestWord.length()) {
                shortestWord = words[i];
                shortIndex = i;
            }
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
                longIndex = i;
            }
        }

        String[] parts = sentence.split(" ");
        if (shortIndex < longIndex) {
            for (int i = shortIndex; i <= longIndex; i++) {
                parts[i] = parts[i].toUpperCase();
            }
        } else {
            for (int i = longIndex; i <= shortIndex; i++) {
                parts[i] = parts[i].toUpperCase();
            }
        }
        return parts;
    }

    private static void printWithEffect(String[] parts) throws InterruptedException {
        if (parts == null) {
            return;
        }

        for (String part : parts) {
            for (char ch : part.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
