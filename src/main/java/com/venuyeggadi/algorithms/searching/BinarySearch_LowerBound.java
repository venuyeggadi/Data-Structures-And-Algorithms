package com.venuyeggadi.algorithms.searching;

public class BinarySearch_LowerBound {

    /**
     * Time: O(log n)
     * Space: O(1)
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length; /** not length - 1 because length is valid upper bound (a potential position to insert) */

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) /** potential insert position can be mid itself */
                right = mid;
            else
                left = mid + 1; /** potential insert position is definitely after mid */
        }

        /**
         * left can range from 0 to length
         * left is the first position where the given element can be potentially inserted, whether it's found or not found
         * So left is where the given element could be potentially found */

        if (left < nums.length && nums[left] == target)
            return left;

        return -1;
    }
}