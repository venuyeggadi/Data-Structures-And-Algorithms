package com.venuyeggadi.problemsolving.basicprograms;

import java.util.Scanner;

class MaximumValueInArray
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();

        System.out.println(maxValue(a));
    }
    //O(n)
    static int maxValue(int[] a)
    {
        int max = a[0];
        for(int i = 1; i < a.length; i++)
            if(a[i] > max)
                max = a[i];
        return max;
    }
}
