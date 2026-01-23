package com.venuyeggadi.problemsolving.leetcode;

import java.util.Arrays;

/**
 * Recursion
 * Intuition
 *      Exploring all possibilities of subsequences. Similar to generating subsets.
 *
 * Time: O(2 ^ (m+n))
 *     1. same as O(2^m * 2^n), all possibilities of first string times all possibilities of second string
 *     2. Thinking in terms of decision tree, maximum height of the tree is m + n, so time complexity is 2 ^ (m + n).
 *          path would look like (0,1)->(0,2)..->(0,n-1) -> (1,n-1)->(2,n-1)..->(m-1,n-1)
 * Space: O(m + n)
 *     Maximum length of the outstanding recursion stack at any point of time.
 */
class LongestCommonSubsequence_Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();

        return longestCommonSubsequenceAfterIndexes(str1, 0, str2, 0);
    }

    private static int longestCommonSubsequenceAfterIndexes(char[] str1, int i, char[] str2, int j) {
        if (i == str1.length || j == str2.length)
            return 0;

        if (str1[i] == str2[j])
            return 1 + longestCommonSubsequenceAfterIndexes(str1, i + 1, str2, j + 1);

        int moveFirst = longestCommonSubsequenceAfterIndexes(str1, i + 1, str2, j);
        int moveSecond = longestCommonSubsequenceAfterIndexes(str1, i, str2, j + 1);

        return Math.max(moveFirst, moveSecond);
    }
}


/**
 * Recursion + Memoization (Dynamic Programming - Top-down)
 * Intuition
 *      Exploring all possibilities of subsequences. Similar to generating subsets.
 *
 * Time: O(m * n)
 *     Distinct recursive calls made will be m * n.
 *     Because when call like (0,0), (0,1),(1,1),(0,2), (1,0),(2,0),(1,1) happen, duplicate call get the values from memo (cache).
 *     Only those calls go and compute the value, which are happening for the first time when computing that combination of (i, j).
 *     Total combination are m * n. So time is m * n;
 *
 * Space: O(m * n + m + n) => O(m * n)
 *     m * n for memo array.
 *     m + n is the maximum length of the outstanding recursion stack at any point of time.
 */
class LongestCommonSubsequence_Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();
        int[][] memo = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; ++i)
            Arrays.fill(memo[i], -1);

        return longestCommonSubsequenceAfterIndexes(str1, 0, str2, 0, memo);
    }

    private static int longestCommonSubsequenceAfterIndexes(char[] str1, int i, char[] str2, int j, int[][] memo) {
        if (i == str1.length || j == str2.length)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (str1[i] == str2[j]) {
            memo[i][j] = 1 + longestCommonSubsequenceAfterIndexes(str1, i + 1, str2, j + 1, memo);
        } else {
            int moveFirst = longestCommonSubsequenceAfterIndexes(str1, i + 1, str2, j, memo);
            int moveSecond = longestCommonSubsequenceAfterIndexes(str1, i, str2, j + 1, memo);
            memo[i][j] =  Math.max(moveFirst, moveSecond);
        }

        return memo[i][j];
    }
}


/**
 * Dynamic Programming - Bottom-up (Tabulation)
 * Intuition
 *      Can be deduced from the Top-down approach.
 *      Needs a (m+1) * (n+1) dp array.
 *
 * Time: O(m * n)
 * Space: O(m * n)
 *     Size of the dp array.
 */
class LongestCommonSubsequence_Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();
        int m = str1.length, n = str2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (str1[i] == str2[j])
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        return dp[0][0];
    }
}


/**
 * Dynamic Programming - Bottom-up (Tabulation) - Space Optimized
 * Intuition
 *      Can be deduced from the Top-down approach.
 *      Just two dp arrays of size (n+1) are enough.
 *
 * Time: O(m * n)
 * Space: O(min(m, n))
 *      Size of the dp array.
 */
class LongestCommonSubsequence_Solution4 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();

        if (str1.length < str2.length) {
            char[] temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int m = str1.length, n = str2.length;
        int[] prev = new int[n + 1], curr = new int[n + 1];

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (str1[i] == str2[j])
                    curr[j] = 1 + prev[j + 1];
                else
                    curr[j] = Math.max(prev[j], curr[j + 1]);
            }
            /** Swap. no need to create new curr array each time. */
            int[] temp = curr;
            curr = prev;
            prev = temp;
        }

        return prev[0];
    }
}


/**
 * Dynamic Programming - Bottom-up (Tabulation) - Space Optimized - (Optimal)
 * Intuition
 *      Can be deduced from the Top-down approach.
 *      1 dp array of size (n+1) along with a previous corner value are enough.
 *
 * Time: O(m * n)
 * Space: O(min(m, n))
 *      Size of the dp array.
 */
class LongestCommonSubsequence_Solution5 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();
        if (str1.length < str2.length) { /** swap the strings so that dp array is as small as possible */
            char[] temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int m = str1.length, n = str2.length;
        int[] dp = new int[n + 1];

        for (int i = m - 1; i >= 0; --i) {
            int cornerVal = 0; // dp[n]
            for (int j = n - 1; j >= 0; --j) {
                int temp = dp[j]; /** Corner value (i + 1, j + 1) to be used for next iteration. Can use two array for clarity */
                if (str1[i] == str2[j])
                    dp[j] = 1 + cornerVal;
                else
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                cornerVal = temp;
            }
        }

        return dp[0];
    }
}