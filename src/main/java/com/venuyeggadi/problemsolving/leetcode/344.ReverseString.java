package com.venuyeggadi.problemsolving.leetcode;
/*
 * 344. Reverse String
 * Write a function that reverses a string. The input string is given as an
   array of characters s.
 
 * Example 1:
   Input: s = ["h","e","l","l","o"]
   Output: ["o","l","l","e","h"]
 
 * Example 2:
   Input: s = ["H","a","n","n","a","h"]
   Output: ["h","a","n","n","a","H"]

 * Constraints:
   * 1 <= s.length <= 105
   * s[i] is a printable ascii character.
 
 * Follow up: Do not allocate extra space for another array. You must do this by
   modifying the input array in-place with O(1) extra memory.
 */

//#1
/* Time : O(n)
     for n/2 swaps
   Space: O(1)
*/
class ReverseStringSolution1 {
    public void reverseString(char[] s) {
        char temp;
        int n = s.length;
        for(int i = 0; i < n/2; i++) {
            temp = s[i];
            s[i] = s[n - 1 - i];
            s[n -1 - i] = temp;
        }
    }
}


//#2
/* Time : O(n)
     for n/2 method calls
   Space : O(n)
   to store n/2 method calls in stack
*/
class ReverseStringSolution2 {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        reverse(s, start, end);
    }
    
    public void reverse(char[] s, int start, int end) {
        if(start >= end)
            return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        reverse(s, start + 1, end - 1);
    }

    /* just another way of returning from a void method
    public void reverse(char[] s, int start, int end) {
        if(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            reverse(s, start + 1, end - 1);
        }
    }
    */

    /* by passing a single extra variable
    public void reverse(char[] s, int index) {
        int length = s.length;
        if (index >= length / 2)
            return;

        char temp = s[index];
        s[index] = s[length - 1 - index];
        s[length - 1 - index] = temp;

        reverse(index + 1, s);
    }
    */
}


//#3
//Two pointer approach
//Generalization of approach #1
// O(n), O(1)
class ReverseStringSolution3 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}