package com.venuyeggadi.problemsolving.leetcode;


/**
 * DFS (Recursion - bottom-up)
 * Time: O(n) where n -> number of nodes in tree
 * Space: O(k) where k => maximum depth of the tree
 *      Best Case (balanced tree): O(log n)
 *      Worst Case (degenerate tree): O(n)
 */
class MaximumDepthOfBinaryTree_Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}

/**
 * DFS (Recursion - top-down)
 * Time: O(n) where n -> number of nodes in tree
 * Space: O(k) where k => maximum depth of the tree
 *      Best Case (balanced tree): O(log n)
 *      Worst Case (degenerate tree): O(n)
 */
class MaximumDepthOfBinaryTree_Solution2 {
    public int maxDepth(TreeNode root) {
        return maxDepthRec(root, 0);
    }

    private int maxDepthRec(TreeNode root, int parentDepth) {
        if (root == null)
            return parentDepth;

        int depth = parentDepth + 1;
        int leftDepth = maxDepthRec(root.left, depth);
        int rightDepth = maxDepthRec(root.right, depth);

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

