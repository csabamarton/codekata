package com.csmarton.hackerrank.datastrucure.tree;

public class LowestCommonAncestor {
	static Node lca(Node root,int v1,int v2)
	{
		int data = root.data;
		if((v1 > data && v2 < data) || (v1 < data && v2 > data)) {
			return root;
		} else {
			if(v1 < data){
				return lca(root.left, v1, v2);
			} else {
				return lca(root.right, v1, v2);
			}
		}
	}
}
