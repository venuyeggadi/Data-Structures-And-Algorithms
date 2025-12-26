package com.venuyeggadi.algorithms.recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("123321"));
        System.out.println(isPalindromeV2("123321"));
    }

    private static boolean isPalindrome(String str) {
        if (str.length() < 2)
            return true;
        if (str.length() == 2)
            return str.charAt(0) == str.charAt(1);

        return (str.charAt(0) == str.charAt(str.length() - 1)) && isPalindrome(str.substring(1, str.length() - 1));
    }

    private static boolean isPalindromeV2(String str) {
        if (str.length() < 2)
            return true;

        if (str.charAt(0) == str.charAt(str.length() - 1))
            return isPalindrome(str.substring(1, str.length() - 1));
        return false;
    }
}
