package com.andrewbayd;

import com.andrewbayd.datastructures.TreeNode;

/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree.
Return the root node of the BST after the insertion.

https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        if (val > root.val) root.right = insertIntoBST(root.right, val);
        return root;
    }
}
