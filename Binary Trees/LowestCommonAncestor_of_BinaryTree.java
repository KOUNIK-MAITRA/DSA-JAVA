import java.io.*;
import java.util.*; 
class LowestCommonAncestor_of_BinaryTree
{
   static class TreeNode
   {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int val)
       {
           this.val=val;
           left=null;
           right=null;
       }
   }
   public static void main(String args[])
   {
      TreeNode root=new TreeNode(3);
      root.left=new TreeNode(5);
      root.right=new TreeNode(1);
      root.left.left=new TreeNode(6);
      root.left.right=new TreeNode(2);
      root.right.left=new TreeNode(0);
      root.right.right=new TreeNode(8);
      root.left.right.left=new TreeNode(7);
      root.left.right.right=new TreeNode(4);
      
      TreeNode p= new TreeNode(5);
      TreeNode q= new TreeNode(1);
      
      System.out.println(lowestCommonAncestor(root,p,q).val);
   }
   static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root==null) 
         return null;
        
        // if root is either of the nodes then lca is root so return root
        if(root.val==p.val || root.val==q.val) 
         return root;
        
        // check is either of the nodes is present in the left subtree
        TreeNode left=lowestCommonAncestor(root.left,p,q); 
        
        // check if either of the nodes is present in the right subtree
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        // if we get null from left then both the nodes are present in the right subtree
        if(left==null) 
         return right;
        //if we get null from right then both the nodes are present in the left subtree
        if(right==null) 
         return left;
        
        //if both left and right give a value (which will be p and q) then root is the lca return root
        return root;
      
    }
}