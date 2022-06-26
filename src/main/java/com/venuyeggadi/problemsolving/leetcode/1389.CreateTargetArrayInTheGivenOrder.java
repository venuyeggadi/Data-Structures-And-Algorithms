package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 1389. Create Target Array in the Given Order
    Given two arrays of integers nums and index. Your task is to create 
    target array under the following rules:
     * Initially target array is empty.
     * From left to right read nums[i] and index[i], insert at index index[i]
       the value nums[i] in target array.
     * Repeat the previous step until there are no elements to read in nums and index.
     * Return the target array.
    It is guaranteed that the insertion operations will be valid.

  * Example 1:
	Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
	Output: [0,4,1,3,2]
	Explanation:
	  nums       index     target
	   0            0        [0]
	   1            1        [0,1]
	   2            2        [0,1,2]
	   3            2        [0,1,3,2]
	   4            1        [0,4,1,3,2]
  
  * Example 2:
    Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
    Output: [0,1,2,3,4]
    Explanation:
	  nums       index     target
	   1            0        [1]
	   2            1        [1,2]
	   3            2        [1,2,3]
	   4            3        [1,2,3,4]
	   0            0        [0,1,2,3,4]

   * Example 3:
     Input: nums = [1], index = [0]
     Output: [1]

   * Constraints:
     * 1 <= nums.length, index.length <= 100
     * nums.length == index.length
     * 0 <= nums[i] <= 100
     * 0 <= index[i] <= i
*/


//#1
//O(n^2), O(n)
class CreateTargetArrayInTheGivenOrderSolution1 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(index[i] >= index[j])
                    index[i]++;
            }
        }
        
        int[] target = new int[n];
        for(int i = 0; i < n; i++)
            target[index[i]] = nums[i];
        
        return target;
    }
}


//#2
//O(n^2), O(n)
class CreateTargetArrayInTheGivenOrderSolution2 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            list.add(index[i], nums[i]);
        
        int[] target = new int[n];
        
        Iterator<Integer> iterator = list.iterator();
        for(int i = 0; i < n; i++)
            target[i] = iterator.next();
        
        return target;
    }
}


//#3
/*
Time Complexity:
   Best Case: O(n), if the indices are in strictly increasing order.
   Worst Case: O(n^2), if the indices are not strictly increasing.
Space Complexity: O(n)
*/
class CreateTargetArrayInTheGivenOrderSolution3 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] target = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j > index[i]; j--)
                target[j] = target[j-1];
            target[index[i]] = nums[i];
        }
        
        return target;
    }
}