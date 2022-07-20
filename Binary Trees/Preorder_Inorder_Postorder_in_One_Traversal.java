import java.io.*;
import java.util.*;
 class Preorder_Inorder_Postorder_in_One_Traversal
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
    static class Pair{
     Node node;
     int num;
     Pair(Node node, int num){
      this.node=node;
      this.num=num;
        }
    }
    static void traversals(Node root,ArrayList<Integer> preorder,ArrayList<Integer>inorder,ArrayList<Integer>postorder){
        Stack <Pair> stack=new Stack<>();
        stack.push(new Pair(root,1));
        
        if(root==null)
         return;
        
         while(!stack.isEmpty()){
           Pair curr=stack.pop();
           
           if(curr.num==1){
            preorder.add(curr.node.data);
            curr.num++;
            stack.push(curr);
            
            if(curr.node.left!=null)
            {
                stack.push(new Pair(curr.node.left,1));
            }
            }
           else if(curr.num==2){
            inorder.add(curr.node.data);
            curr.num++;
            stack.push(curr);
            
            if(curr.node.right!=null)
            { stack.push(new Pair(curr.node.right,1));
            }
            } 
           else{
               postorder.add(curr.node.data);
            }
            }
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
        
        ArrayList < Integer > pre = new ArrayList < > ();
        ArrayList < Integer > in = new ArrayList < > ();
        ArrayList < Integer > post = new ArrayList < > ();
        traversals(root, pre, in , post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }
}
