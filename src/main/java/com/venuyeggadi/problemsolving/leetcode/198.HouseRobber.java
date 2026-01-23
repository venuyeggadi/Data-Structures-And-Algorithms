package com.venuyeggadi.problemsolving.leetcode;

import java.util.Arrays;

/**
 * Recursion
 *
 * Intuition:
 * Example: [2, 1, 1, 2]
 * Once we rob house at index 0 (2), we can either rob house at index 2 (1) or house at index 3 (2). So we have two choices and we can choose the
 * once that gives us maximum.
 *
 * Time: O(2 ^ (n/2)) => O(2^n)
 * Space: O(n/2) => O(n)
 */
class HouseRobber_Solution1 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        return Math.max(rob(nums, 0), rob(nums, 1));
    }

    private int rob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        int max = Math.max(rob(nums, index + 2), rob(nums, index + 3));

        return nums[index] + max;
    }
}


/**
 * Dynamic programming (top to bottom)
 *
 * Time: O(n/2) => O(n)
 * Space: O(n/2) => O(n)
 */
class HouseRobber_Solution2 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return Math.max(rob(nums, 0, memo), rob(nums, 1, memo));
    }

    private int rob(int[] nums, int index, int[] memo) {
        if (index >= nums.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int max = Math.max(rob(nums, index + 2, memo), rob(nums, index + 3, memo));
        memo[index] = nums[index] + max;

        return memo[index];
    }
}


/**
 * Dynamic programming (bottom-up)
 * Intuition
 * Going through each house, calculate the max amount that can robbed till that particular house. For house i, the maximum that can be robbed is
 * max of two choices
 *      1. rob house i and maximum till house i - 1, OR
 *      2. skip house i -> choose whatever is till house i - 1.
 * i.e., maxRobbedTillHouse[i] = maximum(maxRobbedTillHouse[i] + maxRobbedTillHouse[i - 2], maxRobbedTillHouse[i - 1])
 *
 *
 * Time: O(n)
 * Space: O(n)
 */
class HouseRobber_Solution3 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] maxRobbed = new int[nums.length];
        maxRobbed[0] = nums[0];
        maxRobbed[1] = Math.max(nums[0], nums[1]); /** maximum till house 1 */

        for (int i = 2; i < nums.length; ++i) {
            maxRobbed[i] = Math.max(nums[i] + maxRobbed[i - 2], maxRobbed[i - 1]);
        }

        return maxRobbed[maxRobbed.length - 1];
    }
}

/**
 * Dynamic programming (bottom-up) - Space optimized
 *
 * Time: O(n)
 * Space: O(1)
 */
class HouseRobber_Solution4 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int maxRobbed0 = nums[0];
        int maxRobbed1 = Math.max(nums[0], nums[1]); /** maximum till house 1 */

        for (int i = 2; i < nums.length; ++i) {
            int temp = maxRobbed1;
            maxRobbed1 = Math.max(nums[i] + maxRobbed0, maxRobbed1);
            maxRobbed0 = temp;
        }

        return maxRobbed1;
    }
}

class HouseRobber_Solution4_Better {
    public int rob(int[] nums) {
        int maxRobbed0 = 0;
        int maxRobbed1 = 0;

        for (int i = 0; i < nums.length; ++i) {
            int temp = maxRobbed1;
            maxRobbed1 = Math.max(nums[i] + maxRobbed0, maxRobbed1);
            maxRobbed0 = temp;
        }

        return maxRobbed1;
    }
}

