package com.venuyeggadi.algorithms.sorting;


/**
 * Intuition
 * Selecting one element at a time and placing it in its correct position, i.e., all the elements left to it are less than or equal to it
 * and all the elements right to it or greater than or equal to it.
 * This element is commonly known as pivot. Now that this element is in its correct position, rest is to do the same for the elements
 * left to it and right to it. So the flow is as follows,
 *    1. Partition: Choose an element and place it in its right position, which divides the array into two parts.
 *    2. Recursively do the same for left and right parts.
 * Partition can be achieved in many ways.
 *
 * Time:
 *    Average case: O(n log n) <= Assuming (on average) that the elements we choose find their position in the middle of the array so the partition makes the array into two equals halves.
 *          Time = 2 * time taken for half + time for partition
 *          T(n) = 2 * T (n/2) + n
 *          T(n) = n + n log n
 *    Worst case: O(n^2) <= when the elements we choose find their position in the ends of the array which results in skewed partition (like [0, n-2] and [n-1, n-1]).
 * Space:
 *    Average case: O(log n) <= space for recursive stack when partition happens in middle.
 *    Worst case: (n) <= space for recursive stack when partition happens on ends.
 */
public class QuickSort {

      public static void sort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
      }

      private static void quickSort(int[] arr, int startIndex, int endIndex) {
            if (startIndex >= endIndex)
                  return;

            int pivotIndex = partition(arr, startIndex, endIndex);

            quickSort(arr, startIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, endIndex);
      }

      /** More intuitive */
      private static int partition(int[] nums, int start, int end) {
            int mid = start + (end - start) / 2;
            swap(nums, mid, end);

            int l = start, r = end - 1;
            while (l <= r) {
                  if (nums[l] < nums[end])
                        ++l;
                  else {
                        swap(nums, l, r);
                        --r;
                  }
            }

            swap(nums, l, end);

            return l;
      }

      private static int partition1(int[] arr, int start, int end) {
            int mid = (start + end) / 2;
            swap(arr, mid, end);

            int left = start;
            for (int i = start; i < end; ++i) {
                  if (arr[i] < arr[end]) {
                        swap(arr, i, left);
                        left++;
                  }
            }

            swap(arr, left, end);

            return mid;
      }

      private static void swap(int[] arr, int indexA, int indexB) {
            int temp = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = temp;
      }
}
