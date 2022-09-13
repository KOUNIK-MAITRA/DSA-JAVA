import java.io.*;
import java.util.*;
class N_ary_Tree_LevelOrder_Traversal
{
    public static void main(String args[])
    {
      Node root=new Node(1);
      root.children=new ArrayList<Node>();
      root.children.add(new Node(3));
      root.children.add(new Node(2));
      root.children.add(new Node(4));
      root.children.get(0).children=new ArrayList<Node>();
      root.children.get(0).children.add(new Node(5));
      root.children.get(0).children.add(new Node(6));
      
      System.out.println(levelOrder(root));
    }
    static List<List<Integer>> levelOrder(Node root) 
    {     
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) 
         return ans;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
          List<Integer> currLevel= new ArrayList<>();   
          int nodesInCurrLevel=queue.size();
          
          for(int i=0;i<nodesInCurrLevel;i++)
          {
              Node curr= queue.poll();
              currLevel.add(curr.val);
              
              if(curr.children!=null)
              {
                for(Node child : curr.children)
                    queue.offer(child);
              }
          }
            ans.add(currLevel);
        }              
        return ans;
    }
    static class Node
    {
      int val;
      ArrayList<Node> children;
      Node(int val)
      {
          this.val=val;
          children=null;
      }
    }
}
