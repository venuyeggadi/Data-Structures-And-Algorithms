package com.venuyeggadi.algorithms.sorting;

public class QuickSort {

      public static void sort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
      }

      private static void quickSort(int[] arr, int startIndex, int endIndex) {
            if (startIndex >= endIndex)
                  return;
            int pivotIndex = (startIndex + endIndex) / 2;
            int leftPointer = startIndex, rightPointer = endIndex;

            for (int i = startIndex; i <= endIndex; i++) {
                  if (arr[i] <= arr[pivotIndex]) {
                        swap(arr, leftPointer++, i);
                  } else {
                        swap(arr, rightPointer--, i);
                  }
            }

            quickSort(arr, startIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, endIndex);
      }

      private static void swap(int[] arr, int indexA, int indexB) {
            int temp = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = temp;
      }
}
