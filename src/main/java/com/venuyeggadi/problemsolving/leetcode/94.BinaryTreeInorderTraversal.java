package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * In order traversal of Binary Search Tree results in a sorted list of elements
 *
 * To sort a list of elements
 *      -> Build a BST -> Takes a time of O (n * log n) => because log n is the time to insert a single element
 *      -> Do inorder traversal -> O(n)
 *  Total: O(n + n log n) => O(n log n)
 *
 *  All these traversals, Preorder, Postorder, Inorder are examples of Depth-First-Search (DFS)
 */

/**
 * Time: O(n)
 * Space: O(h) where h is the height of the tree
 *      O(n) for unbalanced tree
 *      O(log n) for balanced tree
 */

class BinaryTreeInorderTraversal_Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(list, root);
        return list;
    }

    private void traverse(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        traverse(list, root.left);
        list.add(root.val);
        traverse(list, root.right);
    }
}
