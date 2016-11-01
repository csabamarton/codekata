package com.csmarton.hackerrank.datastrucure.tree;

public class MaxHeight
{
	public int getHeight(Node root)
	{
		int height = 0;

		if(root.left != null) {
			height = getHeight(root.left);
		}

		if(root.right != null) {
			int rightHeight = getHeight(root.right);
			if(rightHeight > height) {
				height = rightHeight;
			}
		}

		return ++height;
	}
}
