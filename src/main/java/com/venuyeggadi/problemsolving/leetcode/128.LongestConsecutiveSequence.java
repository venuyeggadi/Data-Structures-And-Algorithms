package com.venuyeggadi.problemsolving.leetcode;

/* https://leetcode.com/problems/longest-consecutive-sequence/solution/
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.

 * Example 1:
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 * Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

 * Constraints:
    * 0 <= nums.length <= 105
    * -109 <= nums[i] <= 109
 */

import java.util.*;


/**
 * By sorting
 *
 * Time complexity: O(nlog(n) + n) = O(nlog(n))
 * Space complexity: O(n) -> for merge sort, O(log n) for quick sort
 *
 * Note: If we make a copy of the given array instead of sorting in-place, space complexity = O(n)
 */
class LongestConsecutiveSequence_Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        longestStreak = Math.max(longestStreak, currentStreak);

        return longestStreak;
    }
}

class LongestConsecutiveSequence_Solution1_Better {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                continue;
            if (nums[i + 1] == nums[i] + 1) {
                ++count;
                max = Math.max(max, count);
            }
            else {
                count = 1;
            }
        }

        return max;
    }
}

// ***** Time Limit Exceeded. ******
/**
 * Set
 *     For each number, count all the consecutive numbers present in the given data.
 *     For checking the if the consecutive numbers exist or not, we can directly scan array which
 *     would make the total time complexity O(n^3). We can scan the data in O(1) by using a Set which
 *     would result in O(n^2)
 *
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
class LongestConsecutiveSequence_Solution2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums)
            numSet.add(num);

        int longestStreak = 1;

        for (int num : numSet) {
            int currentNum = num;
            int currentStreak = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}


/**
 * Set
 *      Skip counting the sequence for the number if the number is in the middle of the sequence because
 *      it would've already been counted.
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Note: If we make a copy of the given array instead of sorting in-place, space complexity = O(n)
 */
class LongestConsecutiveSequence_Solution3 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);

        int longestStreak = 0;
        for (int num : numSet) {
            if (numSet.contains(num-1))
                continue;
            int currentNum = num;
            int currentStreak = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}



/**
 * Union Find - Disjoint Set
 * Union By Rank
 *
 *  Time: O(n.a(n)) ~ O(n)
 *  Space: O(n)
 */
class LongestConsecutiveSequence_Solution4 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        int index = 0;
        for (int num : nums) {
            numToIndex.putIfAbsent(num, index++);
        }

        int uniqueNumbers = index;
        UnionFind uf = new UnionFind(uniqueNumbers);

        for (int num : numToIndex.keySet()) {
            if (numToIndex.containsKey(num + 1))
                uf.union(numToIndex.get(num), numToIndex.get(num + 1));
        }

        Map<Integer, Integer> parentToCount = new HashMap<>();
        for (int i = 0; i < uniqueNumbers; i++) {
            int parent = uf.find(i);
            parentToCount.put(parent, parentToCount.getOrDefault(parent, 0) + 1);
        }

        int max = 0;
        for (int count : parentToCount.values()) {
            max = Math.max(count, max);
        }

        return max;
    }

    public static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int v) {
            if (v != parent[v])
                parent[v] = find(parent[v]);
            return parent[v];
        }

        public boolean union(int v1, int v2) {
            int p1 = find(v1), p2 = find(v2);
            if (p1 == p2)
                return false;

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p2] > rank[p1]) {
                parent[p1] = p2;
            } else {
                parent[p1] = p2;
                ++rank[p2];
            }

            return true;
        }
    }
}


/**
 * Union Find - Disjoint Set
 * Union By Size
 *
 * Time: O(n.a(n)) ~ O(n)
 * Space: O(n)
 */
class LongestConsecutiveSequence_Solution4_Way1 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        int index = 0;
        for (int num : nums) {
            numToIndex.putIfAbsent(num, index++);
        }

        int uniqueNumbers = index;
        UnionFind uf = new UnionFind(uniqueNumbers);

        for (int num : numToIndex.keySet()) {
            if (numToIndex.containsKey(num + 1))
                uf.union(numToIndex.get(num), numToIndex.get(num + 1));
        }

        return uf.getMaxSize();
    }

    public class UnionFind {
        private final int[] parent;
        private final int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int v) {
            if (v != parent[v])
                parent[v] = find(parent[v]);
            return parent[v];
        }

        public boolean union(int v1, int v2) {
            int p1 = find(v1), p2 = find(v2);
            if (p1 == p2)
                return false;

            if (size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            } else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }

            return true;
        }

        public int getMaxSize() {
            int max = 0;
            for (int num : size)
                max = Math.max(num, max);

            return max;
        }
    }
}


/**
 * HashMap - Union Find style
 *      Boundary merging. The sequence will have accurate length of the sequence at the boundaries,
 *      i.e., left and right ends.
 *
 * Time: O(n)
 * Space: O(n)
 */
class LongestConsecutiveSequence_Solution5 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (map.containsKey(num))
                continue;
            int leftLength = map.getOrDefault(num - 1, 0);
            int rightLength = map.getOrDefault(num + 1, 0);
            int currentLength = 1 + leftLength + rightLength;
            map.put(num, currentLength);
            map.put(num - leftLength, currentLength);
            map.put(num + rightLength, currentLength);
            res = Math.max(res, currentLength);
        }

        return res;
    }
}
