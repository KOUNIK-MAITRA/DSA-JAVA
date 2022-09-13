import java.io.*;
import java.util.*;
 class TopView_of_a_BinaryTree
{ 
  static class Node
  {
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
  }
  static class Pair
  {
     int horzDist;
     Node node;
     Pair(int horzDist, Node node)
     {
         this.horzDist=horzDist;
         this.node=node;
     }        
  } 
  static ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        queue.add(new Pair(0,root));
        
        while(!queue.isEmpty())
        {
           Pair curr=queue.poll();
           int currDist=curr.horzDist;
           Node currNode=curr.node;
           
           map.putIfAbsent(currDist,currNode.data);
           
           if(currNode.left!=null)
            queue.add(new Pair(currDist-1,currNode.left));
        
           if(currNode.right!=null)
            queue.add(new Pair(currDist+1,currNode.right));
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        ans.addAll(map.values());
        return ans;
        
    }
  public static void main()
  {
      Node root = new Node(1);
      root.left = new Node(2);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.left.right.left = new Node(6);
      root.right = new Node(3);
      root.right.right = new Node(7);
      
      System.out.println(topView(root));
  }
}
