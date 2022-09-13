import java.io.*;
import java.util.*;
 class VerticalOrderTraversal
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
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
    static ArrayList <Integer> verticalOrder(Node root)
    {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,root));
        
        while(!queue.isEmpty())
        {
            Pair curr = queue.poll();
            Node currNode = curr.node;
            int currDist= curr.horzDist;
            
            map.putIfAbsent(currDist,new ArrayList<>());
            map.get(currDist).add(currNode.data);
            
            if(currNode.left!=null)
                queue.add(new Pair(currDist-1,currNode.left));
            
            if(currNode.right!=null)
                queue.add(new Pair(currDist+1,currNode.right));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
        {
            ans.addAll(entry.getValue());
        }
        
        return ans;
    }  
    public static void main(String args[])
    {
        Node root= new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(6);
        root.right.left= new Node(5);
        root.right.right= new Node(7);
        
        System.out.println(verticalOrder(root));   
    }
}
