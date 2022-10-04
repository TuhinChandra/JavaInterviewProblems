package com.tuhin.examples;

import java.util.Arrays;

public class EqualSideOfArray {
    public static int findEvenIndex(final int[] arr) {
        // your code
        for (int x = 0; x < arr.length; x++) {
            if (Arrays.stream(arr, 0, x).sum() == Arrays.stream(arr, x + 1, arr.length).sum()) return x;

        }
        return -1;
    }

    public static void main(final String[] args) {
        System.out.println("Exepected=3, Actual=" + findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }
}
