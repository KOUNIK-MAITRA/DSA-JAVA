import java.io.*; 
import java.util.*;
class BinaryTreeTraversals
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
    static void preOrder(Node root)
    {
     if(root==null)
        return;   
       // preOrder--> Root->left->right
       System.out.print(root.data+ " ");
       preOrder(root.left);
       preOrder(root.right);
    }
       static void inOrder(Node root)
    {
        if(root==null)
        return ;
        // inOrder--> left->root->right
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    static void postOrder(Node root)
    {
        if(root==null)
        return ;
        // postOrder--> left->right->root
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
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
        
        System.out.print ("Pre Order Traversal: ");
        preOrder(root);
        System.out.println();
        
        System.out.print ("In Order Traversal: ");
        inOrder(root);
        System.out.println();
       
        System.out.print ("Post Order Traversal: ");
        postOrder(root);
        System.out.println(); 
    }
}
