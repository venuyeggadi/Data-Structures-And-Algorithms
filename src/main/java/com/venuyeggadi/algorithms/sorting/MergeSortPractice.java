package com.venuyeggadi.algorithms.sorting;

import java.util.Arrays;

public class MergeSortPractice {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 3, 6, 8, 9, 6, -4, -2, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] sorted = sortInner(arr, 0, arr.length - 1);
        System.arraycopy(sorted, 0, arr, 0, sorted.length);
    }

    private static int[] sortInner(int[] arr, int start, int end) {
        if (start == end)
            return new int[]{arr[start]};

        int mid = start + (end - start) / 2;
        int[] leftArray = sortInner(arr, start, mid);
        int[] rightArray = sortInner(arr, mid + 1, end);
        int[] merged = new int[leftArray.length + rightArray.length];

        int index = 0, leftIndex = 0, rightIndex = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                merged[index++] = leftArray[leftIndex++];
            } else {
                merged[index++] = rightArray[rightIndex++];
            }
        }

        while (leftIndex < leftArray.length)
            merged[index++] = leftArray[leftIndex++];

        while (rightIndex < rightArray.length)
            merged[index++] = rightArray[rightIndex++];

        return merged;
    }
}
