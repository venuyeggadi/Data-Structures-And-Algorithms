package com.venuyeggadi.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
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
