package student;


public class Test {
	public static void main(String[] args) {
		Node nodeE = new Node("E", 3);
		Node nodeF = new Node("F", 12);
		Node nodeG = new Node("G", 8);
		Node nodeH = new Node("H", 2);
		Node nodeI = new Node("I", 4);
		Node nodeJ = new Node("J", 6);
		Node nodeK = new Node("K", 14);
		Node nodeL = new Node("L", 5);
		Node nodeM = new Node("M", 2);
		
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		
		Node nodeA = new Node("A");
		
		nodeB.addChild(nodeE);
		nodeB.addChild(nodeF);
		nodeB.addChild(nodeG);
		
		nodeC.addChild(nodeH);
		nodeC.addChild(nodeI);
		nodeC.addChild(nodeJ);
		
		nodeD.addChild(nodeK);
		nodeD.addChild(nodeL);
		nodeD.addChild(nodeM);
		
		nodeA.addChild(nodeB);
		nodeA.addChild(nodeC);
		nodeA.addChild(nodeD);
		
		MiniMaxSearchAlgo minimax = new MiniMaxSearchAlgo();
		minimax.execute(nodeA);
		System.out.println();
		
//		----------------------------------
		 nodeE = new Node("E");
		 nodeF = new Node("F");
		 nodeG = new Node("G", -5);
		 nodeH = new Node("H", 3);
		 nodeI = new Node("I", 8);
		 nodeJ = new Node("J");
		 nodeK = new Node("K");
		 nodeL = new Node("L", 2);
		 nodeM = new Node("M");
		
		 Node nodeN = new Node("N", 4);
		 Node nodeO = new Node("O");
		 Node nodeW = new Node("W", -3);
		 Node nodeX = new Node("X", -5);
		 
		 Node nodeP = new Node("P", 9);
		 Node nodeQ = new Node("Q", -6);
		 Node nodeR = new Node("R", 0);
		 
		 Node nodeS = new Node("S", 3);
		 Node nodeT = new Node("T", 5);
		 Node nodeU = new Node("U", -7);
		 Node nodeV = new Node("V", -9);
		 
		 
		 nodeB = new Node("B");
		 nodeC = new Node("C");
		 nodeD = new Node("D", 0);
		
		 nodeA = new Node("A");
		 
		 nodeO.addChild(nodeW);
		 nodeO.addChild(nodeX);
		 
		 nodeF.addChild(nodeO);
		 nodeF.addChild(nodeN);
		 
		 nodeB.addChild(nodeF);
		 nodeB.addChild(nodeG);
		 
		 nodeJ.addChild(nodeP);
		 nodeJ.addChild(nodeQ);
		 nodeJ.addChild(nodeR);
		 
		 nodeC.addChild(nodeH);
		 nodeC.addChild(nodeI);
		 nodeC.addChild(nodeJ);
		 
		 nodeK.addChild(nodeS);
		 nodeK.addChild(nodeT);
		 nodeM.addChild(nodeU);
		 nodeM.addChild(nodeV);
		 
		 nodeE.addChild(nodeK);
		 nodeE.addChild(nodeL);
		 nodeE.addChild(nodeM);
		 
		 nodeA.addChild(nodeB);
		 nodeA.addChild(nodeC);
		 nodeA.addChild(nodeD);
		 nodeA.addChild(nodeE);
		 
		 
		
		AlphaBetaSearchAlgo ab = new AlphaBetaSearchAlgo();
		RightToLeftSearchAlgo right = new RightToLeftSearchAlgo();
//		right.execute(nodeA);
		ab.execute(nodeA);
		System.out.println(ab.bestMove(nodeA, "A").getLabel() + nodeA.getValue());
//		nodeA.printTree();
//		nodeA.getChildren().sort(Node.maxToMin);
//		for(Node nd: nodeA.getChildren()) {
//			System.out.println(nd.getLabel());
//		}
//		System.out.println(minimax.minValue(nodeA));
//		System.out.println(ab.maxValue(nodeA, 999, -999));
//		ab.execute(nodeA);
//		nodeA.printTree();
//		for(Node nd:nodeA.allChildren()) {
//			System.out.println(nd.getLabel() +" "+ nd.isVisited());
//		}
	}
}
