package com.venuyeggadi.problemsolving.leetcode;


import java.util.ArrayList;

/**
 *
 */
class MiddleOfTheLinkedList_Solution1 {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get(arr.size() / 2);
    }
}

/**
 * Bruteforce: Calculate the length. Calculate the middle position, return it.
 * Time: O(n + n/2) => O(n)
 * Space: O(1)
 */
class MiddleOfTheLinkedList_Solution2 {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode trav = head;
        while (trav != null) {
            length++;
            trav = trav.next;
        }

        int middle = length / 2 + 1;

        ListNode result = head;
        while (middle > 1) {
            result = result.next;
            --middle;
        }

        /** OR
         * int middle = length / 2;
         *
         * ListNode result = head;
         * while (middle > 0) {
         *    result = result.next;
         *    --middle;
         * }
         */

        return result;
    }
}


/**
 * Fast and Slow pointers (Floyd's Tortoise and Hare algorithm)
 * Move the slow pointer at speed of 1 and fast at speed of 2. By the time fast reaches the end, slow would be in the middle.
 *
 * Here, if there are two middle elements, the second middle is considered the middle element.
 * If we consider the first middle as the middle element, just start fast pointer ahead by 1 node that slow pointer will be 1 node behind the
 * the second middle by the time fast reaches the end.
 *
 * Time: O(n/2) => O(n)
 * Space: O(1)
 */

class MiddleOfTheLinkedList_Solution3 {
    public ListNode middleNode(ListNode head) {
        ListNode fastPointer = head, slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }
}




