package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: O(n)
 * Space: O(h) where h is the height of the tree
 */

class BinaryTreePreorderTraversal_Solution {
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
