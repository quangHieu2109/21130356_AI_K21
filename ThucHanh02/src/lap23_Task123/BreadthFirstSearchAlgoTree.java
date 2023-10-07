package lap23_Task123;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgoTree implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Node result=null ;
		boolean find = false;
		List<Node> visited = new ArrayList<>();
		// BFS
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		if (root.getLabel().equals(goal)) {
			return root;
		} else {
			w:while (!queue.isEmpty()) {
				Node visit = queue.poll();
				visited.add(visit);

				for (Edge edge : visit.getChildren()) {
//					if (!visited.contains(edge.getEnd()) && !queue.contains(edge.getEnd())) {
						if (edge.getEnd().getLabel().equals(goal)) {
							edge.getEnd().setParent(visit);
							edge.getEnd().setPathCost(edge.getWeight()+edge.getBegin().getPathCost());
							visited.add(edge.getEnd());
							result = edge.getEnd();
//							break w;
						} else {
							queue.add(edge.getEnd());
							edge.getEnd().setParent(visit);
							edge.getEnd().setPathCost(edge.getWeight()+edge.getBegin().getPathCost());
							visited.add(edge.getEnd());
						}
					}
//				}
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
		Queue<Node> queue = new LinkedList<>();
		List<Node> visited = new ArrayList<>();
		queue.add(root);
		
		boolean find = false;
		
		w:while(!queue.isEmpty()) {
			Node visiting = queue.poll();
			visited.add(visiting);
			if(root.getLabel().equals(goal)) {
				System.out.println(12);
				result = root;
				break;
			}else  {
				if(visiting.getLabel().equals(start)) {
					
					queue = new LinkedList<>();
					visited = new ArrayList<>();
					find = true;
				}
				
				for(Edge ed:visiting.getChildren()) {
					Node end = ed.getEnd();
					if(find) {
//						if(!visited.contains(ed.getEnd()) && !queue.contains(ed.getEnd())) {
//							System.out.println(1);
							if(ed.getEnd().getLabel().equals(goal)) {
								ed.getEnd().setParent(visiting);
								ed.getEnd().setPathCost(ed.getWeight()+ed.getBegin().getPathCost());
								result = ed.getEnd();
//								break w;
								
							}else {
								ed.getEnd().setParent(visiting);
								ed.getEnd().setPathCost(ed.getWeight()+ed.getBegin().getPathCost());
								queue.add(ed.getEnd());
								visited.add(ed.getEnd());
							}
//						}
					}else {
						if(!visited.contains(ed.getEnd()) && !queue.contains(ed.getEnd())) {
								queue.add(ed.getEnd());
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
