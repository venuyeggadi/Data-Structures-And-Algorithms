package com.venuyeggadi.problemsolving.leetcode;

/** Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
	Return the array in the form [x1,y1,x2,y2,...,xn,yn].

  * Example 1:
	Input: nums = [2,5,1,3,4,7], n = 3
	Output: [2,3,5,4,1,7] 
	Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
  * Example 2:
	Input: nums = [1,2,3,4,4,3,2,1], n = 4
	Output: [1,4,2,3,3,2,4,1]
  * Example 3:
	Input: nums = [1,1,2,2], n = 2
	Output: [1,2,1,2]

  * Constraints:
	* 1 <= n <= 500
    * nums.length == 2n
    * 1 <= nums[i] <= 10^3
*/


/**
 * Time: O(n)
 * Space: O(1)
 * 		Output array is not considered as extra space.
 */
class ShuffleTheArray_Solution1 {
    public int[] shuffle(int[] nums, int n) {
		int[] shuffledArray = new int[nums.length];

		for (int i = 0; i < n; i++) {
			shuffledArray[2 * i] = nums[i];
			shuffledArray[2 * i + 1] = nums[n + i];
		}

		return shuffledArray;
    }
}

class ShuffleTheArray_Solution1_Way2 {
	public int[] shuffle(int[] nums, int n) {
		int[] shuffledArray = new int[nums.length];

		int index = 0;
		for (int i = 0; i < n; ++i) {
			shuffledArray[index++] = nums[i];
			shuffledArray[index++] = nums[i + n];
		}

		return shuffledArray;
	}
}


/**
 * In-place
 *
 * Intuition: : Encoding values using multiplication factor
 * Encode the existing value and new value in the same location in order avoid overwriting the existing value. Encoded value = existing value + ((new value) % M) * M
 * Existing value can be obtained by modulo (value % M), and new value can be obtained by dividing (value / M)
 * Choose the multiplication factor such that it is max(nums) + 1, So that modulo can work correctly.
 *
 * Time: O(n)
 * Time: O(1)
 */
class ShuffleTheArray_Solution2 {
	public int[] shuffle(int[] nums, int n) {
		int M = 1001; // Because 1 <= nums[i] <= 1000

		for (int i = 0; i < n; i++) {
			nums[2 * i] = nums[2 * i] + (nums[i] % M) * M;
			nums[2 * i + 1] = nums[2 * i + 1] + (nums[n + i] % M) * M;
		}

		for (int i = 0; i < nums.length; ++i)
			nums[i] = nums[i] / M;

		return nums;
	}
}

/**
 * Intuition: Encoding pairs of values using multiplication, then decoding them and copying to the array starting from last to avoid overwriting.
 */
class ShuffleTheArray_Solution2_Way2 {
	public int[] shuffle(int[] nums, int n) {
		int M = 1001; // Because 1 <= nums[i] <= 1000

		for (int i = 0; i < n; ++i) {
			nums[i] = nums[i] + nums[i + n] * M;
		}

		for (int i = nums.length - 1; i > 0; i -= 2) {
			int encoded = nums[i / 2];
			nums[i] = encoded / M;
			nums[i - 1] = encoded % M;
		}

		return nums;
	}
}

/**
 * Bit manipulation
 * Intuition
 * Same as solution 2 way 2 => Encoding pairs of values using bit manipulation, then decoding them and copying to the array starting from last to avoid overwriting.
 * Max value of nums[i] = 1000, So any value can fit in 10 bits (10 consecutive 1's = 1023).
 * So, we store a number's pair in the next 10 bits, and then decode back to get the result.
 */
class ShuffleTheArray_Solution3 {
	public int[] shuffle(int[] nums, int n) {

		for (int i = 0; i < n; ++i) {
			nums[i] = nums[i] | (nums[i + n] << 10);
		}

		for (int i = nums.length - 1; i > 0; i -= 2) {
			int encoded = nums[i / 2];
			int allOnes = (1 << 10) - 1; // OR 1023
			nums[i - 1] = encoded & allOnes;
			nums[i] = encoded >> 10; // OR (encoded & (allOnes << 10)) >> 10;
		}

		return nums;
	}
}

