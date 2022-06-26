package com.venuyeggadi.problemsolving.leetcode;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place
   so that objects of the same color are adjacent, with the colors in the order 
   red, white, and blue.We will use the integers 0, 1, and 2 to represent the color 
   red, white, and blue, respectively.

 * You must solve this problem without using the library's sort function.

 

 * Example 1:
   Input: nums = [2,0,2,1,1,0]
   Output: [0,0,1,1,2,2]
 
 * Example 2:
   Input: nums = [2,0,1]
   Output: [0,1,2]
   
 * Example 3:
   Input: nums = [0]
   Output: [0]

 * Example 4:
   Input: nums = [1]
   Output: [1]

 * Constraints:
   n == nums.length
   1 <= n <= 300
   nums[i] is 0, 1, or 2.
   
 *Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/


//Just like counting sort
// O(n), O(1)
class SortColorsSolution1 {
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i : nums)
        {
            if(i == 0)
                num0++;
            else if(i == 1)
                num1++;
            else
                num2++;
        }
        int i = 0;
        while(i < num0)
            nums[i++] = 0;
        while(i < num0+num1)
            nums[i++] = 1;
        while(i < nums.length)
            nums[i++] = 2;
    }
}

//Dutch national flag algorithm
// O(n), O(1)
class SortColorsSolution2 {
    public void sortColors(int[] nums) {
        int low = 0, i = 0, hi = nums.length - 1;
        int temp;
        while (i <= hi) {
            switch (nums[i]) {
                case 0:
                    temp = nums[low];
                    nums[low] = nums[i];
                    nums[i] = temp;
                    i++;
                    low++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    temp = nums[hi];
                    nums[hi] = nums[i];
                    nums[i] = temp;
                    hi--;
                    break;
            }
        }
    }
}