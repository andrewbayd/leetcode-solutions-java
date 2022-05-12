package com.andrewbayd;

import com.andrewbayd.datastructures.TreeNode;

/*
Given a binary tree, determine if it is height-balanced.

https://leetcode.com/problems/balanced-binary-tree/
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
