package com.venuyeggadi.problemsolving.leetcode;


/**
 * Bruteforce
 * Time: O(n * k)
 * Space: O(1)
 */
class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_Solution1 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int answer = 0;
        for (int i = 0; i <= arr.length - k; ++i) {
            int sum = 0;
            for (int j = i; j < i + k; ++j)
                sum += arr[j];
            if (sum * 1.0 / k >= threshold)
                ++answer;
        }

        return answer;
    }
}

class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_Solution1_Way1 {
    public int numOfSubarrays2(int[] arr, int k, int threshold) {
        int answer = 0;
        int r = k - 1;
        while (r < arr.length) {
            int sum = 0;
            for (int i = r - k + 1; i <= r; ++i)
                sum += arr[i];
            if (sum * 1.0 / k >= threshold)
                ++answer;
            ++r;
        }

        return answer;
    }
}


/**
 * Prefix Sum
 * Time: O(n)
 * Space: O(n)
 */
class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_Solution2 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; ++i)
            prefix[i] = arr[i] + prefix[i - 1];

        int answer = 0;
        for (int r = k - 1; r < arr.length; ++r) {
            int start = r - k + 1;
            int sum = prefixSum(prefix, start, r);
            if (sum * 1.0 / k >= threshold)
                ++answer;
        }

        return answer;
    }

    private static int prefixSum(int[] prefixSumArr, int start, int end) {
        if (start == 0)
            return prefixSumArr[end];
        return prefixSumArr[end] - prefixSumArr[start - 1];
    }
}

class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_Solution2_Way1 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i)
            prefix[i + 1] = prefix[i] + arr[i];

        int answer = 0;
        for (int end = k - 1; end < arr.length ; ++end) {
            int start = end - k + 1;
            int sum = prefix[end + 1] - prefix[start];
            if (sum * 1.0 / k >= threshold)
                ++answer;
        }

        return answer;
    }
}


/**
 * Sliding Window
 * Time: O(n)
 * Space: O(1)
 */
class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_Solution3 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int l = 0;
        int answer = 0;
        for (int r = 0; r < arr.length; ++r) {
            if (r - l + 1 > k) {
                if (sum * 1.0 / k >= threshold)
                    ++answer;
                sum -= arr[l++];
                sum += arr[r];
            } else
                sum += arr[r];
        }

        if (sum * 1.0 / k >= threshold)
            ++answer;

        return answer;
    }
}

class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_Solution3_Way1 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int curSum = 0;

        for (int i = 0; i < k - 1; i++) {
            curSum += arr[i];
        }

        for (int L = 0; L <= arr.length - k; L++) {
            curSum += arr[L + k - 1];
            if ((curSum / k) >= threshold) {
                res++;
            }
            curSum -= arr[L];
        }

        return res;
    }
}

class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_Solution3_Way2 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold *= k;
        int res = 0, curSum = 0;

        for (int R = 0; R < arr.length; R++) {
            curSum += arr[R];
            if (R >= k - 1) {
                if (curSum >= threshold) {
                    res++;
                }
                curSum -= arr[R - k + 1];
            }
        }
        return res;
    }
}