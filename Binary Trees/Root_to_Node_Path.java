import java.io.*;
import java.util.*;
public class Root_to_Node_Path
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
       root.right=new TreeNode(3);
       root.left.left=new TreeNode(4);
       root.left.right=new TreeNode(5);
       root.right.left=new TreeNode(6);
       root.right.right=new TreeNode(7);
       int B =5;
       System.out.println(solve(root,B));
   }
   static ArrayList<Integer> solve(TreeNode root, int B) 
    {
        ArrayList<Integer> ans= new ArrayList<>();
        nodeToPath(root,B,ans);
        return ans;
    }
   static boolean nodeToPath(TreeNode node , int B, ArrayList<Integer> ans)
   {
        if(node == null)
          return false;
        
        ans.add(node.val);
        
        if(node.val==B) 
          return true;
        
       
        if(nodeToPath(node.left,B,ans) || nodeToPath(node.right,B,ans))
          return true;
        
        ans.remove(ans.size()-1);
        
        return false;
                
   }
}
