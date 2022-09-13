import java.io.*;
import java.util.*;
 class LeftView_of_BinaryTree
{
   static class Node
   {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
   }
   static ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans =new ArrayList<>();
        leftView(0,root,ans);
        return ans;
    }
    
   static void leftView(int level, Node node,ArrayList<Integer> ans)
    {
        if(node==null)
        return;
        
        if(ans.size()==level)
        ans.add(node.data);
        
        leftView(level+1,node.left,ans);
        leftView(level+1,node.right,ans);
    }
   public static void main(String args[])
   {
       Node root=new Node(10);
       root.left=new Node(20);
       root.left.left=new Node(40);
       root.left.right=new Node(60);
       root.right=new Node(30);
       
       System.out.println(leftView(root));
   }
   
}
