package com.venuyeggadi.problemsolving.leetcode;

/**
 * https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bruteforce
 * Time: O(k * n)
 * Space: O(1)
 */
class FinalArrayStateAfterKMultiplicationOperations_I_Solution1 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; ++i) {
            int index = minValueIndex(nums);
            nums[index] = nums[index] * multiplier;
        }

        return nums;
    }

    private static int minValueIndex(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < arr[minIndex])
                minIndex = i;
        }

        return minIndex;
    }
}


/**
 * Priority Queue
 * Time: O(n + k log n + n log n)
 *      n -> for building the priority queue (Heapify algorithm)
 *      k * log n -> for manipulation
 *      n * log n -> for forming back the nums array
 * Space: O(n)
 */
class FinalArrayStateAfterKMultiplicationOperations_I_Solution2 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < nums.length; ++i) {
            pq.offer(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; ++i) {
            int[] minValue = pq.poll();
            pq.offer(new int[]{minValue[0] * multiplier, minValue[1]});
        }

        while (!pq.isEmpty()) {
            int[] value = pq.poll();
            nums[value[1]] = value[0];
        }

        return nums;
    }
}

/**
 * Priority Queue
 * Time: O(n + k log n)
 *      n -> for building the priority queue (Heapify algorithm)
 *      k * log n -> for manipulation
 * Space: O(n)
 */
class FinalArrayStateAfterKMultiplicationOperations_I_Solution2_Better {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < nums.length; ++i) {
            pq.offer(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; ++i) {
            int[] minValue = pq.poll();
            int index = minValue[1];
            nums[index] = nums[index] * multiplier;
            pq.offer(new int[]{nums[index], index});
        }

        return nums;
    }
}
