import java.io.*;
import java.util.*;
 class Symmetric_BinaryTree
{
    static class TreeNode
    {
      int val;
      TreeNode left;
      TreeNode right;
  
      TreeNode(int val) 
      { this.val = val; 
        left=null;
        right=null;
      }
    }
    public static void main(String args[])
    {
      TreeNode root= new TreeNode(1);
      root.left=new TreeNode(2);
      root.left.left=new TreeNode(3);
      root.left.right=new TreeNode(4);
      root.right=new TreeNode(2);
      root.right.left=new TreeNode(4);
      root.right.right=new TreeNode(3);
      
      System.out.println(isSymmetric(root));
    }
    static boolean isSymmetric(TreeNode root) 
    {
      return root==null || isSymmetric(root.left, root.right);  
    }
    static boolean isSymmetric(TreeNode left , TreeNode right)
    {
        if(left==null || right==null)
            return left==right;
        if(left.val != right.val)
            return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
