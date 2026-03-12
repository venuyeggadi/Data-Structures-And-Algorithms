package com.venuyeggadi.problemsolving.leetcode;

import java.util.Arrays;


/**
 * Bruteforce - Linear Search
 *
 * Time: O(n)
 * Space: O(1)
 */


/**
 * Binary search
 * Intuition
 *      Find the position of the minimum value first (This can be done using binary search). It divides the array into two sorted arrays.
 *      Decide which half the target element could be potentially found and apply binary search on that.
 *
 * Time: O(log n + log n) => O(log n)
 * Space: O(1)
 */
class SearchInRotatedSortedArray_Solution1 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[r])
                r = mid;
            else
                l = mid + 1;
        }

        int minIndex = l;

        int left, right;
        if (target >= nums[minIndex] && target <= nums[nums.length - 1]) {
            left = minIndex;
            right = nums.length - 1;
        } else {
            left = 0;
            right = minIndex - 1;
        }

        if (left > right)
            return -1;

        int index = Arrays.binarySearch(nums, left, right + 1, target); /** right index is exclusive */

        if (index >= 0)
            return index;

        return -1;
    }
}


/**
 * Binary Search - One pass
 * Intuition
 *      The problem here is know which half to eliminate.
 *      We can do that by checking if the half is already sorted (continuously increase) and whether it can potentially contain that element or not.
 *      If it does not contain, we can eliminate that half move to the other half.
 *
 *      Note: Given the search range is rotated, When we divide the array at mid, it always holds true that if one half (including mid)
 *      then the other half (including mid) contains that rotation point (where sorting order is disrupted).
 *
 * Time: O(log n)
 * Space: O(1)
 */
class SearchInRotatedSortedArray_Solution2 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;

            boolean firstHalfIsContinuous = nums[l] <= nums[mid];
            if (firstHalfIsContinuous) {
                if (target < nums[mid] && target >= nums[l])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return -1;
    }
}