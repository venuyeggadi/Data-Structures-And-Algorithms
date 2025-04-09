package com.venuyeggadi.problemsolving.leetcode;

/** Given an integer array nums of length n, you want to create an array ans of length 2n
    where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
    Specifically, ans is the concatenation of two nums arrays.
    Return the array ans.

  * Example 1:
    Input: nums = [1,2,1]
    Output: [1,2,1,1,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
    - ans = [1,2,1,1,2,1]

  * Example 2:
    Input: nums = [1,3,2,1]
    Output: [1,3,2,1,1,3,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
    - ans = [1,3,2,1,1,3,2,1]

  * Constraints:
    * n == nums.length
    * 1 <= n <= 1000
    * 1 <= nums[i] <= 1000
*/


//#1
//O(n), O(n)
class ConcatenationOfArraySolution1 {
    public int[] getConcatenation(int[] nums) {
        int[] concatenatedArray = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            concatenatedArray[i] = nums[i];
            concatenatedArray[nums.length + i] = nums[i];
        }

        return concatenatedArray;
    }
}

//#2 Same as above but with built-in function
//
/**
 System.arraycopy() is highly optimized for copying data, specifically for arrays.
 The underlying native implementation is written in a low-level language (like C or C++),
 which can directly manipulate memory,perform optimizations like using efficient memory copying algorithms, and reduce overhead.

 It's a 'native' (also has native keyword) function and implemented in another language using JNI (Java Native Interface).
 */
//
//O(n), O(n)
class ConcatenationOfArraySolution2 {
    public int[] getConcatenation(int[] nums) {
        int[] concatenatedArray = new int[2 * nums.length];
        System.arraycopy(nums, 0, concatenatedArray, 0, nums.length);
        System.arraycopy(nums, 0, concatenatedArray, nums.length, nums.length);

        return concatenatedArray;
    }
}