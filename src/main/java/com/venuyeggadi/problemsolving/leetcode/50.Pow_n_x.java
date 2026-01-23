package com.venuyeggadi.problemsolving.leetcode;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Constraints:
 *  -100.0 < x < 100.0
 *  -231 <= n <= 231-1
 *  n is an integer.
 *  Either x is not zero or n > 0.
 *  -104 <= xn <= 104
 */

/**
 * Bruteforce - Iteration
 * Time: O(n)
 * Space: O(1)
 */
class Pow_x_n_Solution1 {
    public double myPow(double x, int n) {
        int times = n;
        if (times < 0)
            times = -times;

        double ans = 1;
        for (int i = 0; i < times; ++i)
            ans = ans * x;

        if (n < 0)
            return 1 / ans;

        return ans;
    }
}


/**
 * Binary Exponentiation
 * Time: O(log n)
 * Space: O(1)
 */
class Pow_x_n_Solution2 {
    public double myPow(double x, int n) {
        long times = n; /** converting to long is important for case where n = Math.MIN_VALUE */
        if (times < 0)
            times = -times;

        double ans = pow(x, times);

        if (n < 0)
            return 1 / ans;

        return ans;
    }

    private static double pow(double x, long n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                ans = ans * x;
            x = x * x;
            n = n >> 1;
        }

        return ans;
    }
}

class Pow_x_n_Solution2_Way2 {
    public double myPow(double x, int n) {
        long times = n;
        if (times < 0)
            times = -times;

        double ans = pow(x, times);

        if (n < 0)
            return 1 / ans;

        return ans;
    }

    private static double pow(double x, long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        double rootAnswer = pow(x, n/2);
        double answer = rootAnswer * rootAnswer;

        if ((n & 1) == 0) { // even
            return answer;
        }

        return answer * x;
    }
}