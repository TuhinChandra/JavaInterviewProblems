package com.tuhin.examples;

import java.util.*;

public class GuessTheWordGame {
    final static List<String> wordList = Arrays.asList("apple", "dog", "cat", "book");

    public static void main(final String[] args) {
        String wordToGuess = getComputerSelectedWord(args);
        char[] revealedWord = maskWord(wordToGuess);
        printComputerSelectedWord(wordToGuess);
        final List<Character> triedChars = new ArrayList<>();
        int lives = 5;
        final Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Guess the letter::");
            final char userInput = input.nextLine().toCharArray()[0];
            if (wordToGuess.contains(String.valueOf(userInput))) {
                if (String.valueOf(revealedWord).contains(String.valueOf(userInput))) {
                    System.out.println("You have already guessed this. " +
                            "The current word is " + String.valueOf(revealedWord));
                    continue;
                }
                revealCharacters(wordToGuess, revealedWord, userInput);
                System.out.println("Correct. " + String.valueOf(revealedWord));
            } else if (haveYouAlreadyTriedThisChar(triedChars, userInput)) {
                System.out.println("You have already have tried this letter. " +
                        "The current word is " + String.valueOf(revealedWord));
                continue;
            } else {
                triedChars.add(userInput);
                lives--;
                System.out.println("Incorrect 1 life lost. " + lives + " remaining. " +
                        "The current word is " + String.valueOf(revealedWord));
            }
            if (haveYouGuessedSuccessfully(wordToGuess, revealedWord)) {
                //Reset the game
                System.out.println("You wave won!!!");
                wordToGuess = getComputerSelectedWord(args);
                revealedWord = maskWord(wordToGuess);
                printComputerSelectedWord(wordToGuess);
                triedChars.clear();
                continue;
            } else if (lives == 0) {
                System.out.println("Game Over!!!");
                break;
            }
        }
    }

    private static boolean haveYouAlreadyTriedThisChar(final List<Character> triedChars, final char userInput) {
        return triedChars.contains(userInput);
    }

    private static void revealCharacters(final String wordToGuess, final char[] revealedWord, final char userInput) {
        for (int index = 0; index < wordToGuess.length(); index++) {
            if (wordToGuess.charAt(index) == userInput) {
                revealedWord[index] = userInput;
            }
        }
    }

    private static void printComputerSelectedWord(final String wordToGuess) {
        System.out.println("Computer choose this word to guess:" + wordToGuess);
    }

    private static boolean haveYouGuessedSuccessfully(final String wordToGuess, final char[] revealedWord) {
        return wordToGuess.equalsIgnoreCase(String.valueOf(revealedWord));
    }

    private static char[] maskWord(final String wordToGuess) {
        return "*".repeat(wordToGuess.length()).toCharArray();
    }

    protected static String getComputerSelectedWord(final String[] args) {
        final Random random = new Random();
        final int randomIndex = null != args && args.length > 0 ? Integer.parseInt(args[0]) : random.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }
}
