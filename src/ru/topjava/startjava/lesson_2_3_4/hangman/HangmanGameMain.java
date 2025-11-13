package ru.topjava.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        String guessWord = game.chooseWord();
        game.start(guessWord);
    }
}
