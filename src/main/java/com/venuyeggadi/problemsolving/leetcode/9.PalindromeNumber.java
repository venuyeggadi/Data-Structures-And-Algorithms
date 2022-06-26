package com.venuyeggadi.problemsolving.leetcode;/* Given an integer x, return true if x is palindrome integer.
   An integer is a palindrome when it reads the same backward as forward.
   For example, 121 is palindrome while 123 is not.

 * Example 1:
   Input: x = 121
   Output: true

 * Example 2:
   Input: x = -121
   Output: false
   Explanation: From left to right, it reads -121. From right to left,
   it becomes 121-. Therefore it is not a palindrome.
 
 * Example 3:
   Input: x = 10
   Output: false
   Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 * Example 4:
   Input: x = -101
   Output: false

 * Constraints:
   * -231 <= x <= 231 - 1
 
 Follow up: Could you solve it without converting the integer to a string?
 */

//#1 Reversing and equating
/* 
Time Complexity : O(log10(x))
   since loop runs log(x) base 10 times.
Space Complexity : O(1)
*/
class PalindromeNumberSolution1 {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int rev = 0, xTemp = x;
        while(xTemp > 0) {
            rev = rev * 10 + xTemp%10;
            xTemp /= 10;
        }
        
        return rev == x;
    }
}

//or just reverse half of the number
class PalindromeNumberSolution2 {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        /* When the length is an odd number, we can get rid of the middle
           digit of original number by revertedNumber/10 since it contains
           an extra digit */ 
        
        return x == revertedNumber || x == revertedNumber/10;
    }
}


//#2 Converting to a character array
/*
Time : O(log10(x))
   O(log10(x) + log10(x)) = O(log10(x)) since it takes O(log10(x)) to convert
   to char array and another O(log10(x)) for traversing the array

Space : O(log10(x)) for array
*/
class PalindromeNumberSolution3 {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        char[] charArr = String.valueOf(x).toCharArray();
        for(int i = 0; i < charArr.length/2; i++) {
            if(charArr[i] != charArr[charArr.length - 1 - i])
                return false;
        }
        
        return true;
    }
}

//#using string builder
/*
Time : O(log10(x))
   since reverse method takes O(n) which in this case is O(log10(x)).
Space : O(log10(x)) for string and string builder.
*/
class PalindromeNumberSolution4 {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder(xStr);
        
        return xStr.equals(sb.reverse().toString());
    }
}