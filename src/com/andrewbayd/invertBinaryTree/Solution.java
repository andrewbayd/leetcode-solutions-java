package com.andrewbayd.invertBinaryTree;

/*
Given the root of a binary tree, invert the tree, and return its root.

https://leetcode.com/problems/invert-binary-tree/
 */

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        invertRecursive(root);
        return root;

    }

    private void invertRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertRecursive(root.left);
        invertRecursive(root.right);
    }
}
