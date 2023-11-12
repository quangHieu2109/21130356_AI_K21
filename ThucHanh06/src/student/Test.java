package student;

public class Test {
public static void main(String[] args) {
	Node node = new Node();
	node.generateBoard();
//	node.displayBoard();
//	System.out.println(node.getH());
//	System.out.println("Random: ........................................");
//	for(Node nd : node.generateAllCandidates()) {
//		nd.displayBoard();
//		System.out.println(nd.getH());
//	}
//	System.out.println("Execute");
//	Search.executeHillClimbingWithRandomRestart(node);
	
	Node nd = Search.executeSASearch(1000, 7000, 0.95);
	nd.displayBoard();
	System.out.println(nd.getH());
//	node.generateAllCandidates();
	
}
}
