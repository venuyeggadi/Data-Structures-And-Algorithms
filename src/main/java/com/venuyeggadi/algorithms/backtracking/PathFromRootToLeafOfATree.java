package com.venuyeggadi.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Determine if a path exists from the root of the tree to a leaf node. It may not contain any zeroes
 * 2. Return such a path if exists.
 */


public class PathFromRootToLeafOfATree {

    /**
     * Time: O(n)
     * Space: O(log n) for a balanced tree, or O(n) in the worst case for a skewed tree.
     *  *    where n -> size of the tree
     */
    public boolean pathExists(TreeNode root) {
        if (root == null || root.val == 0)
            return false;
        if (root.left == null && root.right == null)
            return true;

        if (pathExists(root.left))
            return true;

        return pathExists(root.right);
    }

    /**
     * Time: O(n)
     * Space: O(log n)
     *  where n -> size of the tree
     */
    public List<TreeNode> path(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        determinePath(root, list);
        return list;
    }

    private boolean determinePath(TreeNode root, List<TreeNode> list) {
        if (root == null || root.val == 0)
            return false;

        list.add(root);

        if (root.left == null && root.right == null)
            return true;
        if (determinePath(root.left, list))
            return true;
        if (determinePath(root.right, list))
            return true;

        list.remove(list.size() - 1);

        return false;
    }

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
