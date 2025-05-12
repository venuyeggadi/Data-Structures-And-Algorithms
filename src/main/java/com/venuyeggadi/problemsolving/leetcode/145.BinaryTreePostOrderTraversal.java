package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: O(n)
 * Space: O(h) where h is the height of the tree
 */

class BinaryTreePostOrderTraversal_Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(list, root);
        return list;
    }

    private void traverse(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        traverse(list, root.left);
        traverse(list, root.right);
        list.add(root.val);
    }
}
