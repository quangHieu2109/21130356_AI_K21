package lap23_Task123;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");

		
		nodeS.addEdge(nodeC, 4);
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);

		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);

		nodeB.addEdge(nodeG, 6);

		nodeC.addEdge(nodeF, 2);

		nodeD.addEdge(nodeH, 7);

		nodeE.addEdge(nodeG, 6);

		nodeF.addEdge(nodeG, 1);
		

//		BreadthFirstSearchAlgoTree bjfTree = new BreadthFirstSearchAlgoTree();
//		DepthFirstSearchAlgoTree dfsTree = new DepthFirstSearchAlgoTree();
//		BreadthFirstSearchAlgo bfsGraph = new BreadthFirstSearchAlgo();
//		DepthFirstSearchAlgo dfsGraph = new DepthFirstSearchAlgo();
//		System.out.print("BFS Graph: ");
//		NodeUtils.print(NodeUtils.printPath(bfsGraph.execute(nodeS, "G")));
//		System.out.print("BFS Tree: ");
//		NodeUtils.print(NodeUtils.printPath(bjfTree.execute(nodeS, "G")));
//		System.out.print("DFS Graph: ");
//		NodeUtils.print(NodeUtils.printPath(dfsGraph.execute(nodeS, "G")));
//		System.out.print("DFS Tree: ");
//		NodeUtils.print(NodeUtils.printPath(dfsTree.execute(nodeS, "G")));
		
//		System.out.println("\n");
//		
//		System.out.print("BFS Graph: ");
//		NodeUtils.print(NodeUtils.printPath(bfsGraph.execute(nodeS,"A", "G")));
//		System.out.print("BFS Tree: ");
//		NodeUtils.print(NodeUtils.printPath(bjfTree.execute(nodeS,"A", "G")));
//		System.out.print("DFS Graph: ");
//		NodeUtils.print(NodeUtils.printPath(dfsGraph.execute(nodeS,"A", "G")));
//		System.out.print("DFS Tree: ");
//		NodeUtils.print(NodeUtils.printPath(dfsTree.execute(nodeS,"A", "G")));
		
		
		
	}
}
