package com.venuyeggadi.problemsolving.leetcode;

/*
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of
   all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.

 * Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
 * Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

 * Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 * Follow up: Can you solve the problem in O(1) extra space complexity?
   (The output array does not count as extra space for space complexity analysis.)

 */


// Solution 0
/**
 * Bruteforce
 * For each element, compute the product of the rest of the elements.
 *
 * Time: O(n^2)
 * Space: O(1)
 */


//Solution 1
/**
 * Using two separate arrays for prefix and suffix products.
 *
 * Time complexity: O(n + n + n) = O(n)
 * Space complexity: O(n + n) = O(n)
 */
class ProductOfArrayExceptSelf_Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefixProduct = new int[length];
        int[] postfixProduct = new int[length];
        int[] result = new int[length];

        prefixProduct[0] = nums[0];
        for (int i = 1; i < length; i++)
            prefixProduct[i] = nums[i] * prefixProduct[i-1];

        postfixProduct[length-1] = nums[length-1];
        for (int i = length-2; i > -1; i--)
            postfixProduct[i] = nums[i] * postfixProduct[i+1];

        result[0] = postfixProduct[1];
        result[length-1] = prefixProduct[length-2];
        for (int i = 1; i < length-1; i++)
            result[i] = prefixProduct[i-1] * postfixProduct[i+1];

        return result;
    }
}

// Computing prefix and suffix in different way.
class ProductOfArrayExceptSelf_Solution1_Way2 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] prefixProduct = new int[length];
        int[] postfixProduct = new int[length];

        prefixProduct[0] = 1;
        for (int i = 1; i < length; i++)
            prefixProduct[i] = nums[i-1] * prefixProduct[i - 1];

        postfixProduct[length - 1] = 1;
        for (int i = length-2; i >= 0; i--)
            postfixProduct[i] = nums[i+1] * postfixProduct[i + 1];

        for (int i = 0; i < length; i++)
            result[i] = prefixProduct[i] * postfixProduct[i];

        return result;
    }
}

//Solution 2
/**
 * Without using extra space. Note that output array does not count as extra space.
 *
 * Initially result contains values such that result[i] = product of numbers till nums[i - 1].
 * In the second pass in reverse, it contains the actual result.
 *
 * Time complexity: O(n + n + n) = O(n)
 * Space complexity: O(1)
 */
class ProductOfArrayExceptSelf_Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        result[0] = 1;
        for (int i = 1; i < length; i++)
            result[i] = result[i - 1] * nums[i - 1];

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }

        return result;
    }
}

// For a consistent prefix, suffix calculation
class ProductOfArrayExceptSelf_Solution3 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int prefix = 1;
        for (int i = 0; i < length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}