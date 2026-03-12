package com.venuyeggadi.algorithms.searching;

public class BinarySearch_UpperBound {

    /**
     * Time: O(log n)
     * Space: O(1)
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length; /** not length - 1 because length is valid lower bound (a potential position to insert) */

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) /** potential insert position is definitely after mid */
                left = mid + 1;
            else
                right = mid; /** potential insert position can be mid itself */
        }

        /**
         * left can range from 0 to length
         * left is the last position where the given element can be potentially inserted, whether it's found or not found
         * So left - 1 is where the given element could be potentially found */

        if (left > 0 && nums[left - 1] == target)
            return left - 1;

        return -1;
    }
}