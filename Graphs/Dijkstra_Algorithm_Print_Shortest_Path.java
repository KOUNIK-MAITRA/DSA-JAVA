import java.io.*;
import java.util.*;
class Dijkstra_Algorithm_Print_Shortest_Path{
    static class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int source=edge[0];
            int dest=edge[1];
            int dist=edge[2];
            adj.get(source).add(dest);
            adj.get(source).add(dist);

            adj.get(dest).add(source);
            adj.get(dest).add(dist);
        }
        System.out.println(adj);
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.distance-b.distance);
        int prev[]=new int[n+1];
        int dist[]=new int[n+1];
        for(int i=0;i<=n;i++){
            prev[i]=i;
            dist[i]=Integer.MAX_VALUE;
        }

        int source=1;
        dist[source]=0;

        pq.offer(new Pair(source,0));

        // while(!pq.isEmpty()){
            // Pair curr=pq.poll();
            // int currNode=curr.node;
            // int currDist=curr.distance;
            // for(ArrayList<Integer> neighbour: adj.get(currNode)){
                // int neighbourNode=neighbour.get(0);
                // int edgeDist=neighbour.get(1);
                // if(currDist+edgeDist<dist[neighbourNode]){
                    // dist[neighbourNode]=currDist+edgeDist;
                    // prev[neighbourNode]=currNode;
                // }
            // }
        // }

        List<Integer> ans= new ArrayList<>();
        int node=n;
        while(node!=prev[node]){
            ans.add(node);
            node=prev[node];
        }
        ans.add(node);
        Collections.reverse(ans);
        return ans;
    }
    
}

