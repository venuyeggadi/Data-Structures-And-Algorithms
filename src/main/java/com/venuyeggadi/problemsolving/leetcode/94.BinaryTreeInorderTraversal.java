package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

/**
 * Iterative DFS
 * Time: O(n)
 * Space: O(h) for stack where h is the height of the tree
 *      O(n) for unbalanced tree
 *      O(log n) for balanced tree
 */
class BinaryTreeInorderTraversal_Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }
}

class BinaryTreeInorderTraversal_Solution2Way2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                current = node.right;
            }
        }

        return list;
    }
}
