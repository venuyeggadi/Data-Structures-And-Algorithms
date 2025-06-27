package com.venuyeggadi.problemsolving.leetcode;


/**
 * Bruteforce
 * Time: O(n^2)
 * Space: O(1)
 */
class MinimumSizeSubarraySum_Solution1 {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

/**
 * Sliding Window
 * Time: O(n)
 * Space: O(1)
 */
class MinimumSizeSubarraySum_Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = nums[0];

        while (right < nums.length) {
            if (sum >= target)
                min = Math.min(min, right - left + 1);

            if (sum >= target) {
                sum = sum - nums[left];
                left++;
            } else {
                if (right < nums.length - 1) {
                    right = right + 1;
                    sum = sum + nums[right];
                }
                else
                    break;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

/**
 * Sliding Window
 * Time: O(n)
 * Space: O(1)
 */
class MinimumSizeSubarraySum_Solution2_Better {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

