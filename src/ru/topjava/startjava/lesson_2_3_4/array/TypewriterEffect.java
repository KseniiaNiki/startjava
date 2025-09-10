package ru.topjava.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String sentence = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        int[] indices = findShortestAndLongestWords(sentence);
        String[] words = findUpperCaseRange(sentence, indices);
        type(words);
        sentence = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        indices = findShortestAndLongestWords(sentence);
        words = findUpperCaseRange(sentence, indices);
        type(words);
        sentence = null;
        indices = findShortestAndLongestWords(sentence);
        words = findUpperCaseRange(sentence, indices);
        type(words);
        sentence = "";
        indices = findShortestAndLongestWords(sentence);
        words = findUpperCaseRange(sentence, indices);
        type(words);
    }

    private static int[] findShortestAndLongestWords(String sentence) {
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
        int shortestWordIndex = 0;
        int longestWordIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].isBlank()) {
                continue;
            }
            if (words[i].length() < shortestWord.length()) {
                shortestWord = words[i];
                shortestWordIndex = i;
            }
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
                longestWordIndex = i;
            }
        }
        return new int[] {shortestWordIndex, longestWordIndex};
    }

    private static String[] findUpperCaseRange(String sentence, int[] indices) {
        if ((sentence == null) || (indices == null)) {
            return null;
        }
        String[] parts = sentence.split(" ");
        if (indices[0] > indices[1]) {
            indices[0] = indices[0] ^ indices[1] ^ (indices[1] = indices[0]);
        }
        for (int i = indices[0]; i <= indices[1]; i++) {
            parts[i] = parts[i].toUpperCase();
        }
        return parts;
    }

    private static void type(String[] words) throws InterruptedException {
        if (words == null) {
            return;
        }

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
