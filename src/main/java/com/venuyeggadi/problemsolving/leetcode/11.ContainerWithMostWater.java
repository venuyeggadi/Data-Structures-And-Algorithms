package com.venuyeggadi.problemsolving.leetcode;

/*
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that
   the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.

 * Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
    the max area of water (blue section) the container can contain is 49.

 * Example 2:
    Input: height = [1,1]
    Output: 1

 * Constraints:
    * n == height.length
    * 2 <= n <= 10^5
    * 0 <= height[i] <= 10^4

 */


// Solution 1
/*
Bruteforce - Will be Time Limit Exceeded.
Time complexity: O(n^2)
Space complexity: O(1)
 */

class ContainerWithMostWaterSolution1 {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;

        for (int left = 0; left < length - 1; left++){
            for (int right = left + 1; right < length; right++) {
                int area = (right - left) * Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}


// Solution 2
/*
Two pointers
Time complexity: O(n)
Space complexity: O(1)
 */

class ContainerWithMostWaterSolution2 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) ++left;
            else --right;
        }

        return maxArea;
    }
}

class ContainerWithMostWaterSolution2Better {
    public int maxArea(int[] height) {
        int startIndex = 0, endIndex = height.length - 1;

        int maxArea = 0;

        while (startIndex < endIndex) {
            int length = Math.min(height[startIndex], height[endIndex]);
            int width = (endIndex - startIndex);
            int area = width * length;
            maxArea = Math.max(area, maxArea);

            if (height[startIndex] <= height[endIndex]) {
                while(height[startIndex] <= length && startIndex < endIndex)
                    startIndex++;
            }
            else {
                while(height[endIndex] <= length && startIndex < endIndex)
                    endIndex--;
            }
        }

        return maxArea;
    }
}
