package com.csmarton.hackerrank.algorithms.graph;

import java.util.*;

public class EvenTree {

	private int numOfNodes;
	private int numOfEdges;

	private List<Node> allNodes = new ArrayList<Node>();
	private Set<Edge> edges = new HashSet<Edge>();
	private List<Component> components = new ArrayList<Component>();
	private List<Integer> remainingNodes = new ArrayList<Integer>();

	private int numOfCut = 0;

	public static void main(String[] args)
	{
		EvenTree evenTree = new EvenTree();

		String input =
				"20 19\n" + "2 1\n" + "3 1\n" + "4 3\n" + "5 2\n" + "6 5\n" + "7 1\n" + "8 1\n"
						+ "9 2\n" + "10 7\n" + "11 10\n" + "12 3\n" + "13 7\n" + "14 8\n"
						+ "15 12\n" + "16 6\n" + "17 6\n" + "18 10\n" + "19 1\n" + "20 8";

		/*input = "30 29\n" + "2 1\n" + "3 2\n" + "4 3\n" + "5 2\n" + "6 4\n" + "7 4\n" + "8 1\n"
				+ "9 5\n" + "10 4\n" + "11 4\n" + "12 8\n" + "13 2\n" + "14 2\n" + "15 8\n"
				+ "16 10\n" + "17 1\n" + "18 17\n" + "19 18\n" + "20 4\n" + "21 15\n" + "22 20\n"
				+ "23 2\n" + "24 12\n" + "25 21\n" + "26 17\n" + "27 5\n" + "28 27\n" + "29 4\n"
				+ "30 25";

		/*input = "60 59\n" + "2 1\n" + "3 1\n" + "4 2\n" + "5 3\n" + "6 3\n" + "7 3\n" + "8 5\n"
				+ "9 4\n" + "10 6\n" + "11 10\n" + "12 11\n" + "13 7\n" + "14 6\n" + "15 1\n"
				+ "16 5\n" + "17 3\n" + "18 6\n" + "19 2\n" + "20 14\n" + "21 1\n" + "22 1\n"
				+ "23 19\n" + "24 10\n" + "25 10\n" + "26 9\n" + "27 10\n" + "28 27\n" + "29 18\n"
				+ "30 15\n" + "31 14\n" + "32 30\n" + "33 5\n" + "34 2\n" + "35 14\n" + "36 3\n"
				+ "37 23\n" + "38 14\n" + "39 20\n" + "40 5\n" + "41 26\n" + "42 2\n" + "43 5\n"
				+ "44 36\n" + "45 32\n" + "46 24\n" + "47 3\n" + "48 38\n" + "49 30\n" + "50 13\n"
				+ "51 2\n" + "52 39\n" + "53 6\n" + "54 36\n" + "55 13\n" + "56 39\n" + "57 8\n"
				+ "58 50\n" + "59 44\n" + "60 4";
*/
		input = "70 69\n" + "2 1\n" + "3 2\n" + "4 2\n" + "5 3\n" + "6 2\n" + "7 1\n" + "8 7\n"
				+ "9 6\n" + "10 5\n" + "11 4\n" + "12 5\n" + "13 2\n" + "14 13\n" + "15 14\n"
				+ "16 9\n" + "17 15\n" + "18 5\n" + "19 3\n" + "20 10\n" + "21 11\n" + "22 16\n"
				+ "23 10\n" + "24 1\n" + "25 6\n" + "26 7\n" + "27 4\n" + "28 27\n" + "29 23\n"
				+ "30 4\n" + "31 29\n" + "32 7\n" + "33 30\n" + "34 25\n" + "35 15\n" + "36 27\n"
				+ "37 35\n" + "38 21\n" + "39 35\n" + "40 26\n" + "41 21\n" + "42 32\n" + "43 7\n"
				+ "44 40\n" + "45 43\n" + "46 31\n" + "47 24\n" + "48 20\n" + "49 38\n" + "50 28\n"
				+ "51 4\n" + "52 23\n" + "53 44\n" + "54 41\n" + "55 37\n" + "56 9\n" + "57 3\n"
				+ "58 43\n" + "59 39\n" + "60 22\n" + "61 1\n" + "62 35\n" + "63 10\n" + "64 45\n"
				+ "65 20\n" + "66 12\n" + "67 62\n" + "68 39\n" + "69 56\n" + "70 10";

		input = "50 49\n" + "2 1\n" + "3 1\n" + "4 2\n" + "5 2\n" + "6 4\n" + "7 6\n" + "8 5\n"
				+ "9 1\n" + "10 9\n" + "11 4\n" + "12 6\n" + "13 12\n" + "14 1\n" + "15 5\n"
				+ "16 2\n" + "17 8\n" + "18 7\n" + "19 3\n" + "20 18\n" + "21 3\n" + "22 9\n"
				+ "23 6\n" + "24 18\n" + "25 13\n" + "26 11\n" + "27 18\n" + "28 27\n" + "29 13\n"
				+ "30 25\n" + "31 30\n" + "32 24\n" + "33 12\n" + "34 11\n" + "35 12\n" + "36 3\n"
				+ "37 31\n" + "38 21\n" + "39 27\n" + "40 12\n" + "41 22\n" + "42 14\n" + "43 42\n"
				+ "44 33\n" + "45 1\n" + "46 24\n" + "47 22\n" + "48 30\n" + "49 22\n" + "50 43";

		Scanner in = new Scanner(input);

		evenTree.setTestInputData(in);
		evenTree.setEdgesToNodes();

		evenTree.findLeafs();

		evenTree.loop();

		evenTree.findRemovedEdges();
	}

