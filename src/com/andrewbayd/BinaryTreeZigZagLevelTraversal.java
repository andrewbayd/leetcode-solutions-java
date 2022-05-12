package com.andrewbayd;

import com.andrewbayd.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            List<Integer> levelItems = new ArrayList<>();
            int levelSize = q.size();
            boolean isReversed = result.size() % 2 != 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = isReversed ? q.pollLast() : q.pollFirst();
                levelItems.add(current.val);
                if (isReversed) {
                    if (current.right != null) q.addFirst(current.right);
                    if (current.left != null) q.addFirst(current.left);
                } else {
                    if (current.left != null) q.addLast(current.left);
                    if (current.right != null) q.addLast(current.right);
                }
            }
            result.add(levelItems);
        }
        return result;
    }
}
