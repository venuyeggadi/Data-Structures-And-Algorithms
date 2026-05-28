package com.venuyeggadi.algorithms.slidingwindow;

/**
 * Find the length of the longest subarray, with same value in each position
 */
public class SlidingWindowVariable {
    public static void main(String[] args) {
        int [] nums1 = new int[] {4, 2, 2, 3, 3, 3};
        int [] nums2 = new int[] {3, 3};
        System.out.println(longestSubarray_SlidingWindow_Clean(nums1));
        System.out.println(longestSubarray_SlidingWindow_Clean(nums2));
    }

    /**
     * Bruteforce
     * Time: O(n ^ 2)
     * Space: O(1)
     */
    private static int longestSubarray_Bruteforce(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentLength = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    ++currentLength;
                } else {
                    break;
                }
            }

            max = Math.max(max, currentLength);
        }

        return max;
    }

    /**
     * Sliding Window
     * Time: O(n)
     * Space: O(1)
     */
    private static int longestSubarray_SlidingWindow(int[] nums) {
        int max = 0, curr = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == nums[l]) {
                ++curr;
                ++r;
            } else {
                l = r;
                curr = 0;
            }
            max = Math.max(max, curr);
        }

        return max;
    }

    /**
     * Sliding Window
     * Time: O(n)
     * Space: O(1)
     */
    private static int longestSubarray_SlidingWindow_Clean(int[] nums) {
        int max = 0;
        int l = 0;
        for (int r = 0; r < nums.length; ++r) {
            if (nums[l] != nums[r])
                l = r;
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}

