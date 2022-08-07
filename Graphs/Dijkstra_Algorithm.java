import java.io.*;
import java.util.*; 
 class Dijkstra_Algorithm
{
  static class Pair implements Comparator<Pair>{
    int node;
    int distance;
    Pair(){
    }
    Pair(int node, int distance)
    {
        this.node=node;
        this.distance=distance;
    }
    
    @Override
    public int compare(Pair node1 ,Pair node2){
     if(node1.distance<node2.distance)
     return -1;
     if(node1.distance>node2.distance)
     return 1;
     
     return 0;
    }
  }
  static int[] shortestPath(ArrayList<ArrayList<Pair>> adj,int V,int source){
      int[]distance=new int[V];
      Arrays.fill(distance,Integer.MAX_VALUE);
      PriorityQueue<Pair> pq=new PriorityQueue<Pair>(V,new Pair());
      distance[source]=0;
      pq.add(new Pair(source,0));
      while(!pq.isEmpty()){
       Pair currNode=pq.poll();
       for(Pair neighbour : adj.get(currNode.node))
       { if(distance[currNode.node]+neighbour.distance < distance[neighbour.node])
          { distance[neighbour.node]=distance[currNode.node]+neighbour.distance;
           pq.add(new Pair(neighbour.node,distance[neighbour.node]));}
        }
        }
      return distance;
  } 
  static void addEdge(ArrayList<ArrayList<Pair>> adj,int u, int v, int distance)
  { adj.get(u).add(new Pair(v,distance));
    adj.get(v).add(new Pair(u,distance));  
    }
  public static void main(String args[]){
   int V=5;
   ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
   for(int i=0;i<V;i++){
     adj.add(new ArrayList<Pair>());
    }
     addEdge(adj,0,1,2);
     addEdge(adj,1,2,4);
     addEdge(adj,0,3,1);
     addEdge(adj,3,2,3);
     addEdge(adj,1,4,5);
     addEdge(adj,2,4,1);

     System.out.println(Arrays.toString(shortestPath(adj,V,0)));
    }
   
}
