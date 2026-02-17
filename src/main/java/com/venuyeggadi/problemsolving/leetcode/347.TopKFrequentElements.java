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
 * Time complexity: O(nlog(k))
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


class TopKFrequentElements_Solution4 {
    private int[] unique;
    private Map<Integer, Integer> count;

    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }

        quickselect(0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickselect(int left, int right, int kThIndexFromRight) {
        if (left == right) return;

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);

        pivotIndex = partition(left, right, pivotIndex);

        if (kThIndexFromRight == pivotIndex) {
            return;
        } else if (kThIndexFromRight < pivotIndex) {
            quickselect(left, pivotIndex - 1, kThIndexFromRight);
        } else {
            quickselect(pivotIndex + 1, right, kThIndexFromRight);
        }
    }

    private int partition(int left, int right, int pivotIndex) {
        int pivotFrequency = count.get(unique[pivotIndex]);
        swap(pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivotFrequency) {
                swap(storeIndex, i);
                storeIndex++;
            }
        }

        swap(storeIndex, right);

        return storeIndex;
    }

    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }
}