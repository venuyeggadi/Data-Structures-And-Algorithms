package com.venuyeggadi.problemsolving.leetcode;

/* https://leetcode.com/problems/longest-consecutive-sequence/solution/
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.

 * Example 1:
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 * Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

 * Constraints:
    * 0 <= nums.length <= 105
    * -109 <= nums[i] <= 109
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// Solution 1
/*
By sorting
Time complexity: O(nlog(n) + n) = O(nlog(n))
Space complexity: O(1)
Note: If make a copy of the given array instead of sorting in-place, space complexity = O(n)
 */
class LongestConsecutiveSequenceSolution1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        longestStreak = Math.max(longestStreak, currentStreak);

        return longestStreak;
    }
}


// Solution 2
// ***** Time Limit Exceeded. ******
/*
Time complexity: O(n^2)
Space complexity: O(n)
 */
class LongestConsecutiveSequenceSolution2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums)
            numSet.add(num);

        int longestStreak = 1;

        for (int num : numSet) {
            int currentNum = num;
            int currentStreak = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}



// Solution 3
/*
By sorting
Time complexity: O(n)
Space complexity: O(n)
Note: If make a copy of the given array instead of sorting in-place, space complexity = O(n)
 */
class LongestConsecutiveSequenceSolution3 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums)
            numSet.add(num);

        int longestStreak = 1;

        for (int num : numSet) {
            if (!numSet.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}


