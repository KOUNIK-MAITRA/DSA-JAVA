import java.io.*;
import java.util.*;
public class InOrder_Iterative
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
    //left->root->right
    static List<Integer> inOrder(Node root)
    {   List<Integer> inorder=new ArrayList<>();
       if(root==null)
        return inorder;
        
       Stack <Node> stack=new Stack<Node>();
       Node curr=root; //store the curr as root
       while(true)
       {
         if(curr!=null) 
         { stack.push(curr); //insert the curr node in stack and move to left
             curr=curr.left;
            }
         else // if the curr element is null
         { if(stack.isEmpty()) // if the stack becomes empty break from the loop
             break;
           curr=stack.pop();// take out the last element from the stack
           inorder.add(curr.data); // add it to the answer
           curr=curr.right; //move to its right
            }
        }
        return inorder;
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
        
        System.out.println ("Inorder traversal "+inOrder(root));
    }
}
