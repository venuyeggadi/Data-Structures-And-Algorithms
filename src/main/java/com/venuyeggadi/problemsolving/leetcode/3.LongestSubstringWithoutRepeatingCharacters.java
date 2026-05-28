package com.venuyeggadi.problemsolving.leetcode;

/**
 * Given a string s, find the length of the longest substring without repeating characters.

 * Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

 * Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

 * Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * Constraints:
    * 0 <= s.length <= 5 * 104
    * s consists of English letters, digits, symbols and spaces.
 */

import java.util.*;

/**
 * Bruteforce
 *
 * Time: O(n * k)
 * Space: O(k)
 *      Where n is the length of the string and k is the total number of unique characters in the string.
 */
class LongestSubstringWithoutRepeatingCharacters_Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }
}

/**
 * Sliding Window and Set
 *
 * Time: O(n + n) = O(n)
 * Space : O(k)
 *          where k is length of the longest substring which is <= 128 (unique ASCII characters) = O(1)
 */
class LongestSubstringWithoutRepeatingCharacters_Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        char[] charArr = s.toCharArray();
        Set<Character> set = new HashSet<>();

        int startIndex = 0;
        int maxLength = 0;
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            if (set.add(charArr[endIndex])) {
                maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            } else {
                while (!set.add(charArr[endIndex])) {
                    set.remove(charArr[startIndex]);
                    startIndex++;
                }
            }
        }

        return maxLength;
    }
}

class LongestSubstringWithoutRepeatingCharacters_Solution2_Better {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;

        int left = 0;
        for (int right = 0; right < s.length(); ++right) {
            char ch = s.charAt(right);
            while (set.contains(ch))
                set.remove(s.charAt(left++));

            set.add(ch);
            max = Math.max(max, right - left + 1); // Math.max(max, set.size())
        }

        return max;
    }
}


/**
 * Sliding Window and character look up array
 *
 * Time: O(n + n) = O(n)
 * Space: O(128) = O(1)
 */
class LongestSubstringWithoutRepeatingCharacters_Solution2_Way1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        char[] charArr = s.toCharArray();
        boolean[] charExists = new boolean[128];

        int startIndex = 0;
        int maxLength = 0;
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            while (charExists[charArr[endIndex]]) {
                charExists[charArr[startIndex]] = false;
                startIndex++;
            }
            charExists[charArr[endIndex]] = true;
            maxLength = Math.max(maxLength, endIndex - startIndex + 1);
        }

        return maxLength;
    }
}

/**
 * Sliding Window and Last Seen
 *
 * Intuition:
 * Instead just remembering whether a character already exists in the current window,
 * remember the positions at which we saw a character last.
 * So that we can calculate the substring from the last seen location.
 *
 * Time: O(n)
 * Space: O(k)
 */
class LongestSubstringWithoutRepeatingCharacters_Solution3_Map {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); ++r) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                l = Math.max(map.get(ch) + 1, l);
            }
            map.put(ch, r);
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
