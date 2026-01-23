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


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Backtracking (DFS)
 * Time: O(n) for visiting all the nodes
 * Space: O(log n) for a balanced tree, or O(n) in the worst case for a skewed tree.
 *    where n -> size of the tree
 */
class PathSum_Solution1 {

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


class PathSum_Solution1_Way2 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        targetSum -= root.val;
        if (isLeafNode(root))
            return targetSum == 0;

        if (hasPathSum(root.left, targetSum))
            return true;

        return hasPathSum(root.right, targetSum);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}


/**
 * Iterative DFS
 * -> while converting from recursive dfs to iterative dfs, just capture all the arguments to
 *    recursive call in the stack.
 * -> all the parameters can be wrapped inside an object and a single stack can be used.
 *
 * Time: O(n)
 * Space: O(n)
 */
class PathSum_Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> sumStack = new ArrayDeque<>();
        nodeStack.push(root);
        sumStack.push(targetSum);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int sum = sumStack.pop();
            if (isLeafNode(currentNode) && sum - currentNode.val == 0)
                return true;

            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                sumStack.push(sum - currentNode.val);
            }

            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                sumStack.push(sum - currentNode.val);
            }
        }

        return false;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}


/**
 * BFS
 *
 * Time: O(n)
 * Space: O(n)
 */
class PathSum_Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> sumQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        sumQueue.offer(targetSum);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            int sum = sumQueue.poll();
            if (isLeafNode(currentNode) && sum - currentNode.val == 0)
                return true;

            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
                sumQueue.offer(sum - currentNode.val);
            }

            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
                sumQueue.offer(sum - currentNode.val);
            }
        }

        return false;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}