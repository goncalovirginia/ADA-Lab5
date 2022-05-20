package dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedDiGraph implements DiGraph {
	
	private final List<List<Integer>> successors, predecessors;
	
	public LinkedDiGraph(int numNodes) {
		successors = new ArrayList<>(numNodes);
		predecessors = new ArrayList<>(numNodes);
		
		for (int i = 0; i < numNodes; i++) {
			successors.add(new LinkedList<>());
			predecessors.add(new LinkedList<>());
		}
	}
	
	@Override
	public int inDegree(int node) {
		return predecessors.get(node).size();
	}
	
	@Override
	public int outDegree(int node) {
		return successors.get(node).size();
	}
	
	@Override
	public Iterable<Integer> inAdjacentNodes(int node) {
		return predecessors.get(node);
	}
	
	@Override
	public Iterable<Integer> outAdjacentNodes(int node) {
		return successors.get(node);
	}
	
	@Override
	public Iterable<Edge> inIncidentEdges(int node) {
		List<Edge> inAdjacentNodes = new LinkedList<>();
		
		for (int predecessor : predecessors.get(node)) {
			inAdjacentNodes.add(new EdgeClass(predecessor, node));
		}
		
		return inAdjacentNodes;
	}
	
	@Override
	public Iterable<Edge> outIncidentEdges(int node) {
		List<Edge> outAdjacentNodes = new LinkedList<>();
		
		for (int successor : successors.get(node)) {
			outAdjacentNodes.add(new EdgeClass(node, successor));
		}
		
		return outAdjacentNodes;
	}
	
	@Override
	public int numNodes() {
		return successors.size();
	}
	
	@Override
	public int numEdges() {
		return 0;
	}
	
	@Override
	public int aNode() {
		return 0;
	}
	
	@Override
	public void addEdge(int node1, int node2) {
		successors.get(node1).add(node2);
		predecessors.get(node2).add(node1);
	}
	
	@Override
	public boolean edgeExists(int node1, int node2) {
		return false;
	}
	
	@Override
	public Iterable<Integer> nodes() {
		List<Integer> nodes = new ArrayList<>(numNodes());
		
		for (int i = 0; i < numNodes(); i++) {
			nodes.add(i);
		}
		
		return nodes;
	}
	
	@Override
	public Iterable<Edge> edges() {
		return null;
	}
}
