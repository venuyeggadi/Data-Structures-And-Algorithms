package com.venuyeggadi.problemsolving.leetcode;


/**
 * Bruteforce
 *
 * Time: O(n)
 * Space: O(1)
 */
class FindMinimumInRotatedSortedArray_Solution1 {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int num : nums)
            min = Math.min(min, num);

        return min;
    }
}

/**
 * Binary Search
 * Intuition
 *      If the array range being searched is already in a sorted order, the first element is the minimum element.
 *      Given it's rotated, A rotated sorted array has one special property: one part is always sorted, and the other part contains the rotation (and the minimum element).
 *      So after diving in to two halves, if the first half is sorted, minimum will be in the second half (excluding mid), otherwise in the first half itself (including mid)
 *
 * Time: O(log n)
 * Space: O(1)
 */
class FindMinimumInRotatedSortedArray_Solution2 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = nums[0];

        while (l <= r) {
            if (nums[l] <= nums[r])
                return Math.min(min, nums[l]);

            int mid = l + (r - l) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[l] <= nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return min;
    }
}


/**
 * Binary Search - Lower Bound
 * Intuition
 *      Minimum element in a sorted arrays always satisfies a condition (whether rotated or not),
 *      i.e., it is always less than or equal to the last element in the array. i.e., min <= nums[r]  OR min <= nums[nums.length - 1]
 *      So the problem here is to find the first element that is less that or equal to last element in the selected range,
 *      Which can be found using lower bound pattern of the binary search.
 *
 * Time: O(log n)
 * Space: O(1)
 */
class FindMinimumInRotatedSortedArray_Solution3 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[r]) /** nums[mid] <= nums[nums.length - 1] */
                r = mid;
            else
                l = mid + 1;
        }

        return nums[l];
    }
}


/**
 * Can be combined with rotated sorted array property,
 * If the array range being searched is already in a sorted order, the first element is the minimum element.
 */
class FindMinimumInRotatedSortedArray_Solution3_Way2 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            if (nums[l] <= nums[r])
                return nums[l];

            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[r])
                r = mid;
            else
                l = mid + 1;
        }

        return nums[l];
    }
}
