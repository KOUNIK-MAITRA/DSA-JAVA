import java.io.*;
import java.util.*;
 class Serialize_Deserialize_BinaryTree
{
    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) 
          { val = x;
            left=null;
            right=null;
        }
      }  
    public static void main(String args[])
      {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        System.out.println(serialize(root));
      }
      // Encodes a tree to a single string.
    static String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode curr=queue.poll();
            if(curr==null)
            {res.append("null ");
             continue;}
            res.append(curr.val+" ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    static TreeNode deserialize(String data) {
      
        String nodes[]=data.split(" ");
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
