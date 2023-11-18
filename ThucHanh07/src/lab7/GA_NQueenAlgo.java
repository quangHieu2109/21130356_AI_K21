package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;
	public static final double MUTATION_RATE =0.03;
	public static final int MAX_ITERATIONS= 1000;
	private int indexGet =111;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();
	
	public void initPopulation() {
		for(int i=0; i<POP_SIZE; i++) {
			population.add(new Node());
		}
	}
	public Node reproduce(Node x, Node y) {
		Node result = null;
//		System.out.println("father:");
//		x.displayBoard();
//		System.out.println("mother:");
//		y.displayBoard();
		Queen[] queen = x.getState();
		Queen[] tmp = y.getState();
		int index = rd.nextInt(tmp.length-2);
		index=(index==0)?(index+3):index;
		for(int i=index; i<tmp.length; i++) {
			queen[i] = tmp[i];
		}
		result=new Node(queen);
//		System.out.println("index: "+index);
//		
//		System.out.println("child:");
//		result.displayBoard();
		
		return result;
	}
	public Node getParentByRandomSelection() {
		int index = rd.nextInt(POP_SIZE-1);
		while(index == indexGet) {
			 index = rd.nextInt(POP_SIZE-1);
		}
		indexGet = index;
		return population.get(index);
	}
	public Node mutate(Node node) {
		return node.selectNextRandomCandidate();
	}
	public Node getParentByTournamentSelection(int k) {
		List<Node> list = new ArrayList<Node>();
		while(k>0) {
			int index = rd.nextInt(POP_SIZE-1);
			list.add(population.get(index));
			
		}
		int index = rd.nextInt(list.size()-1);
		
	return list.get(index);
	}
	public Node execute() {
		Node result = null;
		int step=0;
		result = population.get(0);
		while(step<MAX_ITERATIONS) {
			List<Node> new_population = new ArrayList<Node>();
			for(int i=0; i<POP_SIZE; i++) {
				Node father = getParentByRandomSelection();
				Node mother = getParentByRandomSelection();
				Node child = reproduce(father, mother);
				if(rd.nextInt(POP_SIZE)%7 ==0) {
					child = mutate(child);
				}
				new_population.add(child);
			}
			population = new_population;
			Collections.sort(population);
//			result = population.get(0);
			if(population.get(0).getH()<result.getH()) {
				result = population.get(0);
			}
			if(result.getH() ==0) {
				break;
			}
			step++;
		}
		
		System.out.println("So lan lap: "+step);
		return result;
	}
	
}
