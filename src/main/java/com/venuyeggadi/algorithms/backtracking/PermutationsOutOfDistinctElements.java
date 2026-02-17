package com.venuyeggadi.algorithms.backtracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Backtracking
 *
 * Time: O(n! + n * n!) => O(n * n!)
 *      e * n! -> n! for all recursive calls
 *      n * n! for the leaf nodes of the recursive calls where we're copying list of size n, and number of leaf nodes will be n!
 * Space:
 * Excluding output list: O(n + n) => O(n)
 *      n -> at max for recursive stack
 *      n -> permutation list
 * Output list takes a space of n * n!
 */
class PermutationsOutOfDistinctElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = new ArrayList<>();

        permutations(nums, new boolean[nums.length], new ArrayList<>(), result);

        System.out.println(result);
    }

    private static void permutations(int[] nums, boolean[] included, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!included[i]) {
                permutation.add(nums[i]);
                included[i] = true;
                permutations(nums, included, permutation, result); /** backtrack */
                included[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
