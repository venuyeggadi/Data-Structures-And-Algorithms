package com.venuyeggadi.problemsolving.leetcode;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
   If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], 
   then return 0.
   Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 * Example 1:
   Input: x = 123
   Output: 321
   Example 2:

 * Input: x = -123
   Output: -321
   Example 3:

 * Input: x = 120
   Output: 21
   Example 4:

 * Input: x = 0
   Output: 0
 
 * Constraints:
   -231 <= x <= 231 - 1
 */

//Approach 1
//O(log10(x)), O(1)
class ReverseIntegerSolution1 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

//Approach 2
//O(log10(x)), O(1)
class ReverseIntegerSolution2 {
	public int reverse(int x) {
		
		int rev = 0, temp;
		
		while(x != 0) {
			temp = rev * 10;
			if(temp/10 != rev)
				return 0;
			rev = temp + x%10;
			if(rev - temp != x % 10)
			return 0;
			x = x/10;
        }
        return rev;
    }
}