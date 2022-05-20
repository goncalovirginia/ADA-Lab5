package dataStructures;

public interface UndiGraph extends Graph {
	
	// Returns the degree of the specified node.
	int degree(int node);
	
	// Returns the nodes adjacent to the specified node.
	Iterable<Integer> adjacentNodes(int node);
	
	// Returns the edges incident on the specified node.
	Iterable<Edge> incidentEdges(int node);
	
}
