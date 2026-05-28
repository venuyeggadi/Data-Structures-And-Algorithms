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
        int left = 0, sum = 0;

        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                ++left;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

/**
 * Not the optimal solution - just for reference
 * Prefix Sum + Binary Search
 * Time: O(n log n)
 * Space: O(n)
 */
class MinimumSizeSubarraySum_Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int result = n + 1;
        for (int left = 0; left < n; left++) {
            int right = getRightBound(prefixSum, left, n, target);
            if (right != n) {
                result = Math.min(result, right - left + 1);
            }
        }

        return result % (n + 1);
    }

    /** Binary Search */
    private static int getRightBound(int[] prefixSum, int start, int end, int target) {
        int left = start;
        while (start < end) {
            int mid = (start + end) / 2;
            int curSum = prefixSum[mid + 1] - prefixSum[left];
            if (curSum >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}