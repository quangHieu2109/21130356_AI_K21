package student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
	
	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		ArrayList<Node> result = new ArrayList<Node>();
		if(!isTerminal()) {
			for(int current:data) {
				int amount = current/2;
				
				if(amount >0) {
					for(int i = amount; i>0; i--) {
						if(current-i != i) {
							ArrayList<Integer> childData = new ArrayList<Integer>();
							ArrayList<Integer> tmp = new ArrayList<Integer>();
							tmp.addAll(data);
							tmp.remove((Integer)current);
							childData.add(current-i);
							childData.add(i);
							childData.addAll(tmp);
							Node child = new Node();
							child.addAll(childData);
							
							result.add(child);
						}
					}
				}
			}
		}
		return result;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		data.sort(DESCOMPARATOR);
		
		if(data.get(0) <=2) {
			return true;
		}
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
