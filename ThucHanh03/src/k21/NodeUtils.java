package k21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeUtils {
	static double  pathCost=0;
	public static List<String> printPath(Node node) {
		pathCost = node.getPathCost();
		if (node != null) {
			List<String> result = new ArrayList<String>();
			result.add(node.getLabel());
			Node tmp;
			while ((tmp = node.getParent()) != null) {

				result.add(tmp.getLabel());
				node = tmp;
			}
			Collections.reverse(result);
			return result;
		} else
			return new ArrayList<String>();
	}
	public static void print(List<String> ls) {
		for(String s: ls) {
			System.out.print(s+" ");
		}
		System.out.print("Cost: "+pathCost+"\n");
	}
}
