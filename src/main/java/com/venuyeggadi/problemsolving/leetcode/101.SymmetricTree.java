package com.venuyeggadi.problemsolving.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time: O(n)
 * Space: O(h) -> h is the height of the tree
 */
class SymmetricTree_Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return areSymmetric(root, root);
    }

    private boolean areSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if ((node1 != null && node2 == null) || (node1 == null && node2 != null))
            return false;

        return node1.val == node2.val
                && areSymmetric(node1.left, node2.right)
                && areSymmetric(node1.right, node2.left);
    }
}


class SymmetricTree_Solution1Better {
    public boolean isSymmetric(TreeNode root) {
        return areSymmetric(root, root);
    }

    private boolean areSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null)
            return node1 == node2;

        return node1.val == node2.val
                && areSymmetric(node1.left, node2.right)
                && areSymmetric(node1.right, node2.left);
    }
}


/**
 * Level order traversal and checking symmetry
 * Time: O(n + n) => O(n)
 *      n for level order traversal and n for checking palindrome
 * Space: O(n) traversal list
 */

class SymmetricTree_Solution2 {
    public boolean isSymmetric(TreeNode root) {
        List<ArrayList<String>> list = getLevels(root);

        System.out.println(list.size());
        for (ArrayList<String> level : list) {
            System.out.println(level);
            boolean isPalindrome = isPalindrome(level);
            System.out.println("palindrome " + isPalindrome);
            if (!isPalindrome)
                return false;
        }

        return true;
    }

    private List<ArrayList<String>> getLevels(TreeNode root) {
        List<ArrayList<String>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<String> level = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    level.add("null");
                    continue;
                }
                level.add(Integer.toString(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
            list.add(level);
        }

        return list;
    }

    private boolean isPalindrome(ArrayList<String> list) {
        int start = 0, end = list.size() - 1;

        while (start < end) {
            if (!list.get(start).equals(list.get(end)))
                return false;
            ++start;
            --end;
        }

        return true;
    }
}


