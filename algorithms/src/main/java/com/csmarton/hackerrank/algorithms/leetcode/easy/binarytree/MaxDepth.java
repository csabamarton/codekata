package com.csmarton.hackerrank.algorithms.leetcode.easy.binarytree;

import com.csmarton.hackerrank.algorithms.leetcode.medium.traversal.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return lookDeep(root, 1);
    }

    private int lookDeep(TreeNode node, int level) {
        if (node == null)
            return level - 1;

        return Math.max(
                lookDeep(node.left, level + 1),
                lookDeep(node.right, level + 1));
    }
}
