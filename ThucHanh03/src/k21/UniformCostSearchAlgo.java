package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo{
// Graph search
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Comparator<Node> cp = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				double tmp = o1.getPathCost() - o2.getPathCost();
				if(tmp >0) {
					return 1;
				}else {
					return -1;
				}
			}
		
		};
		PriorityQueue<Node> queue = new PriorityQueue<>(cp);
		Node result = null;
		List<Node> visited = new ArrayList<>();
		List<Node> visited2 = new ArrayList<>();
		queue.add(root);
//		System.out.println(queue.peek().getLabel());
		if(root.getLabel().equals(goal)) {
			result= root;
			return result;
		}else {
			while(!queue.isEmpty()) {
				Node visit = queue.poll();
				visited2.add(visit);
				for(Edge edge : visit.getChildren()) {
					if(!visited2.contains(edge.getEnd())) {
						if(!visited.contains(edge.getEnd())) {
							edge.getEnd().setParent(visit);
							edge.getEnd().setPathCost(edge.getWeight()+edge.getEnd().getPathCost());
							visited.add(edge.getEnd());
						}else {
							if(edge.getEnd().getPathCost() > edge.getWeight()+visit.getPathCost()) {
								edge.getEnd().setParent(visit);
								edge.getEnd().setPathCost(edge.getWeight()+edge.getEnd().getPathCost());
							}
						}
						queue.add(edge.getEnd());
						
					}
					if(edge.getEnd().getLabel().equals(goal)) {
						result = edge.getEnd();
					}
				}
			}
		}
		
		
		
		
		
		return result;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Comparator<Node> cp = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				double tmp = o1.getPathCost() - o2.getPathCost();
				if(tmp >0) {
					return 1;
				}else {
					return -1;
				}
			}
		
		};
		PriorityQueue<Node> queue = new PriorityQueue<>(cp);
		Node result = null;
		boolean find = false;
		List<Node> visited = new ArrayList<>();
		List<Node> visited2 = new ArrayList<>();
		queue.add(root);
//		System.out.println(queue.peek().getLabel());
		if(root.getLabel().equals(goal)) {
			result= root;
			return result;
		}else {
			while(!queue.isEmpty()) {
				Node visit = queue.poll();
				visited2.add(visit);
				if(visit.getLabel().equals(start)) {
					find = true;
					visited2=new ArrayList<>();
					visited2.add(visit);
					queue = new PriorityQueue<>(cp);
					
				}
				if(!find) {
					for(Edge edge:visit.getChildren()) {
						if(!visited2.contains(edge.getEnd())) {
							queue.add(edge.getEnd());
							
						}
					}
				}else {
					for(Edge edge : visit.getChildren()) {
						if(!visited2.contains(edge.getEnd())) {
							if(!visited.contains(edge.getEnd())) {
								edge.getEnd().setParent(visit);
								edge.getEnd().setPathCost(edge.getWeight()+edge.getEnd().getPathCost());
								visited.add(edge.getEnd());
							}else {
								if(edge.getEnd().getPathCost() > edge.getWeight()+visit.getPathCost()) {
									edge.getEnd().setParent(visit);
									edge.getEnd().setPathCost(edge.getWeight()+edge.getEnd().getPathCost());
								}
							}
							queue.add(edge.getEnd());
							
						}
						if(edge.getEnd().getLabel().equals(goal)) {
							result = edge.getEnd();
						}
					}
				}
			}
		}
		return result;
	}

}
