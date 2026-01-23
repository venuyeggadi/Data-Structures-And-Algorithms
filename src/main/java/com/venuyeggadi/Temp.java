package com.venuyeggadi;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        System.out.println(alternatingXOR(new int[]{2, 3, 1, 4}, 1, 5));
        System.out.println(alternatingXOR(new int[]{1, 0, 0}, 1, 0));
        System.out.println(alternatingXOR(new int[]{7}, 1, 7));
    }

    public static int alternatingXOR(int[] nums, int target1, int target2) {
        int[] targetArr = new int[]{target1, target2, 0};
        int[] memo0 = new int[nums.length];
        int[] memo1 = new int[nums.length];
        Arrays.fill(memo0, -1);
        Arrays.fill(memo1, -1);

        return rec(nums, 0, targetArr, memo0, memo1);
    }

    private static int rec(int[] nums, int index, int[] targetArr, int[] memo0, int[] memo1) {
        if (index == nums.length)
            return 1;
        int xor = 0;
        int count = 0;
        if (targetArr[2] == 0 && memo0[index] != -1)
            return memo0[index];
        if (targetArr[2] == 1 && memo1[index] != -1)
            return memo1[index];

        int[] nextTargetArr = new int[]{targetArr[0], targetArr[1], targetArr[2] ^ 1};

        for (int i = index; i < nums.length; ++i) {
            xor = nums[i] ^ xor;
            if (xor == targetArr[targetArr[2]])
                count += rec(nums, i + 1, nextTargetArr, memo0, memo1);
        }

        if (targetArr[2] == 0)
            memo0[index] = count;
        else
            memo1[index] = count;

        return count;
    }
}
