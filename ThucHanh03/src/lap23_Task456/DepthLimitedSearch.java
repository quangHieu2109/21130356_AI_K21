package lap23_Task456;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {
	public Node execute(Node root, String goal, int limitedDetph) {
		Node result = null;
		List<Node> visited = new ArrayList<>();
		Stack<Node> st = new Stack<>();
		if (root.getLabel().equals(goal)) {
			result = root;
			return result;
		} else {
			st.push(root);
			while (!st.isEmpty()) {
				Node visit = st.pop();
				visited.add(visit);
				if (visit.getDepth() < limitedDetph) {
					for (int i = visit.getChildren().size() - 1; i >= 0; i--) {

						Edge ed = visit.getChildren().get(i);
						if (!visited.contains(ed.getEnd())) {
							ed.getEnd().setParent(visit);
							ed.getEnd().setDepth(visit.getDepth() + 1);
							ed.getEnd().setPathCost(ed.getWeight() + visit.getPathCost());

						}
						if (ed.getEnd().getLabel().equals(goal)) {
							result = ed.getEnd();
							return result;
						} else {
							st.push(ed.getEnd());
						}
					}
				} else {
					continue;
				}
			}
		}
		return result;
	}
	public Node execute2(Node root, String goal, int maxDepth) {
		Node result = null;
		int depth =0;
		for(int i=0; i<=maxDepth; i++) {
			if(execute(root, goal, i) != null) {
				result = execute(root, goal, i);
				depth =i;
				break;
			}
		}
		if(result != null) {
			System.out.println("Da tim ra goal tai depth ="+depth);
		}else {
			System.out.println("Voi depth ="+maxDepth+" khong tim ra goal!");
		}
		return result;
	}
}
