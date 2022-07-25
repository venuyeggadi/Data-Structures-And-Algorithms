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
/*
Time complexity: O(n + n + nlog(n)) = O(nlog(n))
Space complexity: O(n + n + n) = O(n)
Note: Mergesort - O(nlog(n)), O(n)
 */
class TopKFrequentElementsSolution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        ArrayList<Pair> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet())
            freqList.add(new Pair(entry.getKey(), entry.getValue()));

        freqList.sort((a, b) -> b.frequency - a.frequency);

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = freqList.get(i).number;

        return result;
    }

    private static class Pair {
        public int number;
        public int frequency;

        public Pair(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }
    }
}


// Solution 2
/*
Time complexity: O(nlog(k))
Space complexity: O(n)
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        Queue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            final int num = entry.getKey();
            final int freq = entry.getValue();
            minHeap.offer(new Pair(num, freq));
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; ++i)
            result[i] = minHeap.poll().number;

        return result;
    }

    private static class Pair {
        public int number;
        public int frequency;

        public Pair(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }
    }
}


// Solution 3
/*
Time complexity: O(n + n + n + n) = O(n)
Space complexity: O(n + n + n) = O(n)
 */
class TopKFrequentElementsSolution3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        ArrayList<Integer>[] arr = new ArrayList[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (arr[frequency] == null)
                arr[frequency] = new ArrayList<>();
            arr[frequency].add(key);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = arr.length-1; resultList.size() < k; i--) {
            if (arr[i] != null) {
                resultList.addAll(arr[i]);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = resultList.get(i);

        return result;
    }
}
