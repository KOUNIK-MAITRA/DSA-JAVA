import java.io.*;
import java.util.*;
 class RightView_of_BinaryTree
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
  }   
  public static void main(String args[])
  {
    TreeNode root = new TreeNode(1);
    root.left=new TreeNode(2);
    root.left.right=new TreeNode(5);
    root.right=new TreeNode(3);
    root.right.right=new TreeNode(4);
    
    System.out.println(rightSideView(root));
  }
  static List<Integer> rightSideView(TreeNode root) 
  {
      List<Integer> ans = new ArrayList<>();
      rightView(0,root,ans);
      return ans;   
  }
  static void rightView(int level,TreeNode node,List<Integer> ans)
  {// traversal used : root-->right--->left
        if(node==null)
         return;
        
        // check if it is the first node of a level
        if(ans.size()==level)
         ans.add(node.val);
        
        rightView(level+1,node.right,ans);
        rightView(level+1,node.left,ans);
  }
}
