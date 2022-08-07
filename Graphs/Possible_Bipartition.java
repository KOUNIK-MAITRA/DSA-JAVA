
// if the graph is bipartite then its possible else not
import java.io.*;
import java.util.*;
 class Possible_Bipartition
{
  public static void main(String args[]){
    int n=4;
    int[][] dislikes={{1,2},{1,3},{2,4}};
    System.out.println(possibleBipartition(n,dislikes));
  }
  static public boolean possibleBipartition(int n, int[][] dislikes) {
       ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        
        
        for(int i=0;i<=n;i++)
          adj.add(new ArrayList<>());
        
        for(int i=0;i<dislikes.length;i++){
           int person1=dislikes[i][0];
            int person2=dislikes[i][1];
            
            adj.get(person1).add(person2);
            adj.get(person2).add(person1);
        }
        
        //group 1 and group 0
        
        int group[]=new int[n+1];
        Arrays.fill(group,-1);
        
        for(int i=1;i<=n;i++){
            int currPerson=i;
            if(isBipartite(adj,group,currPerson)==false)
                return false;
        }
      return true;
    }
    
   static boolean isBipartite(ArrayList<ArrayList<Integer>> adj,int[]group,int currPerson){
        if(group[currPerson]==-1)
            group[currPerson]=1;
        
        for(int hater : adj.get(currPerson)){
            if(group[hater]==-1){
                group[hater]=1-group[currPerson];
                if(isBipartite(adj,group,hater)==false)
                    return false;
            }
            else if (group[hater]==group[currPerson])
                return false;
        }
        return true;
    }  
}
