package com.venuyeggadi.problemsolving.leetcode;

/*
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Solution1
// Sliding Window and Set
/*
 Time complexity: O(n + n) = O(n) -> 6ms
 Space complexity: O(k) where k is length of the longest substring which is <= 128
                 = O(1)
 */

class LongestSubstringWithoutRepeatingCharactersSolution1 {
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

// Solution2
// Sliding Window and character look up array
/*
 Time complexity: O(n + n) = O(n) -> 2ms
 Space complexity: O(128) = O(1)
 */
class LongestSubstringWithoutRepeatingCharactersSolution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();

        char[] charArr = s.toCharArray();
        boolean[] charExists = new boolean[128];

        int startIndex = 0;
        int maxLength = 0;
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            if (!charExists[charArr[endIndex]]) {
                charExists[charArr[endIndex]] = true;
                maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            } else {
                while (charExists[charArr[endIndex]]) {
                    charExists[charArr[startIndex]] = false;
                    startIndex++;
                }
                charExists[charArr[endIndex]] = true;
            }
        }

        return maxLength;
    }
}

// Time taken -> 1ms
class LongestSubstringWithoutRepeatingCharactersSolution2Refactored {
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


// Solution 3
// Sliding Window and Last Seen
/*
 Instead just remembering whether a character already exists in the current window,
 remember the positions at which we saw a character last. So that we can calculate the substring from the last seen location.
*/
/*
 Time complexity: O(n + n) = O(n)
 Space complexity: O(128) = O(1)
 */
class LongestSubstringWithoutRepeatingCharactersSolution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startIndex = -1; // lastSeenAt        // s[j+1...i] has no repeating chars.
        int[] lastSeen = new int[128]; // lastSeen[c] := index at which c appeared last time
        Arrays.fill(lastSeen, -1);

        for (int endIndex = 0; endIndex < s.length(); ++endIndex) {
            startIndex = Math.max(startIndex, lastSeen[s.charAt(endIndex)]);
            maxLength = Math.max(maxLength, endIndex - startIndex);
            lastSeen[s.charAt(endIndex)] = endIndex;
        }

        return maxLength;
    }
}