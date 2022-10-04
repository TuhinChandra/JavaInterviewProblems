/* Instructions to candidate.

1) A left rotation operation on an array of size N shifts each of the array's elements 1 unit to the left.

For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].

Given an array of N integers and a number, D, perform D left rotations on the array
  
2) Consider adding further tests to main().
3) Implement the function arrayLeftRotation() correctly, and fix the test in main(). */

package com.tuhin.examples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeftRotateArray {

    public static void ps(final int[] in) {
        System.out.println(Arrays.toString(in));
    }

    public static int[] arrayLeftRotation(final int[] a, int d) {
        // Your code here
        while (d > 0) {
            final int poppedInt = a[0];
            for (int index = 0; index < a.length - 1; index++) {
                a[index] = a[index + 1];
            }

            a[a.length - 1] = poppedInt;
            d--;
        }
        return a;
    }

    // you can change anything
    public static void main(final String[] args) {
        int d = 4;
        final int[] a = {1, 2, 3, 4, 5, 6};
//        final List<Integer> inputList = IntStream.of(a).boxed().collect(Collectors.toList());
        final Queue<Integer> queue = new LinkedList<>(IntStream.of(a).boxed().collect(Collectors.toList()));
        while (d > 0) {
            final int poppedInt = queue.remove();
            queue.add(poppedInt);
            d--;
        }
        final int[] output = {5, 6, 1, 2, 3, 4};  // expected output
        if (IntStream.of(output).boxed().collect(Collectors.toList()).equals(queue))
            System.out.println("Test Success with Queue Approach");
        else
            System.out.println("Test Failed with Queue Approach");

        d = 4;
        final int[] res = arrayLeftRotation(a, d);

        // TO-DO: fix tests
        if (validateOut(res, output))
            System.out.println("Test Success");
        else
            System.out.println("Test Failed");
    }

    private static boolean validateOut(final int[] res, final int[] output) {
        return Arrays.toString(res).equals(Arrays.toString(output));
    }
}