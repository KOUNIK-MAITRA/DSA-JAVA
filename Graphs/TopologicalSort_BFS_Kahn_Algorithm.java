import java.io.*;
import java.util.*;
class TopologicalSort_BFS_Kahn_Algorithm
{

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int [] indegree= new int[V];
        int [] ans= new int[V];
        int index=0;

        Queue<Integer> queue = new LinkedList<>();

        for(ArrayList<Integer> nodes : adj)
        {
            for(int node: nodes)
            {
                indegree[node]++;
            }
        }

        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
                queue.offer(i);
        }

        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            ans[index++]=curr;

            for(int neighbour: adj.get(curr))
            {
                indegree[neighbour]--;

                if(indegree[neighbour]==0)
                    queue.offer(neighbour);
            }
        }

        return ans;
    }

    static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
    } 

    public static void main(String args[]){
        int V=6;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<Integer>()); 

        addDirectedEdge(adj,0,2);
        addDirectedEdge(adj,0,3);
        addDirectedEdge(adj,2,3);
        addDirectedEdge(adj,2,1);
        addDirectedEdge(adj,3,1);
        addDirectedEdge(adj,1,4);
        addDirectedEdge(adj,5,1);
        addDirectedEdge(adj,5,4);

        System.out.println(Arrays.toString(topoSort(V,adj)));
    }
} 

