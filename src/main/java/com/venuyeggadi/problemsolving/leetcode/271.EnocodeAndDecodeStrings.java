package com.venuyeggadi.problemsolving.leetcode;

/* This problem statement is taken from lintcode.com as this problem is premium in leetcode.com
 * 271. Encode and Decode Strings
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent
   over the network and is decoded back to the original list of strings.
   Please implement encode and decode

 * Example 1
    Input: ["lint","code","love","you"]
    Output: ["lint","code","love","you"]
    Explanation: One possible encode method is: "lint:;code:;love:;you"
 * Example 2
    Input: ["we", "say", ":", "yes"]
    Output: ["we", "say", ":", "yes"]
    Explanation:
    One possible encode method is: "we:;say:;:::;yes"
 */

/** https://neetcode.io/problems/string-encode-and-decode/question */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Optimal
 *
 * Length-Prefix Encoding - Using string lengths to unambiguously mark boundaries between encoded segments
 * Encoding: ["abc", "ab", "c"] -> "3#abc2#ab1#a"
 *
 * Time:
 *      encode -> O(m)
 *      decode -> O(m)
 * Space:
 *      encode -> O(m + n)
 *          m -> (StringBuilder) for all the characters of the strings and n for '#' and length numbers added additionally
 *      decode -> O(m + n)
 *          m -> for all the strings
 *          n -> for array list (n references to strings)
 *
 *      where,
 *          m -> sum of the lengths of all strings
 *          n -> length of the list of strings
 */
class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int indexOfPound = str.indexOf('#', index);
            int stringLength = Integer.parseInt(str.substring(index, indexOfPound));
            int startIndex = indexOfPound + 1;
            int endIndex = startIndex + stringLength;
            result.add(str.substring(startIndex, endIndex));
            index = endIndex;
        }

        return result;
    }

    // decode method without using indexOf method
    public List<String> decode2(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            int poundIndex = j;
            int wordLength = Integer.parseInt(str.substring(i, poundIndex));
            int endIndex = poundIndex + wordLength;
            list.add(str.substring(poundIndex + 1, endIndex + 1));
            i = endIndex + 1;
        }
        return list;
    }
}

/**
 * Encoding: ["abc", "ab", "c"] -> "3,2,1#abcaba"
 */
class EncodeAndDecodeStrings_Way2 {

    public String encode(List<String> strs) {
        if (strs.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(',');
        }
        sb.append('#');
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty())
            return new ArrayList<>();

        int indexOfPound = str.indexOf('#');
        int[] lengths = Arrays.stream(str.substring(0, indexOfPound).split(",")).mapToInt(Integer::parseInt).toArray();

        List<String> result = new ArrayList<>();

        int startIndex = indexOfPound + 1;
        for (int len : lengths) {
            int endIndex = startIndex + len;
            result.add(str.substring(startIndex, endIndex));
            startIndex = endIndex;
        }

        return result;
    }
}

