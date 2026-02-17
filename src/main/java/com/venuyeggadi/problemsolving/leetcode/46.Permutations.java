package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Iteration
 *
 * Time: 3 * (n+1)! => 3 * (n + 1) * n!  => O(n * n!)
 *        -> 1st time -> 1 * 1 * (3 * 1)           // result has 1 element i.e.,  [[]]
 *        -> 2nd time -> 1 * 2 * (3 * 2)           // result has 1 elements i.e., [[1]]
 *        -> 3rd time -> 2 * 3 * (3 * 3)           // result has 2 elements i.e., [[2,1], [1,2]]
 *        -> 4th time -> 6 * 4 * (3 * 4)           // result has 6 elements i.e., [[3,2,1], [2,3,1], [2,1,3], [3,1,2], [1,3,2], [1,2,3]]
 *        -> nth th time -> (n-1)! * n * (3 * n)   // result has (n-1)! elements
 *        Summing all over n,
 *        ∑{k=1}^{n} (k-1)! * 3 * k * k
 *        3 * ∑{k=1}^{n} k * k * (k-1)!
 *        3 * ∑{k=1}^{n} k * k!
 *        3 * ∑{k=1}^{n} (k + 1)! - k!   // since k * k! = (k + 1)! - k!
 *        3 * (n+1)! - 1!  $ (since intermediate terms cancel).
 *
 * Space:
 * Excluding output list: O(n + n) => O(n)
 *      n -> at max for recursive stack
 *      n -> permutation list
 * Output list takes a space of n * n!
 */
class Permutations_Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> resultTemp = new ArrayList<>();
            for (List<Integer> list : result) {
                for (int p = 0; p <= list.size(); ++p) {
                    list.add(p, num);
                    resultTemp.add(new ArrayList<>(list));
                    list.remove(p);
                }
            }
            result = resultTemp;
        }

        return result;
    }
}


/**
 * Backtracking
 * Intuition:
 *      Typical permutation logic.
 *      For any index k we have n - k elements to choose from.
 *      -> position 0 can any of the n elements
 *      -> position 1 can any of the n-1 elements (element at position 1 excluded)
 *      -> similarly, position 2 can any of the n-2 elements (element at position 2 excluded)
 *      And, total permutations will be n * (n - 1) * ... * 1 = n!
 *
 * Time: e * n! + n * n! = (e + n) * n! => O(n * n!)
 *      1. e * n! -> n! for all recursive calls
 *          The recursion tree has n + 1 levels (depth 0 to n).
 *          At depth d (0 ≤ d ≤ n), the number of recursive calls is n! / (n - d)!
 *          Depth 0 (root): 1 call
 *          Depth 1: n calls
 *          Depth 2: n × (n-1) calls
 *          ...
 *          Depth n: n! calls (the leaves)
 *
 *          ∑{d=0}^{n} [n! / (n - d)!]    =    n! × ∑{k=0}^{n} (1/k!) where k = n - d.
 *          Since ∑_{k=0}^{n} 1/k! ≤ e ≈ 2.718
 *      2. n * n! for the leaf nodes of the recursive calls where we're copying list of size n, and number of leaf nodes will be n!
 *
 * Space:
 * Excluding output list: O(n + n) => O(n)
 *      n -> at max for recursive stack
 *      n -> permutation list
 * Output list takes a space of n * n!
 */
class Permutations_Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
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
                permutations(nums, included, permutation, result);
                included[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}

/**
 * Backtracking (Optimal) - Space optimized
 * Same as the above backtracking solution without using extra spaces for tracking the chosen elements.
 * Intuition:
 *     This approach generates permutations in-place by swapping elements.
 *     Instead of creating new lists or tracking visited elements, we treat the array as divided into:
 *          1. Fixed prefix (positions 0 to idx - 1)    // elements which are already chosen
 *          2. Free suffix (positions idx to end)       // elements available to choose from
 *     At each step:
 *          1. We choose which element should go into position idx.
 *          2. We do this by swapping every element i ≥ idx with idx.
 *          3. After placing a number at position idx, we recursively fill the next index.
 *          4. When recursion returns, we swap back to restore the original list (backtracking).
 *
 *  Time: n * n!
 *       Same as above backtracking solution.
 *  Space: O(1)
 *  Output list takes a space of n * n!
 */

class Permutations_Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private static void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>(nums.length);
            for (int num : nums)
                permutation.add(num);
            result.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; ++i) {
            swap(nums, index, i);
            backtrack(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
