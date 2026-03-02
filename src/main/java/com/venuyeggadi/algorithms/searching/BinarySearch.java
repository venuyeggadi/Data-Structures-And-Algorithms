package com.venuyeggadi.algorithms.searching;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
        int key = scanner.nextInt();

        System.out.println(binarySearchIterative(array, key));
        System.out.println(binarySearchRecursive(array, 0, n-1, key));
        scanner.close();
    }

    /**
     * T(n) = T(n/2) + 1
     *      = T(n/2^k) + k
     *      = T(1) + k   (when n = 2^k)
     *      = log n      (since T(1) = 1)
     *
     * Time: O(log n)
     * Space: O(1)
     */
    static int binarySearchIterative(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(key == array[mid])
                return mid;
            if(key < array[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    /**
     * Time: O(log n)
     * Space: O(log n) to store method calls in stack
     */
    static int binarySearchRecursive(int[] array, int start, int end, int key) {
        if(start > end)
            return -1;

        int mid = start + (end-start)/2;
        if (array[mid] == key)
            return mid;
        else if(key < array[mid])
            return binarySearchRecursive(array, start, mid-1, key);
        else
            return binarySearchRecursive(array, mid+1, end, key);
    }
}
