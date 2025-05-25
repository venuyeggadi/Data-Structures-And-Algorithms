package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive DFS
 * Time: O(n)
 * Space: O(h) for caller stack where h is the height of the tree
 *      O(n) for unbalanced tree
 *      O(log n) for balanced tree
 */

class BinaryTreePreorderTraversal_Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(list, root);
        return list;
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
 * Iterative DFS
 * Time: O(n)
 * Space: O(h) for stack where h is the height of the tree
 *      O(n) for unbalanced tree
 *      O(log n) for balanced tree
 */

class BinaryTreePreorderTraversal_Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(list, root);
        return list;
    }

    private void traverse(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        list.add(root.val);
        traverse(list, root.left);
        traverse(list, root.right);
    }
}