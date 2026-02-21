package com.venuyeggadi.algorithms.sorting;

public class QuickSelect {
    public static void main(String[] args) {

    }


    /**
     * Partitions the array such that all the numbers before requiredIndex are less and elements after requiredIndex are greater than or equal to it.
     * So after the partition, given requiredIndex = K:
     *      Kth smallest element will be positioned at K - 1.
     *      Elements in the index range [0, k-1] are the k smallest elements.
     *
     * Time:
     *      O(N) in the average case, when divided by half at each step.
     *          T(N) = T(N/2) + N = 1 + ... + N/4 + N/2 + N
     *               = O(N)
     *          OR Master Theorem helps to get an average complexity by writing the algorithm cost as T(N) = a T(N/b) + f(N).
     *          Here we have an example of Master Theorem case III: T(N)=T(2)+N, which results in O(N) time complexity.
     *          That's the case with random pivots.
     *      O(N^2) in the worst case.
     *          In the worst case of constantly badly chosen pivots, the problem is not divided by half at each step,
     *          it becomes just one element less, which leads to O(N^2) time complexity. It happens, for example,
     *          if at each step you choose the pivot not randomly, but take the rightmost element. For the random pivot choice,
     *          the probability of having such a worst-case is negligibly small.
     *
     * Space:
     *      Average: O(log n)
     *      Worst case: O(n)
     */
    private void quickSelect(int[] nums, int start, int end, int requiredIndex) {
        if (start >= end)
            return;

        int pivotIndex = partition(nums, start, end);

        if (pivotIndex == requiredIndex) {
            return;
        } else if (requiredIndex < pivotIndex) {
            quickSelect(nums, start, pivotIndex - 1, requiredIndex);
        } else {
            quickSelect(nums, pivotIndex + 1, end, requiredIndex);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        swap(nums, mid, end);

        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                swap(nums, i, left);
                ++left;
            }
        }

        swap(nums, left, end);

        return left;
    }

    // Different way to partition, avoids unnecessary swapping
    private int partition1(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        swap(nums, mid, end);

        int left = start, right = end - 1;
        while (left <= right) {
            if (nums[left] < nums[end]) {
                left++;
            }
            else {
                swap(nums, left, right);
                --right;
            }
        }

        swap(nums, left, end);

        return left;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}