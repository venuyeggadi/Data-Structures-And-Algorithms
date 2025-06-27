package com.venuyeggadi.problemsolving.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

/**
 * BFS
 * Time: O(n)
 * Space: O(n/2) => O(n) for the queue
 */
class BinaryTreeLevelOrderTraversal_Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            list.add(levelList);
        }

        return list;
    }
}

/**
 * Time: O(n) for vising n nodes
 * Space: O(h), h => height of the tree
 *      O(n) for unbalanced
 *      O(log n) for balanced
 */
class BinaryTreeLevelOrderTraversal_Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);

        return list;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> list) {
        if (node == null)
            return;

        if (depth == list.size()) {
            list.add(new ArrayList<Integer>());
        }

        list.get(depth).add(node.val);
        dfs(node.left, depth + 1, list);
        dfs(node.right, depth + 1, list);
    }
}
