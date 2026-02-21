package com.venuyeggadi.problemsolving.leetcode;

/*
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements.
   You may return the answer in any order.

 * Example 1:
   Input: nums = [1,1,1,2,2,3], k = 2
   Output: [1,2]

 * Example 2:
   Input: nums = [1], k = 1
   Output: [1]

 * Constraints:
    * 1 <= nums.length <= 105
    * k is in the range [1, the number of unique elements in the array].
    * It is guaranteed that the answer is unique.

 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */


import java.util.*;


// Solution 1
/**
 * Sorting
 *
 * Time complexity: O(n + n + nlog(n)) = O(nlog(n))
 * Space complexity: O(n + n + n) = O(n)
 *
 * Note: Mergesort - O(nlog(n)), O(n)
 */
class TopKFrequentElements_Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        ArrayList<Integer> uniqueNumList = new ArrayList<>(frequencyMap.keySet());

        uniqueNumList.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = uniqueNumList.get(i);

        return result;
    }
}

class TopKFrequentElements_Solution1_Way2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int[][] freqToNum = new int[map.size()][2];

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freqToNum[index][0] = entry.getValue();
            freqToNum[index][1] = entry.getKey();
            ++index;
        }

        Arrays.sort(freqToNum, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[k];
        index = 0;
        for (int i = freqToNum.length - k; i < freqToNum.length; ++i) {
            result[index++] = freqToNum[i][1];
        }

        return result;
    }
}


// Solution 2
/**
 * Priority Queue
 *
 * Adding all the elements to a priority queue (max heap) and then getting the first k elements would work. It takes O(n log n) time.
 * Instead of that, we can use a minHeap and ensure that there are only k elements at any point (which will be top K elements) and time
 * would only be O(n log k)
 *
 * Time complexity: O(n + nlog(k)) => O(n log k)
 * Space complexity: O(n + k) => O(n)
 */
class TopKFrequentElements_Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int number : nums) {
            numToCount.put(number, numToCount.getOrDefault(number, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(numToCount::get));
        // OR Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(key -> numToCount.get(key)));
        // OR Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> numToCount.get(a) - numToCount.get(b));

        for (int key : numToCount.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = minHeap.poll();

        return result;
    }
}

class TopKFrequentElements_Solution2_Way2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums)
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            pq.offer(new int[]{ entry.getValue(), entry.getKey() });
            if (pq.size() > k)
                pq.poll();
        }

        int[] result = new int[k];
        int i = 0;
        for (int[] pair : pq)
            result[i++] = pair[1];

        return result;
    }
}


// Solution 3
/**
 * Bucket Sort
 *
 * Time complexity: O(n + n + n + n) = O(n)
 * Space complexity: O(n + n + n) = O(n)
 */
class TopKFrequentElements_Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        List<Integer>[] frequencyBuckets = new ArrayList[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (frequencyBuckets[frequency] == null)
                frequencyBuckets[frequency] = new ArrayList<>();
            frequencyBuckets[frequency].add(key);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = frequencyBuckets.length-1; resultList.size() < k; i--) {
            if (frequencyBuckets[i] != null) {
                resultList.addAll(frequencyBuckets[i]);
            }
        }

        //int[] result = resultList.stream().mapToInt(a -> a).toArray();
        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = resultList.get(i);

        return result;
    }
}

class TopKFrequentElements_Solution3_Way2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        ArrayList<Integer>[] bucket = new ArrayList<>[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0; --i) {
            if (bucket[i] == null)
                continue;
            List<Integer> numbers = bucket[i];
            for (int num : numbers)
                result[index++] = num;
            if (index == k)
                break;
        }

        return result;
    }
}


/**
 * QuickSelect
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
 * Space: O(N)
 */
class TopKFrequentElements_Solution4 {
    private int[] unique;
    private Map<Integer, Integer> frequency;

    public int[] topKFrequent(int[] nums, int k) {
        frequency = new HashMap<Integer, Integer>();
        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int n = frequency.size();
        unique = new int[n];
        int i = 0;
        for (int num: frequency.keySet()) {
            unique[i] = num;
            i++;
        }

        // partition n - k smallest elements, same as k largest elements
        quickSelect(0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }

    /**
     * Partitions the array such that all the numbers before requiredIndex are less and elements after requiredIndex are greater than or equal to it.
     * So after the partition, given requiredIndex = K:
     *      Kth smallest element will be positioned at K - 1.
     *      Elements in the index range [0, k-1] are the k smallest elements.
     */
    private void quickSelect(int start, int end, int requiredIndex) {
        if (start >= end)
            return;

        int pivotIndex = partition(start, end);

        if (pivotIndex == requiredIndex) {
            return;
        } else if (requiredIndex < pivotIndex) {
            quickSelect(start, pivotIndex - 1, requiredIndex);
        } else {
            quickSelect(pivotIndex + 1, end, requiredIndex);
        }
    }

    private int partition(int start, int end) {
        int mid = start + (end - start) / 2;
        swap(mid, end);

        int left = start;
        for (int i = start; i < end; i++) {
            if (frequency.get(unique[i]) < frequency.get(unique[end])) {
                swap(i, left);
                ++left;
            }
        }

        swap(left, end);

        return left;
    }

    // Different way to partition, avoids unnecessary swapping
    private int partition1(int start, int end) {
        int mid = start + (end - start) / 2;
        swap(mid, end);

        int left = start, right = end - 1;
        while (left <= right) {
            if (frequency.get(unique[left]) < frequency.get(unique[end])) {
                left++;
            }
            else {
                swap(left, right);
                --right;
            }
        }

        swap(left, end);

        return left;
    }

    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }
}