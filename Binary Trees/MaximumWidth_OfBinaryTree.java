import java.io.*;
import java.util.*;
class MaximumWidth_OfBinaryTree 
{   
    public static void main(String args[])
    {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(3);
        root.right.right=new TreeNode(9);
        
        System.out.println(widthOfBinaryTree(root));
    }
    static int widthOfBinaryTree(TreeNode root) 
    {
        
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,1));
        int width=0;
        
        while(!queue.isEmpty()){
            
            int first=0;
            int last=0;
            int min=queue.peek().index;
            int size=queue.size(); 
            
            for(int i=0; i<size; i++)
            {
                Pair curr=queue.poll();
                TreeNode node=curr.node;
                int currIndex=curr.index-min;
                
                if(i==0) 
                 first=currIndex;
                if(i==size-1) 
                 last=currIndex;
                
                if(node.left!=null) 
                 queue.offer(new Pair(node.left,(2*currIndex)));
                if(node.right!=null) 
                 queue.offer(new Pair(node.right,(2*currIndex+1)));

            }
            
            width=Math.max(width,(last-first)+1);
        }
        
        return width;
    }
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
    static class Pair
    {
        TreeNode node;
        int index;
        
        Pair(TreeNode node,int index)
        {
            this.node=node;
            this.index=index;
        }
    }
}