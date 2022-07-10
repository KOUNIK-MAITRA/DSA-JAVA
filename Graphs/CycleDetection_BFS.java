import java.io.*;
import java.util.*;
class CycleDetection_BFS
{
    static class Node
    {
        int curr;
        int prev;
         Node(int curr, int prev)
        {
            this.curr=curr;
            this.prev=prev;
        }
    }
    public static void main (String args[])
    {
        int V=5;
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        
        for(int i=0;i<=V;i++)
        { adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,1,2);
        addEdge(adj,1,5);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,2,5);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        System.out.println(BFS_detectCycle( V,adj));
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited)
    { 
        Queue <Node> q=new LinkedList<>();
        q.add(new Node(i,-1));
        visited[i]=true;
        
        while(!q.isEmpty())
        {
            Node node=q.peek();
            q.remove();
            
            for(int ele : adj.get(node.curr))
            {
                if(visited[ele]==false)
                { visited[ele]=true;
                  q.add(new Node (ele,node.curr));
                }
                else if(node.prev!=ele)
                  return true;
            }
        }
        
        return false;
    }
    static boolean BFS_detectCycle(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[]=new boolean[V+1];
        Arrays.fill(visited,false);
        
        for(int i=1;i<=V;i++)
        {
            if(visited[i]==false)
            {
                if(isCycle(adj,i,visited))
                 return true;
            }
        }
        return false;
    }
}