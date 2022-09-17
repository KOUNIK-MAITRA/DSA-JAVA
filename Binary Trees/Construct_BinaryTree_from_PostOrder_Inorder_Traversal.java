import java.io.*;
import java.util.*;
 class Construct_BinaryTree_from_PostOrder_Inorder_Traversal
{
   static class TreeNode
    {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
   }
   static TreeNode buildTree(int[] inorder, int[] postorder) 
   {
        HashMap<Integer,Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inorderMap.put(inorder[i],i);
        
        return buildTree(0,postorder.length-1,postorder,0,inorder.length-1,inorder,inorderMap);
        
    } 
   static TreeNode buildTree(int postStart,int postEnd,int[]postorder,
                       int inStart, int inEnd,int []inorder,HashMap<Integer,Integer> inorderMap)
   {
        if(postStart>postEnd || inStart>inEnd) 
         return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int indexOfRoot_in_inorder=inorderMap.get(root.val);
        int no_of_nodes_in_left_subTree=indexOfRoot_in_inorder-inStart;
        int no_of_nodes_in_right_subTree=inEnd-indexOfRoot_in_inorder;
        
        root.left=buildTree(postStart,postStart+no_of_nodes_in_left_subTree,postorder,
                            inStart,indexOfRoot_in_inorder-1,inorder,inorderMap);
        
        root.right=buildTree(postStart+no_of_nodes_in_left_subTree,postEnd-1,postorder,
                             indexOfRoot_in_inorder+1,inEnd,inorder,inorderMap);
        
        return root;
        
            
   }
}
