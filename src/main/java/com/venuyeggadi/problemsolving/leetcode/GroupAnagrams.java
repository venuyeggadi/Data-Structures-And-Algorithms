package com.venuyeggadi.problemsolving.leetcode;

/*
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
   An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
   typically using all the original letters exactly once.

 * Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

 * Example 2:
    Input: strs = [""]
    Output: [[""]]
 * Example 3:
    Input: strs = ["a"]
    Output: [["a"]]

 * Constraints:
    * 1 <= strs.length <= 10^4
    * 0 <= strs[i].length <= 100
    * strs[i] consists of lowercase English letters.
 */


import java.util.*;

// Solution 1
/*
Bruteforce
Time complexity: O(k.n^2)
    where n = |strs| and k = ∣strs[i]∣ = average length of a string
Space complexity: O(n)
    for the boolean array.

Note: we are not considering the space used by result list.
 */
class GroupAnagramsSolution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        List<List<String>> resultList = new ArrayList<>();
        boolean[] grouped = new boolean[length];

        for (int outerIndex = 0; outerIndex < length; outerIndex++) {
            if (!grouped[outerIndex]) {
                ArrayList<String> innerList = new ArrayList<>();
                innerList.add(strs[outerIndex]);
                grouped[outerIndex] = true;
                for (int innerIndex = outerIndex+1; innerIndex < length; innerIndex++) {
                    if (!grouped[innerIndex] && areAnagrams(strs[outerIndex], strs[innerIndex])) {
                        innerList.add(strs[innerIndex]);
                        grouped[innerIndex] = true;
                    }
                }
                resultList.add(innerList);
            }
        }

        return resultList;
    }

    //O(k), O(1)
    public boolean areAnagrams(String s, String t) {
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


// Solution 2
/*
Using HashMap
Time complexity: O(n.k.log(k))
    where n = |strs| and k = ∣strs[i]∣ = average length of a string
Space complexity: O(n.k)
    for the charArray created at each iteration.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}


// Solution 3
/*
Using HashMap
Time complexity: O(n.k)
    where n = |strs| and k = ∣strs[i]∣ = average length of a string
Space complexity: O(n.26) = O(n)

* Here we are using string as a key because arrays in java can't be keys of a map.
  Because they do not override the hashCode() method. They use hashCode() method of Object class.
 */
class GroupAnagramsSolution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] freqPatternArray = new int[26];
            for (char ch : word.toCharArray())
                freqPatternArray[ch - 'a']++;
            String freqPatternString = Arrays.toString(freqPatternArray);
            if (!map.containsKey(freqPatternString))
                map.put(freqPatternString, new ArrayList<>());
            map.get(freqPatternString).add(word);
        }

        return new ArrayList<>(map.values());
    }
}