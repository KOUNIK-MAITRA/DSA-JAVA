import java.io.*;
import java.util.*;
 class NetworkDelay
{
 static class Node implements Comparator<Node>{
        int node;
        int time;
      Node(){
        }
      Node (int node, int time){
          this.node=node;
          this.time=time;
        }
      @Override 
         public int compare(Node node1 ,Node node2){
         if(node1.time<node2.time)
         return -1;
         if(node1.time>node2.time)
         return 1;

         return 0;
        }
        
    }
 static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
         adj.add(new ArrayList<>());
        
        for(int i=0;i<times.length;i++){
         int source =times[i][0];
          int target=times[i][1];
          int time=times[i][2];
          adj.get(source).add(new Node(target,time));  
        }
        
        int timeTaken[]=new int[n+1];
        Arrays.fill(timeTaken,Integer.MAX_VALUE);
        timeTaken[k]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        
        pq.add(new Node(k,0));
        
        while(!pq.isEmpty()){
            Node currNode=pq.poll();
            
            for(Node neighbour : adj.get(currNode.node)){
                if(timeTaken[currNode.node]+neighbour.time<timeTaken[neighbour.node])
                { timeTaken[neighbour.node]=timeTaken[currNode.node]+neighbour.time;
                  pq.add(new Node(neighbour.node,timeTaken[neighbour.node]));
                }
            }
        }
        int maxTime=0;
        for(int i=1;i<=n;i++)
        {
            if(timeTaken[i]==Integer.MAX_VALUE)
                return -1;
            maxTime=Math.max(maxTime,timeTaken[i]);
        }
        
        return maxTime;
        
    }   
 public static void main(String args[]){
     int times[][]={{2,1,1},{2,3,1},{3,4,1}};
     int n=4;
     int k=2;
     
     System.out.println(networkDelayTime(times,n,k));
  }
}
