package com.venuyeggadi;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
            new int[]{1, 1, 3},
            new int[]{1, 1, 2},
            new int[]{1, 1, 1},
            new int[]{1, 1, 5}
        };

        Arrays.sort(arr, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(arr);

        for (int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
