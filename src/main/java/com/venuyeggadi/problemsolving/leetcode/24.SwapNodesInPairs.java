package com.venuyeggadi.problemsolving.leetcode;

/*
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
   You must solve the problem without modifying the values in the list's nodes
   (i.e., only nodes themselves may be changed.)

 * Example 1:
   Input: head = [1,2,3,4]
   Output: [2,1,4,3]

 * Example 2:
   Input: head = []
   Output: []

 * Example 3:
   Input: head = [1]
   Output: [1]

 * Constraints:
   * The number of nodes in the list is in the range [0, 100].
   * 0 <= Node.val <= 100
 */
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
import java.util.List;

/**
 * Bruteforce
 * Time: O(n)
 * Space: O(n)
 *      For the list
 */
class SwapNodesInPairs_Solution1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        for (int i = 1; i < list.size(); i += 2) {
            ListNode temp = list.get(i - 1);
            list.set(i - 1, list.get(i));
            list.set(i, temp);
        }

        for (int i = 0; i < list.size() - 1; ++i) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;

        return list.get(0);
    }
}


/**
 * Iteration
 * Time: O(n)
 * Space: O(1)
 */
class SwapNodesInPairs2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode tail = swapPairs(head.next.next);

        ListNode resultHead = head.next;
        resultHead.next = head;
        head.next = tail;

        return resultHead;
    }
}


/**
 * Recursion
 * Time: O(n)
 * Space: O(n)
 * Due to call stack.
 */
class SwapNodesInPairs3 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode tail = swapPairs(head.next.next);

        ListNode resultHead = head.next;
        resultHead.next = head;
        head.next = tail;

        return resultHead;
    }
}
