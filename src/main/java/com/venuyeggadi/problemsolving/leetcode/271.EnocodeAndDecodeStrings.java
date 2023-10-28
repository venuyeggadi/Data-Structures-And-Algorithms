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


import java.util.ArrayList;
import java.util.List;

// Solution 1
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

        for (int i = 0; i < str.length(); ) {
            int poundIndex = str.indexOf('#', i);
            int wordLength = Integer.parseInt(str.substring(i, poundIndex));
            int endIndex = poundIndex + wordLength;
            result.add(str.substring(poundIndex + 1, endIndex + 1));
            i = endIndex + 1;
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
