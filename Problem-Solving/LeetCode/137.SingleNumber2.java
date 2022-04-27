/* Given an integer array nums where every element appears three times
   except for one, which appears exactly once. Find the single element
   and return it.

   You must implement a solution with a linear runtime complexity and 
   use only constant extra space.

 * Example 1:
   Input: nums = [2,2,3,2]
   Output: 3
 * Example 2:
   Input: nums = [0,1,0,1,0,1,99]
   Output: 99

 * Constraints:
   * 1 <= nums.length <= 3 * 104
   * -231 <= nums[i] <= 231 - 1
   * Each element in nums appears exactly three times except for one 
     element which appears once.
*/


//#1 HashMap
/*
Time : O(n)
Space : O(n)
*/
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(Integer num : map.keySet())
            if(map.get(num) == 1)
                return num;
        
        return 0;
    }
}



//#2 Bit Manipulation and Math
/*
Algorithm :
    0. take an array of size 32 to count the bits in numbers at respective indices
    1. count all the set bits that exist at respective indices in all the numbers
    2. travese the array to see if any one has a count which is not multiple of 3
       (ingeneral multiple of k if all the elements exist k times)
    3. It is not a multiple of three because it comes from that number which exists
       only once the given numbers. So, set the respective bit in the result to 1.
    4. return the result after traversing the whole array
*/
class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];
        int mask;
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                mask = 1 << i;
                if((num & mask) != 0)
                    bitCount[i]++;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; i++) {
            if(bitCount[i] % 3 != 0) {//ingeneral k times if all the elements exist k times.
                
                result = result | (1 << i);
            }
        }
        
        return result;
    }
}




//#5 Math
/*
Time : O(n)
Space : O(n)
*/
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long uniqueSum = 0;
        long totalSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                uniqueSum += num;
            }
            totalSum += num;
        }
        
        return (int) (((3 * setSum) - tSum) / 2);
    }
}


//#4 Brute force
/*
Time : O(nlogn)
Space : O(1)
*/
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
		for (int i=2; i<nums.length; i+=3) {
			if (nums[i] != nums[i-2])
				return nums[i-2];
		}
		return nums[nums.length-1];     
    }
}

