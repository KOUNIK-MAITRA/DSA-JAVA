import java.io.*;
import java.util.*;
class CycleDetection_DFS
{   
    static boolean checkCycle(int currNode, int prev,boolean visited[],ArrayList<ArrayList<Integer>> adj)
    {
        visited[currNode]=true;// mark the curr node as visited
        for(int node : adj.get(currNode)) // check for all nodes in the adjacency list
        {
           if(visited[node]==false) // if the node is not visited
           { if(checkCycle(node,currNode,visited,adj)) // check for cycle using dfs
               return true;
            }
            // if the nod is already visisted just check if its not the parent/prev node
            else if(node!=prev) // if node is not the prev node of currNode-cycle present
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
            if(visited[i]==false)// if the node is not visisted
            {   int currNode=i;
                if(checkCycle(currNode,-1,visited,adj)) // check for cycle using dfs
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