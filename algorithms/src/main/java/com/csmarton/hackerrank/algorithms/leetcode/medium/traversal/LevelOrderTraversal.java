package com.csmarton.hackerrank.algorithms.leetcode.medium.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return List.of();

        Map<Integer, List<Integer>> nodes = new HashMap<>();

        traverse(root, nodes, 0);

        return nodes.values().stream().collect(Collectors.toList());
    }

    private void traverse(TreeNode top, Map<Integer, List<Integer>> nodes, int level) {
        if(top.left != null) {
            traverse(top.left, nodes, level + 1);
        }
        if(top.right != null) {
            traverse(top.right, nodes, level + 1);
        }

        if(nodes.containsKey(level)) {
            nodes.get(level).add(top.val);
        } else {
            List<Integer> levelNodes = new ArrayList<>();
            levelNodes.add(top.val);
            nodes.put(level, levelNodes);
        }
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)
            return List.of();

        Map<Integer, List<Integer>> nodes = new HashMap<>();

        traverse(root, nodes, 0);

        return nodes.values().stream().collect(Collectors.toList());
    }

    private void traverse2(TreeNode top, Map<Integer, List<Integer>> nodes, int level) {
        if(top.left != null) {
            traverse(top.left, nodes, level + 1);
        }
        if(top.right != null) {
            traverse(top.right, nodes, level + 1);
        }

        if(nodes.containsKey(level)) {
            nodes.get(level).add(top.val);
        } else {
            List<Integer> levelNodes = new ArrayList<>();
            levelNodes.add(top.val);
            nodes.put(level, levelNodes);
        }
    }
}
