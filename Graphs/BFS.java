import java.util.*;
import java.io.*;
class BFS
{

        static ArrayList<Integer> bfsTraversal(int V, ArrayList<ArrayList<Integer>> adj)
        {
            ArrayList<Integer> bfs = new ArrayList<>();// ds to store the bfs traversal
            boolean visited[]=new boolean[V]; // to mar the nodes that have been already visited
            
            for(int i=0;i<V;i++) // check for every node
            {
                if(visited[i]==false) // if the node is not visited
                {
                    Queue<Integer> q = new LinkedList<>(); // create a queue
                    q.add(i);// add the node
                    visited[i]=true;//mark the node visited
                    
                    while(!q.isEmpty()) // while the queue is not empty
                    {
                        int node=q.poll(); //remove the node from the queue
                        bfs.add(node); // add it to the ans ds
                        
                        for( int ele : adj.get(i)) // check for every adjacent node
                        {
                            if(visited[ele]==false) // if the node is not visited
                            {
                                visited[ele]=true; // mark it as visited
                                q.add(ele);// and add it to the queue
                            }
                        }
                    }
                }
            }
            
            return bfs;
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
                
		System.out.println(bfsTraversal(V,adj));
	}
}
