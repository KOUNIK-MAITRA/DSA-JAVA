import java.io.*;
import java.util.*; 
class Shortest_Path_in_Directed_Acyclic_Graph
{
    static class Pair
    {
        int node;
        int distance;
        Pair(int node,int distance)
        {
            this.node=node;
            this.distance=distance;
        }
    }

    static int[] shortestPath(int N,int M, int[][] edges) 
    {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<N;i++)
            adj.add(new ArrayList<Pair>());

        for(int[] edge : edges)
        {
            int parent=edge[0];
            int child=edge[1];
            int distance=edge[2];

            adj.get(parent).add(new Pair(child,distance));
        }

        boolean[] visited=new boolean[N];
        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<N;i++)
        {
            if(!visited[i])
            {
                TopoSort_DFS(i,adj,visited,stack); 
            }
        }

        int[] dist=new int[N];
        Arrays.fill(dist,(int)(1e9));
        int src=0;
        dist[src]=0;

        while(!stack.isEmpty())
        {
            int curr=stack.pop();
            for(Pair neighbour: adj.get(curr))
            {
                int node=neighbour.node;
                dist[node]=Math.min(dist[node],dist[curr]+neighbour.distance);
            }
        }

        for(int i=0;i<N;i++)
        {
            if(dist[i]==(int)(1e9))
                dist[i]=-1;
        }

        return dist;
    }

    static void TopoSort_DFS(int node,ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stack)
    {
        visited[node]=true;

        for(Pair neighbour : adj.get(node))
        {
            if(!visited[neighbour.node]){
                TopoSort_DFS(neighbour.node,adj,visited,stack);
            }
        }

        stack.push(node);
    }

    public static void main(String args[])
    {
        int n=6;
        int m=7;
        int [][]edge={{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        System.out.println(Arrays.toString(shortestPath(n,m,edge)));
    }
}
