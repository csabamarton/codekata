package com.csmarton.hackerrank.algorithms.leetcode.easy;

import com.csmarton.hackerrank.algorithms.leetcode.medium.traversal.TreeNode;

public class SameTree {

    //https://leetcode.com/problems/same-tree/description/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if ((p == null && q != null) || (q == null && p != null)) return false;

        if(p.val != q.val) return false;

        boolean left = isSameTree(p.left, q.left);
        if(left == false) return false;

        return isSameTree(p.right, q.right);
    }
}
