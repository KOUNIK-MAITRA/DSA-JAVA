import java.io.*;
import java.util.*;
 class Prims_Algoritmn_Minimum_Spanning_Tree
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
   static void PrimAlgo_MST(ArrayList<ArrayList<Pair>> adj, int V){
   int N=V;
   int edges=N-1;
   
   int []key=new int [N];
   int []parent=new int[N];
   boolean [] MST= new boolean[N];
   
   Arrays.fill(key,Integer.MAX_VALUE);
   Arrays.fill(parent,-1);
   
   key[0]=0;
   PriorityQueue<Pair> pq=new PriorityQueue<>(new Pair());
   pq.add(new Pair(0,key[0]));
    for(int i=0;i<edges;i++){
         int currNode=pq.poll().node;
     
         MST[currNode]=true;
        for(Pair neighbour : adj.get(currNode)){
          if(neighbour.distance<key[neighbour.node]){ 
             key[neighbour.node]=neighbour.distance;
             pq.add(new Pair(neighbour.node,neighbour.distance));
             parent[neighbour.node]=currNode;
            }       
        }       
    }
   for(int i=1;i<N;i++){
    System.out.println(parent[i]+"--->"+i);
    }
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
     addEdge(adj,1,2,3);
     addEdge(adj,0,3,6);
     addEdge(adj,3,1,8);
     addEdge(adj,1,4,5);
     addEdge(adj,2,4,7);

     PrimAlgo_MST(adj,V);
    } 
}
