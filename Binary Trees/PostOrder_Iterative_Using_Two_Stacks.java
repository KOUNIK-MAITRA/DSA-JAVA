import java.io.*;
import java.util.*;
 class PostOrder_Iterative_Using_Two_Stacks
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
    static List<Integer> postOrder(Node root)
    {  List<Integer> postOrder=new ArrayList<>();
       if(root==null)
       return postOrder;
       
       Stack<Node> s1=new Stack<>();
       Stack<Node> s2=new Stack<>();
       
       s1.push(root);
       
       while(!s1.isEmpty())
       { Node curr=s1.pop();
         s2.push(curr);
         if(curr.left!=null)
         {s1.push(curr.left);
            }
         if(curr.right!=null)
         {s2.push(curr.right);
            }
        }  
       
        while(!s2.isEmpty())
        { 
            postOrder.add(s2.pop().data);
        }
       return postOrder; 
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
        
        System.out.println ("Postorder traversal "+postOrder(root));
    }
}
