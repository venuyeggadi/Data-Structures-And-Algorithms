package com.venuyeggadi.problemsolving.leetcode;

/** 53. Maximum Subarray
    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.

  * Example 1:
	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
	
  * Example 2:
	Input: nums = [1]
	Output: 1
	
  * Example 3:
	Input: nums = [5,4,-1,7,8]
	Output: 23
	
  * Constraints:
	* 1 <= nums.length <= 105
	* -104 <= nums[i] <= 104
	* Follow up: If you have figured out the O(n) solution, try coding another solution
	  using the divide and conquer approach, which is more subtle.
*/


import java.util.Arrays;

/**
 * Bruteforce - (Time Limit Exceeded)
 * O(n^3), O(1)
 */
class MaximumSubarray_Solution1 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, sum(i, j, nums));
            }
        }

        return max;
    }

    private int sum(int start, int end, int[] arr) {
        int sum = 0;
        for (int i = start; i <= end; i++)
            sum += arr[i];

        return sum;
    }
}

/**
 * Bruteforce without 3rd loop - (Time Limit Exceeded)
 * O(n^2), O(1)
 */
class MaximumSubarray_Solution2 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}

/**
 * Prefix Sum - (Time Limit Exceeded)
 * O(n^2), O(1)
 */
class MaximumSubarray_Solution3 {
    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] = nums[i] + nums[i - 1];

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, sum(i, j, nums));
            }
        }

        return max;
    }

    private int sum(int start, int end, int[] arr) {
        if (start == 0)
            return arr[end];

        return arr[end] - arr[start - 1];
    }
}

/**
 * Kadane's
 * (n), O(1)
 */
class MaximumSubarray_Solution4 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];

        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) /** Resetting sum. Because negative sum doesn't contribute for a max sum. And max sum till that point is already captured. */
                sum = 0;
        }
        
        return max;
    }
}

// Same solution
class MaximumSubarray_Solution4_Way2 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];

        for (int num : nums) {
            sum = Math.max(sum + num, num); /** Sets sum to num if sum < 0. Same as re-setting sum to 0 if it's < 0. Think like. should include previous with sum with the current num or start over from current num */
            max = Math.max(max, sum);
        }
        
        return max;
    }
}

/** If we want the indices */
class MaximumSubarray_Solution4_Indices {
    public int maxSubArray(int[] nums) {
        int max = nums[0], maxL = 0, maxR = 0;
        int currSum = 0, l = 0, r = 0;

        for (r = 0; r < nums.length; r++) {
            currSum += nums[r];
            if (currSum > max) {
                max = currSum;
                maxL = l;
                maxR = r;
            }
            if (currSum < 0) {
                currSum = 0;
                l = r + 1;
            }
        }

        System.out.println(maxL + ", " + maxR);

        return max;
    }
}


/**
 * Divide and Conquer
 *
 * Time: O(n log n)
 *      T(n) = 2 T(n/2) + n
 *      T(n) = 2^logn * T(1) + n log n
 *      T(n) = n + n log n
 *
 *
 */
class MaximumSubarray_Solution5 {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private static int maxSubArray(int[] nums, int start, int end) {
        if (start > end)
            return Integer.MIN_VALUE;

        int mid = start + (end - start) / 2;

        int maxFromLeftArray = maxSubArray(nums, start, mid - 1);
        int maxFromRightArray = maxSubArray(nums, mid + 1, end);
        int maxOnEitherSide = Math.max(maxFromLeftArray, maxFromRightArray);

        int runningSum = 0;
        int maxRunningSumToLeft = 0;
        for (int i = mid - 1; i >= start; --i) {
            runningSum += nums[i];
            maxRunningSumToLeft = Math.max(maxRunningSumToLeft, runningSum);
        }

        runningSum = 0;
        int maxRunningSumToRight = 0;
        for (int i = mid + 1; i <= end; ++i) {
            runningSum += nums[i];
            maxRunningSumToRight = Math.max(maxRunningSumToRight, runningSum);
        }

