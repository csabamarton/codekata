package com.csmarton.hackerrank.datastrucure.tree;

public class HuffmanDecoding {

	class Node {
		int freq;
		char data;
		Node left;
		Node right;

	}

	private static final char INTERNAL_NODE_DATA = '\0';

	void decode(String s, Node root)
	{

		boolean hasNew = s.length() > 0;

		Node tempNode = root;
		while (hasNew) {

			char c = s.charAt(0);
			s = s.substring(1);
			if (tempNode.data == INTERNAL_NODE_DATA) {
				if (c == '0') {
					tempNode = tempNode.left;
				} else {
					tempNode = tempNode.right;
				}
			}

			if (tempNode.data != INTERNAL_NODE_DATA) {
				System.out.print(tempNode.data);
				tempNode = root;
				hasNew = s.length() > 0;
			}
		}
	}
}