	private void findRemovedEdges()
	{
		System.out.print(numOfCut);
	}

	private void loop()
	{
		boolean hasNonEventComponent = true;
		while (remainingNodes.size() != 0 || hasNonEventComponent) {
			int numOfComponents = components.size();
			while (hasNonEventComponent) {
				hasNonEventComponent = findNextNodes();
				if (numOfComponents == components.size()) {
					findLeafs();
				}
				numOfComponents = components.size();
			}
			findLeafs();
			hasNonEventComponent = hasNonEvenCompontent();
		}
	}

	private boolean findNextNodes()
	{
		for (Component component : components) {
			boolean hasOutterNodeInChildrens = component.hasOuterNodeInChildes();
			if (component.isEven() && !hasOutterNodeInChildrens) {
				component.setCompleted(true);
				component.cutFromParent();
			} else if (hasOutterNodeInChildrens) {
				//wait
			} else if (!hasOutterNodeInChildrens && !component.isEven()) {
				Component mergedComp = mergeCompontentWithParent(component,
						component.getParentNode());
				component.setNodes(mergedComp.getNodes());
			}
		}

		findAndMergeJoinedCompontents();

		return hasNonEvenCompontent();
	}

	private boolean hasNonEvenCompontent()
	{
		for (Component component : components) {
			if (!component.isEven()) {
				return true;
			}
		}

		return false;
	}

	private Integer getMaxKey(Set<Integer> keys)
	{
		Integer maxKey = null;

		for (Integer key : keys) {
			if (maxKey == null || maxKey < key) {
				maxKey = key;
			}
		}

		return maxKey;
	}

	private void findAndMergeJoinedCompontents()
	{
		Map<Integer, Component> topNodeIdMap = new HashMap<Integer, Component>();
		for (int i = 0; i < components.size(); i++) {
			topNodeIdMap.put(components.get(i).getTopNodeId(), components.get(i));
		}

		for (int i = 0; i < components.size(); i++) {
			if (topNodeIdMap.size() == 0) {
				break;
			}

			Integer maxKey = getMaxKey(topNodeIdMap.keySet());
			Component otherComp = topNodeIdMap.get(maxKey);

			Component mergeComponent = null;

			boolean needMerge = false;

			for (Component component : components) {
				if (!otherComp.equals(component) && component.getNodes().contains(maxKey)) {
					needMerge = true;
					mergeComponent = component;

					break;
				}
			}

			if (needMerge) {
				mergeComponent.addOtherCompontent(otherComp);
				topNodeIdMap.put(mergeComponent.getTopNodeId(), mergeComponent);
				components.remove(otherComp);
			}
			topNodeIdMap.remove(maxKey);
		}
	}

	private Component mergeCompontentWithParent(Component nonEventComponent, Integer key)
	{
		Component component = new Component();
		component.addNode(key);
		component.addOtherCompontent(nonEventComponent);

		remainingNodes.remove(key);

		component.cutFromParent();

		return component;
	}

	private void setEdgesToNodes()
	{
		for (Edge edge : edges) {
			Node parentNode = getNodeById(edge.getNode1());
			parentNode.addEdge(edge);

			Node childNode = getNodeById(edge.getNode2());
			childNode.addEdge(edge);

			parentNode.addChild(childNode);
			childNode.setParent(parentNode);
		}
	}

	private List<Integer> findLeafs()
	{
		List<Integer> leafs = new ArrayList<Integer>();

		int remainingSize = remainingNodes.size();

		for (int i = 0; i < remainingSize; i++) {

			Integer remainingNodeId = remainingNodes.get(i);
			Node node = getNodeById(remainingNodeId);

			if (node.getChildren() == null || node.getChildren().size() == 0) {
				leafs.add(remainingNodeId);
				Component compontent = new Component();
				compontent.addNode(remainingNodeId);
				components.add(compontent);
			}
		}

		for (int i = leafs.size() - 1; i >= 0; i--) {
			remainingNodes.remove(leafs.get(i));
		}

		return leafs;
	}

	private Node getNodeById(int id)
	{
		return allNodes.get(id - 1);
	}

