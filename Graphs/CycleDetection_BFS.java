import java.io.*;
import java.util.*;
class CycleDetection_BFS
{
    static class Node
    {
        int curr;
        int prev;
         Node(int curr, int prev)
        {
            this.curr=curr;
            this.prev=prev;
        }
    }
    public static void main (String args[])
    {
        int V=5;
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        
        for(int i=0;i<=V;i++)
        { adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,1,2);
        addEdge(adj,1,5);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,2,5);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        System.out.println(BFS_detectCycle( V,adj));
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited)
    { 
        Queue <Node> q=new LinkedList<>(); // make a queue ds to traverse using bfs
        q.add(new Node(i,-1));// make a node add the currNode and make its prev as -1
        visited[i]=true;// mark the node visited
        
        while(!q.isEmpty()) 
        {
            Node node=q.poll(); // remove the top element
           
            for(int ele : adj.get(node.curr)) //check for every element in the adjacency  list
            {
                if(visited[ele]==false) // if the nod is not already visited
                { visited[ele]=true; // mark it as visited
                  q.add(new Node (ele,node.curr)); //add the element to the queue
                }
                else if(node.prev!=ele) // if the node is visited check if it is the previous node if not cycle detected
                  return true;
            }
        }
        
        return false;
    }
    static boolean BFS_detectCycle(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[]=new boolean[V+1];// make a visited array
        Arrays.fill(visited,false);
        
        for(int i=1;i<=V;i++) // check for every vertex
        {
            if(visited[i]==false) // if the vertex is not already visited
            {
                if(isCycle(adj,i,visited)) //if the cycle is present 
                 return true;
            }
        }
        return false;
    }
}