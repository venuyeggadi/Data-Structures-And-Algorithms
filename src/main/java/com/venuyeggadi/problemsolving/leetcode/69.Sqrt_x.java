package com.venuyeggadi.problemsolving.leetcode;


/**
 * Bruteforce
 * Time: O(sqrt(n))
 * Space: O(1)
 */
class Sqrt_x_Solution1 {
    public int mySqrt(int x) {
        int result = 0;
        for (int i = 0; i <= x; ++i) {
            if ((long) i * i > x)
                return result;
            result = i;
        }

        return result;
    }
}

class Sqrt_x_Solution1_Way2 {
    public int mySqrt(int x) {
        long X = (long) x + 1;
        for (long i = 0; i <= X; ++i) {
            long product = i * i;
            if (product > x)
                return (int)(i - 1);
        }

        return -1;
    }
}


/**
 * Binary Search
 * Intuition
 *      If it's a perfect square, it will be found and returned.
 *      If not, left pointer will be at a position one more than the answer, so left - 1 is the answer.
 *
 * Time: O(log n)
 * Space: O(1)
 */
class Sqrt_x_Solution2 {
    public int mySqrt(int x) {
        int left = 0, right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long product = (long) mid * mid;
            if (product == x)
                return mid;
            if (product > x)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left - 1;
    }
}
/** Same as above */
class Sqrt_x_Solution2_Way2 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long product = (long) mid * mid;
            if (product == x)
                return mid;
            if (product < x) {
                result = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        return result;
    }
}

/**
 * Recursion
 *      Sqrt(x) = 2 * Sqrt(x / 4)
 *
 * Time: O(log n) - base 4
 * Space: O(log n)
 *      for recursion stack
 */
class Sqrt_x_Solution3 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int lowerBound = mySqrt(x >> 2) << 1;  // 2 * mySqrt(x / 4)
        int r = lowerBound + 1;

        if ((long) r * r <= x)
            return r;

        return lowerBound;
    }
}


/**
 * Newton's method for finding the roots of an equation
 *      x^2 = N
 *      f(x) = x^2 - N
 * if an initial guess is x0, next approximated value x is,
 * x = x0 - f(x0) / f'(x0), where f'(x) is the derivative.
 *
 * in our case, x = x0 - (x0^2 - N) / (2 * x0) = x0 - (x0 - N/x0) / 2 = (x0 + N/x0) / 2;
 *
 * Time: O(log n)
 *      Answer becomes half everytime. (maybe)
 * Space: O(1)
 */
class Sqrt_x_Solution4 {
    public int mySqrt(int x) {
        double ans = x;

        while (Math.abs(ans * ans - x) > 0.1) {
            ans = (ans + x / ans) / 2;
            System.out.println(ans);
        }

        return (int)ans;
    }
}

class Sqrt_x_Solution4_Way2 {
    public int mySqrt(int x) {
        long ans = x;

        while (ans * ans > x) {
            ans = (ans + x / ans) >> 1;
        }

        return (int) ans;
    }
}