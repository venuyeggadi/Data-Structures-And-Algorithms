package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Sorting the list everytime
 * Time:
 *    addNum: O(n log n)
 *    findMedian: O(1)
 * Space:
 *    n + (n or n log n)
 */
class MedianFinder_Solution1 {

    List<Integer> list = new ArrayList<>();

    public MedianFinder_Solution1() {

    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        System.out.println(list.toString());
        if ((list.size() & 1) == 0)
            return (list.get(list.size()/2) + list.get(list.size()/2 - 1)) / 2.0;
        return list.get(list.size()/2);
    }
}


/**
 * No need to sort entire list everytime it's already sorted. Just insert the new number in it's correct position.
 * Time:
 *     addNum: O(n)
 *     findMedian: O(1)
 * Space:
 *     O(n)
 */
class MedianFinder_Solution2 {

    List<Integer> list = new ArrayList<>();

    public MedianFinder_Solution2() {

    }

    public void addNum(int num) {
        int indexToInsertAt = 0;
        while (indexToInsertAt < list.size() && num > list.get(indexToInsertAt))
            indexToInsertAt++;

        if (indexToInsertAt < list.size())
            list.add(indexToInsertAt, num);
        else
            list.add(num);
    }

    public double findMedian() {
        System.out.println(list.toString());
        if ((list.size() & 1) == 0)
            return (list.get(list.size()/2) + list.get(list.size()/2 - 1)) / 2.0;
        return list.get(list.size()/2);
    }
}



class MedianFinder_Solution3 {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder_Solution3() {

    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 0;
    }
}