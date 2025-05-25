package com.venuyeggadi.problemsolving.leetcode;


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

class PathSum_Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sumEqualsTarget(root, 0, targetSum);
    }

    private boolean sumEqualsTarget(TreeNode root, int currentSum, int target)
    {
        if (root == null)
            return false;

        int sum = currentSum + root.val;
        if (isLeafNode(root))
            return sum == target;

        if (sumEqualsTarget(root.left, sum, target))
            return true;

        return sumEqualsTarget(root.right, sum, target);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}