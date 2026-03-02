package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time: O(n^2)
 *  total iterations = (n/2)
 *  complexity of contains = O(n)
 *  complexity of replace = O(n)
 *  => (n/2) * 2n = O(n^2)
 *
 * Space: O(n)
 *  At any moment in the program, we're only having one string in memory.
 *  Because when we assign replaced string to the new string, actual string is discard (after some time by garbage collector).
 */
class ValidParenthesis_Solution1 {
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}

/**
 * Stack
 * Time: O(n)
 * Space: O(n)
 */
class ValidParenthesis_Solution2 {

    public boolean isValid(String s) {
        char[] characters = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : characters) {
            if (isOpenBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char tos = stack.pop();
                if (!areMatchingBrackets(tos, c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    private boolean areMatchingBrackets(char openBracket, char closeBracket) {
        if (openBracket == '(' && closeBracket == ')')
            return true;
        if (openBracket == '{' && closeBracket == '}')
            return true;
        if (openBracket == '[' && closeBracket == ']')
            return true;

        return false;
    }
}
