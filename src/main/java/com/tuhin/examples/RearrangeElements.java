package com.tuhin.examples;

public class RearrangeElements {
    public static void rearrange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] < 0) {
                left++;
            } else if (nums[right] >= 0) {
                right--;
            } else {
                // Swap nums[left] and nums[right]
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, -3, 4, -5, 6, -7};
        rearrange(nums);
        System.out.println("Array after rearranging:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
