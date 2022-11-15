import java.io.*;
import java.util.*;
class Dijkstras_Algorithm_PriorityQueue
{
    static class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        int distance[]=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new Pair(src,0));
        distance[src]=0;

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int currNode=curr.node;
            int currDistance=curr.distance;

            for(ArrayList<Integer> neighbour : adj.get(currNode)){
                int neighbourNode=neighbour.get(0);
                int neighbourDistance=neighbour.get(1);
                if(currDistance+neighbourDistance<distance[neighbourNode]){
                    distance[neighbourNode]=currDistance+neighbourDistance;
                    pq.offer(new Pair(neighbourNode,distance[neighbourNode]));
                }
            }
        }
        return distance;
    }
}