package com.venuyeggadi.problemsolving.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Tracking the already visited elements
 * Time: O(n)
 * Space: O(n)
 */
class LinkedListCycle_Solution1 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode trav = head;

        while(trav != null) {
            if(visitedNodes.contains(trav))
                return true;
            visitedNodes.add(trav);
            trav = trav.next;
        }

        return false;
    }
}

/**
 * Fast and slow pointer
   Once both the pointers enter the cycle, it is certain that they intersect at one node. Because,
   Whatever maybe the distance between the fast and slow pointer once they both enter the cycle, distance would be decreased by 1
   for each move (because slow is moving by 1 and fast by 2). Eventually, the distance becomes 0 meaning that they met.
 * Time: O(n)
 * Space: O(1)
 */
class LinkedListCycle_Solution2 {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;

        while(fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer)
                return true;
        }

        return false;
    }
}