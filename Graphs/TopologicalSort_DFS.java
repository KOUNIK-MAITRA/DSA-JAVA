import java.io.*;
import java.util.*;
class TopologicalSort_DFS
{
  static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
      adj.get(u).add(v);
    }   
  static void dfs(ArrayList<ArrayList<Integer>> adj,int currNode,boolean[]visited,Stack<Integer> stack){
     visited[currNode]=true;
     int parent=currNode;
     for(int neighbour : adj.get(parent)){
         if(visited[neighbour]==false)
          dfs(adj,neighbour,visited,stack);
        }
     stack.push(currNode);   
    }  
  static int[] topologicalSort(ArrayList<ArrayList<Integer>> adj,int V){
      int []topo_sorted=new int [V];
      boolean visited[]=new boolean[V];
      Stack<Integer> stack=new Stack<>();
      for(int i=0;i<V;i++)
      { if(visited[i]==false)
          dfs(adj,i,visited,stack);
        }
      for(int i=0;i<V;i++){
        topo_sorted[i]=stack.pop();
        }
      return topo_sorted;
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
      
      System.out.println(Arrays.toString(topologicalSort(adj,V)));
        }
} 

