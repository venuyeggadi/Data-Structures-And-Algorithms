package com.venuyeggadi.problemsolving.leetcode;
import java.util.PriorityQueue;

/** https://leetcode.com/problems/kth-largest-element-in-an-array/description/
*/

/** Using Bubble sorting technique
  * Time: O(k * n) and O(n^2) when k = n
  * Space: O(1)
 */
class KthLargestElementInAnArray_Solution1 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                for (int index = 0; index < nums.length - 1; index++) {
                    if (nums[index] > nums[index + 1]) {
                        int temp = nums[index];
                        nums[index] = nums[index + 1];
                        nums[index + 1] = temp;
                    }
                }
            }

            return nums[nums.length - k];
        }
    }
}

/** PriorityQueue
 * Time: O(n * log n)
 * Space: O(k)
 */
class KthLargestElementInAnArray_Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}
