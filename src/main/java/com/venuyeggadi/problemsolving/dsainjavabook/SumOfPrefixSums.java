package com.venuyeggadi.problemsolving.dsainjavabook;

public class SumOfPrefixSums {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(sumOfPrefixSums1(arr));
        System.out.println(sumOfPrefixSums2(arr));
    }

    private static int sumOfPrefixSums1(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k <= i; k++)
                total += arr[k];
        }

        return total;
    }

    private static int sumOfPrefixSums2(int[] arr) {
        int prefix = 0, total = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];
            total += prefix;
        }

        return total;
    }
}
