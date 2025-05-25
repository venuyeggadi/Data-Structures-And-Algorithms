package com.venuyeggadi.problemsolving.leetcode;

/**
 * Time: O(n * log n) ; log n is at max 32 here
 * Space: O(1)
 */
class CountingBits_Solution1Way1  {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i  = 0; i < result.length; i++)
            result[i] = numberOfBits(i);

        System.out.println(result);
        return result;
    }

    private int numberOfBits(int num) {
        int count = 0;

        while (num != 0) {
            if ((num & 1) == 1)
                count++;
            num = num >> 1;
        }

        return count;
    }
}

class CountingBits_Solution1Way2 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i  = 0; i < result.length; i++)
            result[i] = numberOfBits(i);
        return result;
    }

    private int numberOfBits(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0)
                ++count;
        }

        return count;
    }
}

class CountingBits_Solution1Way3 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i  = 0; i < result.length; i++)
            result[i] = numberOfBits(i);
        return result;
    }

    private int numberOfBits(int num) {
        int count = 0;
        while (num != 0) {
            ++count;
            num = num & (num - 1);
        }

        return count;
    }
}
