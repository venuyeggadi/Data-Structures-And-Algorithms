package com.venuyeggadi.algorithms.sorting;

import java.util.Scanner;

class BubbleSort
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = b[i] = in.nextInt();

        bubbleSortIterative(a);
        bubbleSortRecursive(b, n);

        for(int el : a)
            System.out.print(el+" ");
        System.out.println();
        for(int el : b)
            System.out.print(el+" ");
    }

    static void bubbleSortIterative(int[] a)
    {
        int temp;
        for(int i = 0; i < a.length - 1; i++)
        {
            for(int j = 0; j < a.length - 1; j++)
            {
                if(a[j] > a[j+1])
                {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
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
