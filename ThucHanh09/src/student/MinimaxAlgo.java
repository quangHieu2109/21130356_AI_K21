package student;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int result= Integer.MIN_VALUE;
		for(Node nd:node.getSuccessors()) {
			int value;
			if(nd.isTerminal()) {
				value=1;
			}else {
				value = minValue(nd);
			}
			if(value >result) {
				result = value;
			}
		}
		return result;
	}
	public Node bestMove(Node node) {
		Node result=null;
		for(Node nd:node.getSuccessors()) {
			if(maxValue(nd) == minValue(node)) {
				result = nd;
				return result;
			}
		}
		return result;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		int result = Integer.MAX_VALUE;
		for(Node nd: node.getSuccessors()) {
			int value ;
			if(nd.isTerminal()) {
				value=0;
			}else {
				value = maxValue(nd);
			}
			if(value < result) {
				result = value;
			}
		}
		return result;
	}
}
