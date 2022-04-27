/** 1512. Number of Good Pairs
    Given an array of integers nums, return the number of good pairs.
    A pair (i, j) is called good if nums[i] == nums[j] and i < j.
  
  * Example 1:
    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

  * Example 2:
    Input: nums = [1,1,1,1]
    Output: 6
    Explanation: Each pair in the array are good.

  * Example 3:
    Input: nums = [1,2,3]
    Output: 0

  * Constraints:
    * 1 <= nums.length <= 100
    * 1 <= nums[i] <= 100
*/


//#1
//O(n^2), O(1)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int goodPairs = 0;
        
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++)
                if(nums[i] == nums[j])
                    goodPairs++;
        }
        
        return goodPairs;
    }
}


//#2
//O(n), O(1)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        int[] freqCount = new int[101];
        
        for(int num : nums) {
            goodPairs += freqCount[num];
            freqCount[num]++;
        }
        
        return goodPairs;
    }
}