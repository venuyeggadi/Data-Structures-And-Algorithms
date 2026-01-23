package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Backtracking
 *
 * Time: O(2^(t/m))
 *      Because it forms a decision tree (2 choice) of height t/m.
 * Space: O(t/m)
 *
 *      where t -> target
 *            m -> minimum number in the candidates array.
 */

class CombinationSum_Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        generateCombinations(candidates, target, 0, combination, 0, result);

        return result;
    }

    private void generateCombinations(int[] candidates, int target, int index, List<Integer> combination, int sum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (sum > target || index >= candidates.length)
            return;

        combination.add(candidates[index]);
        generateCombinations(candidates, target, index, combination, sum + candidates[index], result);

        combination.remove(combination.size() - 1);
        generateCombinations(candidates, target, index + 1, combination, sum, result);
    }
}

/**
 * Backtracking (Optimal)
 *
 * Intuition
 * This optimized backtracking solution avoids exploring useless paths by using sorting + early stopping.
 *   * We sort the numbers so that once a number makes the sum exceed the target,
 *     all numbers after it will also exceed the target - we can safely stop exploring further (break / return).
 *   * At each position, we try every number starting from index i, allowing reuse of the same number.
 *   * We build combinations step-by-step, and whenever the running total equals the target, we record the current list.
 *
 *
 * Time: O(2 ^(t/m))
 * Space: O(t/m)
 *
 *      where t -> target
 *            m -> minimum number in the candidates array.
 */

class CombinationSum_Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        Arrays.sort(candidates);

        generateCombinations(candidates, target, 0, combination, 0, result);

        return result;
    }

    private void generateCombinations(int[] candidates, int target, int index, List<Integer> combination, int sum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int j = index; j < candidates.length; ++j) {
            if (sum + candidates[j] > target)
                return;
            combination.add(candidates[j]);
            generateCombinations(candidates, target, j, combination, sum + candidates[j], result);
            combination.remove(combination.size() - 1);
        }
    }
}