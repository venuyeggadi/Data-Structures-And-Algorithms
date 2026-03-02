package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;


/**
 * Stack
 *
 * Time: O(n)
 * Space: O(n)
 */
class BaseBallGame_Solution1 {

    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String string : operations) {
            switch (string) {
                case "+":
                    Integer a = stack.pop();
                    Integer b = stack.peek();
                    stack.push(a);
                    stack.push(a + b);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(string));
            }
        }

        int sum = 0;
        for (int num : stack)
            sum += num;

        // using streams
        // sum = stack.stream().reduce(0, (a, b) -> a + b);
        // sum = stack.stream().reduce(0, Integer::sum);
        // sum = stack.stream().reduce(Integer::sum).orElse(0);
        // sum = stack.stream().collect(Collectors.summingInt(Integer::intValue));
        // sum = stack.stream().mapToInt(Integer::intValue).sum();

        return sum;
    }
}
