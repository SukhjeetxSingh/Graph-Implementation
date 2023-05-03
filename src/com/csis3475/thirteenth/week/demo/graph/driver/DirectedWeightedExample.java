package com.csis3475.thirteenth.week.demo.graph.driver;
import com.csis3475.thirteenth.week.demo.graph.*;
import com.csis3475.thirteenth.week.demo.standardADT.*;

/** 
   A driver that demonstrates the class DirectedGraph
   and a weighted graph.
 
   @author Frank M. Carrano
   @author bambang simplify the content
   @version 5.1
*/
public class DirectedWeightedExample
{
	private static DirectedGraph<String> myGraph = new DirectedGraph<>();
	private static StackInterface<String> path = new LinkedStack<>();
	private static final String A = "A";
	private static final String B = "B";
	private static final String C = "C";
	private static final String D = "D";
	private static final String E = "E";
	private static final String F = "F";
	private static final String G = "G";
	private static final String H = "H";
	private static final String I = "I";
	
	public static void main(String[] args)
	{ 
      createGraph();
      testCheapestPath();
      GraphUtility.testBFS(myGraph, A);
      GraphUtility.testDFS(myGraph, A);
      
	}  // end main
	
	public static void testCheapestPath() {
		GraphUtility.showPathDirected(myGraph, A, B, path);
		GraphUtility.showPathDirected(myGraph, A, C, path);
		GraphUtility.showPathDirected(myGraph, A, D, path);
		
		GraphUtility.showPathDirected(myGraph, E, I, path);
		GraphUtility.showPathDirected(myGraph, E, A, path);
	}
	
	public static void createGraph() {
		myGraph.clear();
		myGraph.addVertex(A);
		myGraph.addVertex(B);
		myGraph.addVertex(C);
		myGraph.addVertex(D);
		myGraph.addVertex(E);
		myGraph.addVertex(F);
		myGraph.addVertex(G);
		myGraph.addVertex(H);
		myGraph.addVertex(I);
		
		myGraph.addEdge(A, B, 2);
		myGraph.addEdge(A, D, 5);
		myGraph.addEdge(A, E, 4);
		
		myGraph.addEdge(B, E, 1);
		myGraph.addEdge(B, A, 1);

		
		myGraph.addEdge(C, B, 3);
		myGraph.addEdge(D, G, 2);
		
		myGraph.addEdge(E, F, 3);
		myGraph.addEdge(E, H, 6);
		
		myGraph.addEdge(F, C, 4);
		myGraph.addEdge(F, H, 3);
		
		myGraph.addEdge(G, H, 1);
		myGraph.addEdge(H, I, 1);
		myGraph.addEdge(I, F, 1);
		
	}
	
   

	
}  // end 


