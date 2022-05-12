package com.andrewbayd;

import com.andrewbayd.datastructures.TreeNode;

import java.util.Arrays;
import java.util.Iterator;

/*
Design an algorithm to serialize and deserialize a binary search tree.

https://leetcode.com/problems/serialize-and-deserialize-bst/
 */

public class SerializeDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serializeRecursive(root, result);
        return result.toString().trim();
    }

    private void serializeRecursive(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("x ");
            return;
        }
        str.append(root.val).append(" ");
        serializeRecursive(root.left, str);
        serializeRecursive(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeRecursive(Arrays.asList(data.split(" ")).iterator());
    }

    private TreeNode deserializeRecursive(Iterator<String> data) {
        String current = data.next();

        if (current.equals("x")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(current));
        root.left = deserializeRecursive(data);
        root.right = deserializeRecursive(data);

        return root;
    }
}
