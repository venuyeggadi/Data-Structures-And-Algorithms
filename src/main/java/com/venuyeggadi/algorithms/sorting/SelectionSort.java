package com.venuyeggadi.algorithms.sorting;

import java.util.Scanner;

class SelectionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = b[i] = in.nextInt();

        selectionSortIterative(a);
        selectionSortRecursive(b, 0);

        for(int el : a)
            System.out.print(el+" ");
        System.out.println();
        for(int el : b)
            System.out.print(el+" ");
    }

    static void selectionSortIterative(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < a.length; j++)
                if(a[j]<a[minIndex])
                    minIndex = j;

            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    static void selectionSortRecursive(int[] a, int i) {
        if( i == a.length-1)
            return;
        int minIndex = i;
        for(int j = i + 1; j < a.length; j++)
            if(a[j] < a[minIndex])
                minIndex = j;
        int temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
        selectionSortRecursive(a, i+1);
    }
}
