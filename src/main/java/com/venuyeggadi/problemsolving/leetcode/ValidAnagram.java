package com.venuyeggadi.problemsolving.leetcode;
/*
 * https://leetcode.com/problems/valid-anagram/
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
   An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
   typically using all the original letters exactly once.


 * Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true
 * Example 2:
    Input: s = "rat", t = "car"
    Output: false
 * Constraints:
    * 1 <= s.length, t.length <= 5 * 10^4
    * s and t consist of lowercase English letters.

 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Solution 1
/*
Using HashMap
Time Complexity: O(n)
Space Complexity: O(n)
Where n is length of the longest string.
 */
class ValidAnagramSolution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) - 1);

        for (int num : map.values())
            if (num != 0)
                return false;

        return true;
    }
}



// Solution 2
/*
Time Complexity: O(n)
Space Complexity: O(52) = O(1)
Where n is length of the longest string.
 */
class ValidAnagramSolution2 {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++)
            if (freqS[i] != freqT[i])
                return false;

        return true;
    }
}

class ValidAnagramSolution2Way2 {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }

        return Arrays.toString(freqS).equals(Arrays.toString(freqT));
    }
}

// With only one frequency array
class ValidAnagramSolution2Way3 {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())
            return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++)
            if (freq[i] != 0)
                return false;

        return true;
    }
}