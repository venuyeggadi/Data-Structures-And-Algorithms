/** There is a biker going on a road trip. The road trip consists of n+1 points at
    different altitudes. The biker starts his trip on point 0 with altitude equal 0.
    You are given an integer array gain of length n where gain[i] is the net gain
    in altitude between points i and i+1 for all (0 <= i < n). Return the highest altitude of a point.

  * Example 1:
    Input: gain = [-5,1,5,0,-7]
    Output: 1
    Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
  * Example 2:
    Input: gain = [-4,-3,-2,-1,4,3,2]
    Output: 0
    Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.

  * Constraints:
    * n == gain.length
    * 1 <= n <= 100
    * -100 <= gain[i] <= 100
*/

//#1 O(n), O(n)
class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitude = new int[n+1];
        
        altitude[0] = 0;
        for(int i = 1; i < n+1; i++)
            altitude[i] = altitude[i-1] + gain[i-1];
        
        int max = altitude[0];
        for(int i : altitude)
            if(i > max)
                max = i;
        
        return max;
    }
}


//#2 O(n), O(1)
//modifying original array
class Solution {
    public int largestAltitude(int[] gain) {
        for(int i = 1; i < gain.length; i++)
            gain[i] += gain[i-1];
        
        int max = 0;
        for(int i : gain)
            if(i > max)
                max = i;
        
        return max;
    }
}

//#3 O(n), O(1)
//without modifying original array
class Solution {
    public int largestAltitude(int[] gain) {
        int runningSum = 0, max = 0;
        for(int i : gain) {
            runningSum += i;
            max = Math.max(max, runningSum);
        }
        
        return max;
    }
}