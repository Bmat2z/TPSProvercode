package student;

import java.util.Map;
import java.util.List;
import java.util.Set;

import edu.rice.comp440.rovers.model.Action;
import edu.rice.comp440.rovers.model.percepts.AntPercepts;
import edu.rice.comp440.rovers.model.rovers.AbstractAntRover;
import edu.rice.comp440.rovers.view.DebugDrawer.DebugAssistant;

public class AntRover extends AbstractAntRover 
{

	public double[] pheromoneLevels;
	
	public Action direction;
	
	//public Action Direction;
	
	double pheromoneValue;
	
	@Override
	protected Action nextAction(AntPercepts percepts) 
	{
		 Map<Action, Double> pheromones = percepts.pheromoneLevels();
		 
		 Action Direction = null;
		 
		 List<Map> north = null;
		 
		 
//		 /////////////  CHOOSING DIRECTION WITH NO TIES  ////////
//		 
//		 if((pheromones.get(Action.NORTH) < pheromones.get(Action.EAST))&&
//				 (pheromones.get(Action.NORTH) < pheromones.get(Action.WEST)&&
//						 (pheromones.get(Action.NORTH) < pheromones.get(Action.SOUTH))))
//		 {
//			 Direction = Action.NORTH;
//			 
//			 
//		 } 
//		 
//		 else
//		 
//		 if((pheromones.get(Action.EAST) < pheromones.get(Action.NORTH))&&
//				 (pheromones.get(Action.EAST) < pheromones.get(Action.WEST)&&
//						 (pheromones.get(Action.EAST) < pheromones.get(Action.SOUTH))))
//		 {
//			 Direction = Action.EAST;
//		 }
//		 else
//		 if((pheromones.get(Action.SOUTH) < pheromones.get(Action.EAST))&&
//				 (pheromones.get(Action.SOUTH) < pheromones.get(Action.WEST)&&
//						 (pheromones.get(Action.SOUTH) < pheromones.get(Action.NORTH))))
//		 {
//			 Direction = Action.SOUTH;
//		 }
//		 else
//		 if((pheromones.get(Action.WEST) < pheromones.get(Action.EAST))&&
//				 (pheromones.get(Action.WEST) < pheromones.get(Action.NORTH))&&
//						 (pheromones.get(Action.WEST) < pheromones.get(Action.SOUTH)))
//		 {
//			 Direction = Action.WEST;
//		 }
//		 else
//		//////////////  CHOOSING DIRECTION WITH 2 WAY TIES  ///////////
//		 
//		 if(pheromones.get(Action.NORTH) == pheromones.get(Action.SOUTH))
//		{
//			if(percepts.coinToss())
//			{
//				Direction = Action.NORTH;
//			}
//			else
//			{
//				Direction = Action.SOUTH;
//			}
//		}
//		 else
//		if(pheromones.get(Action.NORTH) == pheromones.get(Action.EAST))
//		{
//			if(percepts.coinToss())
//			{
//				Direction = Action.NORTH;
//			}
//			else
//			{
//				Direction = Action.EAST;
//			}
//		}
//		else
//		if(pheromones.get(Action.NORTH) == pheromones.get(Action.WEST))
//		{
//			if(percepts.coinToss())
//			{
//				Direction = Action.NORTH;
//			}
//			else
//			{
//				Direction = Action.WEST;
//			}
//		}
//		else
//		if(pheromones.get(Action.SOUTH) == pheromones.get(Action.EAST))
//		{
//			if(percepts.coinToss())
//			{
//				Direction = Action.EAST;
//			}
//			else
//			{
//				Direction = Action.SOUTH;
//			}
//		}
//		else
//		if(pheromones.get(Action.SOUTH) == pheromones.get(Action.WEST))
//		{
//			if(percepts.coinToss())
//			{
//				Direction = Action.WEST;
//			}
//			else
//			{
//				Direction = Action.SOUTH;
//			}
//		}
//		else
//		if(pheromones.get(Action.WEST) == pheromones.get(Action.EAST))
//		{
//			if(percepts.coinToss())
//			{
//				Direction = Action.WEST;
//			}
//			else
//			{
//				Direction = Action.EAST;
//			}
//		}
//		else
//		/////////////////  CHOOSING DIRECTION WITH 3 WAY TIES  ///////////
//		
//		if((pheromones.get(Action.NORTH) == pheromones.get(Action.EAST))&&
//				 (pheromones.get(Action.NORTH) == pheromones.get(Action.WEST)))
//		{
//			if(percepts.coinToss())
//			{
//				if(percepts.coinToss())
//				{
//					Direction = Action.WEST;
//				}
//				else
//				{
//					Direction = Action.EAST;
//				}
//			}
//			else
//			{
//				Direction = Action.NORTH;
//			}
//		}
//		else
//		if((pheromones.get(Action.NORTH) == pheromones.get(Action.SOUTH))&&
//				 (pheromones.get(Action.NORTH) == pheromones.get(Action.WEST)))
//		{
//			if(percepts.coinToss())
//			{
//				if(percepts.coinToss())
//				{
//					Direction = Action.WEST;
//				}
//				else
//				{
//					Direction = Action.SOUTH;
//				}
//			}
//			else
//			{
//				Direction = Action.NORTH;
//			}
//		}
//		else
//		if((pheromones.get(Action.NORTH) == pheromones.get(Action.EAST))&&
//				 (pheromones.get(Action.NORTH) == pheromones.get(Action.SOUTH)))
//		{
//			if(percepts.coinToss())
//			{
//				if(percepts.coinToss())
//				{
//					Direction = Action.SOUTH;
//				}
//				else
//				{
//					Direction = Action.EAST;
//				}
//			}
//			else
//			{
//				Direction = Action.NORTH;
//			}
//		}
//		else
//		if((pheromones.get(Action.SOUTH) == pheromones.get(Action.EAST))&&
//				 (pheromones.get(Action.SOUTH) == pheromones.get(Action.WEST)))
//		{
//			if(percepts.coinToss())
//			{
//				if(percepts.coinToss())
//				{
//					Direction = Action.WEST;
//				}
//				else
//				{
//					Direction = Action.EAST;
//				}
//			}
//			else
//			{
//				Direction = Action.SOUTH;
//			}
//		}
//		else
//		///////////////////  CHOOSING DIRECTION WITH 4 WAY TIE  /////////////////
//		
//		if((pheromones.get(Action.NORTH) == pheromones.get(Action.EAST))&&
//				 (pheromones.get(Action.NORTH) == pheromones.get(Action.WEST))&&
//				 (pheromones.get(Action.NORTH) == pheromones.get(Action.SOUTH)))
//		{
//			if(percepts.coinToss())
//			{
//				if(percepts.coinToss())
//				{
//					Direction = Action.WEST;
//				}
//				else
//				{
//					Direction = Action.EAST;
//				}
//			}
//			else
//			{
//				if(percepts.coinToss())
//				{
//					Direction = Action.SOUTH;
//				}
//				else
//				{
//					Direction = Action.NORTH;
//				}
//			}
//		}
						 
		
		
		 
		 
		 
		
		 double northValue = pheromones.get(Action.NORTH);
		 double westValue = pheromones.get(Action.WEST);
		 double southValue = pheromones.get(Action.SOUTH);
		 double eastValue = pheromones.get(Action.EAST);
		 
		 
		 double[] pheromoneLevels = {northValue , westValue , eastValue , southValue}; 
		 
		 for(int p = 0; p < pheromoneLevels.length; p++)
		 {
			 for(int q = 0; q < pheromoneLevels.length - q; q++)
			 {
				 if(pheromoneLevels[q] > pheromoneLevels[q + 1])
				 {
					double temp = pheromoneLevels[q];
					pheromoneLevels[q] = pheromoneLevels[q + 1];
					pheromoneLevels[q + 1] = temp;
				 }
			 }
			 
		 }
		 
		 System.out.println(pheromoneLevels[0]);
		 
		 if (pheromoneLevels[0] == pheromoneLevels[1])
		 {
			 
			 
			 if (percepts.coinToss()) 
	         {
	             if (percepts.coinToss()) 
	             {
	                 Direction = Action.NORTH;
	                 
	             } else 
	             {
	                 Direction = Action.SOUTH;
	             }
				 
				// pheromoneLevels[0] = pheromoneLevels[0];
	         } 
	         
	         else 
	         
	         {
	             if (percepts.coinToss()) 
	             
	             {
	                 Direction = Action.EAST;
	                 
	             } else 
	             { 
	                 Direction = Action.WEST;
	             }
	        	 
//	        	 double holder = pheromoneLevels[0];
//	        	 pheromoneLevels[1] = pheromoneLevels[0];
//	        	 
//	        	 pheromoneLevels[1] = holder;
	         }
		 }	 
			 
		  else 
			 
		 {
			 if(pheromoneLevels[0] == northValue)
			 {
				 Direction = Action.NORTH;
				 System.out.println("North");
			 } 
			 
			 if(pheromoneLevels[0] == eastValue)
			 {
				 Direction = Action.EAST;
				 System.out.println("East");
			 }
			 
			 if(pheromoneLevels[0] == southValue)
			 {
				 Direction = Action.SOUTH;
				 System.out.println("South");
			 }
			 
			 if(pheromoneLevels[0] == westValue)
			 {
				 Direction = Action.WEST;
				 System.out.println("West");
			 }
		 }
         
		 
		
		 
		 
		 
		 
		 
		 
//		 for (Map.Entry<Action, Double> entry : pheromones.entrySet())
//		 {
//			 Action direction = entry.getKey();
//			 double pheromone = entry.getValue();
//			 
//			 //System.out.println(direction);
//			 //System.out.println(pheromone);
//			 
//			 	 
//		 }
		 
		
		 
		 
		 percepts.setPheromoneLevel(1 + percepts.currentPheromoneLevel());
		
		
		 /*
		 * TODO: Your code here!
		 */

		 return Direction;
	}
	
//	public void swap(int x, int y)
//	{
//		double temp = pheromoneLevels[x];
//		pheromoneLevels[x] = pheromoneLevels[y];
//		pheromoneLevels[y] = temp;
//		
//	}
	
	@Override
	public void debugDraw(DebugAssistant debugAssistant) 
	{
		 //debugAssistant.clear();
		 
		 
	     //debugAssistant.drawPath(debugRoute);
		
		/*
		 * TODO: Your debug drawing here!
		 */
	}

}
