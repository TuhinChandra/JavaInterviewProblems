package com.tuhin.examples;

public class MaximumSubarraySum {
    public static int maxSubArraySum(int[] nums) {
        int maxSum = nums[0]; // Initialize maxSum with the first element of the array
        int currentSum = nums[0]; // Initialize currentSum with the first element of the array

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Calculate the current sum including the current element or start a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update maxSum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 }; // Example array
        System.out.println("Maximum subarray sum: " + maxSubArraySum(nums)); // Should print 6
    }
}
