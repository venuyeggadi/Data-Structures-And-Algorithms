package com.venuyeggadi.problemsolving.leetcode;/* Given an integer array nums sorted in non-decreasing order, return an array
   of the squares of each number sorted in non-decreasing order.

 * Example 1:
   Input: nums = [-4,-1,0,3,10]
   Output: [0,1,9,16,100]
   Explanation: After squaring, the array becomes [16,1,0,9,100].
   After sorting, it becomes [0,1,9,16,100].

 * Example 2:
   Input: nums = [-7,-3,2,3,11]
   Output: [4,9,9,49,121]

 * Constraints:
   * 1 <= nums.length <= 104
   * -104 <= nums[i] <= 104
   * nums is sorted in non-decreasing order.

 * Follow up: Squaring each element and sorting the new array is very trivial,
   could you find an O(n) solution using a different approach?
*/

//#1
//O(n), O(1)(not taking result array into consideration)
class SquaresOfASortedArraySolution1 {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        while(i < nums.length && nums[i] < 0) {
            nums[i] = -nums[i];
            i++;
        }
        
        int[] ans = new int[nums.length];
        i = nums.length - 1;
        int start = 0, end = nums.length - 1;
        while(start <= end) { //or i >= 0
            if(nums[start] >= nums[end]) {
                ans[i] = nums[start] * nums[start];
                start++;
            }
            else {
                ans[i] = nums[end] * nums[end];
                end--;
            }
                
            i--;
        }
        
        return ans;
    }
}


//same as above but without modifying the original array
class SquaresOfASortedArraySolution2 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = nums.length - 1;
        int start = 0, end = nums.length - 1;
        
        while(start <= end) { //or i >= 0
            if(Math.abs(nums[start]) >= Math.abs(nums[end])) { // or nums[start]*nums[start] >= nums[end]*nums[end]
                ans[i--] = nums[start] * nums[start];
                start++;
            }
            else {
                ans[i--] = nums[end] * nums[end];
                end--;
            }
        }
        
        return ans;
    }
}