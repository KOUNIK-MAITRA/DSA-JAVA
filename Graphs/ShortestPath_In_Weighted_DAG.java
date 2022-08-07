import java.io.*;
import java.util.*;
 class ShortestPath_In_Weighted_DAG
{
  static void topoSortDFS(ArrayList<ArrayList<Pair>> adj,int node,boolean[] visited,Stack stack){
      visited[node]=true;
      for(Pair neighbour : adj.get(node)){
          if(visited[neighbour.node]==false)
          {topoSortDFS(adj,neighbour.node,visited,stack);}
        }
      stack.push(node);  
    }  
  static int[] minDistance(ArrayList<ArrayList<Pair>> adj,int V,int source){
      Stack<Integer> stack= new Stack<>();
      int []distance=new int[V];
      Arrays.fill(distance,Integer.MAX_VALUE);
      distance[source]=0;
      boolean visited[]=new boolean [V];
      for(int i=0;i<V;i++){
          int currNode=i;
          if(visited[currNode]==false){
             topoSortDFS(adj,currNode,visited,stack);
            }
        }
      while (!stack.isEmpty()){
        int currNode=stack.pop();
        if(distance[currNode]!=Integer.MAX_VALUE){
        for(Pair neighbour :adj.get(currNode)){
         
            if(distance[currNode]+neighbour.distance<distance[neighbour.node])
            {distance[neighbour.node]=distance[currNode]+neighbour.distance;
            }
          
        }
       } 
        } 
       return distance;
     }  
  static void addEdge(ArrayList<ArrayList<Pair>> adj,int u,int v , int distance)
  { adj.get(u).add(new Pair(v,distance));
     }  
  public static void main(String args[]){
      int V=6;
      ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
      for(int i=0;i<V;i++){
        adj.add(new ArrayList<Pair>());
        }
       addEdge(adj,0,1,2);
       addEdge(adj,0,4,1);
       addEdge(adj,1,2,3);
       addEdge(adj,2,3,6);
       addEdge(adj,4,2,2);
       addEdge(adj,4,5,4);
       addEdge(adj,5,3,1);
       
       int source =0 ;
       System.out.println(Arrays.toString(minDistance(adj,V,source)));
     }  
  static class Pair
  {
   int node;
   int distance;
   Pair(int node, int distance)
   { this.node=node;
     this.distance=distance;  
    } 
  }
}
