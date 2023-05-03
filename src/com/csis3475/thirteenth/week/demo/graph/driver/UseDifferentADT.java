package com.csis3475.thirteenth.week.demo.graph.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.csis3475.thirteenth.week.demo.graph.DirectedGraph;
import com.csis3475.thirteenth.week.demo.standardADT.LinkedListWithIterator;
import com.csis3475.thirteenth.week.demo.standardADT.LinkedStack;
import com.csis3475.thirteenth.week.demo.standardADT.ListInterface;
import com.csis3475.thirteenth.week.demo.standardADT.StackInterface;

public class UseDifferentADT {

	
	private final static String filePathwithName = "data/csis_courses_SSi503.csv";
	private final static String myHome = "My Home";
	private final static String brentwood = "Brentwood";
	private final static String metrotown = "Metrotown";
	private final static String newWestminster = "New Westminster";
	private final static String surrey = "Surrey";
	private final static String northVan = "North Vancouver";
	
	private static DirectedGraph<String> myDirectedGraph = new DirectedGraph<>();
	private static StackInterface<String> stackOrder =  new LinkedStack<>();
	private static ArrayList<DirectedGraph<String>> graphsList = new ArrayList<>();

	private static LinkedListWithIterator<DirectedGraph<String>> listOfGraphs = new LinkedListWithIterator<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		readFileFromSystem(filePathwithName);
		myDirectedGraph.displayEdges();
		stackOrder = myDirectedGraph.getTopologicalOrder();
		System.out.println(graphsList.size());

		
		for (Iterator iterator = graphsList.iterator(); iterator.hasNext();) {
			DirectedGraph<String> directedGraph = (DirectedGraph<String>) iterator.next();
			System.out.println(directedGraph.getNumberOfEdges());
			stackOrder = directedGraph.getTopologicalOrder();			
			GraphUtility.displayStack(stackOrder);
		}
		
	}
	
	
	
	public static void readFileFromSystem(String fileNameWithPath) throws IOException {
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileNameWithPath));

		while((line = br.readLine()) != null) {
			DirectedGraph<String> myTempDirectedGraph = new DirectedGraph<>();
			String[] codes = line.split(",");
			for(int i = 0; i < codes.length -1 ; i++) {
				myDirectedGraph.addVertex(codes[0]);
				i++;
				myDirectedGraph.addEdge(codes[0], codes[i]);
				i--;
				myTempDirectedGraph.addVertex(codes[0]);
				myTempDirectedGraph.addEdge(codes[0], codes[i]);
			}
			graphsList.add(myTempDirectedGraph);
		}
	}

}
