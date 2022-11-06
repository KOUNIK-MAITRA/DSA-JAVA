import java.io.*;
import java.util.*;
class  Find_Eventual_Safe_States_CycleDetection_Method_DFS
{
    static List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int V=graph.length;
        boolean visited[]=new boolean[V];
        boolean DFSvisited[]=new boolean[V];
        boolean isSafe[]=new boolean[V];
        List<Integer> safeNodes=new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                CycleDFS(i,graph,visited,DFSvisited,isSafe);
            }
        }

        for(int i=0;i<V;i++)
        {
            if(isSafe[i])
                safeNodes.add(i);
        }

        return safeNodes;
    }

    static boolean CycleDFS(int curr,int[][]graph, boolean[] visited, boolean[]DFSvisited,boolean[] isSafe)
    {
        visited[curr]=true;
        DFSvisited[curr]=true;
        isSafe[curr]=false;

        for(int neighbour:graph[curr])
        {
            if(!visited[neighbour])
            {
                // cycle found
                // neighbour is attached to a node which is part of a cycle
                if(CycleDFS(neighbour,graph,visited,DFSvisited,isSafe))
                {
                    isSafe[neighbour]=false;
                    return true;
                }
            }

            // cycle found
            // the node neighbour is part of a cycle itself
            else if(DFSvisited[neighbour])
            {
                isSafe[neighbour]=false;
                return true;
            }
        }

        // cycle was not found
        isSafe[curr]=true;
        DFSvisited[curr]=false;
        return false;
    }
    
    public static void main(String args[])
    {
        int [][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}