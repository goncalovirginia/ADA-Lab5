package dataStructures;

public class EdgeClass implements Edge {
	
	private final int firstNode, secondNode;
	
	public EdgeClass(int firstNode, int secondNode) {
		this.firstNode = firstNode;
		this.secondNode = secondNode;
	}
	
	@Override
	public int firstNode() {
		return firstNode;
	}
	
	@Override
	public int secondNode() {
		return secondNode;
	}
	
	@Override
	public int oppositeNode(int node) {
		return node == firstNode ? secondNode : firstNode;
	}
	
}
