import java.io.*;
import java.util.*;
class TopologicalSort_BFS_Kahn_Algorithm
{
     
  static void bfsTopoSort(ArrayList<ArrayList<Integer>> adj,int V,ArrayList<Integer> topo_sorted,int []inDegree){
      Queue<Integer> queue=new LinkedList<>();
      for(int vertex=0;vertex<V;vertex++)
      { if(inDegree[vertex]==0)
          queue.add(vertex);
        }
      
      while(!queue.isEmpty()){
        int node=queue.poll();
        topo_sorted.add(node);
        for(int neighbour : adj.get(node)){
         inDegree[neighbour]--;
         if(inDegree[neighbour]==0)
          queue.add(neighbour);
        }
       }  
    }
  static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj,int V){
      ArrayList<Integer> topo_sorted=new ArrayList<>();
      int []inDegree=new int[V];
      for(int vertex=0;vertex<V;vertex++)
        {for(int node : adj.get(vertex))
           inDegree[node]++;
         } 
      bfsTopoSort(adj,V,topo_sorted,inDegree) ;
      return topo_sorted;
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
      
      System.out.println(topologicalSort(adj,V));
        }
} 


