package com.venuyeggadi.problemsolving.leetcode;

/*
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
   compute how much water it can trap after raining.

 * Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
    In this case, 6 units of rain water (blue section) are being trapped.

 * Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9

 * Constraints:
    * n == height.length
    * 1 <= n <= 2 * 10^4
    * 0 <= height[i] <= 10^5

 */


// Solution 1
/*
Bruteforce
Time complexity: O(n^2)
Space complexity: O(1)
 */
class TrappingRainWaterSolution1 {
    public int trap(int[] height) {
        int length = height.length;
        int result = 0;

        for (int i = 1; i < length - 1; ++i) {
            int leftMax = 0, rightMax = 0;
            for (int k = i - 1; k >= 0; --k)
                leftMax = Math.max(leftMax, height[k]);

            for (int k = i + 1; k < length; ++k)
                rightMax = Math.max(rightMax, height[k]);

            int water = Math.min(leftMax, rightMax) - height[i];
            result += Math.max(water, 0);
        }

        return result;
    }
}


// Solution 2
/*
Using prefix and suffix arrays -- Leetcode solution page called it DP
Time complexity: O(n)
Space complexity: O(n)
 */
class TrappingRainWaterSolution2 {
    public int trap(int[] height) {
        int length = height.length;
        int[] leftMaxArr = new int[length];
        int[] rightMaxArr = new int[length];

        leftMaxArr[0] = height[0];
        for (int i = 1; i < length; ++i)
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);

        rightMaxArr[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; --i)
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);

        int result = 0;

        for (int i = 1; i < length - 1; i++) {
            int leftMax = leftMaxArr[i - 1];
            int rightMax = rightMaxArr[i + 1];
            int water = Math.min(leftMax, rightMax) - height[i];
            result += Math.max(water, 0);
        }

        return result;
    }
}


// Solution 3
/*
Using a global maxima
Time complexity: O(n)
Space complexity: O(1)
 */
class TrappingRainWaterSolution3 {
    public int trap(int[] height) {
        int n = height.length;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (height[i] > height[maxIndex])
                maxIndex = i;
        }

        int ans = 0;

        int leftMax = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] < leftMax)
                ans += leftMax - height[i];
            else
                leftMax = height[i];
        }

        int rightMax = 0;
        for (int i = n - 1; i > maxIndex; i--) {
            if (height[i] < rightMax)
                ans += rightMax - height[i];
            else
                rightMax = height[i];
        }

        return ans;
    }
}


// Solution 3
/*
Using two pointers
Time complexity: O(n)
Space complexity: O(1)
 */

