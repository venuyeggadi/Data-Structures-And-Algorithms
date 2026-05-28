package com.venuyeggadi.algorithms.slidingwindow;

public class SlidingWindowVariable_2 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 1, 2, 4, 3};
        System.out.println(minimumLengthSubarray(nums, 8));
        System.out.println(minimumLengthSubarray_SlidingWindow(nums, 8));
    }

    /**
     * Bruteforce
     * Time: O(n^2)
     * Space: O(1)
     */
    private static int minimumLengthSubarray(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * Sliding Window
     * Time: 2n => O(n)
     * Space: O(1)
     */
    private static int minimumLengthSubarray_SlidingWindow(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; ++r) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                ++l;
            }
        }

        return  min == Integer.MAX_VALUE ? -1 : min;
    }
}
