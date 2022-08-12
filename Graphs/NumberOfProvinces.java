import java.io.*;
import java.util.*; 
class NumberOfProvinces
{
  public static void main(String args[]){
      int [][] isConnected={{1,1,0},{1,1,0},{0,0,1}};
      System.out.println(findCircleNum(isConnected));
  }
  static int findCircleNum(int[][] isConnected) {
      ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        int n=isConnected.length;
        int m=isConnected[0].length;
        int V=n;
       
        for(int i=0;i<=n;i++)
          adj.add(new ArrayList<Integer>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

              int vertex1=i+1;
              int vertex2=j+1;
              
            if(isConnected[i][j]==1 && i!=j)
              adj.get(vertex1).add(vertex2);   
          }
        }
        
        boolean visited[]=new boolean[n+1];
        int count=0;
        for(int i=1;i<=V;i++){
            if(visited[i]==false)
            {   count++;
                DFStraversal(adj,i,visited);   
            }
        }
        
        return count;
        
    }
    
  static void DFStraversal(ArrayList<ArrayList<Integer>> adj,int node, boolean[]visited){
        visited[node]=true;
        
        for(int neighbour : adj.get(node)){
            if(visited[neighbour]==false)
              DFStraversal(adj,neighbour,visited);  
        }
    }
}
