package com.tuhin.examples;

public class Chess {

    public static void main(final String[] args) {
        System.out.println(run("2b", 3, 2));
        System.out.println(run("5h", 11, 25));
    }

    public static String run(final String startPosition, final int R, final int C) {
        final int startRow = Integer.parseInt(String.valueOf(startPosition.charAt(0)));
        final int startCol = startPosition.charAt(1) - 96;
        int endRow = (startRow + R) % 8;
        endRow = endRow != 0 ? endRow : 8;
        final int endColInt = ((startCol + C) % 8) + 96;
        final char endCol = (char) endColInt;
        final String endPosition = endRow + "" + endCol;
        return endPosition;
    }
}
