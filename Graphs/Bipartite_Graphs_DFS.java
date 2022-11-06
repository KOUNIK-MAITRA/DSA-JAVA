import java.io.*;
import java.util.*;
class Bipartite_Graphs_DFS
{
    static boolean dfsCheck(ArrayList<ArrayList<Integer>> adj,int currNode, int[]color){
        if(color[currNode]==-1)
            color[currNode]=1;

        int parent =currNode;
        for(int neighbour:adj.get(parent)){
            if(color[neighbour]==-1)
            { color[neighbour]=1-color[parent];
                if(!dfsCheck(adj,neighbour,color)){
                    return false;
                }
            }
            else if(color[neighbour]==color[parent])
                return false;
        }
        return true;
    }

    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj,int V){
        int [] color=new int[V];
        Arrays.fill(color,-1);

        for(int i=0;i<V;i++){
            int currNode=i;
            if(!dfsCheck(adj,currNode,color))
                return false;

        }
        return true;
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
