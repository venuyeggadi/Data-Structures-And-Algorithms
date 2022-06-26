package com.venuyeggadi.problemsolving.leetcode;/* Given an integer n, return the number of trailing zeroes in n!.
   Follow up: Could you write a solution that works in logarithmic time complexity?

 * Example 1:
   Input: n = 3
   Output: 0
   Explanation: 3! = 6, no trailing zero.
 
 * Example 2:
   Input: n = 5
   Output: 1
   Explanation: 5! = 120, one trailing zero.
 * Example 3:
   Input: n = 0
   Output: 0

 * Constraints:
   * 0 <= n <= 104

*/

//#1 Math
/* Intution : We need compute the power of 10 in the given factoril
              i.e., min(power of two, power of 5)

Time : O(log(n))
       As we divide each time by 2 it takes log2(n), and for dividing by five
       it takes log5(n). since log2(n) > log5(n), overall complexity is log2(n) = log(n)

Space : O(1)
       As we are using constant space.
*/

class FactorialTrailingZerosSolution1 {
    public int trailingZeroes(int n) {
        int twos = 0, fives = 0, tempN = n;
        while(tempN > 0) {
            twos += tempN/2;
            tempN /= 2;
        }
        tempN = n;
        while(tempN > 0) {
            fives += tempN/5;
            tempN /= 5;
        }
        
        return Math.min(twos, fives);
    }
}
//actuall log5(n) is always <= log2(n), so just power of 5 is enough.
class FactorialTrailingZerosSolution2 {
    public int trailingZeroes(int n) {
        int fives = 0;
        while(n > 0) {
            fives += n/5;
            n /= 5;
        }
        
        return fives;
    }
}
//which is same as
// n/5 + n/25 + n/125 + ... + n/(5^k)
class FactorialTrailingZerosSolution3 {
    public int trailingZeroes(int n) {
        int count = 0;
        for(int i = 5; i <= n; i = i * 5) {
            count = count + n / i;
        }
        return count;
    }
} 