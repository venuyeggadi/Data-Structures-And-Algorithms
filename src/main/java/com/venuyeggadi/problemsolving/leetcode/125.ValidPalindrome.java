package com.venuyeggadi.problemsolving.leetcode;


/* https://leetcode.com/problems/valid-palindrome/
 * 125. Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
   and removing all non-alphanumeric characters, it reads the same forward and backward.
   Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.

 * Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

 * Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

 * Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.

 * Constraints:
    * 1 <= s.length <= 2 * 105
    * s consists only of printable ASCII characters.

 */


/**
 * Solution 1
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class ValidPalindromeSolution1 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c <= 'z' && c >= 'a' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        String cleanString = sb.toString();
        return cleanString.equals(sb.reverse().toString());
    }
}

// Same solution but without reversing the string.
class ValidPalindromeSolution2 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c <= 'z' && c >= 'a' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        char[] charArray = sb.toString().toCharArray();
        int n = charArray.length;

        if (n < 2) return true;

        for (int i = 0; i <= n / 2; i++)
            if (charArray[i] != charArray[n - 1 - i]) return false;

        return true;
    }
}


/** Solution 2
 * Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class ValidPalindromeSolution3 {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        int n = charArray.length;
        if (n < 2) return true;
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !isAlphaNumeric(charArray[left]))
                left++;
            while (left < right && !isAlphaNumeric(charArray[right]))
                right--;
            if (charArray[left] != charArray[right])
                return false;
            left++;
            right--;

        }

        return true;
    }

    public static boolean isAlphaNumeric(char c) {
        return (c <= 'z' && c >= 'a') || (c >= '0' && c <= '9');
    }
}


/** Solution 3
 * Two Pointers
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class ValidPalindromeSolution4 {
    public boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;

        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(leftIndex)))
                ++leftIndex;
            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(rightIndex)))
                --rightIndex;
            if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex)))
                return false;
            ++leftIndex;
            --rightIndex;
        }

        return true;
    }
}
/** The toLowerCase method can be written as below */
class Util {
    static char toLowerCase(char ch) {
        char diff = 'a' - 'A';
        return ch < 'A' || ch > 'Z' ? ch : (char)(ch + diff);
    }

    static boolean isAlphaNumeric(char ch) {
        return (ch <= 'z' && ch >= 'a') || ch <= 'Z' && ch >= 'A' || (ch >= '0' && ch <= '9');
    }
}
