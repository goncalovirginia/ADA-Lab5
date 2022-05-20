package dataStructures;

public interface Edge {
	
	// Returns the first endpoint of the edge, which is its origin if the edge is directed.
	int firstNode();
	
	// Returns the second endpoint of the edge, which is its destination if the edge is directed.
	int secondNode();
	
	// Returns the edge endpoint that is distinct from the specified node.
	int oppositeNode(int node);
	
}
