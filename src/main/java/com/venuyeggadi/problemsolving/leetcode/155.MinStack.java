package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Bruteforce
 *
 * Time:
 *  getMin() -> O(n)
 *  everything else -> O(1)
 * Space: O(n)
 */
class MinStack_Solution1 {
    private final Deque<Integer> stack;

    public MinStack_Solution1() {
        stack = new ArrayDeque<Integer>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int num : stack){
            min = Math.min(min, num);
        }

        // OR
        // min = stack.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);

        return min;
    }
}


/**
 * Two stacks
 *
 * Time: O(1) for everything
 * Space: 2n -> O(n)
 */
class MinStack_Solution2 {
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack_Solution2() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.add(val);
        } else {
            int min = Math.min(val, minStack.peek());
            minStack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * One stack - Optimal
 * Same as above: 1 stacks with two values for item (item can be a custom class with two values or just an array)
 *
 * Time: O(1) for everything
 * Space: 2n -> O(n)
 */
class MinStack_Solution3 {
    private final Deque<int[]> stack;

    public MinStack_Solution3() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new int[]{ val, val });
        } else {
            int min = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{ val, min });
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Same but using a dynamic array.
 */
class MinStack_Solution3_Way2 {
    private List<int[]> list;

    public MinStack_Solution3_Way2() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        int[] pair = new int[2];
        pair[0] = val;
        if (list.isEmpty()) {
            pair[1] = val;
        } else {
            pair[1] = Math.min(list.get(list.size() - 1)[1], val);
        }

        list.add(pair);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1)[0];
    }

    public int getMin() {
        return list.get(list.size() - 1)[1];
    }
}


/**
 * Not needed, (tricky, difficult to understand & debug)
 * One stack
 * Maintaining a single variable for min value.
 * Stack contains the encoded values (val - min) (min = previous in/ min till that point)
 *
 * Time: O(1) for every operation
 * Space: O(n)
 */
class MinStack_Solution4 {
    private final Deque<Long> encodedStackValue;
    private long min;

    public MinStack_Solution4() {
        encodedStackValue = new ArrayDeque<>();
        min = 0;
    }

    public void push(int val) {
        if (encodedStackValue.isEmpty())
            min = val;

        encodedStackValue.push(val - min);

        if (val < min)
            min = val;
    }

    public void pop() {
        long tos = encodedStackValue.pop();
        if (tos < 0) /** tos < 0 indicates minimum has changed at this point, so needs restoration */
            min = min - tos; /** tos = val - min => min = val - tos => min = min - tos (when tos < 0, min = val) */
    }

    public int top() {
        long tos = encodedStackValue.peek();

        if (tos < 0) /** tos < 0 indicates a new minimum was found at this point, which would have beeen stored as min */
            return (int)min;
        else
            return (int)(tos + min);
    }

    public int getMin() {
        return (int)min;
    }
}

