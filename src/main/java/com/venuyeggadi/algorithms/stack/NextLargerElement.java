package com.venuyeggadi.algorithms.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextLargerElement {
    public static void main(String[] args) {
        int[] nums = new int[]{ 5, 4, 3, 2, 1, 2, 3, 4, 5 };
        int[] answer = new int[nums.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                answer[i] = 0;
            else
                answer[i] = stack.peek();
            stack.push(nums[i]);
        }

        System.out.println(Arrays.toString(answer));
    }
}