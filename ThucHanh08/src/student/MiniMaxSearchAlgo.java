package student;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		maxValue(node);
	}

	
	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
//	public int maxValue(Node node) {
//		int result = Integer.MIN_VALUE;
//		if (!node.isTerminal()) {
//			for (Node nd : node.getChildren()) {
//				if (!nd.isTerminal()) {
//					if(minValue(nd) > result) {
//						result = minValue(nd);
//					}
//				}else {
//					if(nd.getValue()>result) {
//						result = nd.getValue();
//					}
//				}
//				
//			}
//		}
//		return result;
//	}

	public int maxValue(Node node) {

		if (!node.isTerminal()) {
			node.getChildren().sort(Node.minToMax);
			node.setValue(Integer.MIN_VALUE);
			for (Node nd : node.getChildren()) {
				if (!nd.isTerminal()) {
					nd.setValue(minValue(nd));
				}
				if (nd.getValue() > node.getValue()) {
					node.setValue(nd.getValue());
				}
			}

		}

		return node.getValue();
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

//	public int minValue(Node node) {
//		int result = Integer.MAX_VALUE;
//		if (!node.isTerminal()) {
//			for (Node nd : node.getChildren()) {
//				if (!nd.isTerminal()) {
//					if(maxValue(nd) < result) {
//						result = maxValue(nd);
//					}
//				}else {
//					if(nd.getValue()<result) {
//						result = nd.getValue();
//					}
//				}
//			}
//		}
//		return result;
//	}

	public int minValue(Node node) {

		if (!node.isTerminal()) {
			node.getChildren().sort(Node.minToMax);
			node.setValue(Integer.MAX_VALUE);
			for (Node nd : node.getChildren()) {
				if (!nd.isTerminal()) {
					nd.setValue(maxValue(nd));
				}
				if (nd.getValue() < node.getValue()) {
					node.setValue(nd.getValue());
				}
			}

		}

		return node.getValue();
	}
}
