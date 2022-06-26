package com.venuyeggadi.problemsolving.basicprograms;

import java.util.Scanner;

class AreAllTheElementsDistinct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        System.out.println(areAllDistinct(a));
    }

    //O(n^2), O(1)
    static boolean areAllDistinct(int[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] == a[j])
                    return false;
        return true;
    }
}