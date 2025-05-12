package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Bruteforce: Sort and then return Kth element
 * Time: O(n + n log n) => O(n log n)
 * Space: O(n + n + n) => O(n)
 *      n -> list, n -> call stack (in degenerated tree), n -> sort
 */
class KthSmallestElementInABST_Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(list, root);
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void traverse(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        traverse(list, root.left);
        traverse(list, root.right);
    }
}

/**
 * Inorder Traversal -> resulting a sorted list
 * Time: O(n)
 * Space: O(n + n) => O(n)
 *      n -> list, n -> call stack (in degenerated tree)
 */

class KthSmallestElementInABST_Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<Integer>();
        inOrderTraversal(sortedList, root);

        return sortedList.get(k - 1);
    }

    private void inOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(list, root.left);
        list.add(root.val);
        inOrderTraversal(list, root.right);
    }
}

/**
 * Inorder Traversal -> capture the value when count is k while traversing
 * Time: O(n)
 * Space: O(n)
 *      n -> call stack (in degenerated tree)
 */

class KthSmallestElementInABST_Solution3 {
    public int kthSmallest(TreeNode root, int k) {
        int[] countAndResultTracker = new int[2];
        countAndResultTracker[0] = k;
        inOrderTraversal(root, countAndResultTracker);
        return countAndResultTracker[1];
    }

    private void inOrderTraversal(TreeNode root, int[] countAndResultTracker) {
        if (root == null)
            return;
        inOrderTraversal(root.left, countAndResultTracker);
        --countAndResultTracker[0];
        if (countAndResultTracker[0] == 0) {
            countAndResultTracker[1] = root.val;
            return;
        }
        inOrderTraversal(root.right, countAndResultTracker);
    }
}