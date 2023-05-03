package com.csis3475.thirteenth.week.demo.graph.driver;
import com.csis3475.thirteenth.week.demo.graph.*;
import com.csis3475.thirteenth.week.demo.standardADT.*;

public class GraphUtility {
	
	public static void checkVertexAndEdgeCount(GraphInterface<String> myGraph, int numberOfVertices, int numberOfEdges)
	   {
	      System.out.println("\nNumber of vertices = " + myGraph.getNumberOfVertices() +
	                         " (should be " + numberOfVertices + ")");
	      System.out.println("Number of edges = " + myGraph.getNumberOfEdges() +
	                         " (should be " + numberOfEdges + ")");
	   } // end checkVertexAndEdgeCount
	
	public static void testBFS(GraphInterface<String> myGraph, String v)
	{
		System.out.println("\n\nBreadth-First Traversal beginning at vertex " + v + ": ");
		QueueInterface<String> bfs = myGraph.getBreadthFirstTraversal(v);
		
		displayQueue(bfs);
      System.out.println(" Actual");
	} // end testBFS
	
	public static void testDFS(GraphInterface<String> myGraph,String v)
	{
		System.out.println("\n\nDepth-First Traversal beginning at vertex " + v + ": ");
		QueueInterface<String> dfs = myGraph.getDepthFirstTraversal(v);
		
		displayQueue(dfs);
      System.out.println(" Actual");
	} // end testDFS
	
	public static void showPath(GraphInterface<String> myGraph,String vertex1, String vertex2, String expectedPath, StackInterface<String> path)
	{
		System.out.print("\nThe shortest path from " + vertex1 + " to " + vertex2 + " is ");
		int length = myGraph.getShortestPath(vertex1, vertex2, path);
		displayStack(path);
		System.out.println(" and has a length of " + length + ".");
		System.out.println("Expected path:                   " + expectedPath);
	} // end showPath
	
	public static boolean checkEdge(GraphInterface<String> myGraph, String vertex1, String vertex2, boolean ok)
	{
		boolean check = ok;	
	 	if (!myGraph.hasEdge(vertex1, vertex2))	
	 	{
			System.out.println("hasEdge error " + vertex1 + " " + vertex2);
			check = false;
		} // end if
	
		return check;
	} // end checkEdge
	
	public static boolean checkNoEdge(GraphInterface<String> myGraph, String vertex1, String vertex2, boolean ok)
	{
		boolean check = ok;	
	 	if (myGraph.hasEdge(vertex1, vertex2))	
	 	{
			System.out.println("hasEdge error " + vertex1 + " " + vertex2);
			check = false;
		} // end if
	
		return check;
	} // end checkNoEdge
	
	public static void displayStack(StackInterface<String> s)
	{
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
			
		assert(s.isEmpty());
	} // end displayStack
	
	public static void displayQueue(QueueInterface<String> q)
	{
		while (!q.isEmpty())
			System.out.print(q.dequeue() + " ");
	} // end displayQueue
	
	// Undirected	
	public static void showPathUndirected(UndirectedGraph<String> myGraph,String vertex1, String vertex2, String expectedPath, StackInterface<String> path)
	{
		System.out.print("\nThe shortest path from " + vertex1 + " to " + vertex2 + " is ");
		int length = myGraph.getShortestPath(vertex1, vertex2, path);
		displayStack(path);
		System.out.println(" and has a length of " + length + ".");
		System.out.println("Expected path:                   " + expectedPath);
	} // end showPath
		
	
	// Directed
		
	public static void showPathDirected(DirectedGraph<String> myGraph,String vertex1, String vertex2, StackInterface<String> path)
	{
		System.out.println("The cheapest path from " + vertex1 + " to " + vertex2 + " is ");
		double cost = myGraph.getCheapestPath(vertex1, vertex2, path);
		displayStack(path);
		System.out.println("and has a cost of " + cost + ".");
		System.out.println();
	} // end showPath
	
	
}
