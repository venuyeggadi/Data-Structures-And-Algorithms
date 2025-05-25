package com.venuyeggadi.problemsolving;

import java.util.ArrayList;
import java.util.List;

class Subsets_Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<Integer>();

        createSubsets(nums, 0, subset, result);

        return result;
    }

    private void createSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
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


class Subsets_Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {  // i < Math.pow(2, n)
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(subset);
        }
        
        return res;
    }
}



