import java.io.*;
import java.util.*;
 class Count_Good_Nodes
{  
  static class TreeNode 
  {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val)
      {
          this.val = val;
          left=null;
          right=null;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  public static void main(String args[])
  {
     TreeNode root = new TreeNode(3);
     root.left=new TreeNode(1);
     root.right= new TreeNode(4);
     root.left.left=new TreeNode(3);
     root.right.left=new TreeNode(1);
     root.right.right=new TreeNode(5);
     
     System.out.println(goodNodes(root));
  }
  static int goodNodes(TreeNode root) 
    {
      int max=Integer.MIN_VALUE;  
      return checkIfGoodNode(root,max);
    }  
  static int checkIfGoodNode(TreeNode node, int max)
    {  
       if(node==null)
        return 0; 
        
       int count = 0;
        
       if(node.val >= max) 
        count = 1;
        
       count+=checkIfGoodNode(node.left,Math.max(node.val,max)); 
       count+=checkIfGoodNode(node.right,Math.max(node.val,max));
       return count; 
        
    }   
}
