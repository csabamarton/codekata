package com.csmarton.hackerrank.datastrucure.tree;

public class BinarySearchTreeInsertion {
	class Node {
		int data;
		Node left;
		Node right;
	}

	public Node insert(Node root, int value)
	{
		if(root == null){
			Node newNode = new Node();
			newNode.data = value;
			return newNode;
		}

		if(root.data > value){
			if(root.left == null){
				Node newNode = new Node();
				newNode.data = value;
				root.left = newNode;
			} else {
				insert(root.left, value);
			}
		} else if(root.data < value){
			if(root.right == null){
				Node newNode = new Node();
				newNode.data = value;
				root.right = newNode;
			} else {
				insert(root.right, value);
			}
		}

		return root;
	}

}
