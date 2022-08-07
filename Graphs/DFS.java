import java.util.*;
import java.io.*;
class DFS
{
        static void dfs (int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans)
        {
            ans.add(node); // add the node that called for dfs
            visited[node]=true;// mark the node as viisted
            
            for(int ele : adj.get(node)) //for every element in the adjaceny list
            {
                if(visited[node]==false)// if the node is not viisted
                {
                    dfs(node,visited,adj,ans);// call for dfs
                }
            }
        }
        static ArrayList<Integer> dfsTraversal(int V, ArrayList<ArrayList<Integer>> adj)
        {
           ArrayList<Integer> dfs =new ArrayList<>(); // ds to store the dfs traversal
           boolean visited[]=new boolean[V]; // a boolean visisted array to mark the nodes that are already visisted
           
           for(int i=0;i<V;i++)// check for every node in the graph
           { if(visited[i]==false) // if the node is not viisted
               dfs(i,visited,adj,dfs);// call for its dfs
            }
           
           return dfs;
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
