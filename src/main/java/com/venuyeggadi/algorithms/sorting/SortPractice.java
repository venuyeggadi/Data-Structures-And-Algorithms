package com.venuyeggadi.algorithms.sorting;

import java.util.Arrays;

public class SortPractice {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 3, 6, 8, 9, 6, -4, -2, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    private static void sort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    private static void quicksort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(nums, start, end); // Choose a number and place it in its correct position

        quicksort(nums, start, pivotIndex - 1);
        quicksort(nums, pivotIndex + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        swap(nums, mid, end);

        int l = start, r = end - 1;
        while (l <= r) {
            if (nums[l] <= nums[end])
                ++l;
            else {
                swap(nums, l, r);
                --r;
            }
        }

        swap(nums, l, end);

        return l;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
