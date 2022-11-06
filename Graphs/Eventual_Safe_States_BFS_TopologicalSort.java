import java.io.*;
import java.util.*;
class Eventual_Safe_States_BFS_TopologicalSort {
    static List<Integer> eventualSafeNodes(int[][] graph) {
        int V =graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        // form the adjacency list in reverse order
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<Integer>());

        for(int i=0;i<V;i++)
        {
            for(int node:graph[i])
            {
                adj.get(node).add(i); 
            }
        }

        int indegree[]=new int[V];
        for(ArrayList<Integer> nodes : adj)
        {
            for(int node : nodes)
                indegree[node]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
                queue.offer(i);
        }

        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            ans.add(curr);
            for(int neighbour : adj.get(curr))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                    queue.offer(neighbour);
            }
        }

        Collections.sort(ans);        
        return ans;
    }
    
    public static void main(String args[])
    {
        int [][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}