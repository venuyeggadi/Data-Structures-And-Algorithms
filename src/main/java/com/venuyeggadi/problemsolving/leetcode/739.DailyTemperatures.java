package com.venuyeggadi.problemsolving.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Bruteforce
 *
 * Time: O(n^2)
 * Space: O(1)
 */
class DailyTemperatures_Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }
}


/**
 * Monotonic Stack
 * Monotonically Decreasing stack
 *      Starting from the last, it maintains values that are greater than the current element (specificallt nearest greater element).
 * Note: We can also store pair of values [value, index] (an array of 2 values) in the stack, but it is unnecessary in this case.
 *
 * Time: O(n)
 * Space: O(n)
 */
class DailyTemperatures_Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return answer;
    }
}

/**
 * Same as above - Monotonically Decreasing stack, but starting from start of the array.
 * Each element will compute the answer for all the previous elements which are less than it.
 * For current element, some future element will compute the answer.
 * */
class DailyTemperatures_Solution2_Way2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty())
                stack.push(i);
            else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return answer;
    }

    // Removing unnecessary conditionals
    public int[] dailyTemperatures_Way2(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }
}


/**
 * Dynamic programming
 * Intuition
 *      Coming from the last, the day at which warmer temperature could be found can be found using the next answers.
 *      For temperature at i, if the next day's temperature is greater, that would be the answer.
 *      If the next day's temperature is lower or equal to current, a temperature that is greater than current temperature can only be found at or after the
 *      next day's answer. So we directly skip (jump) to the next day's answer and start searching from there.
 *
 * Time: O(n) for any kind of input
 *      When inputs are strictly increasing, [1,2,3,4,5], the inner while loop execute only once (finds next warmer temperature in constant time) only.
 *      When inputs are strictly decreasing, [1,2,3,4,5], the inner while loop execute only once (finds next warmer temperature in constant time) only.
 *      When input something like [6,1,2,3,4,5], for the last 5 element it will jump once and finds answer, but for the first element, it jumps 5 times, so time would be O(2n) => O(n).
 *
 * Space: O(1)
 */
class DailyTemperatures_Solution3 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        answer[n - 1] = 0;
        for (int i = n - 2; i >= 0; --i) {
            int j = i + 1;
            /**
             * j will stop either at a temperature greater than current or when there are no warmer temperatures ahead.
             * because, if the next temperate which is less than current cannot find any warmer temperature ahead, current one can also will not find any, so we stop.
             */
            while (answer[j] != 0 && temperatures[j] <= temperatures[i]) {
                j = j + answer[j];
            }
            if (temperatures[j] > temperatures[i])
                answer[i] = j - i;
        }

        return answer;
    }
}