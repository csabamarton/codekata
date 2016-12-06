package com.csmarton.hackerrank.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BreadFirst {

	private List<Node> nodes;

	private class Node {
		List<Integer> children;
		boolean visited;
		boolean inQueue;
		int distance;

	}

	private int beginIndex;
	private Queue<Integer> queue;

	public static void main(String[] args)
	{
        BreadFirst bf = new BreadFirst();
		bf.start();
	}

	private void start()
	{
		Scanner in = new Scanner(System.in);

		int numOfGraphs = in.nextInt();

		for (int i = 0; i < numOfGraphs; i++) {
			int numOfNodes = in.nextInt();
			int numOfEdges = in.nextInt();

			buildGraph(numOfNodes, numOfEdges, in);

			beginIndex = in.nextInt() - 1;
			queue.add(beginIndex);

			while (!queue.isEmpty()) {

				traversalGraph(queue.poll());
			}

			printDistances();
		}
	}

	private void printDistances()
	{
		for (int i = 0; i < nodes.size(); i++) {
			if (i == beginIndex) {
				continue;
			}

			Node node = nodes.get(i);
			if (node.distance == 0) {
				System.out.print(-1);
			} else {
				System.out.print(node.distance);
			}
			System.out.print(" ");
		}
		System.out.println();
	}

	private void buildGraph(int numOfNodes, int numOfEdges, Scanner in)
	{

		queue = new LinkedList<Integer>();
		nodes = new ArrayList<>(numOfNodes);

		for (int i = 0; i < numOfNodes; i++) {
			Node node = new Node();
			nodes.add(node);
		}

		for (int i = 0; i < numOfEdges; i++) {

			Integer first = in.nextInt() - 1;
			Integer second = in.nextInt() - 1;

			addEdge(first, second);
			addEdge(second, first);
		}

	}

	private void addEdge(Integer first, Integer second)
	{
		Node node = nodes.get(first);
		List<Integer> childrenIds = node.children;

		if (childrenIds == null) {
			childrenIds = new ArrayList<>();
		}

		if (!childrenIds.contains(second)) {
			childrenIds.add(second);
		}

		node.children = childrenIds;
	}

	private void traversalGraph(Integer startIndex)
	{
		Node start = nodes.get(startIndex);
		start.inQueue = false;

		List<Integer> childrenIds = start.children;

		if (childrenIds != null) {
			for (int i = 0; i < childrenIds.size(); i++) {
				Integer id = childrenIds.get(i);
				Node childNode = nodes.get(id);

				if (!childNode.visited && !childNode.inQueue) {
					queue.add(id);
					childNode.inQueue = true;

					childNode.distance = start.distance + 6;
				}
			}
		}

		start.visited = true;
	}
}