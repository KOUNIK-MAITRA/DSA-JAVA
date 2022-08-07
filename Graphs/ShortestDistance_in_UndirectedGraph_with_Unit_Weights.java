import java.io.*;
import java.util.*;
 class ShortestDistance_in_UndirectedGraph_with_Unit_Weights
{
 static void BFSTraversal(ArrayList<ArrayList<Integer> > adj,int[]distance,int source){
    Queue<Integer> queue=new LinkedList<>();
    queue.add(source);
    distance[source]=0;
    
    while(!queue.isEmpty()){
     int currNode=queue.poll();
     for(int neighbour : adj.get(currNode)){
         if(distance[currNode]+1<distance[neighbour])
         { distance[neighbour]=distance[currNode]+1;
           queue.add(neighbour);  
            }
        }
    }
    }   
 static int[] minDistance(ArrayList<ArrayList<Integer> > adj,int V){
   int []distance= new int[V];
   Arrays.fill(distance,Integer.MAX_VALUE);
   int source=0;
   BFSTraversal(adj,distance,source);
   return distance;
    }   
 static void addEdge(ArrayList<ArrayList<Integer> > adj,int u, int v)
  {
   adj.get(u).add(v);
   adj.get(v).add(u);
  }
 public static void main(String[] args)
 {
  
  int V = 9;
  ArrayList<ArrayList<Integer> > adj= new ArrayList<ArrayList<Integer> >(V);

  for (int i = 0; i < V; i++)
	adj.add(new ArrayList<Integer>());
  // Adding edges one by one
  addEdge(adj, 0, 1);
  addEdge(adj, 0, 3);
  addEdge(adj, 1, 2);
  addEdge(adj, 1, 3);
  addEdge(adj, 2, 6);
  addEdge(adj, 3, 4);
  addEdge(adj, 4, 5);
  addEdge(adj, 5, 6);
  addEdge(adj, 6, 7);
  addEdge(adj, 6, 8);
  addEdge(adj, 7, 8);
		      
  System.out.println(Arrays.toString(minDistance(adj,V)));		
		
  }    
 } 
