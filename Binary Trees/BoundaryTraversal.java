import java.io.*;
import java.util.*;
class BoundaryTraversal
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
    static boolean isLeaf(Node node){
       if(node.left==null && node.right==null)
        return true;
        else
        return false;
    }
   
    static void addLeftBoundary(Node root,List<Integer> ans){
        Node curr=root.left; //curr =left child of the root
        while(curr!=null){
         if(isLeaf(curr)==false)//if the curr node is not a leaf then add it to the ans
          ans.add(curr.data);
         
         if(curr.left!=null) // if a left child exists 
          curr=curr.left;
         else // if left child doesn't exist
         curr=curr.right;
        }
     }
     
    static void addRightBoundary(Node root,List<Integer> ans){
        Node curr=root.right;
        List<Integer> nodesInRightBoundary=new ArrayList<>();
        while(curr!=null){
         if(isLeaf(curr)==false)
          nodesInRightBoundary.add(curr.data);
         
         if(curr.right!=null)
          curr=curr.right;
          else
          curr=curr.left;
        }
        
        for(int i=nodesInRightBoundary.size()-1;i>=0;i--)
        {ans.add(nodesInRightBoundary.get(i));
        }
    }
    
    static void addLeaves(Node root,List<Integer> ans){
        if(isLeaf(root)){
         ans.add(root.data);
         return;}
        
        if(root.left!=null)
         addLeaves(root.left,ans);
        
        if(root.right!=null)
         addLeaves(root.right,ans);
    }
    
    static List<Integer> boundaryTraversal(Node root){
     List<Integer> ans=new ArrayList<Integer>();
     if(root==null)
      return ans;
     
     if(isLeaf(root)==false)
       ans.add(root.data);
       
     addLeftBoundary(root,ans);
     addLeaves(root,ans);
     addRightBoundary(root,ans);
     
     return ans;
    }
    public static void main (String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(3);
        root.left.left.right=new Node(4);
        root.left.left.right.left=new Node(5);
        root.left.left.right.right=new Node (6);
        
        root.right=new Node(7);
        root.right.right=new Node(8);
        root.right.right.left=new Node(9);
        root.right.right.left.left=new Node(10);
        root.right.right.left.right=new Node(11);
        
        System.out.println(boundaryTraversal(root));
    }
}
