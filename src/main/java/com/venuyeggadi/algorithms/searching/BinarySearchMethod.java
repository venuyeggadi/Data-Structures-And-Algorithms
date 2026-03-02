package com.venuyeggadi.algorithms.searching;

import java.util.Arrays;

public class BinarySearchMethod {
    public int binarySearch(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int isCorrect = isCorrect(mid);
            if (isCorrect > 0)
                left = mid - 1;
            else if (isCorrect < 0)
                right = mid + 1;

            return mid;
        }

        return -1;
    }

    // Assuming that we're searching for a number in the range [500, 1000]
    private int isCorrect(int num) {
        int product = num * num;
        if (product < 500)
            return -1;
        else if (product > 1000)
            return 1;

        return 0;
    }
}