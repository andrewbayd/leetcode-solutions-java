package com.andrewbayd.BinarySearchTreeLCA;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

public class Solution {

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        } else {
            return root;
        }
    }
}
