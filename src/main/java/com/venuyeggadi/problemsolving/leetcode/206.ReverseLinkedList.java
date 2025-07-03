package com.venuyeggadi.problemsolving.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.ArrayList;

/**
 * Bruteforce
 * Time: n * n -> O(n^2)
 * Space: O(1)
 */
class ReverseLinkedList_Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        int lastValue = removeLast(head);
        ListNode reversedListHead = new ListNode(lastValue, null);
        ListNode reversedListTail = reversedListHead;

        while (head.next != null) {
            int value = removeLast(head);
            ListNode nextNode = new ListNode(value, null);
            reversedListTail.next = nextNode;
            reversedListTail = reversedListTail.next;
        }

        ListNode lastNode = new ListNode(head.val, null);
        reversedListTail.next = lastNode;

        return reversedListHead;
    }

    // assuming two nodes at least
    private int removeLast(ListNode head) {
        ListNode trav = head;
        while (trav.next.next != null) {
            trav = trav.next;
        }

        int value = trav.next.val;
        trav.next = null;

        return value;
    }
}


/** Using extra space - Array
 *  Time: O(n)
 *  Space: O(n)
 */
class ReverseLinkedList_Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode trav = head;
        while (trav != null) {
            list.add(trav);
            trav = trav.next;
        }
        ListNode reversed = list.get(list.size() - 1);
        ListNode tail = reversed;
        for (int i = list.size() - 2; i >= 0; --i) {
            tail.next = list.get(i);
            tail = tail.next;
        }
        tail.next = null;

        return reversed;
    }
}


/**
 * Time: O(n)
 * Space: O(1)
 */
class ReverseLinkedList_Solution3 {
    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;

        while (head != null) {
            ListNode newHead = head;
            head = head.next;
            newHead.next = reversedHead;
            reversedHead = newHead;
        }

        return reversedHead;
    }
}


/**
 * Recursive solution
 * Time: O(n)
 * Space: O(n) for recursive stack
 */
class ReverseLinkedList_Solution4 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode remainingListHead = head.next;
        ListNode remainingListReversed = reverseList(remainingListHead);

        head.next = null;
        remainingListHead.next = head; // remainingListHead becomes tail after reversing

        return remainingListReversed;
    }
}
