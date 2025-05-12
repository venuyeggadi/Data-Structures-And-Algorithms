package com.venuyeggadi.problemsolving.leetcode;


/**
 * Time: O(n) where n -> number of nodes in tree
 * Space: O(k) where k => maximum depth of the tree
 *      Best Case (balanced tree): O(log n)
 *      Worst Case (degenerate tree): O(n)
 */
class MaximumDepthOfBinaryTree_Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);

        return Math.max(leftDepth, rightDepth);
    }
}


// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

