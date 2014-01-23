package student.provided;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AUndirectedGraph<NodeType> implements
		IUndirectedGraph<NodeType> {

	private Map<NodeType, Set<NodeType>> adjacencies;
	private Map<UnorderedPair<NodeType>, Float> edgeWeights;

	public AUndirectedGraph() {
		adjacencies = new HashMap<NodeType, Set<NodeType>>();
		edgeWeights = new HashMap<UnorderedPair<NodeType>, Float>();
	}

	@Override
	public void addNode(NodeType node) {
		if (!adjacencies.keySet().contains(node)) {
			adjacencies.put(node, new HashSet<NodeType>());
		}
	}

	@Override
	public boolean hasNode(NodeType node) {
		return adjacencies.keySet().contains(node);
	}

	@Override
	public void removeNode(NodeType node) {
		for (NodeType neighbor : adjacencies.get(node)) {
			adjacencies.get(neighbor).remove(node);
			
			UnorderedPair<NodeType> edge;
			edge = new UnorderedPair<NodeType>(node, neighbor);
			edgeWeights.remove(edge);
		}
		
		adjacencies.remove(node);
	}

	@Override
	public void addEdge(NodeType a, NodeType b, float weight) {
		addNode(a);
		addNode(b);
		adjacencies.get(a).add(b);
		adjacencies.get(b).add(a);
		
		edgeWeights.put(new UnorderedPair<NodeType>(a, b), weight);
	}

	@Override
	public boolean hasEdge(NodeType a, NodeType b) {
		if (!hasNode(a) || !hasNode(b)) {
			return false;
		}

		return adjacencies.get(a).contains(b);
	}

	@Override
	public void removeEdge(NodeType a, NodeType b) {
		if (!hasNode(a) || !hasNode(b)) {
			return;
		}

		adjacencies.get(a).remove(b);
		adjacencies.get(b).remove(a);
		
		edgeWeights.remove(new UnorderedPair<NodeType>(a, b));
	}
	
	@Override
	public float getEdgeWeight(NodeType a, NodeType b) {
		return edgeWeights.get(new UnorderedPair<NodeType>(a, b));
	}

	/**
	 * Return the set of nodes belonging to this graph. The returned set will be
	 * immutable; use addNode(...) and removeNode(...) to add and remove nodes.
	 */
	@Override
	public Set<NodeType> getNodes() {
		return Collections.unmodifiableSet(adjacencies.keySet());
	}

	/**
	 * Return the set of nodes that are adjacent to the given node. The returned
	 * set will be immutable; use addEdge(...) and removeEdge(...) to add and
	 * remove edges.
	 */
	@Override
	public Set<NodeType> getNeighbors(NodeType node) {
		return Collections.unmodifiableSet(adjacencies.get(node));
	}

	@Override
	public abstract List<NodeType> aStar(NodeType start, NodeType end,
			IDistanceEstimator<NodeType> distanceEstimator);

}
