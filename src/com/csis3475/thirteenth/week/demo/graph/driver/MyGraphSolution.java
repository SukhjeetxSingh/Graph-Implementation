package com.csis3475.thirteenth.week.demo.graph.driver;

import com.csis3475.thirteenth.week.demo.graph.*;
import java.util.Iterator;

import com.csis3475.thirteenth.week.demo.graph.*;
import com.csis3475.thirteenth.week.demo.standardADT.*;

public class MyGraphSolution {
	
	private final static String myHome = "My Home";
	private final static String brentwood = "Brentwood";
	private final static String metrotown = "Metrotown";
	private final static String newWestminster = "New Westminster";
	private final static String surrey = "Surrey";
	private final static String northVan = "North Vancouver";
	/*
	 * Directed : weighted and unweighted same declaration for both
	 * Undirected: weighted and unweighted same decalaration 
	 * The only diffrence between weighted and unweighted is with constructor specifying the weights of edges
	 * StackInterface is Must
	 */
	private final static DirectedGraph<String> myNewDirectedUnweightedGraph = new DirectedGraph<>();
	private static UndirectedGraph<String> myUndriectedGraph =  new UndirectedGraph<>();
	private static StackInterface<String> stackOrder = new LinkedStack<String>();

	public static void main(String[] args) {

		System.out.println("**********************************************************");

		createDirectedUnweightedGraph(myNewDirectedUnweightedGraph);
		
		myNewDirectedUnweightedGraph.displayEdges();

		System.out.println("**********************************************************");
		
		
		stackOrder = myNewDirectedUnweightedGraph.getTopologicalOrder();
		System.out.print("Stack Order : ");
		GraphUtility.displayStack(stackOrder);
		GraphUtility.displayQueue(myNewDirectedUnweightedGraph.getBreadthFirstTraversal(surrey));
		System.out.println("\n\nPath to my home :");
		GraphUtility.showPathDirected(myNewDirectedUnweightedGraph, northVan , myHome, stackOrder);
		GraphUtility.showPathDirected(myNewDirectedUnweightedGraph, myHome , northVan, stackOrder);

		System.out.println(myNewDirectedUnweightedGraph.getShortestPath(surrey, myHome, stackOrder));
		
		System.out.println("Checking edges: ");
		System.out.println(GraphUtility.checkEdge(myNewDirectedUnweightedGraph, surrey, myHome, false));
				
		
		/*
		 * Change the edge and edge weight
		 */
		System.out.println("**********************************************************");
		myNewDirectedUnweightedGraph.addEdge(surrey, newWestminster, 10);
		myNewDirectedUnweightedGraph.displayEdges();
		System.out.println("**********************************************************");

		
	}
	
	
	public static void createDirectedUnweightedGraph(DirectedGraph<String> myNewDirectedUnweightedGraph) {
		
		
		myNewDirectedUnweightedGraph.clear();
		myNewDirectedUnweightedGraph.addVertex(brentwood);
		myNewDirectedUnweightedGraph.addVertex(myHome);
		myNewDirectedUnweightedGraph.addVertex(metrotown);
		myNewDirectedUnweightedGraph.addVertex(newWestminster);
		myNewDirectedUnweightedGraph.addVertex(surrey);
		myNewDirectedUnweightedGraph.addVertex(northVan);
		
		
		myNewDirectedUnweightedGraph.addEdge(myHome, brentwood,0);
		myNewDirectedUnweightedGraph.addEdge(myHome, newWestminster, 0);


		myNewDirectedUnweightedGraph.addEdge(metrotown, brentwood, 0);

		myNewDirectedUnweightedGraph.addEdge(brentwood, northVan, 0);


		
		myNewDirectedUnweightedGraph.addEdge(metrotown, newWestminster, 0);
		
		myNewDirectedUnweightedGraph.addEdge(surrey, newWestminster, 0);

		
	}
	

}

