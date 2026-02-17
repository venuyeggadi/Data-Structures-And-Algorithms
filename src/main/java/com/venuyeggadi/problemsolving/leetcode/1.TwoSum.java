package com.venuyeggadi.problemsolving.leetcode;


/*
 * Given an array of integers nums and an integer target, return indices of the two numbers
   such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same
   element twice.
 * You can return the answer in any order.

 * Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

 * Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

 * Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

 * Constraints:
    * 2 <= nums.length <= 10^4
    * -10^9 <= nums[i] <= 10^9
    * -10^9 <= target <= 10^9
    * Only one valid answer exists.
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/** Solution 1
 * Bruteforce
 * Time : O(n^2)
 * Space : O(1)
 * */
class TwoSum_Solution1 {
    public int[] twoSum(int[] nums, int target) {
        boolean found = false;
        int i, j = 0;
        for (i = 0; i < nums.length - 1; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }//we can also use labelled for loop to exit the outer loop directly
        return new int[]{i, j};
    }
}

//Same Bruteforce with optimised return statement
class TwoSum_Solution1_WithBetterReturnStatement {
    public int[] twoSum(int[] nums, int target) {
        boolean found = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }
}

/**
 * Solution 2
 * Sorting
 * Intuition
 *     We can sort the array and use two pointers to find the two numbers that sum up to the target.
 *     This is more efficient than the brute force approach. This approach is similar to the one used in Two Sum II.
 *
 * Time : O(n log n)
 * Space : O(n)
 *      n -> for num to index mapping array
 *      log n OR n-> space for sorting (log n for quicksort, n for mergesort)
 */
class TwoSum_Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[][] numIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; ++i) {
            numIndex[i][0] = nums[i];
            numIndex[i][1] = i;
        }

        Arrays.sort(numIndex, Comparator.comparingInt(a -> a[0])); // OR Arrays.sort(numIndex, (a, b) -> a[0] - b[0]);

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = numIndex[left][0] + numIndex[right][0];
            if (sum == target)
                return new int[]{numIndex[left][1], numIndex[right][1]};
            else if (sum < target)
                ++left;
            else
                --right;
        }

        return null;
    }
}

/**
 * Using HashMap (Dictionary) - Two Pass
 * We can reduce the time complexity to 'n' by making lookup table for the elements instead of linearly searching for the
 * compliment element that is needed.
 * Pre-compute a hash map of number and their indices. Scan the array checking for compliment in the hashmap.
 *
 * Time : O(n), Space : O(n)
 */
class TwoSum_Solution3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();  // num -> index

        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numToIndex.containsKey(diff) && numToIndex.get(diff) != i) {
                return new int[]{i, numToIndex.get(diff)};
            }
        }

        return new int[0];
    }
}

/**
 * Using HashMap (Dictionary) - One pass
 * Building lookup table on the fly. Scan each element in the array by checking for complement in previously added elements to the hashmap.
 *
 * Time complexity : O(n).
 *      We traverse the list containing n elements only once. Each look up in the Hash table costs only O(1) time.
 * Space complexity : O(n).
 *      The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 */
class TwoSum_Solution4 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), index};
            //else (optional);
            map.put(nums[index], index);
        }
        return null;
    }
}