package com.csmarton.hackerrank.algorithms.leetcode.medium.traversal;

public class ValidBinaryTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return check(root, null, null);
    }

    private boolean check(TreeNode root, Integer max, Integer min) {
        if (root == null)
            return true;

        if((max != null && root.val >= max) || (min != null && root.val <= min))
            return false;

        return check(root.left, root.val, min) && check(root.right, max, root.val);
    }

    public static void main(String[] args) {
        ValidBinaryTree validBinaryTree = new ValidBinaryTree();

        //TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));


        System.out.println(validBinaryTree.isValidBST(root));
    }
}
