package com.andrewbayd;

import com.andrewbayd.datastructures.TreeNode;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class BinaryTreeLCA {
    public static TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;
        if (root.equals(node1) || root.equals(node2)) return root;

        TreeNode leftLCA = lca(root.left, node1, node2);
        TreeNode rightLCA = lca(root.right, node1, node2);

        if (leftLCA != null && rightLCA != null) return root;
        if (leftLCA != null) return leftLCA;
        return rightLCA;
    }
}
