package com.venuyeggadi.problemsolving.leetcode;

/**
 * Recursion
 * Time: O(2^n)
 * Space: O(n)
 */
class FibonacciNumber_Solution1 {
    public int fib(int n) {
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }
}

/**
 * Top-Down Dynamic Programming (Memoization)
 * Time: O(n)
 * Space: O(n + n) = O(n)
 */
class FibonacciNumber_Solution2 {
    public int fib(int n) {
        int[] memo = new int[n + 1];

        return memoize(n, memo);
    }

    private int memoize(int n, int[] memo) {
        if (n <= 1)
            return n;

        if (memo[n] != 0)
            return memo[n];

        memo[n] = memoize(n - 1, memo) + memoize(n - 2, memo);

        return memo[n];
    }
}

/**
 * Bottom-Up Dynamic Programming (Tabulation)
 * Time: O(n)
 * Space: O(n)
 */
class FibonacciNumber_Solution3 {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];

        return fib[n];
    }
}

/**
 * Optimized Bottom-Up (Constant space)
 * Time: O(n)
 * Space: O(1)
 */
class FibonacciNumber_Solution4 {
    public int fib(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}

class FibonacciNumber_Solution4Better {
    public int fib(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[]{ 0, 1 };
        for (int i = 2; i <= n; i++) {
            int temp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0] = temp;
        }

        return dp[1];
    }
}

