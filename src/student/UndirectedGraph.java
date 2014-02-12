package student;

import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;

import student.provided.AUndirectedGraph;
import student.provided.IDistanceEstimator;


public class UndirectedGraph extends AUndirectedGraph<NodeType> 
{

	@Override
	public List<NodeType> aStar(NodeType start, NodeType end,
			IDistanceEstimator<NodeType> distanceEstimator) 
		{
			
			// TODO Auto-generated method stub
			
			
			List<NodeType> openSet = new ArrayList<>(); //evaluated nodes. 
			
			List<NodeType> closedSet = new ArrayList<>(); //nodes to be evaluated
			
			List<NodeType> cameFrom = new ArrayList<>();
			
			Hashtable<NodeType, Double> pointSet = new Hashtable<NodeType, Double>();
			
			HashMap<NodeType , Double> nodeSets = new HashMap<NodeType , Double>();
			
			openSet.addAll(super.getNeighbors(start));
			
			NodeType currentNode = null;
			
			double gScore = 0;
			
			double fScore = gScore + distanceEstimator.estimateDistance(start, end);
			
			while(openSet.size() != 0)
			{
				gScore += super.getEdgeWeight(start, currentNode);
				
				
				for(NodeType entry : openSet)
				{
					nodeSets.put(entry, fScore);
				}
				
				System.out.print(nodeSets.values());
				
				
			}
		
		
		
		
			return null;
		
		}

}
