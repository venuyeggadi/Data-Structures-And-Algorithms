package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

class SubsetsII_Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);

        createSubsets(nums, 0, subset, result);

        return result;
    }

    private static void createSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        createSubsets(nums, index + 1, subset, result);

        subset.remove(subset.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1])
            ++index;

        createSubsets(nums, index + 1, subset, result);
    }
}
