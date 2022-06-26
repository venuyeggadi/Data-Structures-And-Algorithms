package com.venuyeggadi.problemsolving.leetcode;/* Given an integer array nums, in which exactly two elements appear only
   once and all the other elements appear exactly twice. Find the two elements
   that appear only once. You can return the answer in any order.
   
   You must write an algorithm that runs in linear runtime complexity and uses
   only constant extra space.

 * Example 1:
   Input: nums = [1,2,1,3,2,5]
   Output: [3,5]
   Explanation:  [5, 3] is also a valid answer.
 
 * Example 2:
   Input: nums = [-1,0]
   Output: [-1,0]

 * Example 3:
   Input: nums = [0,1]
   Output: [1,0]

 * Constraints:
   * 2 <= nums.length <= 3 * 104
   * -231 <= nums[i] <= 231 - 1
   * Each integer in nums will appear twice, only two integers will appear once.

*/


import java.util.*;

//#1 HashMap
/*
Algorithm :
    1. count the frequency of each element
    2. return the elements which appeat twice.

Complexity Analysis:
  Time : O(n)
      Two loops. So O(n + n/2) = O(n) since map operations take O(1).
  Space : O(n)
      HashMap of size approaximately n/2.
*/
class SingleNumberIIISolution1 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int[] result = new int[2];
        int i = 0;
        for(Integer num : map.keySet())
            if(map.get(num) == 1)
                result[i++] = num;
        
        return result;
    }
}


//#2 HashSet
/*
Algorithm :
   1. for each element in nums, add to set if already not in the set.
   2. remove if already in the set.
   3. return the two elements left in the set.

Complexity :
   Time : O(n)
   Space : O(n)
*/
class SingleNumberIIISolution2 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num))
                set.remove(Integer.valueOf(num));
            else
                set.add(num);
        }
        
        Iterator<Integer> it = set.iterator();
        int[] result = new int[2];
        int i = 0;
        while(it.hasNext()) {
            result[i++] = it.next().intValue();
        }
        
        return result;
    }
}


//#3 Bit Manipulation
/*
Algorithm :
   1. XOR all the elements in the array so that we will be left with the XOR
      of required two numbers.
   2. Find the right-most index of set bit in the result. This bit is set because
      the numbers have different bits at this index.
   3. Now XOR all the elements which have set bit(1) at this index to get first number
      and XOR all the elements which don't have set bit to get second number.
   4. return the two numbers.

Complexity :
   Time : O(n)
      Two for loops and a while loop which takes maximum of 31 iterations.
      So O(n + n + 31) = O(n)
   Space : O(1)
      As we are using constant space.
*/
class SingleNumberIIISolution3 {
    public int[] singleNumber(int[] nums) {
        int twoXor = 0;
        for(int num : nums)
            twoXor ^= num;
        int i = 0;//right most index of 1
        while((twoXor&1) != 1) {
            i++;
            twoXor = twoXor >> 1;
        }
        int mask = 1 << i;
        int firstNum = 0, secondNum = 0;
        for(int num : nums) {
            if((num&mask) != 0)
                firstNum ^= num;
            else
                secondNum ^= num;
        }
        
        return new int[]{firstNum, secondNum};
    }
}