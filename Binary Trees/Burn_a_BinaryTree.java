import java.io.*;
import java.util.*; 
class Burn_a_BinaryTree
{
    static class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.left.left=new Node(8);
        root.left.right=new Node(5);
        root.left.right.left=new Node(10);
        root.right=new Node(3);
        root.right.right=new Node(7);
        
        System.out.println(minTime(root,10));
    }
    public static int minTime(Node root, int target) 
    {
       HashMap<Node,Node> parentMap = new HashMap<>();
       Node start=parentMap(root,parentMap,target);
           
       Queue<Node> queue = new LinkedList<>();
       queue.offer(start);
      
       HashSet<Node> visited = new HashSet<>();
       visited.add(start);
      
       int time=-1;
      
       while(!queue.isEmpty())
       {
           int size=queue.size();
           
           for(int i=0;i<size;i++)
           {
               Node curr=queue.poll();
               
               if(curr.left!=null && !visited.contains(curr.left))
               {
                   queue.add(curr.left);
                   visited.add(curr.left);
               }
               
               if(curr.right!=null && !visited.contains(curr.right))
               {
                   queue.add(curr.right);
                   visited.add(curr.right);
               }
               
               Node parent= parentMap.get(curr);
               if(!visited.contains(parent))
               {
                   queue.add(parent);
                   visited.add(parent);
               }
               
           }
           
           time++;
       }
       
       return time;
       
    }
    
    static Node parentMap(Node root, HashMap<Node,Node> map ,int target )
    {
      Queue<Node> queue=new LinkedList();
      map.put(root,root);
      queue.offer(root);
      Node start=null;
      
      while(!queue.isEmpty())
      {
         Node curr=queue.poll();
         if(curr.data==target) start=curr;
         
         if(curr.left!=null)
         {
             queue.offer(curr.left);
             map.put(curr.left,curr);
         }
         if(curr.right!=null)
         {
             queue.offer(curr.right);
             map.put(curr.right,curr);
         }
      }
    
        return start;
    }
}
