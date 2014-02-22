package student;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;
import java.util.PriorityQueue;
import java.util.Set;

import student.provided.AUndirectedGraph;
import student.provided.IDistanceEstimator;


public class UndirectedGraph extends AUndirectedGraph<NodeType> 
{
	
//	public class AStarPoints
//	{
//		private AStarPoints (NodeType node , Double score);
//		
//	}
	
	public class nodeComparator implements Comparator<HashMap<NodeType , Double>>
	{
		public int compare(HashMap<NodeType , Double> first , HashMap<NodeType , Double> second)
		{
			if (first.get(first) < second.get(second))
			{
				return -1;
				
			} else if (first.get(first) > second.get(second))
			{
				
				return 1;
				
			} else {
			
			return 0;
			
			}
		}
	}

	@Override
	public List<NodeType> aStar(NodeType start, NodeType end,
			IDistanceEstimator<NodeType> distanceEstimator) 
		{
			
			// TODO Auto-generated method stub
			
			int goal = (Integer) null;
			
			List<NodeType> openSet = new ArrayList<>(); //nodes to be evaluated. 
			
			List<NodeType> closedSet = new ArrayList<>(); //evaluated nodes.
			
			List<NodeType> cameFrom = new ArrayList<>();
			
			Map<NodeType , Double> nodeSets = new HashMap<NodeType , Double>();
			
			HashMap<NodeType , Double> visitedNodes = new HashMap<NodeType , Double>();
			
			PriorityQueue<HashMap<NodeType , Double>> frontier = new PriorityQueue<HashMap<NodeType , Double>>(25 , new nodeComparator());
			
			//openSet.addAll(super.getNeighbors(start));
			
			Map<NodeType , Double> startNode = new HashMap<NodeType , Double>();
			
			startNode.put(start , distanceEstimator.estimateDistance(start, end));
			
			NodeType currentNode = null;
			
			HashMap<NodeType , Double> current = null;
			
			frontier.add((HashMap<NodeType, Double>) startNode);
			
			visitedNodes = null;
			
			double gScore = 0;
			
			double fScore = gScore + distanceEstimator.estimateDistance(start, end);
			
			Set<Integer> set;
			
			
			
			// ok.  look.  add all of the neighboring nodes into openSet then put all of openSet into a hashmap with (nodetype, fScore).  arbitrarily put one 
			// into the currentNode (the first one is a pretty good choice).  then go through the hashmap of all nodes in openSet and compare the value 
			// to that of the arbitrarily chosen current.  switch currentNode with the node being evaluated if (nodeEvauating < currentNode).  do this for
			// the entire openSet and once you have the smallest value, proceed to leave that set as currentNode and proceed with the rest of the search.  
			
			while(frontier.size() != 0)
			{
				//gScore += super.getEdgeWeight(start, currentNode);
				
				
								
				current = frontier.poll();
				
				visitedNodes.putAll(current);
				
				if(current.keySet().toArray()[0].equals(end))
				{
					goal = 1;
					
					break;
					
				} else 
				{
					openSet.addAll(super.getNeighbors((NodeType) current.keySet().toArray()[0]));
					
					for(NodeType entry : openSet)
					{
						gScore += super.getEdgeWeight(start, currentNode);
						
						fScore = gScore + distanceEstimator.estimateDistance(currentNode, end);
						
						nodeSets.put(entry, fScore);
					}
					
					openSet.clear();
					
					for(Map.Entry<NodeType , Double> entry : nodeSets.entrySet())
					{
						/* make a for each so that each entry is checked in the priority queue for being there, and it it is there 
						 * check the value for the smaller of the two.  if the new is smaller that the old, swap, if not, throw away the new one.
						 */
						
						if(!frontier.contains(entry.getKey()) && !visitedNodes.containsKey(entry.getKey()))
						{
							frontier.add((HashMap<NodeType, Double>) entry);
						} else 
						{
							Map<NodeType , Double> nodeHolder = new HashMap<NodeType , Double>(); 
							
							for(int x = 0; x <= frontier.size(); x++)
							{
								nodeHolder.putAll(frontier.poll());
							}
							
							frontier.clear();
							
							for(Map.Entry<NodeType, Double> entry2 : nodeHolder.entrySet())
							{
								if(entry2.getKey().equals(entry.getKey()))
								{
									//check the associated values.
									
									if(entry2.getValue() < entry.getValue())
									{
										entry = entry2;
										
										frontier.add((HashMap<NodeType, Double>) entry);
										
										entry2 = null;
									} 
								}
								
								frontier.add((HashMap<NodeType, Double>) entry2);
							}
							
							
							
							
							
							
							
						}
						
						
						
					}
					
					

					
				}
				
				
				
				
				
			}
		
		
		
		
			return null;
		
		}

}
