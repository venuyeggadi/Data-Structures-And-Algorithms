package com.venuyeggadi.problemsolving.leetcode;


import java.util.Arrays;

/**
 * Bruteforce
 * Concatenate and sort, find median
 *
 * Time: m + n + (m+n)log(m+n) => O((m+n)log(m+n))
 *      m + n => for concatenation
 *      (m+n) log (m+n) for sorting
 * Space:
 *      m + n for merged array
 *      m + n for sorting (either quick or merge sort)
 */
class MedianOfTwoSortedArrays_Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int L = m + n;
        int[] merged = new int[L];
        System.arraycopy(nums1, 0, merged, 0, m);
        System.arraycopy(nums2, 0, merged, m, n);

        Arrays.sort(merged);

        if ((L & 1) == 1)
            return merged[L / 2];
        else
            return (merged[(L - 1) / 2] + merged[L / 2]) / 2.0;
    }
}

/**
 * Merge and find median
 *
 * Time: O(m + n)
 * Space: O(m + n)
 *
 *      where m = nums1.length
 *            n = num1.length
 */
class MedianOfTwoSortedArrays_Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int L = m + n;
        if (L == 0)
            return 0;

        int[] merged = new int[L];

        int i = 0, j = 0, index = 0;

        while (index < L) {
            if (i >= m)
                merged[index] = nums2[j++];
            else if (j >= n)
                merged[index] = nums1[i++];
            else if (nums1[i] <= nums2[j])
                merged[index] = nums1[i++];
            else
                merged[index] = nums2[j++];

            ++index;
        }

        if ((L & 1) == 1)
            return merged[L / 2];
        else
            return (merged[(L - 1) / 2] + merged[L / 2]) / 2.0;
    }
}

/**
 * Instead of actually merging, we can simulate merging and find the middle element(s), to avoid using extra space.
 *
 * Time: O(m + n)
 * Space: O(1)
 *
 *      where m = nums1.length
 *            n = num1.length
 */
class MedianOfTwoSortedArrays_Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int L = m + n;
        if (L == 0)
            return 0;

        int i = 0, j = 0, index = 0;
        int requiredIndex = L / 2;
        int median1 = 0, median2 = 0;

        while (index <= requiredIndex) {
            median1 = median2;
            if (i >= m)
                median2 = nums2[j++];
            else if (j >= n)
                median2 = nums1[i++];
            else if (nums1[i] <= nums2[j])
                median2 = nums1[i++];
            else
                median2 = nums2[j++];

            ++index;
        }

        if ((L & 1) == 1)
            return median2;
        else
            return (median1 + median2) / 2.0;
    }
}


/**
 * Binary Search
 *      Intuition
 *      Find the middle element of the combined array without merging the two arrays.
 *      Let's say we want to find the median of arrays having length 10 and 15.
 *      It means out task is to find the 13th (say kth) element if they're merged.
 *      So we take say half of the elements (k / 2) from each array and eliminate those half elements
 *      that will definitely be part of the first k elements.
 *      We can do this until either of the arrays are exhausted or when k = 1 (just need to find the minimum first of the two arrays)
 *
 * Time: O(log (m + n))
 * Space: O(log (m + n)) for recursion stack.
 */
class MedianOfTwoSortedArrays_Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int L = m + n;

        if (L % 2 == 0) {
            int k1 = L / 2;
            int k2 = k1 + 1;
            int median1 = findKthSmallestElement(nums1, 0, nums2, 0, k1);
            int median2 = findKthSmallestElement(nums1, 0, nums2, 0, k2);
            return (median1 + median2) / 2.0;
        }

        int k = L / 2 + 1;
        return findKthSmallestElement(nums1, 0, nums2, 0, k);
    }

    private int findKthSmallestElement(int[] nums1, int startIndex1, int[] nums2, int startIndex2, int k) {
        int m = nums1.length - startIndex1, n = nums2.length - startIndex2;

        if (m == 0)
            return nums2[startIndex2 + k - 1];
        if (n == 0)
            return nums1[startIndex1 + k - 1];

        if (k == 1)
            return Math.min(nums1[startIndex1], nums2[startIndex2]);

        int i = Math.min(m, k/2);
        int j = Math.min(n, k/2);

        if (nums1[startIndex1 + i - 1] <= nums2[startIndex2 + j - 1])
            return findKthSmallestElement(nums1, startIndex1 + i, nums2, startIndex2, k - i);
        else
            return findKthSmallestElement(nums1, startIndex1, nums2, startIndex2 + j, k - j);
    }
}


/**
 * Binary Search - Optimal
 *      We need to find the middle element (say kth) if they're merged. But because they're separated, we need to select
 *      some number (say i) of elements from first array and remaining (k - i) from the second array. We perform binary search
 *      on the first array to choose some number of elements, like a partition and check if that partition forms the first k elements.
 *
 *      Reason for swapping the arrays and choosing the smaller one as first array:
 *      1. Time complexity would be log(min(m,n)) instead of log(m).
 *      2. When first array is bigger, it takes values from binary search ranges form 0 <= i <= m (number of elements chosen),
 *         when i is an extreme value, say 0, it forces j to be k which could be out of bounds for j.
 *         Ex: m = 10, n = 2
 *             k = 6
 *             when, i = 0, j = 6 which is out of bounds for second array (n = 2)
 *
 *      If we don't want to swap, i should be limited in range,
 *      valid j range is 0 <= j <= n but j is forced to be (k - i),
 *      so, 0 <= k - i <= n
 *          -k <= -i <= n-k
 *          k-n <= i <= k
 *
 * Time: O(log(min(m,n))
 * Space: O(1)
 */
class MedianOfTwoSortedArrays_Solution5 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =  nums1.length, n = nums2.length;
        if (n < m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int L = m + n;
        int half = (L + 1) / 2; /** divide exactly by half (half+1 in case of odd number of elements) */

        int l = 0, r = m;
        // int l = Math.max(0, half - n), r = Math.min(half, m); // If not swapped

        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;
            /** i = number of elements considered from nums1 and j from nums2
                i - 1 and j - 1 are the positions of those arrays */

            /** We want to consider the ith and its next element to check if the partition is correct */
            int nums1Left = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int nums1Right = i < m ? nums1[i] : Integer.MAX_VALUE;
            int nums2Left = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int nums2Right = j < n ? nums2[j] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if (L % 2 == 0)
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                return Math.max(nums1Left, nums2Left);
            } else if (nums1Left <= nums2Right) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }

        return -1;
    }
}