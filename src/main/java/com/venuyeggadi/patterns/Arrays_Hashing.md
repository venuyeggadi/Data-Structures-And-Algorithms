## Arrays & Hashing

### Static Arrays
| Operation                                                      | Big-O Time |
|----------------------------------------------------------------|------------|
| r/w i-th element                                               | O(1)       |
| Insert / Remove End (Assuming that space is already available) | O(1)       |
| Insert Middle                                                  | O(n)       |
| Remove Middle                                                  | O(n)       |

* In-place changes, Two pointers
* Problems
  * [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) - [Solution](../problemsolving/leetcode/26.RemoveDuplicatesfromSortedArray.java)
  * [Remove Element](https://leetcode.com/problems/remove-element/) - [Solution](../problemsolving/leetcode/27.RemoveElement.java)
  * [Shuffle The Array](https://leetcode.com/problems/shuffle-the-array/) - [Solution](../problemsolving/leetcode/1470.ShuffleTheArray.java)


### Dynamic Arrays
| Operation           | Big-O Time     |
|---------------------|----------------|
| r/w i-th element    | O(1)           |
| Insert / Remove End | Amortized O(1) |
| Insert Middle       | O(n)           |
| Remove Middle       | O(n)           |
* ArrayList in java
  * get(index) to get, set(index, element) to set element at index
  * add(length, E element) to add element at end, remove(length - 1) to remove last element
  * add(index, E element) to insert in at index
  * remove(index) to remove element at index
* [Array List](../datastructures/dynamicarray/ArrayList.java)
* Problems
  * [Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/) - [Solution](../problemsolving/leetcode/1929.ConcatenationOfArray.java)

### Kadane's Algorithm
* Problems
  * [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/) - [Solution](../problemsolving/leetcode/53.MaximumSubarray.java)
  * [Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/) - [Solution](../problemsolving/leetcode/)
  * [Longest Turbulent Subarray](https://leetcode.com/problems/longest-turbulent-subarray/) - [Solution](../problemsolving/leetcode/)
  
### Sliding Window Fixed
* [Given an array, return true if there are two elements within a window of size k that are equal](../algorithms/slidingwindow/SlidingWindowFixed.java)  
* Problems 
  * [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/) - [Solution]()
  * [Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/) - [Solution](../problemsolving/leetcode/1343.NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold.java)



### Sliding Window Variable
* [Find the length of the longest subarray, with same value in each position](../algorithms/slidingwindow/SlidingWindowVariable.java)
* [Find the minimum length subarray, where the sum is greater than or equal to the target. Assume all values are positive.](../algorithms/slidingwindow/SlidingWindowVariable_2.java)
* Problems
  * [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) - [Solution](../problemsolving/leetcode/209.MinimumSizeSubarraySum.java)
  * [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) - [Solution](../problemsolving/leetcode/3.LongestSubstringWithoutRepeatingCharacters.java)
  * [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) - [Solution](../problemsolving/leetcode/424.LongestRepeatingCharacterReplacement.java)

### Sliding Window Template
```java
public int fn(int[] arr) {
    int left = 0, ans = 0, curr = 0;

    for (int right = 0; right < arr.length; right++) {
        // do logic here to add arr[right] to curr

        while (WINDOW_CONDITION_BROKEN) {
            // remove arr[left] from curr
            left++;
        }

        // update ans
    }

    return ans;
}
```

### Two Pointers
https://leetcode.com/problems/valid-palindrome/  
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/  
https://leetcode.com/problems/remove-duplicates-from-sorted-array/  
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/  
https://leetcode.com/problems/container-with-most-water/  
https://leetcode.com/problems/trapping-rain-water/


### Prefix Sum

