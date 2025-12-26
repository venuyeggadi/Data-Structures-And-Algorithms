package com.venuyeggadi.algorithms.recursion;

public class MultiplicationOfTwoNumbers {
    public static void main(String[] args) {
        System.out.println(multiplyV2(5, 5));
        System.out.println(multiplyV2(5, -5));
        System.out.println(multiplyV2(-5, 5));
        System.out.println(multiplyV2(-5, -5));
    }

    private static int multiplyV1(int m, int n) {
        if (n == 0)
            return 0;
        if (n < 0) {
            m = -m;
            n = -n;
        }

        return m + multiplyV1(m, n - 1);
    }

    private static int multiplyV2(int m, int n) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -m + multiplyV2(m, n + 1);
        return m + multiplyV2(m, n - 1);
    }
}
