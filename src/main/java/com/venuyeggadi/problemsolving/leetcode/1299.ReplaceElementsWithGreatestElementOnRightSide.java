package com.venuyeggadi.problemsolving.leetcode;/* Given an array arr, replace every element in that array with the greatest
   element among the elements to its right, and replace the last element with -1.
   After doing so, return the array.

 * Example 1:
   Input: arr = [17,18,5,4,6,1]
   Output: [18,6,6,6,1,-1]
   Explanation: 
     - index 0 --> the greatest element to the right of index 0 is index 1 (18).
     - index 1 --> the greatest element to the right of index 1 is index 4 (6).
     - index 2 --> the greatest element to the right of index 2 is index 4 (6).
     - index 3 --> the greatest element to the right of index 3 is index 4 (6).
     - index 4 --> the greatest element to the right of index 4 is index 5 (1).
     - index 5 --> there are no elements to the right of index 5, so we put -1.
 
 * Example 2:
   Input: arr = [400]
   Output: [-1]
   Explanation: There are no elements to the right of index 0.
 
 * Constraints:
   * 1 <= arr.length <= 104
   * 1 <= arr[i] <= 105
*/


//#1 Bruteforce
//O(n^2), O(1)
class ReplaceElementsWithGreatestElementOnRightSideSolution1 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max;
        for(int i = 0; i < n-1; i++) {
            max = arr[i+1];
            for(int k = i+2; k < n; k++)
                if(arr[k] > max)
                    max = arr[k];
            arr[i] = max;
        }
        arr[n-1] = -1;
        
        return arr;
    }
}


//#2
//O(n), O(1)
class ReplaceElementsWithGreatestElementOnRightSideSolution2 {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        
        for(int i = arr.length-1; i > -1; i--) {
            int num = arr[i];
            arr[i] = max;
            max = Math.max(max, num);
        }
        
        return arr;
    }
}