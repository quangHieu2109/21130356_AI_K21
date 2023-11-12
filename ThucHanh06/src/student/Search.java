package student;

import java.util.Random;

public class Search {
	static int stepClimbed = 0;
	static int stepClimbedAfterRandomRestart = 0;
	static int randomRestarts = 5;

	public static Node execute(Node initialState) {
		Node result = null;
		Node next = initialState.selectNextRandomCandidate();
		while (next != null && next.getH() != 0) {
//			System.out.println("Visiting");
//			next.displayBoard();
//			System.out.println(next.getH());
			result = next;
			next = next.selectNextRandomCandidate();
		}

		return result;
	}

	public static Node executeHillClimbingWithRandomRestart(Node initialState) {

		Node result = null;
		Node next = initialState.selectNextCandidate();
		int step = 0;
		while (next.getH() != 0) {

			if (next.selectNextCandidate() == null) {
//				if(step + 1 > randomRestarts) {
//					break;
//				}
				Node tmp = new Node();
				tmp.generateBoard();
				next = tmp;
				stepClimbedAfterRandomRestart = 0;
				step++;
			} else {
				next = next.selectNextCandidate();
				stepClimbedAfterRandomRestart++;

			}

			stepClimbed++;

		}
		result = next;
//		System.out.println(next.getH());
		result.displayBoard();
		System.out.println(result.getH());
		System.out.println("Số lần leo: " + stepClimbed);
		System.out.println("Số lần restart: " + randomRestarts);
		System.out.println("Số lần leo núi của lần restart cuối: " + stepClimbedAfterRandomRestart);
		return result;
	}

	public static Node executeSASearch(double startingTemperature, int numberOfIterations, double coolingRate) {
		double temparature = startingTemperature;
		Node node = new Node();
		node.generateBoard();

		int bestH = node.getH();
		Node bestSolution = node;
		Node currentSolution = bestSolution;
		for (int i = 0; i < numberOfIterations; i++) {
			double rd = new Random().nextDouble();
			if (temparature == 0 || bestH == 0) {
				System.out.println("Nhiệt độ hiện tại:"+temparature + " số lần lặp " + i + " kết quả: " + bestH);
				return bestSolution;
			} else {
				currentSolution = currentSolution.selectNextRandomCandidate();
				int currentH = currentSolution.getH();
				if (currentH < bestH) {
					bestSolution = currentSolution;
					bestH = currentH;
				} else if (Math.exp((bestH - currentH) / temparature) > rd) {
					bestSolution = currentSolution;
//					bestH = currentH;
				}
			}
			temparature *= coolingRate;
		}
		return bestSolution;
	}
}
