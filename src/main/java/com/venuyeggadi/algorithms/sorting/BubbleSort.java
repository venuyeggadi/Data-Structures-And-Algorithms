package com.venuyeggadi.algorithms.sorting;

import java.util.Scanner;

class BubbleSort
{
    static void bubbleSortIterative(int[] a)
    {
        int temp;
        for(int times = 0; times < a.length - 1; times++)
        {
            for(int index = 0; index < a.length - 1 - times; index++)
            {
                if(a[index] > a[index+1])
                {
                    temp = a[index];
                    a[index] = a[index+1];
                    a[index+1] = temp;
                }
            }
        }
    }

    static void bubbleSortRecursive(int[] a, int n)
    {
        if(n <= 1)
            return;
        int temp;
        for(int j = 0; j < a.length - 1; j++)
        {
            if(a[j] > a[j+1])
            {
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
        bubbleSortRecursive(a, --n);
    }
}
