package com.venuyeggadi.problemsolving.leetcode;


/**
 * Bruteforce
 *
 * Time: O(m * n)
 * Space: O(1)
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
 * Bruteforce
 *
 * Time: O(m * n)
 * Space: O(1)
 */
class KokoEatingBananas_Solution1_Way2 {
    public int minEatingSpeed(int[] piles, int h) {
        int maximum = max(piles);

        for (int i = 1; i <= maximum; ++i)
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
 * Binary Search
 *
 * Time: O(n + n * log m) => O(n * log m)
 * Space: O(1)
 *      Where n is the length of the input array piles and m is the maximum number of bananas in a pile.
 */
class KokoEatingBananas_Solution2 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = max(piles);

        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean canEatAll = canEatAllPiles(piles, h, mid);
            if (canEatAll)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    /** OR */
    public int minEatingSpeed_Way2(int[] piles, int h) {
        int l = 1, r = max(piles);

        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean canEatAll = canEatAllPiles(piles, h, mid);
            if (canEatAll)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return l;
    }

    /** OR */
    public int minEatingSpeedWay3(int[] piles, int h) {
        int maximum = max(piles);

        int l = 1, r = maximum;
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