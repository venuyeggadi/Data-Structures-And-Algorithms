package com.venuyeggadi.problemsolving.leetcode;/* Given integer array nums, return the third maximum number in this array.
   If the third maximum does not exist, return the maximum number.

 * Example 1:
   Input: nums = [3,2,1]
   Output: 1
   Explanation: The third maximum is 1.
 
 * Example 2:
   Input: nums = [1,2]
   Output: 2
   Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

 * Example 3:
   Input: nums = [2,2,3,1]
   Output: 1
   Explanation: Note that the third maximum here means the third maximum distinct number.
   Both numbers with value 2 are both considered as second maximum.

 * Constraints:
   * 1 <= nums.length <= 104
   * -2^31 <= nums[i] <= 2^31 - 1
 
 *Follow up: Can you find an O(n) solution?
*/

import java.util.HashSet;
import java.util.Set;

//#1 Bruteforce
//O(n), O(n)
class ThirdMaximumNumberSolution1 {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        int n = set.size();
        int[] uniqueNums = new int[n];
        int k = 0;
        for(int num : set)
            uniqueNums[k++] = num;
        
        int temp;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n-1-i; j++) {
                if(uniqueNums[j] > uniqueNums[j+1]) {
                    temp = uniqueNums[j];
                    uniqueNums[j] = uniqueNums[j+1];
                    uniqueNums[j+1] = temp;
                }
            }
        }
        
        if(n < 3)
            return uniqueNums[n-1];
        
        return uniqueNums[n-3];
    }
}