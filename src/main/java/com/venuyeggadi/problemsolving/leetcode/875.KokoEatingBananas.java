package com.venuyeggadi.problemsolving.leetcode;


/**
 * Bruteforce
 *      Start with speed 1 and increase if Koko cannot finish all piles. First speed with which it can finish all the bananas
 *      is the minimum speed.
 *
 * Time: O(m * n)
 * Space: O(1)
 *
 *      Where n is the length of the input array piles and m is the maximum number of bananas in a pile.
 */
class KokoEatingBananas_Solution1_Way1 {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1;

        while (true) {
            if (canEatAllPiles(piles, h, speed)) {
                return speed;
            }
            ++speed;
        }
    }

    private boolean canEatAllPiles(int[] piles, int targetHours, int speed) {
        int hours = 0;
        for (int num : piles)
            hours += Math.ceil(1.0 * num / speed);

        return hours <= targetHours;
    }
}

/**
 * Same as above, limit it to the maximum speed instead of the infinite loop.
 * maximum speed is the maximum number of bananas in a pile.
 */
class KokoEatingBananas_Solution1_Way2 {
    public int minEatingSpeed(int[] piles, int h) {
        int maximum = max(piles);

        for (int i = 1; i <= maximum; ++i) // OR we can iterate in reverse
            if (canEatAllPiles(piles, h, i))
                return i;

        return -1;
    }

    private boolean canEatAllPiles(int[] piles, int targetHours, int speed) {
        int hours = 0;
        for (int num : piles)
            hours += Math.ceil(1.0 * num / speed);

        return hours <= targetHours;
    }

    private int max(int[] nums) {
        int max = nums[0];
        for (int num : nums)
            if (num > max)
                max = num;

        return max;
    }
}


/**
 * Binary Search - Finding the lower bound
 *
 * Time: O(n + n * log m) => O(n * log m)
 * Space: O(1)
 *      Where n is the length of the input array piles and m is the maximum number of bananas in a pile.
 */
class KokoEatingBananas_Solution2 {
    public int minEatingSpeedWay3(int[] piles, int h) {
        int maximum = max(piles);

        int l = 1, r = maximum; // minimum and maximum speeds
        int minimum = 1; // OR 0 OR maximum, anything works

        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean canEatAll = canEatAllPiles(piles, h, mid);
            if (canEatAll) {
                minimum = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return minimum;
    }


    private boolean canEatAllPiles(int[] piles, int targetHours, int speed) {
        int hours = 0; // or long to avoid overflow
        for (int num : piles)
            hours += Math.ceil(1.0 * num / speed); // other way to ceil: (num + speed - 1) / speed;

        return hours <= targetHours;
    }

    private int max(int[] nums) {
        int max = nums[0];
        for (int num : nums)
            if (num > max)
                max = num;

        return max;
    }
}