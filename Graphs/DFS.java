import java.util.*;
import java.io.*;
class DFS
{
        static void dfs (int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans)
        {
            ans.add(node);
            visited[node]=true;
            
            for(int ele : adj.get(node))
            {
                if(visited[node]==false)
                {
                    dfs(node,visited,adj,ans);
                }
            }
        }
        static ArrayList<Integer> dfsTraversal(int V, ArrayList<ArrayList<Integer>> adj)
        {
           ArrayList<Integer> ans =new ArrayList<>();
           boolean visited[]=new boolean[V];
           
           for(int i=0;i<V;i++)
           { if(visited[i]==false)
               dfs(i,visited,adj,ans);
            }
           
           return ans;
        }
        
	static void addEdge(ArrayList<ArrayList<Integer> > adj,int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static void main(String[] args)
	{
		// Creating a graph with 5 vertices
		int V = 5;
		ArrayList<ArrayList<Integer> > adj= new ArrayList<ArrayList<Integer> >(V);

		for (int i = 0; i < V; i++)
		 adj.add(new ArrayList<Integer>());

		// Adding edges one by one
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
                
		System.out.println(dfsTraversal(V,adj));
	}
}
