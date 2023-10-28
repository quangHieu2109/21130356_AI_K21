package lap4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Comparator<Node> cp = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				double f1 = o1.getH()+o1.getG();
				double f2 = o2.getH()+o2.getG();
				int result = 0;
				if(f1>f2) {
					result = 1;
				}else if(f1<f2) {
					result =-1;
				}
				if(result ==0) {
					return o1.getLabel().compareTo(o2.getLabel());
				}else {
					return result;
				}
			}
		};
		PriorityQueue<Node> queue = new PriorityQueue<Node>(cp);
		List<Node> visited = new ArrayList<Node>();
		Node result = null;
		queue.add(root);
		if(root.getLabel().equals(goal)) {
			return root;
		}else {
			while(!queue.isEmpty()) {
				Node visiting = queue.poll();
//				System.out.println("Parent: "+visiting.getLabel());
//				System.out.println(visiting.getLabel()+" "+(visiting.getG()+visiting.getH()));
				visited.add(visiting);
				for(Edge edge:visiting.getChildren()) {
					if(!visited.contains(edge.getEnd())) {
						if(edge.getEnd().getLabel().equals(goal)) {
							result=edge.getEnd();
						}
						if(edge.getEnd().getG() != 0) {
							if(edge.getBegin().getG()+edge.getWeight()+edge.getEnd().getH() 
									<edge.getEnd().getG()+edge.getEnd().getH()) {
								edge.getEnd().setG(edge.getBegin().getG()+edge.getWeight());
								edge.getEnd().setParent(visiting);
							}
						}else {
							edge.getEnd().setG(edge.getBegin().getG()+edge.getWeight());
							edge.getEnd().setParent(visiting);
						}
						
						queue.add(edge.getEnd());
					}
					
					
				}
			}
		}
		return result;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Comparator<Node> cp = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				double f1 = o1.getH()+o1.getG();
				double f2 = o2.getH()+o2.getG();
				int result = 0;
				if(f1>f2) {
					result = 1;
				}else if(f1<f2) {
					result =-1;
				}
				if(result ==0) {
					return o1.getLabel().compareTo(o2.getLabel());
				}else {
					return result;
				}
			}
		};
		PriorityQueue<Node> queue = new PriorityQueue<Node>(cp);
		List<Node> visited = new ArrayList<Node>();
		Node result = null;
		boolean find = false;
		queue.add(root);
		if(root.getLabel().equals(goal)) {
			return root;
		}else {
			while(!queue.isEmpty()) {
				Node visiting = queue.poll();
//				System.out.println("Parent: "+visiting.getLabel());
//				System.out.println(visiting.getLabel()+" "+(visiting.getG()+visiting.getH()));
				if(visiting.getLabel().equals(start)) {
					queue.removeAll(queue);
					find=true;
				}
				if(!find) {
					for(Edge edge:visiting.getChildren()) {
						if(!queue.contains(edge.getEnd())) {
							queue.add(edge.getEnd());
						}
					}
				}else {
					visited.add(visiting);
					for(Edge edge:visiting.getChildren()) {
						if(!visited.contains(edge.getEnd())) {
							if(edge.getEnd().getLabel().equals(goal)) {
								result=edge.getEnd();
							}
							if(edge.getEnd().getG() != 0) {
								if(edge.getBegin().getG()+edge.getWeight()+edge.getEnd().getH() 
										<edge.getEnd().getG()+edge.getEnd().getH()) {
									edge.getEnd().setG(edge.getBegin().getG()+edge.getWeight());
									edge.getEnd().setParent(visiting);
								}
							}else {
								edge.getEnd().setG(edge.getBegin().getG()+edge.getWeight());
								edge.getEnd().setParent(visiting);
							}
							
							queue.add(edge.getEnd());
						}
						
						
					}
				}
			}
		}
		return result;
	}
	public boolean isAdmissibleH(Node root, String goal) {
		boolean result =true;
		Queue<Node> queue = new LinkedList<Node>();
		List<Node> visited = new ArrayList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node visiting = queue.poll();
			visited.add(visiting);
			if(visiting.getH() > execute(visiting, goal).getG()) {
				result=false;
				return result;
			}
			
			for(Node node:visiting.getChildrenNodes()) {
				if(!visited.contains(node) && !queue.contains(node)) {
					queue.add(node);
				}
			}
		}
		
		return result;
	}

}
