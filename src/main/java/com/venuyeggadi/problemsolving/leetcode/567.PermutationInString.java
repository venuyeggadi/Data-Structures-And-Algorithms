package com.venuyeggadi.problemsolving.leetcode;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */


import java.util.Arrays;

/**
 * Bruteforce
 * Same as solution 2, but arePermutations is implemented using sorting -> L1 log L1
 * Time: L2 * L1^2 * log L1
 * Space: O(L1)
 */
class PermutationInString_Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] subStrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String(subStrArr);

                if (sortedSubStr.equals(sortedS1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Hashmap/ character frequency
 *
 * Time: L1 + L2 * (L1 + 26) => O(L1 * L2)
 * Space: O(26) => O(1)
 */
class PermutationInString_Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        int[] f1 = new int[26];

        for (char c : s1.toCharArray())
            f1[c - 'a']++;

        for (int i = 0; i + s1.length() <= s2.length(); ++i) {
            int[] f2 = new int[26];
            for (int k = i; k < i + s1.length(); ++k)
                f2[s2.charAt(k) - 'a']++;

            if (arePermutations(f1, f2))
                return true;
        }

        return false;
    }

    private static boolean arePermutations(int[] f1, int[] f2) {

        for (int i = 0; i < 26; ++i)
            if (f1[i] != f2[i])
                return false;

        return true;
    }
}

/**
 * Sliding Window
 *
 * Time: L1 + 26 + L2 * 26 => O(L2)
 * Space: O(26) -> O(1)
 */
class PermutationInString_Solution3 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] f1 = new int[26], f2 = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        if (arePermutations(f1, f2))
            return true;

        for (int i = 1; i + s1.length() <= s2.length(); ++i) {
            f2[s2.charAt(i - 1) - 'a']--;
            f2[s2.charAt(i + s1.length() - 1) - 'a']++;
            if (arePermutations(f1, f2))
                return true;
        }

        return false;
    }

    private static boolean arePermutations(int[] f1, int[] f2) {
        for (int i = 0; i < 26; ++i)
            if (f1[i] != f2[i])
                return false;

        return true;
    }
}

