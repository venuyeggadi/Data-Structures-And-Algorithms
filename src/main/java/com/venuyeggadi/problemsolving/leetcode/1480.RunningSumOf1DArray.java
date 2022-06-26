package com.venuyeggadi.problemsolving.leetcode;/* Given an array nums. We define a running sum of an array
   as runningSum[i] = sum(nums[0]…nums[i]). Return the running sum of nums.

 * Example 1:
   Input: nums = [1,2,3,4]
   Output: [1,3,6,10]
   Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 
 * Example 2:
   Input: nums = [1,1,1,1,1]
   Output: [1,2,3,4,5]
   Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 
 * Example 3:
   Input: nums = [3,1,2,10,1]
   Output: [3,4,6,16,17]

 * Constraints:
   * 1 <= nums.length <= 1000
   * -10^6 <= nums[i] <= 10^6

*/

//#1
//O(n), O(1)
class RunningSumOf1DArraySolution1 {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i-1];
        
        return nums;
    }
}

//#2
//O(n), O(1)
class RunningSumOf1DArraySolution2 {
    public int[] runningSum(int[] nums) {
    	int prevSum = 0;
        for(int i = 0; i < nums.length; i++) {
            nums[i] += prevSum;
            prevSum = nums[i];
        }
        
        return nums;
    }
}



//#3 same as #1, but here we don't change the original array.
/**
 * Time complexity: O(n) where n is the length of the input array.
      This is because we use a single loop that iterates over the entire
      array to calculate the running sum.
 * Space complexity: O(1) since we don't use any additional space to find the
      running sum. Note that we do not take into consideration the space
      occupied by the output array.
*/
class RunningSumOf1DArraySolution3 {
public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            result[i] = result[i - 1] + nums[i];
        return result;
    }
}

