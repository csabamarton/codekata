package com.csmarton.hackerrank.algorithms.leetcode.medium.binarytree;

import com.csmarton.hackerrank.algorithms.leetcode.medium.traversal.TreeNode;
import com.csmarton.hackerrank.algorithms.leetcode.medium.traversal.ValidBinaryTree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;

        while(!(node.val >= p.val && node.val <= q.val) && !(node.val <= p.val && node.val >= q.val)) {
            if (node.val < p.val)
                node = node.right;
            else
                node = node.left;
        }

        return node;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        TreeNode q = new TreeNode(4);
        TreeNode p = new TreeNode(2, null, q);

        TreeNode root = new TreeNode(6, p, new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        //TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));


        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, p, q));
    }

    //[6,2,8,0,4,7,9,null,null,3,5]
}
