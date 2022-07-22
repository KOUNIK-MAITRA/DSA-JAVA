import java.io.*;
import java.util.*;
// longest distance between two nodes
// the path may or maynot pass through the root 
 class Diameter_Of_BinaryTree
{
  static class Node{
     int data;
     Node left;
     Node right;
     Node(int data)
     {this.data=data;
      left=null;
      right=null;
        }
    }
  static int findDiameter(Node root,int[] diameter){
    if(root==null)
    {return 0;}
    
    int heightOfLeftSubTree=findDiameter(root.left,diameter);
    int heightOfRightSubTree=findDiameter(root.right,diameter);
    
    // calculating the diameter
    diameter[0]=Math.max(diameter[0],(heightOfLeftSubTree+heightOfRightSubTree));
    
    return (1+Math.max(heightOfLeftSubTree,heightOfRightSubTree)); //returning the height
    }  
  public static void main (String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        
        int[] diameter=new int[1];
         diameter[0]=0;
        findDiameter(root,diameter);
       
        System.out.println("Diameter of the binary tree is : "+diameter[0]);
        
    }
}
