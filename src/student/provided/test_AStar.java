package student.provided;

/*import java.util.List;
import java.util.Set;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;

import student.UndirectedGraph;
import student.provided.AUndirectedGraph;
import student.provided.CartesianPoint;*/

import java.util.List;

import student.UndirectedGraph;
import instructor.AStarTest;
import student.provided.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;


public class test_AStar  {
    public static void main(String[] args) {
    	
    	 System.out.println("Testing my A* Implementation...");
    	 
    	 /*CartesianPoint point = null;
    	 NodeType node = null;*/
    	 
    	 //node 
    	 
    	 
    	 
         AStarTest tester= new AStarTest();
         
         System.out.println("made the tester");
         
         IUndirectedGraph<CartesianPoint> MyGraph = new UndirectedGraph();
         
         System.out.println("made the Graph");
         
         tester.getTestMaze(MyGraph);
         
         System.out.println("got the test maze");
         
         tester.testAstar(MyGraph);
         
         System.out.println("tested A*");
    }

	
}
