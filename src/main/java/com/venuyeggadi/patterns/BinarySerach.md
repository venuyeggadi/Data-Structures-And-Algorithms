# Binary Search

### Search Array
* [Binary Search Implementation](../algorithms/searching/BinarySearch.java)
* [Binary Search Implementation - Order agnostic](../algorithms/searching/OrderAgnosticBinarySearch.java)
* Java's in-built method - index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
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
* Problems
  * [Binary Search](https://leetcode.com/problems/binary-search/) - [Solution](../problemsolving/leetcode/704.BinarySearch.java)
  * [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/) - [Solution](../problemsolving/leetcode/74.SearchA2DMatrix.java)

### Generic Binary Search Method
* A general template of Binary Searching for finding a value that satisfies a condition.
* [Binary Search Method](../algorithms/searching/BinarySearchMethod.java)
* Problems
  * [Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/) - [Solution](../problemsolving/leetcode/374.GuessNumberHigherOrLower.java)

### Finding the first solution that is valid / Finding optimal solution
  * [First Bad Version](https://leetcode.com/problems/first-bad-version/) - [Solution](../problemsolving/leetcode/278.FirstBadVersion.java)
  * [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) - [Solution](../problemsolving/leetcode/875.KokoEatingBananas.java)
  * Consider a problem where our task is to process k jobs using n machines.
    Each machine i is assigned an integer pi : the time to process a single job. What is
    the minimum time to process all the jobs?
    For example, suppose that k= 8, n = 3 and the processing times are p1 = 2,
    p2 = 3, and p3 = 7. In this case, the minimum total processing time is 9.
    Assuming that they the work in parallel, Machine 1 does 4 jobs in 8 seconds
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