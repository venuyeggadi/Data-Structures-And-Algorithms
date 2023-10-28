package com.venuyeggadi.problemsolving.leetcode;

/*
 * 167. Two Sum II - Input Array Is Sorted
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
   find two numbers such that they add up to a specific target number.
   Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.

 * Example 1:
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

 * Example 2:
    Input: numbers = [2,3,4], target = 6
    Output: [1,3]
    Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

 * Example 3:
    Input: numbers = [-1,0], target = -1
    Output: [1,2]
    Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

 * Constraints:
    * 2 <= numbers.length <= 3 * 10^4
    * -1000 <= numbers[i] <= 1000
    * numbers is sorted in non-decreasing order.
    * -1000 <= target <= 1000
    * The tests are generated such that there is exactly one solution.

 */


import java.util.Arrays;

// Solution 1
/*
Binary Search
Time complexity: O(n * log(n)) = O(nlog(n))
Space complexity: O(1)
 */
class TwoSumIISolution1 {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;

        for (int index1 = 0; index1 < length - 1; index1++) {
            int index2 = Arrays.binarySearch(numbers, index1 + 1, length, target - numbers[index1]);
            if (index2 >= 0)
                return new int[]{index1 + 1, index2 + 1};
        }

        return null;
    }
}


// Solution 2
/*
Two pointers
Time Complexty: O(n)
Space Complexity: O(1)
 */
class TwoSumIISolution2 {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int leftIndex = 0, rightIndex = length - 1;

        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum < target)
                ++leftIndex;
            else if (sum > target)
                --rightIndex;
            else
                return new int[]{leftIndex + 1, rightIndex + 1};
        }

        return null;
    }
}

// Solution 2
/*
Since there always exist a solution, we can write as below with same time and space complexity.
 */
class TwoSumIISolution2SpecificToProblem {
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (numbers[leftIndex] + numbers[rightIndex] != target) {
            if (numbers[leftIndex] + numbers[rightIndex] < target)
                ++leftIndex;
            else
                --rightIndex;
        }

        return new int[] {leftIndex + 1, rightIndex + 1};
    }
}
