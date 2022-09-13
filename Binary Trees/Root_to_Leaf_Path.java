import java.io.*;
import java.util.*;
 class Root_to_Leaf_Path
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
     TreeNode root = new TreeNode(1);
     root.left=new TreeNode(2);
     root.right= new TreeNode(3);
     root.left.right=new TreeNode(5);
         
     System.out.println(binaryTreePaths(root));
  }
  static List<String> binaryTreePaths(TreeNode root) 
    {   
        List<String> res= new ArrayList<>();
        rootToLeafPath(root,"",res);   
        return res;
    }
    
  static void rootToLeafPath(TreeNode node, String path, List<String>res)
    {
        if(node.left==null && node.right==null)
            res.add(path+node.val);
        
        if(node.left!=null)
            rootToLeafPath(node.left,path+node.val+"->",res);
            
        if(node.right!=null)
            rootToLeafPath(node.right,path+node.val+"->",res);
    }
}
