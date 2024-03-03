package com.tuhin.examples.sainsburys;

import java.util.regex.Pattern;

public class Chess {

    private static final char CHAR_SMALL_A = 'a';
    private static final Pattern START_POSITION_PATTERN = Pattern.compile("\\d+[A-Za-z]");

    public static void main(final String[] args) {
        System.out.println(run("2b", 3, 2));
        System.out.println(run("5h", 11, 25));
    }

    public static String run(String startPosition, int rows, int columns) {
        if(!isValidInput(startPosition, rows, columns)) {
            return "INVALID_INPUT";
        }
        int startRow = Character.getNumericValue(startPosition.toLowerCase().charAt(0));
        int startCol = startPosition.toLowerCase().charAt(1) - CHAR_SMALL_A + 1;

        int endRow = (startRow + rows - 1) % 8 + 1;
        int endCol = (startCol + columns - 1) % 8 + 1;

        return endRow + "" + (char) (endCol + CHAR_SMALL_A - 1);
    }

    private static boolean isValidInput(String startPosition, int rows, int columns) {
        return START_POSITION_PATTERN.matcher(startPosition).matches() && rows > 0 && columns > 0;
    }
}