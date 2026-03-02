package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;


/**
 * Bruteforce
 *
 * Time: O(n)
 * Space: O(n)
 */
class EvaluateReversePolishNotation_Solution1 {
    public int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>(Arrays.asList(tokens));

        while (list.size() > 1) {
            int indexOfOperator = 0;
            for (int i = 0; i < list.size(); ++i) {
                if (isOperator(list.get(i))) {
                    indexOfOperator = i;
                    break;
                }
            }

            String result = evaluate(list.get(indexOfOperator - 2), list.get(indexOfOperator - 1), list.get(indexOfOperator));
            list.set(indexOfOperator - 2, result);
            list.remove(indexOfOperator); // order of removal matters
            list.remove(indexOfOperator - 1);
        }

        return Integer.parseInt(list.get(0));
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private String evaluate(String operandA, String operandB, String operator) {
        int a = Integer.parseInt(operandA);
        int b = Integer.parseInt(operandB);

        switch (operator) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            default:
                return String.valueOf(a / b);
        }
    }
}

/**
 * Doubly Linked List
 * Same as above but with linear traversal
 *
 * Time: O(n)
 * Space: O(n)
 */
class EvaluateReversePolishNotation_Solution2 {
    public int evalRPN(String[] tokens) {
        DoublyLinkedList head = new DoublyLinkedList(tokens[0], null, null);
        DoublyLinkedList curr = head;

        for (int i = 1; i < tokens.length; i++) {
            curr.next = new DoublyLinkedList(tokens[i], null, curr);
            curr = curr.next;
        }

        int ans = 0;
        while (head != null) {
            if ("+-*/".contains(head.val)) {
                int l = Integer.parseInt(head.prev.prev.val);
                int r = Integer.parseInt(head.prev.val);
                int res = 0;
                if (head.val.equals("+")) {
                    res = l + r;
                } else if (head.val.equals("-")) {
                    res = l - r;
                } else if (head.val.equals("*")) {
                    res = l * r;
                } else {
                    res = l / r;
                }

                head.val = String.valueOf(res);
                head.prev = head.prev.prev.prev;
                if (head.prev != null) {
                    head.prev.next = head;
                }
            }

            ans = Integer.parseInt(head.val);
            head = head.next;
        }

        return ans;
    }

    private static class DoublyLinkedList {
        String val;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        DoublyLinkedList(String val, DoublyLinkedList next, DoublyLinkedList prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Recursion
 *
 * Time: O(n / 2) => O(n)
 *      n is always going to be odd. Operands = n/2 + 1. Operators = n / 2;
 *      Each operator makes two recursive calls. In the worst case all the operators all consecutive, like ["1", "2", "3", "4", "+", "+", "+"],
 *      max recursive calls will be 3 = number of operators.
 *
 * Space: O(n / 2) => O(n)
 *      For recursive stack at any moment.
 */
class EvaluateReversePolishNotation_Solution3 {
    private final String operators = "+-*/";

    public int evalRPN(String[] tokens) {
        List<String> tokensList = new ArrayList<>(Arrays.asList(tokens));

        return evaluate(tokensList);
    }

    private int evaluate(List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);

        if (!isOperator(token))
            return Integer.parseInt(token);

        int operand2 = evaluate(tokens);
        int operand1 = evaluate(tokens);

        switch (token) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            default:
                return operand1 / operand2;
        }
    };

    private boolean isOperator(String token) {
        return operators.contains(token);
    }
}

/**
 * Stack
 * Intuition
 *      Reverse polish notation naturally requires stack like operations to evaluate.
 *
 * Time: O(n)
 * Space: O(n)
 */
class EvaluateReversePolishNotation_Solution4 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                int value2 = stack.pop();
                int value1 = stack.pop();
                stack.push(evaluate(value1, value2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperand(String token) {
        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/");
    }

    private int evaluate(int value1, int value2, String operand) {
        switch (operand) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            default:
                return value1 / value2;
        }
    }
}