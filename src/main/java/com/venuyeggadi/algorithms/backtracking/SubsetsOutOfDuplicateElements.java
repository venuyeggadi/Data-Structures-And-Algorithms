package com.venuyeggadi.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetsOutOfDuplicateElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 5};
        var result = subsets(nums);
        System.out.println(result.stream().map(l -> l.stream().reduce(Integer::sum)).collect(Collectors.toList()));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<Integer>();

        Arrays.sort(nums);

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

        while (index + 1 < nums.length && nums[index] == nums[index + 1])
            ++index;

        createSubsets(nums, index + 1, subset, result);
    }
}
