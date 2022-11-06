import java.io.*;
import java.util.*;
class Bipartite_Graphs_BFS
{
    static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj,int currNode, int[]color){
        color[currNode]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(currNode);
        while(!q.isEmpty()){
            int parent=q.poll();
            for(int neighbour: adj.get(parent)){
                if(color[neighbour]==-1)
                { color[neighbour]=1-color[parent];
                    q.add(neighbour);}
                else if(color[neighbour]==color[parent])
                    return false;
            }
        }
        return true;
    }

    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj,int V){
        int color[]=new int[V];
        Arrays.fill(color,-1);

        for(int i=0;i<V;i++)
        { int currNode=i;
            if(color[currNode]==-1){
                if(!bfsCheck(adj,currNode,color))
                    return false;
            }
        }
        return  true;
    }  

    public static void main(String args[]){
        int V=7;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,3,0);

        System.out.println(isBipartite(adj,V));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    } 
}
