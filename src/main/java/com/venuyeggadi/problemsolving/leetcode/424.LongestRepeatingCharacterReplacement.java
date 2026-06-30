package com.venuyeggadi.problemsolving.leetcode;
/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Bruteforce
 *
 * Time: O(26 * n^2) => O(n^2)
 * Space: O(k)
 *      n -> length of string
 *      k -> number of unique characters
 */
class LongestRepeatingCharacterReplacement_Solution1 {
    public int characterReplacement(String s, int k) {
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); ++j) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                int maxFrequency = Collections.max(map.values());
                if (j - i + 1 - maxFrequency <= k)
                    result = Math.max(result, j - i + 1);
            }
        }

        return result;
    }
}

/**
 * Bruteforce - with optimized way to find max frequency value
 */
class LongestRepeatingCharacterReplacement_Solution1_Optimised {
    public int characterReplacement(String s, int k) {
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            Map<Character, Integer> count = new HashMap<>();
            int maxFrequency = 0;
            for (int j = i; j < s.length(); ++j) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxFrequency = Math.max(maxFrequency, count.get(s.charAt(j)));
                if (j - i + 1 - maxFrequency <= k)
                    result = Math.max(result, j - i + 1);
            }
        }

        return result;
    }
}

/**
 * Sliding window
 *
 * Time: O(26 * n) => O(n)
 * Space: O(k)
 *      n -> length of string
 *      k -> number of unique characters
 */
class LongestRepeatingCharacterReplacement_Solution2 {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, result = 0;

        for (int r = 0; r < s.length(); ++r) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);

            while (r - l + 1 - Collections.max(count.values()) > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                ++l;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}

/**
 * Sliding window
 *
 * Time: O(n)
 * Space: O(k)
 *      n -> length of string
 *      k -> number of unique characters
 */
class LongestRepeatingCharacterReplacement_Solution2_Optimised {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, result = 0;
        int maxFrequency = 0;

        for (int r = 0; r < s.length(); ++r) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFrequency = Math.max(maxFrequency, count.get(s.charAt(r)));

            while (r - l + 1 - maxFrequency > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                ++l;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}


class LongestRepeatingCharacterReplacement_Solution2_Optimised_WithClearNamings {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        char[] characters = s.toCharArray();
        Map<Character, Integer> charToCount = new HashMap<>();
        int startIndex = 0, endIndex = 0;
        int countOfMostFrequentNumber = 0;

        for (endIndex = 0; endIndex < s.length(); endIndex++) {
            charToCount.put(characters[endIndex], charToCount.getOrDefault(characters[endIndex], 0) + 1);
            countOfMostFrequentNumber = Math.max(countOfMostFrequentNumber, charToCount.get(characters[endIndex]));
            int subStringLength = endIndex - startIndex + 1;
            if (subStringLength - countOfMostFrequentNumber > k) {
                charToCount.put(characters[startIndex], charToCount.get(characters[startIndex]) - 1);
                startIndex++;
            }
        }

        return endIndex - 1 - startIndex + 1;
    }
}


/**
 * Sliding window - not the optimal one but intuitive
 */
class LongestRepeatingCharacterReplacement_Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet) {
            int count = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}
