package com.andrewbayd.symmetricTree;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

https://leetcode.com/problems/symmetric-tree/
 */

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymetricRecursive(root.left, root.right);
    }

    private boolean isSymetricRecursive(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null || first.val != second.val) {
            return false;
        }
        return isSymetricRecursive(first.left, second.right) && isSymetricRecursive(first.right, second.left);
    }

    /*
    Iterative solution

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode first = queue.remove();
            TreeNode second = queue.remove();

            if (first == null && second == null) {
                continue;
            }

            if ((first == null && second != null) || (first != null && second == null) || first.val != second.val) {
                return false;
            }

            queue.add(first.left);
            queue.add(second.right);
            queue.add(first.right);
            queue.add(second.left);
        }

        return true;
    }
    */

}
