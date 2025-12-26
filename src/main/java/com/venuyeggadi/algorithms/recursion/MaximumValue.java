package com.venuyeggadi.algorithms.recursion;

public class MaximumValue {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 8, 7, 6, 5, 4, 9};
        System.out.println(maxValueV1(arr));
        System.out.println(maxValueV2(arr));
    }

    public static int maxValueV1(int[] arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Array must not be empty");

        return maxValueV1Inner(arr, 0, arr.length - 1);
    }

    private static int maxValueV1Inner(int[] arr, int start, int end) {
        if (start == end)
            return arr[start];
        int mid = start + (end - start) / 2;
        int leftMax = maxValueV1Inner(arr, start, mid);
        int rightMax = maxValueV1Inner(arr, mid + 1, end);

        return Math.max(leftMax, rightMax);
    }

    public static int maxValueV2(int[] arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Array must not be empty");

        return maxValueV2Inner(arr, 0, arr.length - 1);
    }

    private static int maxValueV2Inner(int[] arr, int start, int end) {
        if (start == end)
            return arr[start];
        if (end - start == 1)
            return Math.max(arr[start], arr[end]);
        if (end - start == 2)
            return Math.max(Math.max(arr[start], arr[start + 1]), arr[end]);

        int segment = (end - start) / 3;
        int mid1 = start + segment; //1
        int mid2 = start + 2 * segment; //2

        int max1 = maxValueV2Inner(arr, start, mid1);
        int max2 = maxValueV2Inner(arr, mid1 + 1, mid2);
        int max3 = maxValueV2Inner(arr, mid2 + 1, end);

        return Math.max(Math.max(max1, max2), max3);
    }
}