        int maxSpreadingFromMiddle = nums[mid] + maxRunningSumToLeft + maxRunningSumToRight;

        return Math.max(maxOnEitherSide, maxSpreadingFromMiddle);
    }
}


/** Dynamic Programming approaches */

/**
 * Recursion
 *
 * Time: O(2^n)
 * Space: O(n)
 */
class MaximumSubarray_Solution6 {
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, false);
    }

    private static int dfs(int[] nums, int i, boolean inMiddle) {
        if (i == nums.length)
            return inMiddle ? 0 : Integer.MIN_VALUE;

        if (inMiddle) {
            /** Either end here OR include current element and continue to include next elements */
            return Math.max(0, nums[i] + dfs(nums, i + 1, true));
            /** More intuitive but fails for nums = [-1, -2] */
            // OR  return Math.max(nums[i], nums[i] + dfs(nums, i + 1, true));
        }

        /** Either start from current element and continue to include next elements OR Start from next element */
        return Math.max(nums[i] + dfs(nums, i + 1, true), dfs(nums, i + 1, false));
    }
}

// By inverting the flag
class MaximumSubarray_Solution6_Way2 {
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, true);
    }

    private static int dfs(int[] nums, int i, boolean start) {
        if (i == nums.length)
            return start ? Integer.MIN_VALUE : 0;

        if (start) {
            return Math.max(nums[i] + dfs(nums, i + 1, false), dfs(nums, i + 1, true));
        }

        return Math.max(0, nums[i] + dfs(nums, i + 1, false));
    }
}


/**
 * Dynamic Programming - Memoization (Top-down)
 * Time: O(n)
 * Space: O(n)
 */
class MaximumSubarray_Solution7 {
    public int maxSubArray(int[] nums) {
        int[][] memo = new int[nums.length][2];
        for (int[] arr : memo)
            Arrays.fill(arr, Integer.MIN_VALUE);

        return dfs(nums, 0, false, memo);
    }

    private int dfs(int[] nums, int i, boolean inMiddle, int[][] memo) {
        if (i == nums.length) {
            return inMiddle ? 0 : (int) -1e6;
        }

        if (inMiddle) {
            if (memo[i][1] != Integer.MIN_VALUE)
                return memo[i][1];
            memo[i][1] = Math.max(0, nums[i] + dfs(nums, i + 1, true, memo));
            return memo[i][1];
        }

        if (memo[i][0] != Integer.MIN_VALUE)
            return memo[i][0];
        memo[i][0] = Math.max(dfs(nums, i + 1, false, memo), nums[i] + dfs(nums, i + 1, true, memo));
        return memo[i][0];
    }
}

/**
 * Dynamic Programming - Tabulation (Bottom-up)
 * Time: O(n)
 * Space: O(n)
 */
class MaximumSubarray_Solution8 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = Integer.MIN_VALUE;
        dp[n][1] = 0;

        for (int i = n - 1; i >= 0; --i) {
            dp[i][0] = Math.max(nums[i] + dp[i + 1][1], dp[i + 1][0]);
            dp[i][1] = Math.max(0, nums[i] + dp[i + 1][1]);
        }

        return dp[0][0];
    }
}

/**
 * Dynamic Programming - Tabulation (Bottom-up) - Space Optimized
 * Time: O(n)
 * Space: O(1)
 */
class MaximumSubarray_Solution9 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][2];
        dp[1][0] = Integer.MIN_VALUE;
        dp[1][1] = 0;

        for (int i = n - 1; i >= 0; --i) {
            dp[0][0] = Math.max(nums[i] + dp[1][1], dp[1][0]);
            dp[0][1] = Math.max(0, nums[i] + dp[1][1]);
            dp[1][0] = dp[0][0];
            dp[1][1] = dp[0][1];
        }

        return dp[0][0];
    }
}
