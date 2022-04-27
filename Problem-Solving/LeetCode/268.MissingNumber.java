/* Given an array nums containing n distinct numbers in the range [0, n],
   return the only number in the range that is missing from the array.

   Follow up: Could you implement a solution using only O(1) extra space
   complexity and O(n) runtime complexity?

 * Example 1:
   Input: nums = [3,0,1]
   Output: 2
   Explanation: n = 3 since there are 3 numbers, so all numbers are in the
   range [0,3]. 2 is the missing number in the range since it does not appear in nums.

 * Example 2:
   Input: nums = [0,1]
   Output: 2
   Explanation: n = 2 since there are 2 numbers, so all numbers are in the
   range [0,2]. 2 is the missing number in the range since it does not appear in nums.

 * Example 3:
   Input: nums = [9,6,4,2,3,5,7,0,1]
   Output: 8
   Explanation: n = 9 since there are 9 numbers, so all numbers are in the
   range [0,9]. 8 is the missing number in the range since it does not appear in nums.

 * Example 4:
   Input: nums = [0]
   Output: 1
   Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1].
   1 is the missing number in the range since it does not appear in nums.

 * Constraints:
   * n == nums.length
   * 1 <= n <= 104
   * 0 <= nums[i] <= n
   * All the numbers of nums are unique.
*/

//#1 Math
/*
Time complexity : O(n)
   Although Gauss' formula can be computed in O(1) time, summing nums costs
   us O(n) time, so the algorithm is overall linear.
Space complexity : O(1)
   This approach only pushes a few integers around, so it has constant memory usage.
*/
class Solution {
    public int missingNumber(int[] nums) {
        int requiredSum = nums.length * (nums.length + 1)/2;
        int actualSum = 0;
        for(int num : nums) {
            actualSum += num;
        }
        
        return requiredSum - actualSum;
    }
}


//#2 Bruteforce
/*
Complexity Analysis
   Time complexity : O(n*log(n))
   The only elements of the algorithm that have asymptotically non-constant
   time complexity are the main for loop (which runs in O(n) time), and the
   sort invocation (which runs n*log(n) time for Java(Dual-Pivot Quicksort)). 
   herefore, the runtime is dominated by sort, and the entire runtime is O(n*log(n)).
Space complexity : O(1)
   As we have used constant space and also Quicksort takes O(1) space.
*/
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        /*below approach fails if the missing number is either last or first
          number to be in the actual array(if either 0 or n is missing). So */ 
        //Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }
        // If we get here, then the missing number is on the range (0, n)
        for(int i = 1; i < nums.length; i++)
            if(nums[i] - nums[i - 1] != 1)
                return nums[i] - 1;
        
        //for compiler
        return -1;
    }
}



//#3 HashSet
/* Intuition
   A brute force method for solving this problem would be to simply check
   for the presence of each number that we expect to be present. The naive
   implementation might use a linear scan of the array to check for containment,
   but we can use a HashSet to get constant time containment queries and
   overall linear runtime.
*/
/* Complexity Analysis
Time complexity : O(n)
   Because the set allows for O(1) containment queries, the main loop runs
   in O(n) time. Creating numSet costs O(n) time, as each set insertion runs
   in amortized O(1) time, so the overall runtime is O(n + n) = O(n).
Space complexity : O(n)
   nums contains n−1 distinct elements, so it costs O(n) space to store a
   set containing all of them.
*/
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums)
            numSet.add(num);
        
        for(int num = 0; num <= nums.length; num++) {
            if(!numSet.contains(num)) {
                return num;
            }
        }
        
        return -1;//for compiler
    }
}



//#4 Bit manipulation
/* Intuion
     We can harness the fact that XOR is its own inverse to find the missing
     element in linear time.
     original elements -> [0, 1, 2, ..., n-1, n] -->length n+1
               indices ->  0, 1, 2, ..., n-1, n
     given elements  -> [1, 0, 3, ..., someRandomNums in[0, n-1]] -->length n
             indices ->  0, 1, 2, ..., n-1
     so xoring all the elements with their indices in the original array gives 0.
     but an element is missing in the given array. So xoring all the elemets in
     the given array along with the index n gives the missing element.
     
Time complexity : O(n)
   Assuming that XOR is a constant-time operation, this algorithm does
   constant work on n iterations, so the runtime is overall linear.
Space complexity : O(1)
   This algorithm allocates only constant additional space.
*/


class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for(int i = 0; i < nums.length; i++)
            ans ^= (nums[i] ^ i);
        
        return ans;
    }
}