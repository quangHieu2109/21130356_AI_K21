package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {

		state = new Queen[N];

//		generateBoard();
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() { // mỗi cột tạo một quân hậu
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		// Enter your code here
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (j != k) {
					if (state[j].isConflict(state[k])) {
						heuristic++;
					}
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();

		for (int i = 0; i < N; i++) {
			Node node = new Node(this);
//			System.out.println(node.getState()[i]);
			node.getState()[i].move(N);
//			System.out.println(node.getState()[i]);
			result.add(node);
//			node.displayBoard();

		}
		return result;
	}

	public Node selectNextCandidate() {
		// Enter your code here
		Node result = null;
		int h = this.getH();
		List<Node> list = this.generateAllCandidates();
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.getH() > o2.getH()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
//		for(Node nd:list) {
		if (list.get(0).getH() < h) {
			result = list.get(0);
			return result;
		}
//		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		Node result = null;
		List<Node> list = this.generateAllCandidates();
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.getH() > o2.getH()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		Random rd = new Random();
		result = list.get(rd.nextInt(list.size()-1));
		return result;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}

	public Queen[] getState() {
		return state;
	}

}
