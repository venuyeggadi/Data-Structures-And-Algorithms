package com.venuyeggadi.algorithms.recursion;

import java.util.Arrays;

public class MaximumValueAndIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 8, 5, 6};
        System.out.println(Arrays.toString(maxValue(arr)));
    }

    public static int[] maxValue(int[] arr) {
        return maxValueInner(arr, 0);
    }

    private static int[] maxValueInner(int[] arr, int index) {
        if (index == arr.length)
            return null;
        int[] current = new int[]{arr[index], index};
        int[] nextMax = maxValueInner(arr, index + 1);
        if (nextMax == null || current[0] > nextMax[0])
            return current;
        return nextMax;
    }
}
