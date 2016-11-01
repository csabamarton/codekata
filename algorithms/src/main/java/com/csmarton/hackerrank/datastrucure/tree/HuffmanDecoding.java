package com.csmarton.hackerrank.datastrucure.tree;

public class HuffmanDecoding {
	private static final char INTERNAL_NODE_DATA = '\0';

	class Node {
		int freq;
		char data;
		Node left;
		Node right;

	}

	void decode(Node root, String s)
	{
		boolean hasNew = s.length() > 0;

		Node tempNode = root;

		while (hasNew) {
			char c = s.charAt(0);
			s = s.substring(1);

			if (tempNode.data == INTERNAL_NODE_DATA) {
				if (c == '0') {
					tempNode = root.left;
				} else {
					tempNode = root.right;
				}

			} else {
				System.out.print(root.data);
				tempNode = root;
				hasNew = s.length() > 0;
			}
		}
	}
}