	private void setTestInputData(Scanner in)
	{
		numOfNodes = in.nextInt();
		numOfEdges = in.nextInt();

		for (int i = 1; i <= numOfEdges; i++) {
			int node1 = in.nextInt();
			int node2 = in.nextInt();

			Edge edge = new Edge(Math.min(node1, node2), Math.max(node1, node2));
			edges.add(edge);
		}

		for (int i = 1; i <= numOfNodes; i++) {
			Node node = new Node(i);
			allNodes.add(node);
			remainingNodes.add(i);
		}
	}

	private class Component {

		private boolean isCompleted;

		public boolean isCompleted()
		{
			return isCompleted;
		}

		public void setCompleted(boolean completed)
		{
			isCompleted = completed;
		}

		private List<Integer> nodes = new ArrayList<Integer>();

		public List<Integer> getNodes()
		{
			return nodes;
		}

		private Integer getTopNodeId()
		{
			Integer min = null;

			for (Integer node : getNodes()) {
				if (min == null || min > node) {
					min = node;
				}
			}

			return min;
		}

		public boolean addNode(Integer newNodeId)
		{
			if (newNodeId == null) {
				return false;
			}

			if (!nodes.contains(newNodeId)) {
				this.nodes.add(newNodeId);

				return true;
			}

			return false;
		}

		public boolean isEven()
		{
			return this.nodes.size() % 2 == 0;
		}

		public Integer getParentNode()
		{

			Integer minIdNode = getTopNodeId();
			Node topNode = getNodeById(minIdNode);

			Node parent = topNode.getParent();
			if (parent == null)
				return null;

			return parent.getId();
		}

		public void addOtherCompontent(Component otherComp)
		{
			for (Integer nodeIndex : getNodes()) {
				if (otherComp.getNodes().contains(nodeIndex)) {
					otherComp.getNodes().remove(nodeIndex);
				}
			}

			getNodes().addAll(otherComp.getNodes());
		}

		@Override public String toString()
		{
			Collections.sort(getNodes());

			return "Component:" + getNodes();
		}

		public void cutFromParent()
		{
			if (!isEven()) {
				return;
			}

			Integer topNodeId = getTopNodeId();

			if (topNodeId == 1) {
				return;
			}

			Node topNode = getNodeById(topNodeId);
			Node parent = topNode.getParent();
			if (parent == null) {
				return;
			}
			Integer parentNodeId = parent.getId();

			if (hasOuterNodeInChildes())
				return;

			Edge removingEdge = new Edge(parentNodeId, topNodeId);

			topNode.removeEdge(removingEdge);
			parent.removeEdge(removingEdge);
			numOfCut++;
		}

		private boolean hasOuterNodeInChildes()
		{
			for (Integer nodeId : getNodes()) {

				Node nodeById = getNodeById(nodeId);
				if (nodeById.getChildren() == null) {
					continue;
				}

				if (!getNodes().containsAll(nodeById.getChildrenIds())) {
					return true;
				}
			}
			return false;
		}

		public void setNodes(List<Integer> nodes)
		{
			this.nodes = nodes;
		}
	}

	class Node {
		private int id;
		private Node parent;

		public Node getParent()
		{
			return parent;
		}

		public void setParent(Node parent)
		{
			this.parent = parent;
		}

		List<Node> children;

		public List<Node> getChildren()
		{
			return children;
		}

		public List<Integer> getChildrenIds()
		{
			if (children == null)
				return null;

			List<Integer> childrenIds = new ArrayList<Integer>();

			for (Node node : children) {
				childrenIds.add(node.getId());
			}

			return childrenIds;
		}

		public void addChild(Node child)
		{
			if (children == null) {
				children = new ArrayList<Node>();
			}

			children.add(child);
		}

		public Node(int index)
		{
			this.id = index;
		}

		private List<Edge> edges = new ArrayList<Edge>();

		public int getId()
		{
			return id;
		}

		public void addEdge(Edge edge)
		{
			edges.add(edge);
		}

		public List<Edge> getEdges()
		{
			return edges;
		}

		public void removeEdge(Edge removingEdge)
		{
			edges.remove(removingEdge);
			int theOtherNodeId = removingEdge.getTheOtherNodeId(this);

			if (parent != null && parent.getId() == theOtherNodeId) {
				setParent(null);
			} else {
				children.remove(getNodeById(theOtherNodeId));
			}
		}
	}

	class Edge {
		private int node1;
		private int node2;

		public Edge(int node1, int node2)
		{
			this.node1 = node1;
			this.node2 = node2;
		}

		public int getNode1()
		{
			return node1;
		}

		public int getNode2()
		{
			return node2;
		}

		public int getTheOtherNodeId(Node node)
		{
			if (node.getId() == node1) {
				return node2;
			} else {
				return node1;
			}
		}

		@Override public boolean equals(Object o)
		{
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Edge edge = (Edge)o;

			if (node1 != edge.node1)
				return false;
			return node2 == edge.node2;

		}

		@Override public int hashCode()
		{
			int result = node1;
			result = 31 * result + node2;
			return result;
		}
	}
}

