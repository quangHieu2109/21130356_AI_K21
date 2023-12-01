package student;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));
//		for(Node nd: node.getSuccessors()) {
//			for(Node nd2:nd.getSuccessors()) {
//				System.out.println(nd2);
//			}
//		}
		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
		System.out.println(algo.bestMove(node));
	}
}