package com.csmarton.hackerrank.algorithms.leetcode.medium;

import com.csmarton.hackerrank.algorithms.leetcode.medium.traversal.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeSerializer {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recSerialise(root, "");
    }

    private String recSerialise(TreeNode node, String str) {
        if (node == null) {
            str += "null,";

            return str;
        }

        str += String.valueOf(node.val) + ",";
        str = recSerialise(node.left, str);
        str = recSerialise(node.right, str);

        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");

        List<String> list = new LinkedList<>(Arrays.asList(values));

        return deserializeRec(list);
    }

    private TreeNode deserializeRec(List<String> list) {
        String first = list.get(0);

        if(first.equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);

        node.left = deserializeRec(list);
        node.right = deserializeRec(list);

        return node;
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
