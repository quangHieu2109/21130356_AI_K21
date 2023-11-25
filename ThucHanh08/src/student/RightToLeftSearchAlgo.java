package student;

import java.util.Collections;
import java.util.List;

public class RightToLeftSearchAlgo implements ISearchAlgo {

	@Override
	public void execute(Node node) {
		// TODO Auto-generated method stub
		maxValue(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		int result = Integer.MIN_VALUE;
		node.setValue(result);
		if (!node.isTerminal()) {
			node.getChildren().sort(Node.maxToMin);
			for (Node nd : node.getChildren()) {
				if (!nd.isTerminal()) {
					nd.setValue(minValue(nd, alpha, beta));
				}
				if (nd.getValue() >= beta) {
					node.setVisited(true);
					nd.setVisited(true);
					node.setValue(nd.getValue());
					beta = nd.getValue();
				}

			}
		}

		return node.getValue();
	}

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		// alpha=min_value
		// beta=max_value
		int result = Integer.MAX_VALUE;
		node.setValue(result);
		if (!node.isTerminal()) {
			node.getChildren().sort(Node.maxToMin);
			for (Node nd : node.getChildren()) {
				if (!nd.isTerminal()) {
					nd.setValue(maxValue(nd, alpha, beta));
				}
				if (nd.getValue() <= alpha) {
					node.setValue(nd.getValue());
					alpha = nd.getValue();
					node.setVisited(true);
					nd.setVisited(true);
				}

			}
		}

		return node.getValue();
	}
}
