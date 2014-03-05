package student.provided;

import java.util.List;
import java.util.Set;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;

import student.UndirectedGraph;
import student.provided.AUndirectedGraph;
import student.provided.CartesianPoint;
import instructor.AStarTest;




public class test_AStar  {
    public static void main(String[] args){
    	
    	 System.out.println("Testing my A* Implementation...");

         AStarTest tester= new AStarTest();
         AUndirectedGraph<CartesianPoint> MyGraph = new UndirectedGraph();
         tester.getTestMaze(MyGraph);
         tester.testAstar(MyGraph);
    }

	
}
