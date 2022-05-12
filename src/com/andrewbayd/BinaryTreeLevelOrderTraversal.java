package com.andrewbayd;

import com.andrewbayd.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.

https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            List<Integer> levelItems = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
                levelItems.add(current.val);
            }
            result.add(levelItems);
        }
        return result;
    }
}
