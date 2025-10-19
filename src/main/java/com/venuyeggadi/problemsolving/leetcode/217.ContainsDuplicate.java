package com.venuyeggadi.problemsolving.leetcode;
/******************
 * https://leetcode.com/problems/contains-duplicate/
 * 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array,
   and return false if every element is distinct.
 * Example 1:Input: nums = [1,2,3,1]
    Output: true
 * Example 2:
    Input: nums = [1,2,3,4]
    Output: false
 * Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true
 * Constraints:
    * 1 <= nums.length <= 10^5
    * -10^9 <= nums[i] <= 10^9
 *********************/

import java.util.*;
import java.util.stream.Collectors;

// Solution 0
/*
Use to two loops. For each element in the array, traverse the whole array to check if another exists.
Time complexity: O(n^2) = n + (n-1) + ... + 1 = n * (n + 1) /2
Space complexity: O(1)
 */

// Solution 1
/*
Sort the array. Traverse the array and if successive elements are equal return true.
Time Complexity: O(n.log(n))
Space Complexity: O(log(n)) for Quicksort and O(n) for Mergesort.
 */
class ContainsDuplicateSolution1 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int bound = nums.length-1;
        for (int i = 0; i < bound; i++) {
            if (nums[i] == nums[i+1])
                return true;
        }

        return false;
    }
}


// Solution 2
/*
Take a map and count the occurrences of each number. If count is greater than 1, return true.
Time Complexity: O(n)
Space Complexity: O(n)
 */
class ContainsDuplicateSolution2 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (int count : map.values())
            if (count > 1)
                return true;

        return false;
    }
}
class ContainsDuplicateSolution2Better {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int count : map.values())
            if (count > 1)
                return true;

        return false;
    }
}
// Another approach
// Make a set from the elements. If the length of set is not equal to length of array, return true.
class ContainsDuplicateSolutionAnother {
    public boolean containsDuplicate(int[] nums) {
        ArrayList list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        Set<Integer> set = new HashSet<>(list);

        return list.size() != set.size();
    }
}



//Optimal
// Solution 3
/*
Take a set and add elements one by one. Before adding an element check if it already exists.
If exists return true.

Time Complexity: O(n)
Space Complexity: O(n)
 */
class ContainsDuplicateSolution3 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
class ContainsDuplicateSolution3Better {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num))
                return true;
        return false;
    }
}


/**
 * For each element, put it before all the elements bigger than it. It might end up just side the same element.
 * Return true if it does so. The array will be sorted each time we do the iteration.
 * So in the worst case (when array is in decreasing order), it would take,
 * Time: O(n^2)
 */
class ContainsDuplicateSolution4 {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            int key = nums[i];
            int j = i - 1;

            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }

            if(j >= 0 && nums[j] == key)
                return true;

            nums[j + 1] = key;
        }

        return false;
    }
}