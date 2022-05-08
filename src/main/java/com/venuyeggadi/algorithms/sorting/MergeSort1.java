package com.venuyeggadi.algorithms.sorting;

import java.util.Scanner;

class MergeSort1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();

        mergeSort(a, 0, a.length-1);

        for(int el : a)
            System.out.print(el+" ");
        System.out.println();
    }

    static void mergeSort(int[] a, int start, int end)
    {
        if(end - start == 0)
            return;

        int mid=(start+end)/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);

        merge(a, start, mid, end);
    }
    
    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}