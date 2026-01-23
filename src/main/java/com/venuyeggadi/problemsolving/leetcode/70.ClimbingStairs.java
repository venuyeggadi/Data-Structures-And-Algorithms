package com.venuyeggadi.problemsolving.leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *      Input: n = 2
 *      Output: 2
 *      Explanation: There are two ways to climb to the top.
 *      1. 1 step + 1 step
 *      2. 2 steps
 *
 * Example 2:
 *      Input: n = 3
 *      Output: 3
 *      Explanation: There are three ways to climb to the top.
 *      1. 1 step + 1 step + 1 step
 *      2. 1 step + 2 steps
 *      3. 2 steps + 1 step
 *
 * Constraints:
 *      1 <= n <= 45
 */


/**
 * Recursion
 *
 * Intuition
 *      At every step, you have two choices:
 *      * climb 1 step
 *      * climb 2 steps
 *      So from any step i, the number of ways to reach the top is:
 *          ways to reach from i + 1 plus ways to reach from i + 2.
 *      This naturally forms a binary recursion tree where we try all possible paths.
 *      As a base case, If we land exactly on step n, that path counts as 1 valid way
 *      If we cross n, it’s an invalid path
 *      This is a classic example of exploring all possibilities using recursion.
 *
 * Time: O(2^n)
 * Space: O(n)
 */
class ClimbingStairs_Solution1 {
    public int climbStairs(int n) {
        return dfs(1, n) + dfs(2, n);
    }

    private int dfs(int stair, int lastStair) {
        if (stair > lastStair)
            return 0;
        if (stair == lastStair)
            return 1;

        return dfs(stair + 1, lastStair) + dfs(stair + 2, lastStair);
    }
}

class ClimbingStairs_Solution1_Way2 {
    public int climbStairs(int n) {
        return dfs(0, n);
    }

    private int dfs(int stair, int lastStair) {
        if (stair > lastStair)
            return 0;
        if (stair == lastStair)
            return 1;

        return dfs(stair + 1, lastStair) + dfs(stair + 2, lastStair);
    }
}

/**
 * Dynamic Programming (Top-Down)
 * Time: O(n)
 * Space: O(n)
 */
class ClimbingStairs_Solution2 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];

        return dfs(0, n, memo);
    }

    private int dfs(int stair, int lastStair, int[] memo) {
        if (stair > lastStair)
            return 0;
        if (stair == lastStair)
            return 1;

        if (memo[stair] != 0)
            return memo[stair];

        memo[stair] = dfs(stair + 1, lastStair, memo) + dfs(stair + 2, lastStair, memo);

        return memo[stair];
    }
}

/**
 * Dynamic Programming (Bottom-Up)
 * Intuition
 *      To reach step i, you can only come from:
 *        *  step i - 1 (1 step)
 *        * step i - 2 (2 steps)
 *      So the total ways to reach step i is the sum of ways to reach the previous two steps.
 *      This forms a Fibonacci-like pattern.
 */

/**
 * Intuition
 * N = 1 ==> There is only 1 way to climb 1 stair;
 * N = 2 ==> There are 2 ways to climb 2 stairs: 1, 1 stairs; 2 stairs at a time
 * What if N = 3?
 *      We can only climb 1 stair or 2 stairs for the first step.
 *      If we climb 1 stair, we have 2 stairs left, which is the situation for "N = 2", which is 2 ways;
 *      and if we climb 2 stairs, we have 1 stair left, which is the situation for "N = 1", which is 1 way.
 *      So total 2 + 1 = 3 ways
 * N = 4?
 *      Again, we can only climb 1 stair or 2 stairs for the first step.
 *      If we climb 1 stair, we will have 3 stairs left, which is the situation for "N = 3", which is 3 ways;
 *      and if we climb 2 stairs, we will have 2 stairs left, which is the situation for "N = 2", which is 2 ways.
 *      So in total 3 + 2 = 5 ways.
 *
 * We can see that if there are n stairs, the number of ways to climb is the ways to climb n-1 stairs plus the ways to climb n-2 stairs,
 * which, is the famous fibonacci sequence that "each number is the sum of the two preceding ones, starting from 0 and 1"
 *
 */

/**
 * Dynamic Programming (Bottom-Up)
 * Time: O(n)
 * Space: O(n)
 */
class ClimbingStairs_Solution3 {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

/**
 * Dynamic Programming (Bottom-Up) - Space optimized
 * Time: O(n)
 * Space: O(1)
 */
class ClimbingStairs_Solution4 {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int[] dp = new int[] {1, 2};
        for (int i = 3; i <= n; i++) {
            int temp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0] = temp;
        }

        return dp[1];
    }
}


/**
 * In this case, when input is n, answer is n+1 th fibonacci number since f(1) = 1, f(2) = 2 in this case.
 */

/**
 * 5. Matrix Exponentiation
 * Fibonacci matrix exponentiation
 *
 * Time: O(log n)
 * Space: O(1)
 */
class ClimbingStairs_Solution5 {
    public int climbStairs(int n) {
        return 0;
    }
}



/**
 * 6. Math
 * Using Golden Ratio
 *
 * Time: O(1)
 * Space: O(1)
 */
class ClimbingStairs_Solution6 {
    public int climbStairs(int n) {
        return 0;
    }
}
