package com.venuyeggadi.algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array, return true if there are two elements within a window of size k that are equal.
 */
public class SlidingWindowFixed {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(containsDuplicateWithinWindow(arr, 4));
    }

    /**
     * Bruteforce
     * Time: O(n * k)
     * Space: O(1)
     */
    public static boolean closeDuplicatesBruteForce(int[] nums, int k) {
        for (int L = 0; L < nums.length; L++) {
            for (int R = L + 1; R < Math.min(nums.length, L + k); R++) {
                if (nums[L] == nums[R]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sliding Window
     * Time: O(n)
     * Space: O(k)
     */
    private static boolean containsDuplicateWithinWindow(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < nums.length; ++r) {
            if (r - l + 1 > k) {    /** If adding the new element is going to overflow the window, remove the first element */
                set.remove(nums[l]);
                ++l;
            }
            if (set.contains(nums[r]))
                return true;
            set.add(nums[r]);
        }
        return false;
    }
}
