package com.venuyeggadi;

public class Contest {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestBalancedIndex(new int[]{1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,359738368,1,536870913,262144,131072}));
    }
}

class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long product = 1;
        long sum = 0;
    
        for (int num : nums)
            sum += num;

        for (int i = nums.length - 1; i >= 0; --i) {
            sum -= nums[i];
            if (product > sum)
                break;
            if (sum == product)
                return i;

            product *= nums[i];
        }

        return -1;
    }
}
