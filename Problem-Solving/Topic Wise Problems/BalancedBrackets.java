//https://www.hackerrank.com/challenges/balanced-brackets/problem

import java.util.Stack;
import java.util.*;

/**
 * Time Complexity: O(n) 
 * Auxiliary Space: O(n) for stack.
 */ 
//#
class BalancedBrackets {
    
    //#1
    static char complement(char c)
    {
        if(c == '{')
            return '}';
        if(c == '[')
            return ']';
    
        return ')';
    }
    
    static boolean isBalanced1(String str) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : str.toCharArray()) {
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                
                if(! (c == complement(stack.pop())) )
                    return false;
            }

            //can be written in two lines
            /*if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else if(stack.isEmpty() || !(c == complement(stack.pop())) )
                return false;*/
        }
        
        return stack.isEmpty();
    }//end of #1


    //#2
    static char[][] TOKENS = { {'{', '}'}, {'[', ']'}, {'(', ')'}};

    static boolean isOpenTerm(char c) {
        for(char[] array : TOKENS) {
            if(c == array[0]) {
                return true;
            }
        }

        return false;
    }

    static boolean matches(char open, char close) {
        for(char[] array : TOKENS) {
            if(open == array[0])
                return close == array[1];
        }

        return false; //to avoid "missing return statement"
    }
    
    static boolean isBalanced2(String str) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : str.toCharArray()) {
            if(isOpenTerm(c))
                stack.push(c);
            else if(stack.isEmpty() || !matches(stack.pop(), c))
                    return false;
        } 
        
        return stack.isEmpty();
    }//end of #2


    //#3
    static boolean isBalanced3(String s) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new Stack<>();
        for(char c : s.toCharArray()) {
            if(opening.indexOf(c) != -1)
                buffer.push(c);
            else if(closing.indexOf(c) != -1) {
                if(buffer.isEmpty())
                    return false;
                if(closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false;
            }
        }

        return buffer.isEmpty();
    }//end of #3
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s;
        while(n-- > 0) {
            s = in.next();
            System.out.println(isBalanced1(s)?"YES":"NO");
            System.out.println(isBalanced2(s)?"YES":"NO");
            System.out.println(isBalanced3(s)?"YES":"NO");
        }
    }
}