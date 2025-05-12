package com.venuyeggadi.algorithms.sorting;

import java.util.Scanner;

class InsertionSort {

    public static void insertionSortIterative(int[] arr) {
        // i = nonSortedIndex
        // j = insertionIndex;
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j] < arr[j-1]; j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void insertionSortIterative1(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j;
            for(j = i; j > 0 && num < arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = num;
        }
    }

    public static void InsertionSortRecursive(int[] arr, int i) {
        if( i == arr.length)
            return;
        for(int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
        }
        InsertionSortRecursive(arr, i+1);
    }
}
