// Uses breadth first search algorithm to find the path with the lowest weight from the start to the end
// Input for the program is a 2 dimensional list of strings, each row represents an edge with 2 nodes and a weight

import java.util.*;

public class CheapestPath {
	public static void main(String[] args){
		List<List<Character>> input = new ArrayList<List<Character>>();
		input.add(Arrays.asList('A', 'B', '2'));
		input.add(Arrays.asList('A', 'C', '3'));
		input.add(Arrays.asList('B', 'C', '4'));
	    input.add(Arrays.asList('B', 'D', '5'));
		input.add(Arrays.asList('C', 'D', '6'));
		input.add(Arrays.asList('A', 'D', '8'));
		input.add(Arrays.asList('E', 'D', '2'));

		System.out.println("shortest: " + shortest(input, 'A', 'D', new ArrayList<Integer>(), new ArrayList<Character>(), 0));
	}
	
	public static int shortest(List<List<Character>> input, char start, char end, ArrayList<Integer> usedEdges, ArrayList<Character> usedNodes, int totalWeight){
		List<Integer> pathWeights = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++){
			char firstNode = input.get(i).get(0);
			char secondNode = input.get(i).get(1);
			int weight = Character.getNumericValue(input.get(i).get(2));
			if ((firstNode == start && secondNode == end) || (firstNode == end && secondNode == start)){
				pathWeights.add(weight);
			}
			else if (!usedEdges.contains(i) && firstNode == start && !usedNodes.contains(secondNode)) { 
				usedEdges.add(i);
				usedNodes.add(firstNode);
				pathWeights.add(weight + shortest(input, secondNode, end, usedEdges, usedNodes, weight));
			}
			else if (!usedEdges.contains(i) && secondNode == start && !usedNodes.contains(firstNode)) {
				usedEdges.add(i);
				usedNodes.add(secondNode);
				pathWeights.add(weight + shortest(input, firstNode, end, usedEdges, usedNodes, weight));
			}
		}
		int minWeight = 999;
		for (int j = 0; j < pathWeights.size(); j++){
			if (start == 'A')
				System.out.println(pathWeights.get(j));
			if (pathWeights.get(j) < minWeight){
				minWeight = pathWeights.get(j);
			}
		}
		return minWeight;
	}
}
