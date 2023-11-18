package lab7;

public class Test {
public static void main(String[] args) {
//	Node node = new Node();
//	node.displayBoard();
	GA_NQueenAlgo ga = new GA_NQueenAlgo();
	ga.initPopulation();
	Node nd = ga.execute();
	nd.displayBoard();
System.out.println(nd.getH());
	
//	Node father = new Node();
//	Node mother = new Node();
//	ga.reproduce(father, mother);
//	ga.print();
}
}
