/* Count the number of prime numbers less than a non-negative number, n.
 
 * Example 1:
   Input: n = 10
   Output: 4
   Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 
 * Example 2:
   Input: n = 0
   Output: 0

 * Example 3:
   Input: n = 1
   Output: 0

 * Constraints:
   * 0 <= n <= 5 * 106
*/


//#1 Brute force : Time Limit Exceeded.
/*
Time : O(n^1.5)
    Outer loop runs n times. isPrime methods worst case is O(n^0.5) (when input is n)
    So overall O(n * n^.5) = O(n^1.5)
Space : O(1)
    As we are using constant space.
*/
public int countPrimes(int n) {
   int count = 0;
   for (int i = 1; i < n; i++) {
      if (isPrime(i)) count++;
   }
   return count;
}

private boolean isPrime(int num) {
   if (num <= 1) return false;
   /* Loop's ending condition is i * i <= num instead of i <= sqrt(num)
      to avoid repeatedly calling an expensive function sqrt(). */
   for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
   }
   return true;
}



//# Sieve Of Eratosthenes
/*
Time : O( n*log(logn) )
    
Space : O(n)
*/

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++)  //Arrays.fill(isPrime, true)
            isPrime[i] = true;
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i)
                isPrime[j] = false;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}