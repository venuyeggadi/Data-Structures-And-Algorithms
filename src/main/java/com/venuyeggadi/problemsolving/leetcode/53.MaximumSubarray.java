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


/**
 * (Time Limit Exceeded)
 * O(n^3), O(1)
 */
class MaximumSubarray_Solution0 {
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
 * (Time Limit Exceeded)
 * O(n^2), O(1)
 */
class MaximumSubarray_Solution1Way1 {
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
 * (Time Limit Exceeded)
 * Prefix sum
 * O(n^2), O(1)
 */
class MaximumSubarray_Solution1Way2 {
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
class MaximumSubarray_Solution2 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for(int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if(sum < 0) /** Resetting sum. Because negative sum doesn't contribute for a max sum. And max sum till that point is already captured. */
                sum = 0;
        }
        
        return max;
    }
}

// Same solution
class MaximumSubarray_Solution2_Way2 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for(int num : nums) {
            sum = Math.max(sum+num, num); /** Sets sum to num if sum < 0. Same as re-setting sum to 0 if it's < 0. */
            max = Math.max(max, sum);
        }
        
        return max;
    }
}

// If we want the indices
class MaximumSubarray_Solution2_Indices {
    public int maxSubArray(int[] nums) {
        int max = nums[0], maxL = 0, maxR = 0;
        int currSum = 0, l = 0, r = 0;

        for (r = 0; r < nums.length; r++) {
            if (currSum < 0) {
                currSum = 0;
                l = r;
            }
            currSum += nums[r];
            if (currSum > max) {
                max = currSum;
                maxL = l;
                maxR = r;
            }
        }

        System.out.println(maxL +", "+ maxR);

        return max;
    }
}