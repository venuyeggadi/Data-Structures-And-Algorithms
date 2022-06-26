package com.venuyeggadi.problemsolving.leetcode;/* Given an array, rotate the array to the right by k steps, where k is non-negative.
 
 * Example 1:
   Input: nums = [1,2,3,4,5,6,7], k = 3
   Output: [5,6,7,1,2,3,4]
   Explanation:
   rotate 1 steps to the right: [7,1,2,3,4,5,6]
   rotate 2 steps to the right: [6,7,1,2,3,4,5]
   rotate 3 steps to the right: [5,6,7,1,2,3,4]

 * Example 2:
   Input: nums = [-1,-100,3,99], k = 2
   Output: [3,99,-1,-100]
   Explanation: 
   rotate 1 steps to the right: [99,-1,-100,3]
   rotate 2 steps to the right: [3,99,-1,-100]

 * Constraints:
   * 1 <= nums.length <= 105
   * -231 <= nums[i] <= 231 - 1
   * 0 <= k <= 105

 * Follow up:
   Try to come up with as many solutions as you can. There are at least three different
   ways to solve this problem.
   Could you do it in-place with O(1) extra space?

*/

//#1
/*
Complexity:
   Time: O(n)
   Space: O(n)
*/
class RotateArraySolution1 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;// no need
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++)
            result[(i+k)%n] = nums[i];
        for(int i = 0; i < n; i++)
            nums[i] = result[i];
    }
}

//#2
/*
Complexity:
   Time: O(n)
   Space: O(1)
*/
class RotateArraySolution2 {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        /*The above line is must in order to avoid index out of bounds
          exception for last two method calls when k > num.length */
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    static void reverse(int[] nums, int start, int end) {
        int temp;
        while(start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}