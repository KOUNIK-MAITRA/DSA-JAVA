import java.io.*; 
import java.util.*;
class BinaryTree_PostOrderTraversal_One_Stack
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
    static ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> postorder =new ArrayList<>();
        if(root==null)
         return postorder; 
        Node curr=root;
        Stack<Node> stack=new Stack<>();
        
        while(curr!=null||!stack.isEmpty())
        {
            if(curr!=null)
            { stack.push(curr); // add the element to the stack
              curr=curr.left;  // move curr to the left child
            }
            else // if there is no left child
            {
                Node temp =stack.peek().right; //check if a right child exists
                if(temp==null) // if there is no right child i.e its a leaf node
                {
                    temp=stack.peek();
                    stack.pop();
                    postorder.add(temp.data);
                    while(!stack.isEmpty() && temp==stack.peek().right) // if temp is the right child of the last added node then print it and go back to its parent
                    {
                        temp=stack.peek();
                        stack.pop();
                        postorder.add(temp.data);
                    }
                }
                else{ // if right child exists
                 curr=temp; //  make it curr
                }
            }
        }
        
        return postorder;
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
        
        System.out.println(postOrder(root));
    }
}
