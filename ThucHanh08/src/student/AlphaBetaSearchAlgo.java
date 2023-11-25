package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		maxValue(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	public Node bestMove(Node node, String anNode) {
		maxValue(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
		Node result= bestMoveAtAnyNode(node, anNode);
		return result;
	}
	public Node bestMoveAtAnyNode(Node node, String anyNode) {
		Node result = null;
		
		if (node.getLabel().equalsIgnoreCase(anyNode)) {
			for (Node nd : node.getChildren()) {
				if (nd.getValue() == node.getValue()) {
					result = nd;
					return result;
				}
			}
		} else {
			for (Node nd : node.getChildren()) {
				if (!nd.isTerminal()) {
					if (bestMoveAtAnyNode(nd, anyNode) != null) {
						result = bestMoveAtAnyNode(nd, anyNode);
						return result;
					}
				}
			}
		}

		return result;
	}
	
	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		int result = Integer.MIN_VALUE;
		node.setValue(result);
		if(!node.isTerminal()) {
			node.getChildren().sort(Node.minToMax);
			for(Node nd:node.getChildren()) {
				if(!nd.isTerminal()) {
					nd.setValue(minValue(nd, alpha, beta));
				}
				if(nd.getValue() >=beta) {
					node.setVisited(true);
					nd.setVisited(true);
					node.setValue(nd.getValue());
					beta = nd.getValue();
				}
				
			}
		}
		
		return node.getValue();
	}
	
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		//alpha=min_value
		//beta=max_value
		int result = Integer.MAX_VALUE;
		node.setValue(result);
		if(!node.isTerminal()) {
			node.getChildren().sort(Node.minToMax);
			for(Node nd:node.getChildren()) {
				if(!nd.isTerminal()) {
					nd.setValue(maxValue(nd, alpha, beta));
				}
				if(nd.getValue() <=alpha) {
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
