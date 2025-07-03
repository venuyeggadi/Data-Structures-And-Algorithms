package com.venuyeggadi.problemsolving.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Tracking the already visited elements. The first element to be revisited is the head.
 * Time: O(n)
 * Space: O(n)
 */
class LinkedListCycleII_Solution1 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode trav = head;

        while (trav != null) {
            if (set.contains(trav))
                return trav;
            set.add(trav);
            trav = trav.next;
        }

        return null;
    }
}

/**
 * Fast and slow pointer
   Detect whether there is a cycle by checking for intersection of fast and slow pointers.
   The distance between the actualHead of the list to the cycle head is exactly equal to the distance between the intersection
   point and the cycle head. Because,
   Let us say, slow pointer travelled distance L to reach the cycle head. By this time, fast would've travelled distance L within the
   cycle. Let us say that the distance between the fast pointer and the cycle head is x. We know that fast pointer would reach slow
   in x steps, where x is the distance between them. So once they intersect, slow pointer (and fast pointer) would've travelled
   distance x. So the remaining distance (between the intersection and cycle head) is L.
 *
 * Time: O(n) <- The slow pointer would at max traverse the whole list, so at max n operations.
 */
class LinkedListCycleII_Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fastPointer = head, slowPointer = head;
        ListNode intersect = null;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                intersect = slowPointer;
                break;
            }
        }

        if (intersect == null)
            return null;

        ListNode trav = head;
        while (intersect != trav) {
            trav = trav.next;
            intersect = intersect.next;
        }

        return intersect;
    }
}
