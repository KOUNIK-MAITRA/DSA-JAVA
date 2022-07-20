import java.io.*; 
import java.util.*;
//for every node
// height of left sub tree -height of right sub tree <=1
class Check_For_Balanced_BinaryTree
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
    static int heightOfBinaryTree(Node root){
        if(root==null)
         return 0;
        
        int heightOfLeftSubTree=heightOfBinaryTree(root.left);
        int heightOfRightSubTree=heightOfBinaryTree(root.right);
        
        if(heightOfLeftSubTree==-1 || heightOfRightSubTree==-1)
         return -1;
        
        if(Math.abs(heightOfLeftSubTree-heightOfRightSubTree)>1){
         return -1;
        }
        
        return 1+Math.max(heightOfLeftSubTree,heightOfRightSubTree);
    }
    static boolean isBalancedTree (Node root){
        int heightOfTree=heightOfBinaryTree(root);
        if(heightOfTree==-1)
         return false;
        else
         return true;
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
        root.right.right.right=new Node(8);
        root.right.right.right.right=new Node(9);
        
        System.out.println(isBalancedTree(root));
    }
}
