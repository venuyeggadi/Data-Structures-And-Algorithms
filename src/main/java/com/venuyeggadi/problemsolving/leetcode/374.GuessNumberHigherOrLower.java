package com.venuyeggadi.problemsolving.leetcode;

class GuessGame {
    protected int guess(int guess) {
        int pick = 10;
        int diff = pick - guess;
        return diff / Math.abs(diff);
    }
}

/**
 * --- Time Limit Exceeded ---
 * Bruteforce - Linear search
 *
 * Time: O(n)
 * Space: O(1)
 */
class GuessNumberHigherOrLower_Solution1 extends GuessGame {
    public int guessNumber(int n) {
        for (int i = 1; i <= n; ++i)
            if (guess(i) == 0)
                return i;

        return -1;
    }
}

/**
 * Binary Search
 *
 * Time: O(log n)
 * Space: O(1)
 */
class GuessNumberHigherOrLower_Solution2 extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;

        while (start <= end) { // OR while (true) because there will always be an answer.
            int guessed = start + (end - start) / 2;
            int guessResult = guess(guessed);
            if (guessResult < 0)
                end = guessed - 1;
            else if (guessResult > 0)
                start = guessed + 1;
            else
                return guessed;
        }

        return -1;
    }
}

/**
 * Ternary Search
 *
 * Time: O(log3 n)  (base 3)
 * Space: O(1)
 */
class GuessNumberHigherOrLower_Solution3 extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            int guess1 = guess(mid1);
            if (guess1 == 0)
                return mid1;

            int guess2 = guess(mid2);
            if (guess2 == 0)
                return mid2;

            if (guess1 == 1 && guess2 == -1) { // OR guess1 + guess2 == 0
                left = mid1 + 1;
                right = mid2 - 1;
            } else if (guess1 == -1) {
                right = mid1 - 1;
            } else {
                left = mid2 + 1;
            }
        }

        return -1;
    }
}