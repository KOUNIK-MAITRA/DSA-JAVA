import java.io.*;
import java.util.*;
 class MaximumPathSum_in_a_BinaryTree
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
  static int maxPathSum(Node root) {
        int []max=new int[1];
        max[0]=Integer.MIN_VALUE;
        maxSum(root,max);
        
        return max[0];
    }
  static int maxSum (Node root,int[] max)
    {
        if(root==null)
            return 0;
        
        int leftSum=Math.max(0,maxSum(root.left,max));
        int rightSum=Math.max(0,maxSum(root.right,max));
        
        max[0]=Math.max(max[0],root.data+leftSum+rightSum);
        return root.data+Math.max(leftSum,rightSum);
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
        
        System.out.println(maxPathSum(root));
    }
}
