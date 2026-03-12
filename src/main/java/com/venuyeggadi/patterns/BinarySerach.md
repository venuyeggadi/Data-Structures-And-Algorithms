# Binary Search

* To find the position of a given element in a sorted array. 

### Template 1 - Find the Exact Value
* Find the position of a given element in a sorted array (or a position where it can be inserted when it's not found).
* [Binary Search](../algorithms/searching/BinarySearch.java)
* [Binary Search Implementation - Order agnostic](../algorithms/searching/OrderAgnosticBinarySearch.java)

### Template 2 - Find Upper bound
* Find the last position at which the given can be inserted to maintain the sorted order.
  The position just before it is where you could potentially find the given element.
  This works all the time but makes sense when we think of an array that has duplicates of the given elements.
  Using this approach, we can find the position of the last occurrence of the given element (or a position where it can be inserted when it's not found).
* [Binary Search - Upper Bound](../algorithms/searching/BinarySearch_UpperBound.java)

### Template 3 - Find Lower bound
* Find the first position at which the given element can be inserted to maintain the sorted order.
  This is the same position at which the given element can be potentially found.
  This works all the time but makes sense when we think of an array that has duplicates of the given elements.
  Using this approach, we can find the first occurrence of the given element (or a position where it can be inserted when it's not found).
* [Binary Search - Lower Bound](../algorithms/searching/BinarySearch_LowerBound.java)


#### Lower Bound and Upper Bound solution are more advanced that work for normal binary search as well. Sometimes they're necessary to make solution more intuitive.

### Generic Binary Search Method
```
Binary Search can take many alternate forms and might not always be as straight forward 
as searching for a specific value. Sometimes you will have to apply a specific condition or rule 
to determine which side (left or right) to search next.
```
* A general template of Binary Searching for finding a value that satisfies a condition.
* [Binary Search Method](../algorithms/searching/BinarySearchMethod.java)

### How do we identify Binary Search?
Binary Search is an algorithm that divides the search space in 2 after every comparison.
Binary Search should be considered every time you need to search for an index or element in a collection. 
If the collection is unordered, we can always **sort** it first before applying Binary Search.

Binary Search is generally composed of 3 main sections:
* Pre-processing - Sort if collection is unsorted.
* Binary Search - Using a loop or recursion to divide search space in half after each comparison.
* Post-processing - Determine viable candidates in the remaining space.

### Problems
* [Binary Search](https://leetcode.com/problems/binary-search/) - [Solution](../problemsolving/leetcode/704.BinarySearch.java)
* [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) - [Solution](../problemsolving/leetcode/74.SearchA2DMatrix.java)
* [Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/) - [Solution](../problemsolving/leetcode/374.GuessNumberHigherOrLower.java)
* [Sqrt(x)](https://leetcode.com/problems/sqrtx/) - [Solution](../problemsolving/leetcode/69.Sqrt_x.java)

## Finding the first solution that is valid / Finding optimal solution
* Similar to Binary Search - Lower Bound
### Problems
* [First Bad Version](https://leetcode.com/problems/first-bad-version/) - [Solution](../problemsolving/leetcode/278.FirstBadVersion.java)
* [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) - [Solution](../problemsolving/leetcode/875.KokoEatingBananas.java)
* Consider a problem where our task is to process k jobs using n machines.
  Each machine i is assigned an integer pi : the time to process a single job. What is
  the minimum time to process all the jobs?
  For example, suppose that k= 8, n = 3 and the processing times are p1 = 2,
  p2 = 3, and p3 = 7. In this case, the minimum total processing time is 9.
  Assuming that they work in parallel, Machine 1 does 4 jobs in 8 seconds
  Machine 2 does 3 jobs 9 seconds and machine 3 does 1 job in 7 seconds.
  So the minimum time is 9 seconds where all the jobs are completed.
* Template
  ```java
  int l = 1, r = maximum;
    
  while (l < r) {
      int mid = l + (r - l) / 2;
      boolean canEatAll = canEatAllPiles(piles, h, mid);
      if (canEatAll)
          r = mid;
      else
          l = mid + 1;
  }

  return l;
    
    
  /** OR */
  int l = 1, r = maximum;
    
  while (l <= r) {
      int mid = l + (r - l) / 2;
      boolean canEatAll = canEatAllPiles(piles, h, mid);
      if (canEatAll)
          r = mid - 1;
      else
          l = mid + 1;
  }

  return l;
    
    
  /** OR */
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
  ```


## Java's in-built method for binary search
* returns index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
```java
// Arrays of primitive types
Arrays.binarySearch(t[] arr, t key);
Arrays.binarySearch(t[] arr, int fromIndex, int toIndex, t key);

// Object Arrays
Arrays.binarySearch(Object[] a, Object key)
Arrays.binarySearch(Object[] a, int fromIndex, int toIndex, Object key)

// Generic Arrays
Arrays.binarySearch(T[] a, T key, Comparator<? super T> c)
Arrays.binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)
```