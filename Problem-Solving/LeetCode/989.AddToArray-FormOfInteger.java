/** 989. Add to Array-Form of Integer
 	The array-form of an integer num is an array representing its digits in left to right order.
 	For example, for num = 1321, the array form is [1,3,2,1].
 	Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
	
  * Example 1:
	Input: num = [1,2,0,0], k = 34
	Output: [1,2,3,4]
	Explanation: 1200 + 34 = 1234
	
  * Example 2:
	Input: num = [2,7,4], k = 181
	Output: [4,5,5]
	Explanation: 274 + 181 = 455
	
  * Example 3:
	Input: num = [2,1,5], k = 806
	Output: [1,0,2,1]
	Explanation: 215 + 806 = 1021

  * Example 4:
	Input: num = [9,9,9,9,9,9,9,9,9,9], k = 1
	Output: [1,0,0,0,0,0,0,0,0,0,0]
	Explanation: 9999999999 + 1 = 10000000000 

  * Constraints:
	* 1 <= num.length <= 104
	* 0 <= num[i] <= 9
	* num does not contain any leading zeros except for the zero itself.
	* 1 <= k <= 104
*/

//#1
/*
Time: O(max(n, log(k)))
Space: O(max(n, log(k)))
*/
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> list = new LinkedList<>();
        int sum, carry = k;
        for(int i = n-1; i >= 0; i--) {
            sum = (num[i]+carry)%10;
            list.addFirst(sum);
            carry = (num[i]+carry)/10;
        }
        
        while(carry > 0) {
            list.add(0, carry%10);
            carry /= 10;
        }
        
        return list;
    }
}
//with same logic provided in editorial
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        int cur = k;
        List<Integer> ans = new ArrayList();

        int i = n;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += num[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}