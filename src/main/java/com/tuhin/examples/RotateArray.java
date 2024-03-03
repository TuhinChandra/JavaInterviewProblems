package com.tuhin.examples;

public class RotateArray {
    public static void rotateRight(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // To handle cases where k is greater than the length of the array
        reverse(nums, 0, n - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, n - 1); // Reverse the remaining elements
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2; // Number of positions to rotate
        rotateRight(nums, k);
        System.out.println("Array after rotating right by " + k + " positions:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

