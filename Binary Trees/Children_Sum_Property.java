import java.io.*;
import java.util.*;
 class Children_Sum_Property
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        { this.data=data;
          left=null;
          right=null;
        }
    }
    public static void main(String args[])
    {
      Node root=new Node(1);
      root.left=new Node(2);
      root.left.left=new Node(4);
      root.left.left.right=new Node(7);
      root.right=new Node(3);
      root.right.left=new Node(5);
      root.right.right=new Node(6);
      
      System.out.println(isValid(root));
      changeTree(root);
      System.out.println(isValid(root));
    }
    static boolean isValid(Node root)
    {   
        if(root == null || (root.left==null && root.right==null))
         return true;
        else 
         {   
             if(root.left!=null)
              { if(!isValid(root.left))
                   return false;
              }
             
             if(root.right!=null)
              { if(!isValid(root.right))
                   return false;
              } 
            
             int sum=0;
             
             if(root.left!=null) 
              sum+=root.left.data;
             
             if(root.right!=null)
              sum+=root.right.data;
             
             return root.data==sum;
         }  
    }
    static void changeTree(Node root)
    {
        if(root==null || (root.left==null && root.right==null)) // if root is null or it has no children 
         return;
        else
        {   int leftData=0;
            int rightData=0;
            int sum=0;
            int diff=0;
            
            changeTree(root.left); // alter the left subtree so it satisfies childrem sum property
            changeTree(root.right);// alter the right subtree so it satisfies the children sum property
            
            if(root.left!=null) // if left child exists   
             leftData=root.left.data;
            
            if(root.right!=null) // if right child exists
             rightData=root.right.data;
            
            sum=leftData+rightData;
            diff=sum-root.data;
            
            if(diff>0) // root.data < sum hence root.data can be incremented
             root.data+=diff;
            
            else if(diff<0) // root.data > sum but root.data cannot be decremented so we must increment its childrens accordingly
             increment(root,-diff);
        }
    }
    static void increment(Node node, int diff)
    {
        if(node.left!=null) // if left child exists
        {
            node.left.data+=diff;// increment the left childs data by diff
            increment(node.left,diff);// modifiy the remaining subtree so children sum property still holds
        }
        else if(node.right!=null)// if left child doesnot exist then we increment the right child
        {
            node.right.data+=diff;// increment the right childs data by diff
            increment(node.right,diff);// modifiy the remaining subtree so children sum property still holds
        }
    }
}
