package com.andrewbayd;

import com.andrewbayd.datastructures.TreeNode;

/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class GoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int count = 0;
        if (root.val >= max) {
            count++;
            max = root.val;
        }
        count += dfs(root.left, max);
        count += dfs(root.right, max);
        return count;
    }
}
