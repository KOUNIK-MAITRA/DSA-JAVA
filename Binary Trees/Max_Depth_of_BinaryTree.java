import java.io.*; 
class Max_Depth_of_BinaryTree
{
    static class Node{
     int data;
     Node left;
     Node right;
     Node(int data)
     {this.data=data;
      left=null;
      right=null;
        }
    }
    static int maxDepth(Node root){
        if(root==null)
         return 0;
        
        int depthOfLeftTree=maxDepth(root.left);
        int depthOfRightTree=maxDepth(root.right);
        
        return 1+Math.max(depthOfLeftTree,depthOfRightTree);
    }
    public static void main (String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        
        System.out.println(maxDepth(root));
    }
}
