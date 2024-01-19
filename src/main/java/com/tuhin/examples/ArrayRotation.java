package com.tuhin.examples;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        // Example usage:
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 9;

        System.out.println("Original Array: " + Arrays.toString(nums));
        rotateArray2(nums, k);
    }

    private static void rotateArray2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return; // No rotation needed
        }
        k = k % nums.length;
        int[] newnums = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newnums[index++] = nums[i];
        }
        int rotated = index;
        for (int i = 0; i < nums.length - rotated; i++) {
            newnums[index++] = nums[i];
        }
        System.out.println("Rotated Array without changing original: " + Arrays.toString(newnums));
    }
}
