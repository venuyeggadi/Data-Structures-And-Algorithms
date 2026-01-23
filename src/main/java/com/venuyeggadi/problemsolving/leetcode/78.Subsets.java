package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */

/**
 * Backtracking
 *
 * Intuition
 *      The idea is to build all possible subsets by making a choice at each step:
 *      for every number, we have two options — include it or exclude it.
 *      This naturally forms a decision tree.
 *
 *      Backtracking helps us explore both choices:
 *      * Add the current number → explore further
 *      * Remove it (undo) → explore without it
 *      * Whenever we reach the end of the array, the current list represents one
 *      * complete subset, so we store it.
 *
 *      This systematically generates all 2ⁿ subsets.
 *
 * Time: O(n * 2^n)
 *      n times because of cloning the subset.
 * Space: O(n)
 */
class Subsets_Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<Integer>();

        createSubsets(nums, 0, subset, result);

        return result;
    }

    private static void createSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        subset.add(nums[index]);
        createSubsets(nums, index + 1, subset, result);
        subset.remove(subset.size() - 1);
        createSubsets(nums, index + 1, subset, result);
    }
}

/**
 * Iteration
 *
 * Intuition:
 *      Start with just one subset: the empty set [].
 *      For every number in the array, we take all the subsets we have so far and
 *      create new subsets by adding the current number to each of them.
 * Example: input -> [1, 2, 3]
 *      Start: [[]]
 *      Add 1 → [[], [1]]
 *      Add 2 → [[], [1], [2], [1,2]]
 *      Add 3 → [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
 *      Each step doubles the number of subsets.
 *
 * Time: O(n * 2^n)
 * Space: O(n)
 */

class Subsets_Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        for (Integer num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }

        return result;
    }
}

/**
 * Bit Manipulation
 *
 * Intuition
 * Every subset can be represented using bits.
 * For an array of length n, there are 2^n possible subsets.
 * Each subset corresponds to a number from 0 to 2^n - 1.
 *
 * Example for nums = [a, b, c]:
 *      000 → choose nothing → []
 *      001 → choose c
 *      010 → choose b
 *      011 → choose b, c
 *      100 → choose a
 *      101 → choose a, c
 *      110 → choose a, b
 *      111 → choose a, b, c
 *
 * Each bit tells us whether to include the corresponding element.
 *
 * So for every integer num from 0 to 2^n-1:
 *
 * Check each j of num
 * If bit j is 1, include nums[j] in the current subset.
 *
 *
 * Time: O(n * 2^n)
 * Space: O(n)
 */
class Subsets_Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {  /** or i < Math.pow(2, n) */
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) { /** there will be bits sets at most till n positions in the binary representation of the number. It can bb j < 32 as well. But n is < 10 anyway. */
                if (isSetBit(i, j)) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        
        return res;
    }

    private boolean isSetBit(int num, int j) {
        return (num & (1 << j)) == 1;
    }
}



