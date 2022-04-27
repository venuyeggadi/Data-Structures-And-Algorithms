/* Given an array arr of integers, check if there exists two integers N and M such
   that N is the double of M ( i.e. N = 2 * M).
   More formally check if there exists two indices i and j such that :
   i != j
   0 <= i, j < arr.length
   arr[i] == 2 * arr[j]

 * Example 1:
   Input: arr = [10,2,5,3]
   Output: true
   Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
  
 * Example 2:
   Input: arr = [7,1,14,11]
   Output: true
   Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 
 * Example 3:
   Input: arr = [3,1,7,11]
   Output: false
   Explanation: In this case does not exist N and M, such that N = 2 * M. 

 * Constraints:
   * 2 <= arr.length <= 500
   * -10^3 <= arr[i] <= 10^3
*/

//#1 Bruteforce
//O(n^2), O(1)
class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(arr[i] == 2*arr[j] || arr[j] == 2*arr[i])
                    return true;
            }
        }
        
        return false;
    }
}


//#2 Using Set
//O(n), O(n)
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();

        for(int num : arr) {
            if(set.contains(2*num) || (num%2 == 0 && set.contains(num/2)))
                return true;
            else
                set.add(num);
        }
        
        return false;
    }
}
/* num%2 == 0 && set.contains(num/2)
   Here we are making sure that it is even because there is no way half of an odd
   number exists in integer set. So it produces incorrect results if we won't check
   for this condition.
   Ex: if 3 is in the set and if we chech whether 7/2 = 3 is in the set, it returns
       true. but it is false because 2*3 != 7
*/