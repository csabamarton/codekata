package com.csmarton.hackerrank.datastrucure.tree;

public class BinaryTreeValidator
{
	boolean checkBST(Node root) {
		if(root == null) {
			return true;
		}

		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean checkBST(Node root, Integer minLimit, Integer maxLimit) {
		boolean isOK = true;

		if(root.left != null) {
			if(root.left.data > root.data || root.left.data < minLimit){
				return false;
			} else {
				isOK = checkBST(root.left, minLimit, root.data);
			}
		}

		if(!isOK){
			return false;
		}

		if(root.right != null) {
			if(root.right.data < root.data || root.right.data > maxLimit) {
				return false;
			} else {
				return checkBST(root.right, root.data, maxLimit);
			}
		}

		return true;
	}
}
