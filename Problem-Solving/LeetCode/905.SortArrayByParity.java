/* Given an integer array nums, move all the even integers at the beginning
   of the array followed by all the odd integers.
   Return any array that satisfies this condition.
 * Example 1:
   Input: nums = [3,1,2,4]
   Output: [2,4,3,1]
   Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * Example 2:
   Input: nums = [0]
   Output: [0]

 * Constraints:
   * 1 <= nums.length <= 5000
   * 0 <= nums[i] <= 5000
*/

//#1
//just move all the even numbers to left, odd numbers will be moved automatically
//O(n), O(1)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int evenPointer = 0;
        for(int i = 0; i < n; i++)
            if(nums[i]%2 == 0)
                swap(nums, i, evenPointer++);
        
        return nums;
    }
    
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//#2
//O(n), O(1)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int endPointer = nums.length-1;
        int startPointer = 0;
        while(startPointer < endPointer) {
            if(nums[startPointer]%2 != 0) {
                int temp = nums[startPointer];
                nums[startPointer] = nums[endPointer];
                nums[endPointer] = temp;
                endPointer--;
            } else {
                startPointer++;
            }
        }
        
        return nums;
    }
}

//#3
//O(n), O(1)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i]%2 > nums[j]%2) {//when odd and even
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            if (nums[i] % 2 == 0) i++;
            if (nums[j] % 2 == 1) j--;
        }

        return nums;
    }
}

