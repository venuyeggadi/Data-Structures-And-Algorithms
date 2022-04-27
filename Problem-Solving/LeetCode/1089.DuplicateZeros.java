/* Given a fixed length array arr of integers, duplicate each occurrence of zero,
   shifting the remaining elements to the right.
   Note that elements beyond the length of the original array are not written.
   Do the above modifications to the input array in place, do not return anything
   from your function.

 * Example 1:
   Input: [1,0,2,3,0,4,5,0]
   Output: null
   Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 
 * Example 2:
   Input: [1,2,3]
   Output: null
   Explanation: After calling your function, the input array is modified to: [1,2,3]

 * Note:
   * 1 <= arr.length <= 10000
   * 0 <= arr[i] <= 9
*/

//#1
//O(n^2) , O(1)
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                rightShiftByOneFrom(arr, i);
                i++;
            }
        }
    }
    
    static void rightShiftByOneFrom(int[] arr, int k) {
        for(int i = arr.length - 2; i >= k; i--)
            arr[i+1] = arr[i];
    }
}


//#2
//O(n), O(1)
class Solution {
    public void duplicateZeros(int[] arr) {
        int noOfZerosToLeft = 0;
        for(int num : arr)
            if(num == 0)
                noOfZerosToLeft++;
        
        int targetIndex;
        for(int lastIndex = arr.length-1; lastIndex > -1; lastIndex--) {
            if(arr[lastIndex] == 0) {
                noOfZerosToLeft--;
                targetIndex = lastIndex + noOfZerosToLeft;
                if(targetIndex < arr.length)
                    arr[targetIndex] = 0;
                if(targetIndex+1 < arr.length)
                    arr[targetIndex+1] = 0;
            } else {
                targetIndex = lastIndex + noOfZerosToLeft;
                if(targetIndex < arr.length)
                    arr[targetIndex] = arr[lastIndex];
            }
        }
    }
}