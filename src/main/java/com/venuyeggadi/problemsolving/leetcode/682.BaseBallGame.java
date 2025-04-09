package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;

class BaseBallGame_Solution1 {

    public int calPoints(String[] operations) {
        Collection<Integer> resultRecord = applyOperations(operations);

        int sum = 0;
        for (int score : resultRecord) {
            sum += score;
        }

        // using streams
        // sum = resultRecord.stream().reduce(Integer::sum).orElse(0);
        // sum = resultRecord.stream().collect(Collectors.summingInt(Integer::intValue));
        sum = resultRecord.stream().mapToInt(Integer::intValue).sum();

        return sum;
    }

    private static Collection<Integer> applyOperations(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            if (op.equals("+")) {
                Integer tos = stack.pop();
                Integer newTos = tos + stack.peek();
                stack.push(tos);
                stack.push(newTos);
            } else if(op.equals("D")) {
                Integer newTos = 2 * stack.peek();
                stack.push(newTos);
            } else if(op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        return stack;
    }
}
