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


//#1 (Time Limit Exceeded)
//O(n^2), O(1)
class MaximumSubarraySolution1 {
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

//#2
//O(n), O(1)
class MaximumSubarraySolution2 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for(int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if(sum < 0)
                sum = 0;
        }
        
        return max;
    }
}
//same solution
class MaximumSubarraySolution3 {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for(int num : nums) {
            sum = Math.max(sum+num, num);
            max = Math.max(max, sum);
        }
        
        return max;
    }
}