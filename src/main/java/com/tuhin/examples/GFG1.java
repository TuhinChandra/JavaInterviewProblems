package com.tuhin.examples;

import java.util.Arrays;

class GFG1 {

    // Function that counts the minimum
// moves required to convert arr[] to brr[]
    static int minOperations(final int[] arr1, final int[] arr2,
                             final int i, final int j) {

        // Base Case
        if (arr1.equals(arr2))
            return 0;

        if (i >= arr1.length || j >= arr2.length)
            return 0;

        // If arr[i] < arr[j]
        if (arr1[i] < arr2[j])

            // Include the current element
            return 1 + minOperations(arr1, arr2,
                    i + 1, j + 1);

        // Otherwise, excluding the current element
        return Math.max(minOperations(arr1, arr2,
                        i, j + 1),
                minOperations(arr1, arr2,
                        i + 1, j));
    }

    // Function that counts the minimum
// moves required to sort the array
    static void minOperationsUtil(final int[] arr) {
        final int[] brr = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            brr[i] = arr[i];

        Arrays.sort(brr);

        // If both the arrays are equal
        if (arr.equals(brr))

            // No moves required
            System.out.print("0");

            // Otherwise
        else

            // Print minimum operations required
            System.out.println(minOperations(arr, brr,
                    0, 0));
    }

    // Driver code
    public static void main(final String[] args) {
        final int[] arr = {3, 2, 1};

        minOperationsUtil(arr);
    }
}