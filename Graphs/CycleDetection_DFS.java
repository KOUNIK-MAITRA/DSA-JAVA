import java.io.*;
import java.util.*;
class CycleDetection_DFS
{   
    static boolean checkCycle(int node, int prev,boolean visited[],ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=true;
        for(int ele : adj.get(node))
        {
           if(visited[ele]==false)
           { if(checkCycle(ele,node,visited,adj))
               return true;
            }
            else if(ele!=prev)
            return true;
        }
        return false;
    }
    static boolean DFS_detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[]=new boolean[V+1];
        Arrays.fill(visited,false);
        
        for(int i=1;i<=V;i++)
        {
            if(visited[i]==false)
            {
                if(checkCycle(i,-1,visited,adj))
                 return true;
            }
        }
        return false;
    }
    static void addEdge( ArrayList<ArrayList<Integer>> adj,int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String args[])
    {
        int V=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=V;i++)
         adj.add(new ArrayList<Integer>());
        
        addEdge(adj,1,2);
        addEdge(adj,1,5);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,2,5);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        System.out.println(DFS_detectCycle( V,adj));
    }
}