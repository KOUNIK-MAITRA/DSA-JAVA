// topological sort using kahn's algorithmn is only for directed acyclic graphs
// i.e if we can't generate a topological sort then that means the graph is acyclic
// if topological sort works correctly then no.of nodes in the sorted list = V (no.of vertexes) if not then a cycle must be present
import java.io.*;
import java.util.*;
 class CycleDetection_DirectedGraph_BFS_Kahn_Algorithm
{
  static boolean topoSort(ArrayList<ArrayList<Integer>> adj, int V, int[]inDegree){
    int totalNodes=0;
    Queue<Integer> queue=new LinkedList<>();
    for(int node=0;node<V;node++)
    { if(inDegree[node]==0)
        queue.add(node);
    }
    
    while(!queue.isEmpty()){
     int currNode=queue.poll();
     totalNodes++;
     for(int neighbour : adj.get(currNode))
     { inDegree[neighbour]--;
         if(inDegree[neighbour]==0)
          queue.add(neighbour);
        }
    }
    return  (totalNodes==V);
    } 
  static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V){
      int []inDegree=new int[V];
      for(int vertex=0;vertex<V;vertex++){
        for(int node : adj.get(vertex))
         inDegree[node]++;
        }

      return !(topoSort( adj,V,inDegree));
    }
  static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
      adj.get(u).add(v);
     } 
  public static void main(String args[]){
      int V=4;
      ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
      for(int i=0;i<V;i++)
       adj.add(new ArrayList<Integer>()); 
      
    addDirectedEdge(adj,0,1);
    addDirectedEdge(adj,0,2);
    addDirectedEdge(adj,1,2);
    addDirectedEdge(adj,2,0);
    addDirectedEdge(adj,2,3);
    addDirectedEdge(adj,3,3);
      
      System.out.println(isCycle(adj,V));
        }  
}
