import java.io.*;
import java.util.*;
 class BinaryTree_ZigZag_Traversal
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
     static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans =new ArrayList<>();
        Queue<Node> q=new LinkedList<>(); //creating a queue
        
        if(root==null)
            return ans;
        
        q.add(root); // add the root of the tree to the queue
        
        boolean leftToRight=true; // flag to ensure we print the elements in corrrect zigzag order
        
        while(!q.isEmpty()){
            
            int numberOfElementsInlevel=q.size(); // number of elements in curr level
            List<Integer> elementsInLevel=new ArrayList<>(); // list of elements to store elements in curr level
            
            for(int i=0;i<numberOfElementsInlevel;i++) // iterate over all nodes in the  curr level
            {
                 if(q.peek().left!=null) // if a left child exists add it to the queue
                    q.add(q.peek().left);
                
                 if(q.peek().right!=null) // if a right child exists add it to the queue
                    q.add(q.peek().right);
                
                if(leftToRight==true) // if we need to traverse fro left to right
                {
                   elementsInLevel.add(q.poll().data); // add the elements of the current level in the array list
                }
                else // if we need to traverse from right to left
                    elementsInLevel.add(0,q.poll().data); // add elements of the curr level in the array list in reverse order
                
            }
            
            leftToRight=!leftToRight;//reverse the direction of traversal
            ans.add(elementsInLevel); // add the arraylist to the ans 
        }
        
        return ans;
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
        
        System.out.println(zigzagLevelOrder(root));
    }
}
