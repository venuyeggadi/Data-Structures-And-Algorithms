/**
 * Given an array of integers nums and an integer target, return indices of the two numbers
   such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same
   element twice.
 * You can return the answer in any order.

 * Example 1:
   Input: nums = [2,7,11,15], target = 9
   Output: [0,1]
   Output: Because nums[0] + nums[1] == 9, we return [0, 1].

 * Example 2:
   Input: nums = [3,2,4], target = 6
   Output: [1,2]
   
 * Example 3:
   Input: nums = [3,3], target = 6
   Output: [0,1]

 * Constraints:
   * 2 <= nums.length <= 10^4
   * -10^9 <= nums[i] <= 10^9
   * -10^9 <= target <= 10^9
   * Only one valid answer exists.
 */


//Bruteforce Time : O(n^2) , Space : O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        boolean found = false;
        int i = 0, j = 0;
        for(i = 0; i < nums.length - 1; i++) {
            for(j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    found  = true;
                    break;
                }
            }
            if(found)
                break;
        }//we can also use labelled for loop to exit the outer loop directly
        return new int[]{i,j};
    }
}
//Same Bruteforce with optimised return statement
class Solution {
    public int[] twoSum(int[] nums, int target) {
        boolean found = false;
        int i = 0, j = 0;
        for(i = 0; i < nums.length - 1; i++) {
            for(j = i + 1; j < nums.length; j++) {
            	if(nums[i] + nums[j] == target)
            		return new int[]{i, j};
            }
        }
    
        return new int[]{-1, -1};
    }
}


//Using HashMap(Dictionary) Time : O(n), Space : O(n)
/**
 * Time complexity : O(n). We traverse the list containing n elements only once.
       Each look up in the Hash table costs only O(1) time.
 * Space complexity : O(n). The extra space required depends on the number of
       items stored in the hash table, which stores at most n elements.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int complement;
        for(int i = 0; i < nums.length; i++) {
        	complement = target - nums[i];
        	if(map.containsKey(complement))
        		return new int[] { map.get(complement), i};
        	//else (optinal);
        	map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}