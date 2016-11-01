package com.csmarton.hackerrank.datastrucure.tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal
{
	void LevelOrder(Node root)
	{
		List<Node> children = new ArrayList<>();
		List<Node> parents = new ArrayList<>();

		boolean hasNext = true;

		parents.add(root);

		while (hasNext) {
			for (int i = 1; i < parents.size(); i++) {
				Node parent = parents.get(i);
				System.out.print(parent.data);
				if (parent.left != null) {
					children.add(parent.left);
				}
				if (parent.right != null) {
					children.add(parent.right);
				}
			}

			parents.clear();
			parents.addAll(children);

			hasNext = children.size() > 0;
		}
	}
}
