package com.venuyeggadi.problemsolving.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Bruteforce
 * Time: O(n * min(n, k))
 * Space: O(1)
 */
class ContainsDuplicateII_Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            int windowEnd = Math.min(i + k, nums.length - 1);
            for (int j = i + 1; j <= windowEnd; ++j) {
                if (nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }
}

/**
 * Map
 * Time: O(n)
 * Space: O(k)
 */
class ContainsDuplicateII_Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            map.put(nums[i], i);
        }

        return false;
    }
}

/**
 * Sliding Window (with Set)
 * Time: O(n)
 * Space: O(min(n,k))
 */
class ContainsDuplicateII_Solution3 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (right - left > k)
                set.remove(nums[left++]);
            if (set.contains(nums[right]))
                return true;
            set.add(nums[right]);
        }

        return false;
    }
}
