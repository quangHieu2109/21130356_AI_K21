package student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.getH() > o2.getH()) {
					return 1;
				}else return -1;
			}
		
		});
		ArrayList<Node> visited = new ArrayList<Node>();
		Node result = null;
		queue.add(model.getInitialState());
		int i =0;
		while (!queue.isEmpty() ) {
			
			Node current = queue.poll();
			visited.add(current);
			System.out.println("Curent: "+current.getH());
			if(model.computeH2(current) == 0) {
				
				result = current;
				return result;
			}else {
				for(Node nd:model.getSuccessors(current)) {
					if(!visited.contains(nd) && !queue.contains(nd)) {
						
						queue.add(nd);
						nd.setG(current.getG()+1);
						System.out.println("H: "+nd.getH()+" G: "+nd.getG());
					}
				}
			}
			i++;
			
		}
		return result;
	}
	

}
