package lap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Node result = null;
		Comparator<Node> cp = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.getH()<o2.getH()) {
					return -1;
				}else return 1;
			}
		};
		PriorityQueue<Node> queue = new PriorityQueue(cp);
		List<Node> visited = new ArrayList<Node>();
		queue.add(root);
		if (root.getLabel().equals(goal)) {
			return root;
		} else {
			while (!queue.isEmpty()) {
				Node visiting = queue.poll();
				for(Node node: visiting.getChildrenNodes()) {
					if(!visited.contains(node) && !queue.contains(node)) {
						if(node.getLabel().equals(goal)) {
							node.setParent(visiting);
							result=node;
							return result;
						}else {
							node.setParent(visiting);
							queue.add(node);
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node result = null;
		boolean find = false;
		Comparator<Node> cp = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.getH()<o2.getH()) {
					return -1;
				}else return 1;
			}
		};
		PriorityQueue<Node> queue = new PriorityQueue(cp);
		List<Node> visited = new ArrayList<Node>();
		queue.add(root);
		if (root.getLabel().equals(goal)) {
			return root;
		} else {
			while (!queue.isEmpty()) {
				Node visiting = queue.poll();
				if(visiting.getLabel().equals(start)) {
					queue.removeAll(queue);
					find = true;
				}
				if(!find) {
					for(Node node:visiting.getChildrenNodes()) {
						if(!queue.contains(node)) {
							queue.add(node);
						}
					}
				}else {
					for(Node node: visiting.getChildrenNodes()) {
						if(!visited.contains(node) && !queue.contains(node)) {
							if(node.getLabel().equals(goal)) {
								node.setParent(visiting);
								result=node;
								return result;
							}else {
								node.setParent(visiting);
								queue.add(node);
							}
						}
					}
				}
			}
		}
		return result;
	}

}
