package com.venuyeggadi.problemsolving.leetcode;

/*
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
   such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.

 * Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

 * Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

 * Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.

 * Constraints:
    * 3 <= nums.length <= 3000
    * -10^5 <= nums[i] <= 10^5
 */


import java.util.*;


// Solution 1
/*
Two Pointers and Set
Time complexity: O(nlog(n) + n^2) = O(n^2)
Space complexity: O(n + log(n)) = O(n)
Note that the space complexity of Arrays.sort() (Quicksort) is O(log(n))
 */
class ThreeSumSolution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1, right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) ++left;
                else if (sum > 0) --right;
                else {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    ++left;
                    --right;
                }
            }
        }

        return new ArrayList<>(set);
    }
}


// Solution 2
/*
Two Pointers
Time complexity: O(nlog(n) + n^2) = O(n^2)
Space complexity: O(log(n))
Note that the space complexity of Arrays.sort() (Quicksort) is O(log(n))
 */
class ThreeSumSolution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();

        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) ++left;
                else if (sum > 0) --right;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    ++left;
                    --right;
                    while(left < right && nums[left] == nums[left - 1])
                        ++left;
                    while(left < right && nums[right] == nums[right + 1])
                        --right;
                }
            }
        }

        return result;
    }
}

