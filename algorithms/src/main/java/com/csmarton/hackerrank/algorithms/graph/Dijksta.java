package com.csmarton.hackerrank.algorithms.graph;

import java.util.*;

public class Dijksta {

	private int numOfTestCases;
	private int numOfNodes;
	private int numOfEdges;
	private int indexOfStartNode;

	private List<Node> nodes = new ArrayList<Node>();
	private Set<Edge> edges = new HashSet<Edge>();

	private class Node {
		private Set<Edge> edges = new HashSet<Edge>();

		private Map<Integer, Integer> distanceMap = new HashMap<Integer, Integer>();

		public void addEdge(Edge edge)
		{
			edges.add(edge);
		}

		public Map<Integer, Integer> getDistanceMap()
		{
			return distanceMap;
		}
	}

	private class Edge {
		private int node1;
		private int node2;
		private int weight;

		public Edge(int node1, int node2, int weight)
		{
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}

		public int getNode1()
		{
			return node1;
		}

		public int getNode2()
		{
			return node2;
		}

		public int getWeight()
		{
			return weight;
		}
	}

	public static void main(String[] args)
	{
		Dijksta dijksta = new Dijksta();

		String input = "1\n" + "4 4\n" + "1 2 24\n" + "1 4 20\n" + "3 1 3\n" + "4 3 12\n" + "1";
		Scanner in = new Scanner(input);
		dijksta.setNumOfTestCases(in);
		dijksta.start(in);
	}

	private void start(Scanner in)
	{
		for (int i = 0; i < numOfTestCases; i++) {
			setTestInputData(in);
		}
	}

	private void setNumOfTestCases(Scanner in)
	{
		numOfTestCases = in.nextInt();
	}

	private void setTestInputData(Scanner in)
	{
		numOfNodes = in.nextInt();
		numOfEdges = in.nextInt();

		for (int i = 0; i < numOfEdges; i++) {
			int node1 = in.nextInt() - 1;
			int node2 = in.nextInt() - 1;
			int weight = in.nextInt();

			Edge edge = new Edge(Math.min(node1, node2), Math.max(node1, node2), weight);
			edges.add(edge);
		}

		for (int i = 0; i < numOfNodes; i++) {
			Node node = new Node();
			nodes.add(node);
		}

		indexOfStartNode = in.nextInt() - 1;

		setDistancesFrom(null, new ArrayList<Edge>());

		Node startNode = nodes.get(indexOfStartNode);

		Map<Integer, Integer> distanceMap = startNode.getDistanceMap();

		int count = 0;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < distanceMap.size(); i++) {
			Integer distance = distanceMap.get(i+1);

			if (distance == null) {
				result.append("-1");
			} else {
				result.append(distance);
			}

			if (!(distanceMap.size() - 1 == i)) {
				result.append(" ");
			}
		}

		System.out.println(result);
	}

	private void setDistancesFrom(Integer node1Index, List<Edge> usedEdges)
	{
		Node startNode = nodes.get(indexOfStartNode);

		Node node1 = null;
		if (node1Index == null) {
			node1 = startNode;
		} else {
			node1 = nodes.get(node1Index);
		}

		Map<Integer, Integer> distanceMap = startNode.getDistanceMap();

		boolean hasNewEdge = false;
		List<Edge> edgesFromCertainNode = getEdgesFromCertainNode(nodes.indexOf(node1));

		for (Edge edge : edgesFromCertainNode) {
			if (usedEdges.contains(edge)) {
				continue;
			}

			usedEdges.add(edge);
			hasNewEdge = true;

			int targetEdge = edge.getNode2();

			int startDist = 0;
			if (node1Index != null) {
				startDist = distanceMap.get(edge.getNode1());
			}

			Integer currentShortestDist = distanceMap.get(targetEdge);
			if (currentShortestDist == null || currentShortestDist > (edge.getWeight()
					+ startDist)) {
				distanceMap.put(targetEdge, edge.getWeight() + startDist);
			}
		}

		if (hasNewEdge) {
			for (Edge edge : edgesFromCertainNode) {
				setDistancesFrom(edge.getNode2(), usedEdges);
			}
		}
	}

	public List<Edge> getEdgesFromCertainNode(int start)
	{
		List<Edge> edgesForStart = new ArrayList<Edge>();

		for (Edge edge : edges) {
			if (edge.getNode1() == start || edge.getNode2() == start) {
				edgesForStart.add(edge);
			}
		}

		return edgesForStart;
	}
}