package com.venuyeggadi.algorithms.recursion;


public class ReverseAString {
    public static void main(String[] args) {
        System.out.println(reverseV1("123456"));
        System.out.println(reverseV2("123456"));
        System.out.println(reverseV3("123456"));
    }

    public static String reverseV1(String str) {
        if (str.length() < 2)
            return str;
        return reverseV1(str.substring(1)) + str.charAt(0);
    }

    public static String reverseV2(String str) {
        return reverseV2Inner(str, 0);
    }

    private static String reverseV2Inner(String str, int i) {
        if (i == str.length())
            return "";
        return reverseV2Inner(str, i + 1) + str.charAt(i);
    }

    public static String reverseV3(String str) {
        return reverseV3Inner(str, 0, str.length() - 1);
    }

    private static String reverseV3Inner(String str, int start, int end) {
        if (start == end)
            return String.valueOf(str.charAt(start));
        if (end == start + 1)
            return String.valueOf(str.charAt(end)) + String.valueOf(str.charAt(start));

        return str.charAt(end) + reverseV3Inner(str, start + 1, end - 1) + str.charAt(start);
    }
}
