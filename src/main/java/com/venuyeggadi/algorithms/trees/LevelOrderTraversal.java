package com.venuyeggadi.algorithms.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<TreeNode> levelOrderTraversal(TreeNode root) {
        List<TreeNode> resultList = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resultList.add(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return resultList;
    }
}

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
