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
			
			List<NodeType> openSet = new ArrayList<>(); //nodes to be evaluated. nodes come in here they are then moved into nodeSets vvvv
			
			List<NodeType> closedSet = new ArrayList<>(); //evaluated nodes.
			
			List<NodeType> cameFrom = new ArrayList<>(); //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			
			Map<NodeType , Double> nodeSets = new HashMap<NodeType , Double>(); // nodes are turned from a basic data type into a map entry with their fScore
			
			HashMap<NodeType , Double> visitedNodes = new HashMap<NodeType , Double>();
			
			PriorityQueue<HashMap<NodeType , Double>> frontier = new PriorityQueue<HashMap<NodeType , Double>>(25 , new nodeComparator()); 
			/* keeps the nodes 
			sorted by their fScore*/
			
			//openSet.addAll(super.getNeighbors(start));
			
			Map<NodeType , Double> startNode = new HashMap<NodeType , Double>();  //<<<<<<<<<<<<<<<<<<<<<<<<
			
			startNode.put(start , distanceEstimator.estimateDistance(start, end));
			
			NodeType currentNode = null;  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			
			HashMap<NodeType , Double> current = null;
			
			frontier.add((HashMap<NodeType, Double>) startNode);
			
			visitedNodes.clear(); //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			
			double gScore = 0;
			
			double fScore = gScore + distanceEstimator.estimateDistance(start, end);
			
			Set<Integer> set;
			
			
			Map <NodeType , NodeType> childParent = new HashMap<NodeType , NodeType>();
			
			NodeType holder = null;
			
			childParent.put(null, start);
			
			
			
			
			
			
			// ok.  look.  add all of the neighboring nodes into openSet then put all of openSet into a hashmap with (nodetype, fScore).  arbitrarily put one 
			// into the currentNode (the first one is a pretty good choice).  then go through the hashmap of all nodes in openSet and compare the value 
			// to that of the arbitrarily chosen current.  switch currentNode with the node being evaluated if (nodeEvauating < currentNode).  do this for
			// the entire openSet and once you have the smallest value, proceed to leave that set as currentNode and proceed with the rest of the search.  
			
			while(frontier.size() != 0)
			{
				//gScore += super.getEdgeWeight(start, currentNode);
								
				current = frontier.poll();
				
				
				
				visitedNodes.putAll(current);
				
				// if the goal is found and has the lowest fScore
				
				if(current.keySet().toArray()[0].equals(end))
				{
					goal = 1;
					
					break;
					
				} else 
					// if it isnt the goal or the goal doesnt have the lowest fScore
				{
					//puts all the neighbors into openSet
					
					openSet.addAll(super.getNeighbors((NodeType) current.keySet().toArray()[0]));
					
					// attaches each nodes fScore to the node and puts it in a HashMap
					
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
						
						//the rules governing adding nodes to the frontier.  
						
						// if the node isnt in the frontier and isnt in the visited list
						
						if(!frontier.contains(entry.getKey()) && !visitedNodes.containsKey(entry.getKey()))
						{
							// add node to frontier
							
							frontier.add((HashMap<NodeType, Double>) entry);
							
							holder = childParent.remove(null);
							
							childParent.put((NodeType) current.keySet().toArray()[0] , holder);
							
							childParent.put(null, (NodeType) current.keySet().toArray()[0]);
							
							
						} else 
							//if the node is in the frontier or the visited map
						{
							Map<NodeType , Double> nodeHolder = new HashMap<NodeType , Double>(); 
							
							// puts the whole frontier into a map for easy comparing.  
							
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
										// swaps entries when appropriate.  
										
										childParent.remove(entry.getKey());
										
										childParent.put((NodeType) current.keySet().toArray()[0], entry.getKey() );
										
										entry = entry2;
										
										frontier.add((HashMap<NodeType, Double>) entry);
										
										entry2 = null;
										
										
										
									} 
								}
								
								// adds all of the entries back into the frontier, which sorts them as they go in.  
								
								frontier.add((HashMap<NodeType, Double>) entry2);
							}	
							
						}
						
					}
					
					// clears nodeSets map to keep computation space and time down.  
					
					nodeSets.clear();
						
				}
				
			}
		
		/* to rebuild the path, start at the gaol, and work backwards through the nodes.  each node must store a parent, which is the node that came before it 
		 * with the smallest fScore.  as you iterate through the nodes, give each node this parent, and update it as a shorter path is found.  the first parent
		 * is the start node, and the last child is the goal.  
		 */
		
			// now rebuild the path.  um.  ya.  thats the easy part.  
			
			if(goal == 1)
			{
				// rebuild the path starting at the end moving through all of the children to their parents until you have the start node as the parent.  
				
				
					/* ok, so starting at entry <goal , goals parent> put the Parent into the list to be returned by the method.  then once 
					 * that node has gone in, search the remaining map entries for one whos key (the child) is the same as the parent that was just added
					 * to the list. then repeat the process until the parent is the start node.  when that happens, you terminate the loop, the path is found.  
					 * 
					 * just a note, use a  do{operations} while (parent != start).  or something to that effect.    
					 *   
					 */
				
				NodeType parent = end;
				
				cameFrom.add(end);
				
				do
				{
					cameFrom.add(childParent.get(parent));
					
					parent = childParent.get(parent);
					
				} while(parent != start);
				
				cameFrom.add(start);
				
				return cameFrom;
				
				
			}
		
			return null;
		
		}

}













