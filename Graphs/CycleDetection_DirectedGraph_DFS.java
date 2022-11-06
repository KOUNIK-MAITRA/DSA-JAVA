import java.io.*;
import java.util.*;
class CycleDetection_DirectedGraph_DFS
{   
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        boolean DFSvisited[]=new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(isCycle_DFS(i,adj,visited,DFSvisited))
                    return true;
            }
        }
        return false;
    }

    static boolean isCycle_DFS(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] DFSvisited)
    {
        visited[curr]=true;
        DFSvisited[curr]=true;

        for(int neighbour : adj.get(curr))
        {
            if(!visited[neighbour])
            {
                if(isCycle_DFS(neighbour,adj,visited,DFSvisited))
                    return true;
            }
            else if(DFSvisited[neighbour])
                return true;
        }

        DFSvisited[curr]=false;
        return false;
    }

    static void addDirectedEdge(ArrayList<ArrayList<Integer> > adj,int u, int v){
        adj.get(u).add(v);
    }

    public static void main(String args[]){
        int V=4;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        { adj.add(new ArrayList<Integer>());
        }
        addDirectedEdge(adj,0,1);
        addDirectedEdge(adj,0,2);
        addDirectedEdge(adj,1,2);
        addDirectedEdge(adj,2,0);
        addDirectedEdge(adj,2,3);
        addDirectedEdge(adj,3,3);

        System.out.println(isCyclic(V,adj));
    }  
}
