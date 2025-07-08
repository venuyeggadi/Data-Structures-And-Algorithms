package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                list.add(curr.val);
                if (curr.right != null)  // cannot push null element to ArrayDeque
                    stack.push(curr.right);
                curr = curr.left;
            } else {
                curr = stack.pop();
            }
        }

        return list;
    }
}

class BinaryTreePreorderTraversal_Solution2_Way2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                list.add(current.val);
                if (current.right != null)
                    stack.push(current.right);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                current = node;
            }
        }

        return list;
    }
}