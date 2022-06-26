package com.venuyeggadi.problemsolving.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/** 66. Plus One
    You are given a large integer represented as an integer array digits, where each digits[i]
    is the ith digit of the integer. The digits are ordered from most significant to least
    significant in left-to-right order. The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits.

  * Example 1:
    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Incrementing by one gives 123 + 1 = 124.
    Thus, the result should be [1,2,4].

  * Example 2:
    Input: digits = [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    Incrementing by one gives 4321 + 1 = 4322.
    Thus, the result should be [4,3,2,2].

  * Example 3:
    Input: digits = [0]
    Output: [1]
    Explanation: The array represents the integer 0.
    Incrementing by one gives 0 + 1 = 1.
    Thus, the result should be [1].
    
  * Example 4:
    Input: digits = [9]
    Output: [1,0]
    Explanation: The array represents the integer 9.
    Incrementing by one gives 9 + 1 = 10.
    Thus, the result should be [1,0].
 
  * Constraints:
    * 1 <= digits.length <= 100
    * 0 <= digits[i] <= 9
    * digits does not contain any leading 0's.
*/


//#1
//O(n), O(n)
class PlusOneSolution1 {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 1, sum;
        for(int i = digits.length-1; i >= 0; i--) {
            list.addFirst((digits[i]+carry)%10);
            carry = (digits[i]+carry)/10;
        }
        
        while(carry > 0) {
            list.addFirst(carry%10);
            carry /= 10;
        }
        
        int n = list.size();
        int[] ans = new int[n];
        Iterator<Integer> it = list.iterator();
        for(int i = 0; i < n; i++)
            ans[i] = it.next();
        
        return ans;
            
    }
}


//#2
//O(n), O(1)
class PlusOneSolution2 {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        
        int[] ans = new int[digits.length+1]; //[0,0,...,0,0,0]
        ans[0] = 1; //[1,0,0,...,0,0,0]
        
        return ans;
    }
}