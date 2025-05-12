package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Bruteforce
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

        min = stack.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);

        return min;
    }
}


/**
 * Two stacks
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
 * Same as above: 1 stacks with two values for item (item can be a custom class with two values or just an array)
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



class MinStack_Solution4 {
    private long min;
    private Deque<Long> stack;

    public MinStack_Solution4() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty())
            min = val;

        stack.push(val - min);
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        long pop = stack.pop();
        if (pop < 0)
            min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}

