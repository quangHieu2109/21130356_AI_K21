package lap23_Task456;


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
		
		
		UniformCostSearchAlgo us = new UniformCostSearchAlgo();
		DepthLimitedSearch dl = new DepthLimitedSearch();
//		NodeUtils.print(NodeUtils.printPath(us.execute(nodeS, "G")));
		//them sau
//				nodeG.addEdge(nodeH,1);
		NodeUtils.print(NodeUtils.printPath(dl.execute2(nodeS, "G",1)));
//		us.execute(nodeS, "G");
	}
}