import java.io.*;
import java.util.*;
 class LevelOrderTraversal
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
   
   static List<Integer> levelOrder(Node root)
   { // arraylist of arraylist to store the nodes in a level
    List<Integer> traversal=new ArrayList<>();
     // declare queue for the traversal
    Queue <Node> q=new LinkedList<>();
   
     if(root==null)
       return traversal;
     
     q.add(root);// first step --> add the root
     q.add(null); // add a null to mark end of a level
     while(!q.isEmpty()) // traverse till no nodes are left in the queue
     { 
         Node curr=q.peek();// store the curr element
         q.remove();// remove the element from the queue
        
        if(curr!=null) //if  the curr is not null
        {
            traversal.add(curr.data);//add the curr data            
            if(curr.left!=null) //check if left child exists
            q.add(curr.left); //add the left child to queue
            if(curr.right!=null)//check if right child exists
            q.add(curr.right);//add the right child to queue
        }
        else if(!q.isEmpty())//if the queue is not empty
        {//add a null to mark the end of a level
          q.add(null);          
        }
        }
     return traversal;
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
        
        System.out.println(levelOrder(root));
    }
}
