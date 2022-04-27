/* A robot is located at the top-left corner of a m x n grid
   (marked 'Start' in the diagram below).
   The robot can only move either down or right at any point in time.
   The robot is trying to reach the bottom-right corner of the grid
   (marked 'Finish' in the diagram below).

   How many possible unique paths are there?

 * Example 1:
   Input: m = 3, n = 7
   Output: 28
 
 * Example 2:
   Input: m = 3, n = 2
   Output: 3
   Explanation:
   From the top-left corner, there are a total of 3 ways to reach the
   bottom-right corner:
   1. Right -> Down -> Down
   2. Down -> Down -> Right
   3. Down -> Right -> Down

 * Example 3:
   Input: m = 7, n = 3
   Output: 28
 
 * Example 4:
   Input: m = 3, n = 3
   Output: 6 

 * Constraints:
   * 1 <= m, n <= 100
   * It's guaranteed that the answer will be less than or equal to 2 * 109.

*/


//#1
//O(m*n), O(m*n)
/*
Algorithm :
   * Traverse thought every cell and store the number of ways you can reach to
     that cell.
   * At the end target cell(bottom-right) contains the answer.
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0)
                    paths[i][j] = 1;
                else
                    paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
            }
        }
        
        return paths[m - 1][n - 1];
    }
}


//#2
//O(m-1) or O(n-1), O(1)
/*
Intuition : Observe the below pattern.
   Input: m = 3, n = 2
   Output: 3
   Explanation:
   From the top-left corner, there are a total of 3 ways to reach the
   bottom-right corner:
   1. Right -> Down -> Down
   2. Down -> Down -> Right
   3. Down -> Right -> Down
   So here must take 2 (3-1 = 2) down steps and 1 (2-1 = 1) right steps.
   i.e., m-1 down steps and n-1 right steps in general.
   In total we take m-1 + n-1 = m+n-2 steps.
   So from m+n-2 total steps we choose to take m-1 down steps so that remaining
   will be right steps. we can do this in (m+n-2)C(m-1) steps.
   (or)
   From m+n-2 total steps we choose to take n-1 right steps so that remaining
   will be down steps. we can do this in (m+n-2)C(n-1) steps.

   so the answer will be (m+n-2)C(m-1) or (m+n-2)C(n-1) which are equal since
   nCr = nC(n-r).
   Now the problem is to calculate nCr.
   nCr = n*(n-1)*...(n-(r-1))  /  r*(r-1)*(r-2)*....*2*1
       = n*(n-1)*...(n-r+1)  /  1*2*....*(r-2)*(r-1)*r
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int r = m-1; //or n-1
        if(N-r < r)
            r = N - r;//C(N, r) = C(N, N-r); C = combination
        long numerator = 1, denominator = 1, gcd;
        for(int i = 1; i <= r; i++) {
            numerator *= (N-i+1);
            denominator *= i;
            gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return (int)(numerator/denominator);
    }
    
    static long gcd(long a, long b) {
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
}
//Dividing by gcd on every step to avoid overflow problem in most of the time.
//It doesn't alter the result as however divide them at the end.


//#3 Recursion (TLE)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}