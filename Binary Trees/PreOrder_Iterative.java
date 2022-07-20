import java.io.*;
import java.util.*;
public class PreOrder_Iterative
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
    static List<Integer> preOrder(Node root)
    {   List<Integer> preorder=new ArrayList<>();
       if(root==null)
        return preorder;
        
       Stack <Node> stack=new Stack<Node>();
       // first step-add the root to the stack
       stack.push(root);
       // traverse till the stack is empty
       while(!stack.isEmpty())
       {
         Node curr=stack.pop();
         preorder.add(curr.data);
         //add the right child first
         if(curr.right!=null)
          stack.push(curr.right);
          //add the left child
         if(curr.left!=null)
          stack.push(curr.left);
          
        }
        return preorder;
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
        
        System.out.println ("Preorder traversal "+preOrder(root));
    }
}
