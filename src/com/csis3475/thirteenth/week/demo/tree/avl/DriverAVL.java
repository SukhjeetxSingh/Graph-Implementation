package com.csis3475.thirteenth.week.demo.tree.avl;
import com.csis3475.thirteenth.week.demo.tree.*;

import java.util.Iterator;
/** 
   A driver that demonstrates the class AVLTree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class DriverAVL
{
	public static void main(String[] args)
	{
      // For testing purposes, we want to obtain several traversals.
      // As SearchTreeInterface only defines an inorder traversal,
      // we declare aTree's type to be AVLTree instead of SearchTreeInterface.
      AVLTree<Integer> aTree = createTree(); // Tests add
      
      // Display root, height, number of nodes
   	  System.out.println("Root of tree is "   + aTree.getRootData()      + " (should be 60)");
   	  System.out.println("Height of tree is " + aTree.getHeight()        + " (should be 4)");
   	  System.out.println("Tree has "          + aTree.getNumberOfNodes() + " nodes (should be 10)");
      
      
      // Test inorder, preorder, postorder and level order traversals
      testTraversals(aTree, "10 20 35 40 50 55 60 70 80 90", "60 40 20 10 35 50 55 80 70 90",
                            "10 35 20 55 50 40 70 90 80 60", "60 40 80 20 50 70 90 10 35 55");
		System.out.println("Done.");
	}  // end main

   /** Tests add. */
	public static AVLTree<Integer> createTree()
	{
		System.out.println("\n\nCreating an AVL tree:");
		AVLTree<Integer> aTree = new AVLTree<>();
		System.out.println("Initial tree should be empty; isEmpty() returns " + aTree.isEmpty());

      // Test add
		System.out.println("\n\nTesting add() to create the AVL tree shown in Figure 27-10a:\n");
		System.out.println("Adding 60: returns " + aTree.add(60) + " (should be null)");
		System.out.println("Adding 50: returns " + aTree.add(50) + " (should be null)");
		System.out.println("Adding 20: returns " + aTree.add(20) + " (should be null)");
		System.out.println("Adding 80: returns " + aTree.add(80) + " (should be null)");
		System.out.println("Adding 90: returns " + aTree.add(90) + " (should be null)");
		System.out.println("Adding 70: returns " + aTree.add(70) + " (should be null)");
		System.out.println("Adding 55: returns " + aTree.add(55) + " (should be null)");
		System.out.println("Adding 10: returns " + aTree.add(10) + " (should be null)");
		System.out.println("Adding 40: returns " + aTree.add(40) + " (should be null)");
		System.out.println("Adding 35: returns " + aTree.add(35) + " (should be null)");
      System.out.println("Adding 35 again: returns " + aTree.add(35) + " (should be 35)");
     
		return aTree;
	} // end createTree
   
   /** Tests the 4 traversals of a given binary tree. */
   public static void testTraversals(AVLTree<Integer> aTree, String inorder, String preorder, String postorder, String levelOrder)
   {
      testInorder(aTree, inorder);
      // The following traversals are not defined by SearchTreeInterface, but are
      // available to AVLTree from its ancestor class BinaryTree.
      testPreorder(aTree,   preorder);
      testPostorder(aTree,  postorder);
      testLevelOrder(aTree, levelOrder);
   } // end testTraversals
   
   public static void testInorder(AVLTree<Integer> tree, String answer)
   {
      System.out.println("\nTraversing tree inorder:");
      System.out.println(answer + "  Expected");
      
      Iterator<Integer> inorder = tree.getInorderIterator();
      
      while (inorder.hasNext())
      {
         System.out.print(inorder.next() + " ");
      } // end while
      
      System.out.println(" Actual using InorderIterator\n---------------");
   } // end testInorder
   
   public static void testPreorder(AVLTree<Integer> tree, String answer)
   {
      System.out.println("\nTraversing tree preorder:");
      System.out.println(answer + "  Expected");
      
      Iterator<Integer> preorder = tree.getPreorderIterator();
      
      while (preorder.hasNext())
      {
         System.out.print(preorder.next() + " ");
      } // end while
      
      System.out.println(" Actual using PreorderIterator\n---------------");
   } // end testPreorder
   
   public static void testPostorder(AVLTree<Integer> tree, String answer)
   {
      System.out.println("\nTraversing tree postorder:");
      System.out.println(answer + "  Expected");
      
      Iterator<Integer> postorder = tree.getPostorderIterator();
      
      while (postorder.hasNext())
      {	
         System.out.print(postorder.next() + " ");
      } // end while
      
      System.out.println(" Actual using PostorderIterator\n---------------");
   } // end testPostorder 

   public static void testLevelOrder(AVLTree<Integer> tree, String answer)
   {
      System.out.println("\nTraversing tree level order:");
      System.out.println(answer + "  Expected");
      
      Iterator<Integer> levelOrder = tree.getLevelOrderIterator();
      
      while (levelOrder.hasNext())
      {
         System.out.print(levelOrder.next() + " ");
      } // end while
      
      System.out.println(" Actual using LevelOrderIterator\n---------------");
   } // end testLevelOrder
}  // end DriverAVL


