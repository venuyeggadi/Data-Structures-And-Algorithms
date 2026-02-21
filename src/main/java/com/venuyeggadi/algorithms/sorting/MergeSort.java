package com.venuyeggadi.algorithms.sorting;

import java.util.Arrays;


/**
 * Time: O(n log n)
 *      T(n) = 2 T(n/2) + n
 *      T(n) = 2^logn * T(1) + n log n
 *      T(n) = n + n log n
 * Space: O(n)
 */
class MergeSort
{
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 3, 6, 8, 9, 6, -4, -2, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if(end <= start)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums,mid + 1, end);

        merge(nums, start, mid, end);
        // merge2(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int n = end - start + 1;
        int[] merged = new int[n];

        int i = start, j = mid + 1;
        for (int index = 0; index < n; ++index) {
            if (i > mid)
                merged[index] = nums[j++];
            else if (j > end)
                merged[index] = nums[i++];
            else if (nums[i] <= nums[j])
                merged[index] = nums[i++];
            else
                merged[index] = nums[j++];
        }

        int index = start;
        for (int num : merged)
            nums[index++] = num;
    }

    // Another way to merge
    private static void merge2(int[] nums, int start, int mid, int end) {
        int n = end - start + 1;
        int[] merged = new int[n];

        int i = start, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j])
                merged[index++] = nums[i++];
            else
                merged[index++] = nums[j++];
        }

        while (i <= mid)
            merged[index++] = nums[i++];

        while (j <= end)
            merged[index++] = nums[j++];

        index = start;
        for (int num : merged)
            nums[index++] = num;
    }
}