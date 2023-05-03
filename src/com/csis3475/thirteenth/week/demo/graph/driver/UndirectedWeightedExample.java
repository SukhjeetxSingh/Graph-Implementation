package com.csis3475.thirteenth.week.demo.graph.driver;
import com.csis3475.thirteenth.week.demo.graph.*;
import com.csis3475.thirteenth.week.demo.standardADT.*;
/** 
   A driver that demonstrates the class UndirectedGraph
   by creating an undirected, weighted graph.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @author bambang simplify the content
   @version 5.0
*/
public class UndirectedWeightedExample
{
	
   
	public static void main(String[] args)
	{ 
		UndirectedGraph<String> myMap = new UndirectedGraph<>();
		
		myMap.addVertex("Vancouver");
		myMap.addVertex("Richmond");
		myMap.addVertex("Surrey");
		myMap.addVertex("Burnaby");
		
		myMap.addVertex("Abbotsford");
		myMap.addVertex("Hope");
		myMap.addVertex("Squeamish");
		myMap.addVertex("NorthVan");
		
		myMap.addEdge("Vancouver", "Richmond", 10);
		myMap.addEdge("Richmond", "Surrey", 15);
		myMap.addEdge("Surrey", "Burnaby", 12);
		myMap.addEdge("Burnaby", "Hope", 20);
		myMap.addEdge("Hope", "Abbotsford", 15);
		myMap.addEdge("Abbotsford", "Squeamish", 30);
		myMap.addEdge("Abbostford", "Surrey", 17);
		myMap.addEdge("Hope", "NorthVan", 30);
		
		myMap.displayEdges();
		
		
		StackInterface<String> thePath = new LinkedStack<>();
//		thePath = myMap.getTopologicalOrder();
		double distance = myMap.getCheapestPath("Richmond", "NorthVan", thePath);
		System.out.println("The distance from Richmond to NorthVan is " + distance);
		System.out.println("The path should be:");
		while(!thePath.isEmpty()) {
			System.out.println(thePath.pop() + " ");
		}

		System.out.println();
		
	      
	}  // end main
	
	

   
   
	
}  // end 


