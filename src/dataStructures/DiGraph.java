package dataStructures;

public interface DiGraph extends Graph {
	
	// Returns the in-degree of the specified node.
	int inDegree(int node);
	
	// Returns the out-degree of the specified node.
	int outDegree(int node);
	
	// Returns the nodes adjacent to the specified node along incoming edges to it.
	Iterable<Integer> inAdjacentNodes(int node);
	
	// Returns the nodes adjacent to the specified node along outgoing edges from it.
	Iterable<Integer> outAdjacentNodes(int node);
	
	// Returns the incoming edges to the specified node.
	Iterable<Edge> inIncidentEdges(int node);
	
	// Returns the outgoing edges from the specified node.
	Iterable<Edge> outIncidentEdges(int node);
	
}
