import java.io.*;
import java.util.*; 
class Nodes_in_a_Complete_BinaryTree
{   
  static class TreeNode 
  {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; left=null; right=null; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  public static void main(String args[])
  {
    TreeNode root=new TreeNode (1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.left=new TreeNode(4);
    root.left.right=new TreeNode(5);
    root.right=new TreeNode(3);
    root.right.left=new TreeNode(6);
    
    System.out.println(countNodes(root));
  }
  static int countNodes(TreeNode root) 
    {
        if(root==null) 
         return 0;
        
        int leftHeight=findLeftHeight(root);
        int rightHeight=findRightHeight(root);
        
        if(leftHeight==rightHeight)// complete binary tree with all nodes present
            return (int)Math.pow(2,leftHeight)-1;
        else 
            return 1+countNodes(root.left)+countNodes(root.right);
    }
    
  static int findLeftHeight(TreeNode node)
    {
       int height=0;
       while(node!=null)
       {
           height++;
           node=node.left;
       }
       
       return height; 
    }
    
  static int findRightHeight(TreeNode node)
    {
        int height=0;
       while(node!=null)
       {
           height++;
           node=node.right;
       }
       
       return height;
    }
}
