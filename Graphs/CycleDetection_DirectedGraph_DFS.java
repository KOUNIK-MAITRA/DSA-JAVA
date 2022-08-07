import java.io.*;
import java.util.*;
 class CycleDetection_DirectedGraph_DFS
{static void addDirectedEdge(ArrayList<ArrayList<Integer> > adj,int u, int v)
  {
    adj.get(u).add(v);
  }
 public static void main(String args[]){
    int V=4;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<V;i++)
    { adj.add(new ArrayList<Integer>());
    }
    addDirectedEdge(adj,0,1);
    addDirectedEdge(adj,0,2);
    addDirectedEdge(adj,1,2);
    addDirectedEdge(adj,2,0);
    addDirectedEdge(adj,2,3);
    addDirectedEdge(adj,3,3);
    
    System.out.println(isCycle(adj,V));
    }  
 static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj,int currNode, boolean[]visited,boolean[]dfsVisited)
 {  
    visited[currNode]=true;
    dfsVisited[currNode]=true;
    int parent=currNode;
    for(int neighbour : adj.get(parent)){
     if(visited[neighbour]==false)
      return dfsCheck(adj,neighbour,visited,dfsVisited);
      else if (dfsVisited[neighbour]==true)
      return true;      
    }
    dfsVisited[currNode]=false;
     return false;
  }
 static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int V){
     boolean[]visited=new boolean[V+1];
     boolean[]dfsVisited=new boolean[V+1];
     for(int i=1;i<=V;i++)
     { int currNode=i;
       if(visited[currNode]==false){
        if(dfsCheck(adj,currNode,visited,dfsVisited))
         return true;
        }
        }
     return false;
    }   
}
