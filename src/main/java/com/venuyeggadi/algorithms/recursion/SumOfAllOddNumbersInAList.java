package com.venuyeggadi.algorithms.recursion;

public class SumOfAllOddNumbersInAList {
    public static void main(String[] args) {
        System.out.println(sumOfOddNumbers(new int[]{1, 2, 3, 4, 5}));
    }

    private static int sumOfOddNumbers(int[] arr) {
        return sumOfOddNumbersInner(arr, 0);
    }

    private static int sumOfOddNumbersInner(int[] arr, int index) {
        if (index == arr.length)
            return 0;

        if (arr[index] % 2 == 1)
            return arr[index] + sumOfOddNumbersInner(arr, index + 1);

        return sumOfOddNumbersInner(arr, index + 1);
    }
}
