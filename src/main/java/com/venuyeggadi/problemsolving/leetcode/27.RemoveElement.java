package com.venuyeggadi.problemsolving.leetcode;/* Given an integer array nums and an integer val, remove all occurrences of val
   in nums in-place. The relative order of the elements may be changed.
   Since it is impossible to change the length of the array in some languages, you
   must instead have the result be placed in the first part of the array nums.
   More formally, if there are k elements after removing the duplicates, then the
   first k elements of nums should hold the final result. It does not matter what
   you leave beyond the first k elements.
   Return k after placing the final result in the first k slots of nums.
   Do not allocate extra space for another array. You must do this by modifying the
   input array in-place with O(1) extra memory.

 * Custom Judge:
   The judge will test your solution with the following code:
   int[] nums = [...]; // Input array
   int val = ...; // Value to remove
   int[] expectedNums = [...]; // The expected answer with correct length.
                               // It is sorted with no values equaling val.
   int k = removeElement(nums, val); // Calls your implementation
   assert k == expectedNums.length;
   sort(nums, 0, k); // Sort the first k elements of nums
   for (int i = 0; i < actualLength; i++) {
   		assert nums[i] == expectedNums[i];
   }
   If all assertions pass, then your solution will be accepted.

 * Example 1:
   Input: nums = [3,2,2,3], val = 3
   Output: 2, nums = [2,2,_,_]
   Explanation: Your function should return k = 2, with the first two elements of nums being 2.
   It does not matter what you leave beyond the returned k (hence they are underscores).
 
 * Example 2:
   Input: nums = [0,1,2,2,3,0,4,2], val = 2
   Output: 5, nums = [0,1,4,0,3,_,_,_]
   Explanation: Your function should return k = 5, with the first five elements of nums containing
   0, 0, 1, 3, and 4.

   Note that the five elements can be returned in any order.
   It does not matter what you leave beyond the returned k (hence they are underscores).

 * Constraints:
   * 0 <= nums.length <= 100
   * 0 <= nums[i] <= 50
   * 0 <= val <= 100
*/

//#1 Bruteforce
//O(n^2), O(1)
class RemoveElementSolution1 {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[pointer] == val)
                leftShiftFrom(nums, pointer+1);
            else
                pointer++;
        }
        
        return pointer;
    }
    
    static void leftShiftFrom(int[] nums, int index) {
        for(int i = index; i < nums.length; i++)
            nums[i-1] = nums[i];
    }
}


//#2 Two pointer
//O(n), O(1)
class RemoveElementSolution2 {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for(int num : nums) {
            if(num != val)
                nums[pointer++] = num;
        }
        
        return pointer;
    }
}


//#2 Two pointers - when elements to remove are rare.
/* Intuition
   Now consider cases where the array contains few elements to remove. For example,
   nums = [1,2,3,5,4], val = 4. The previous algorithm will do unnecessary copy
   operation of the first four elements. Another example is nums = [4,1,2,3,5], val = 4.
   It seems unnecessary to move elements [1,2,3,5] one step left as the problem
   description mentions that the order of elements could be changed.

   Algorithm
   When we encounter nums[i] = val, we can swap the current element out with the
   last element and dispose the last one. This essentially reduces the array's size by 1.

   Note that the last element that was swapped in could be the value you want to remove itself.
   But don't worry, in the next iteration we will still check this element.
*/
//O(n), O(1)
class RemoveElementSolution3 {
    public int removeElement(int[] nums, int val) {
        int startIndex = 0;
        int endIndex = nums.length-1;
        while(startIndex <= endIndex) {
            if(nums[startIndex] == val)
                nums[startIndex] = nums[endIndex--];
            else
                startIndex++;
        }
        
        return startIndex; //or return endIndex + 1
    }
}