package com.venuyeggadi.algorithms.recursion;

public class ProductOfEvenNumbers {
    public static void main(String[] args) {
        System.out.println(productOfEvenNumbers(new int[]{1, 2, 3, 4, 5}));
    }

    private static int productOfEvenNumbers(int[] arr) {
        return productOfEvenNumbersInner(arr, 0);
    }

    private static int productOfEvenNumbersInner(int[] arr, int index) {
        if (index == arr.length)
            return 1;

        if (arr[index] % 2 == 0)
            return arr[index] * productOfEvenNumbersInner(arr, index + 1);

        return productOfEvenNumbersInner(arr, index + 1);
    }
}
