package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

/**
 * Given a non-empty array of integers nums, every element appears twice
   except for one. Find that single one.

 * You must implement a solution with a linear runtime complexity and use
   only constant extra space. O(n), O(1)

 * Example 1:
   Input: nums = [2,2,1]
   Output: 1

 * Example 2:
   Input: nums = [4,1,2,1,2]
   Output: 4
 
 * Example 3:
   Input: nums = [1]
   Output: 1
 
 * Constraints:
   *  1 <= nums.length <= 3 * 104
   * -3 * 104 <= nums[i] <= 3 * 104
   * Each element in the array appears twice except for one element which appears only once.
 */



//#1 Using Hash table (HashMap)
/* We use hash table to avoid the O(n)O(n) time required for searching the elements.
   * Iterate through all elements in nums and set up key/value pair.
   * Return the element which appeared only once.

Complexity Analysis
Time complexity : O(n * 1) = O(n).
   Time complexity of for loop is O(n).
   Time complexity of hash table(dictionary in python, HashMap in java) operation pop is O(1).
Space complexity : O(n).
   The space required by hash table is equal to the number of elements in \nums.
*/
class SingleNumberSolution1 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int key : nums) {
            if(map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        for(Integer key : map.keySet()) {
            if(map.get(key) == 1)
                return key;
        }
        
        return 0;//for compiler
    }
}

//same with better code
class SingleNumberSolution2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int key : nums)
        	map.put(key, map.getOrDefault(key, 0) + 1);

        for(Integer key : map.keySet()) {
            if(map.get(key) == 1)
                return key;
        }
        
        return 0;//for compiler
    }
}


//#2 1: List operation
/* Algorithm:
   * Iterate over all the elements in nums
   * If some number in nums is new to array, append it
   * If some number is already in the array, remove it
   we will be left with answer

Complexity Analysis
Time complexity : O(n^2)
   We iterate through all nums, taking O(n) time. We search the whole list to
   find whether there is duplicate number, taking O(n) time. Because search
   is in the for loop, so we have to multiply both time complexities which is O(n^2).
Space complexity : O(n)
   We need a list of size n to contain elements in nums.
*/
class SingleNumberSolution3 {
    public int singleNumber(int[] nums) {
        List<Integer> uniqueList = new LinkedList<>();//or an ArrayList
        
        for(int i : nums) {
            if(uniqueList.contains(i))
                uniqueList.remove(Integer.valueOf(i));
            else
                uniqueList.add(i);
        }
        
        return uniqueList.get(0);
    }
}



//#3 Set
/*
 * Algorithm:
   * Iterate over all the elements in nums
   * If some number in nums is new to the set, add it.
   * If some number is already in the set, remove it
   we will be left with answer

Complexity Analysis
  Time complexity : O(n).
      for iterating thorough array O(n) and it takes O(1) for adding and
      removing elements. So overall O(n).
  Space complexity : O(n). set needs space for the elements in nums
*/
class SingleNumberSolution4 {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int i : nums) {
        if(set.contains(i))
            set.remove(Integer.valueOf(i));
        else
            set.add(i);
    }
    return set.iterator().next().intValue();
  }
}



//#4 Math
/* concept:
   2*(a + b + c) - (a + b + c + a + b) = c
   ie., 2*sumOfUniqueNumbers - totalSum gives the number which occurs once.

Complexity Analysis
Time complexity : O(n). for iterating thorough array.
Space complexity : O(n). set needs space for the elements in nums
*/
class SingleNumberSolution5 {
    public int singleNumber(int[] nums) {
        int totalSum = 0;
        int uniqueSum = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            totalSum += num;
            if(!set.contains(num)) {
                uniqueSum += num;
                set.add(num);
            }
        }
        
        return 2*uniqueSum - totalSum;
    }
}


//#5 Bit Manipulation
/*
Concept:
 * If we take XOR of zero and some bit, it will return that bit
   a xor 0 = a
 * If we take XOR of two same bits, it will return 0
   a xor a = 0
 * a xor b xor a = (a xor a) xor b = 0 xor b = b
 So we can XOR all bits together to find the unique number.

Complexity Analysis
Time complexity : O(n).
  * We only iterate through nums, so the time complexity
    is the number of elements in nums.
Space complexity : O(1).
*/
class SingleNumberSolution6 {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for(int i : nums)
            answer = answer ^ i;
        
        return answer;
    }
}


//#6 XOR with Divide and Conquer
/*
Time complexiy: O(log(n))
Space complexity : O(log(n))
*/
class SingleNumberSolution7 {
    public int singleNumber(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    static int helper(int[] nums, int start, int end) {
        if(start - end + 1 == 1)
            return nums[start]; //or end
        if(start - end + 1 == 2)
            return nums[start] ^ nums[end];
        
        return helper(nums, start, (start+end)/2) ^ helper(nums, (start+end)/2+1, end);
    }
}


//#7 Brute Force
/*
Time complexity: O(n*log(n))
   n*log(n) + n = n*log(n)

Space complexity: O(1);
*/
class SingleNumberSolution8 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i+=2) {
            if(nums[i] != nums[i-1])
                return nums[i-1];
        }

        return nums[nums.length - 1];
    }
}