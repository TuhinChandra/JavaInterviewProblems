package com.tuhin.examples;

public class MaximumSubarraySum {

    public static int maxSubarraySum(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            System.out.print("Iteration - " + i + ": nums[i] = " + nums[i]);
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            System.out.println(" maxEndingHere=" + maxEndingHere + " maxSoFar=" + maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubarraySum(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}
