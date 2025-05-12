package com.venuyeggadi.algorithms.sorting;

// Time: 2n => O(n)
// Space: O(k) where k is the range of values
public class BucketSort {
    public static void sort(int[] arr) {
        int[] frequency = new int[100];
        for (int num : arr) {
            frequency[num]++;
        }

        int resultIndex = 0;
        for (int num = 0; num < frequency.length; num++) {
            int times = frequency[num];
            for (int i = 0; i < times; i++) {
                arr[resultIndex++] = num;
            }
        }
    }
}
