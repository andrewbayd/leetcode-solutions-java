package com.andrewbayd.binaryTreeInOrderTraversal;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversalRecursive(root, result);
        return result;
    }

    private void traversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traversalRecursive(root.left, result);
        result.add(root.val);
        traversalRecursive(root.right, result);
    }
}
