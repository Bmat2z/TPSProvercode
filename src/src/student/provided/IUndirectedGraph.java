package student.provided;

import java.util.List;
import java.util.Set;
import java.util.Map;


/**
 * Represents a graph whose nodes are of type NodeType.
 * 
 * @author iwa1
 * 
 * @param <NodeType>
 *            The type of the nodes.
 */
public interface IUndirectedGraph<NodeType> {
	/**
	 * Adds a node to this graph, if it is not already present. No edges will be
	 * added; the node will initially be its own connected component, until the
	 * user adds edges using addEdge(...).
	 * 
	 * If the node is already present in the graph (true if there exists a node
	 * x in the graph for which node.equals(x).
	 * 
	 * @param node
	 *            The node to add.
	 */
	
	
	public void addNode(NodeType node);

	/**
	 * Returns true if there exists a node x in this graph for which
	 * node.equals(x) returns true.
	 * 
	 * @param node
	 *            The node for whose presence to check.
	 * @return Whether or not the specified node was found.
	 */
	public boolean hasNode(NodeType node);

	/**
	 * Removes the specified node, if it is present. All edges incident to this
	 * node will also be removed.
	 * 
	 * @param node
	 *            The node to be removed.
	 */
	public void removeNode(NodeType node);

	/**
	 * Adds an undirected edge between nodes a and b. a may not equal b. If
	 * either a, b, or both are not in the graph, they will be added as nodes to
	 * facilitate the creation of this edge.
	 * 
	 * @param a
	 *            One endpoint of the edge.
	 * @param b
	 *            The other endpoint of the edge.
	 */
	public void addEdge(NodeType a, NodeType b, float weight);

	/**
	 * Report whether an edge exists between a and b.
	 * 
	 * @param a
	 *            One endpoint of the edge.
	 * @param b
	 *            The other endpoint of the edge.
	 * 
	 * @return Whether or not a and b are connected by one edge.
	 */
	public boolean hasEdge(NodeType a, NodeType b);

	/**
	 * Removes an edge, if present. 
	 * 
	 * @param a
	 *            One endpoint of the edge.
	 * @param b
	 *            The other endpoint of the edge.
	 */
	public void removeEdge(NodeType a, NodeType b);
	
	public float getEdgeWeight(NodeType a, NodeType b);

	/**
	 * Return a set of all nodes in the graph.
	 * 
	 * Implementors should take care to ensure that the graph is not corrupted
	 * by an alteration of the returned set. The returned set should either not
	 * be used to back the graph in any way, be modified only to support
	 * read-only behavior, or be modified to update the graph when write
	 * operations occur.
	 * 
	 * @return A set of all nodes in the graph.
	 */
	public Set<NodeType> getNodes();

	/**
	 * Return a set of all nodes that are connected via a single edge to node.
	 * 
	 * Implementors should take care to ensure that the graph is not corrupted
	 * by an alteration of the returned set. The returned set should either not
	 * be used to back the graph in any way, be modified only to support
	 * read-only behavior, or be modified to update the graph when write
	 * operations occur.
	 * 
	 * @param node
	 *            The node whose neighbors to provide.
	 * @return The neighbors of the specified node.
	 */
	public Set<NodeType> getNeighbors(NodeType node);

	/**
	 * Perform A* on the graph to find the optimal path from the start node to
	 * the end node. If a path is found, it will be returned via the list. If no
	 * path is found, an empty list will be returned.
	 * 
	 * @param start
	 *            The node at which the path should start.
	 * @param end
	 *            The node to be reached via the path.
	 * @param distanceEstimator
	 *            An instance which can be used to estimate distances between
	 *            nodes in the graph.
	 * @return A list representing the path from the start node to the end node,
	 *         or an empty list if no path exists. If a path is found, the first
	 *         element of the list should be the start node, and the last
	 *         element should be the end node. Each node traversed on the way
	 *         from the start node to the end node should appear exactly once in
	 *         the list. Therefore, if a path from node a were calculated to
	 *         node d, via the edges (a, b), (b, c), and (c, d), the returned
	 *         list should consist of [a, b, c, d].
	 */
	public List<NodeType> aStar(NodeType start, NodeType end,
			IDistanceEstimator<NodeType> distanceEstimator);
}