package lap23_Task123;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgoTree implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Node result=null ;
		boolean find = false;
		List<Node> visited = new ArrayList<>();
		// BFS
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		if (root.getLabel().equals(goal)) {
			return root;
		} else {
			w:while (!stack.isEmpty()) {
				Node visit = stack.pop();
				visited.add(visit);
				for (int i=visit.getChildren().size()-1; i>=0; i--) {
					Edge edge = visit.getChildren().get(i);
//					if (!visited.contains(edge.getEnd()) && !stack.contains(edge.getEnd())) {
						if (edge.getEnd().getLabel().equals(goal)) {
							edge.getEnd().setParent(visit);
							edge.getEnd().setPathCost(edge.getWeight()+edge.getBegin().getPathCost());
							visited.add(edge.getEnd());
							result = edge.getEnd();
//							break w;
						} else {
							stack.push(edge.getEnd());
							edge.getEnd().setParent(visit);
							edge.getEnd().setPathCost(edge.getWeight()+edge.getBegin().getPathCost());
							visited.add(edge.getEnd());
						}
//					}
				}
			}

		}
		if(result == null) {
			System.out.println("Khong co duong di tu "+root.getLabel()+" toi "+goal);
		}
		return result;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node result = null;
		Stack<Node> stack = new Stack<>();
		List<Node> visited = new ArrayList<>();
		stack.push(root);
		
		boolean find = false;
		
		w:while(!stack.isEmpty()) {
			Node visiting = stack.pop();
			visited.add(visiting);
			if(root.getLabel().equals(goal)) {
				result = root;
				break;
			}else  {
				if(visiting.getLabel().equals(start)) {
					
					stack = new Stack<>();
					visited = new ArrayList<>();
					find = true;
				}
				for(int i=visiting.getChildren().size()-1; i>=0; i--) {
					Edge ed = visiting.getChildren().get(i);
					if(find) {
//						if(!visited.contains(ed.getEnd()) && !stack.contains(ed.getEnd())) {
							
							if(ed.getEnd().getLabel().equals(goal)) {
								ed.getEnd().setParent(visiting);
								ed.getEnd().setPathCost(ed.getWeight()+ed.getBegin().getPathCost());
								result = ed.getEnd();
//								break w;
								
							}else {
								ed.getEnd().setParent(visiting);
								ed.getEnd().setPathCost(ed.getWeight()+ed.getBegin().getPathCost());
								stack.add(ed.getEnd());
								visited.add(ed.getEnd());
							}
//						}
					}else {
						if(!visited.contains(ed.getEnd()) && !stack.contains(ed.getEnd())) {
								stack.push(ed.getEnd());
								visited.add(ed.getEnd());
							}
					}
				}
			}
			
			
		}
		if(result == null) {
			System.out.println("Khong co duong di tu "+start +" toi "+goal);
		}
		return result;
	}

}

