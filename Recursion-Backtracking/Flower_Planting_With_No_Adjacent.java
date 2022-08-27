import java.io.*;
import java.util.*;
 class Flower_Planting_With_No_Adjacent
{
  public static void main(String args[]){
     int n = 3;int[][] paths = {{1,2},{2,3},{3,1}};
     System.out.println(Arrays.toString(gardenNoAdj(n,paths)));
  }
  static int[] gardenNoAdj(int n, int[][] paths)
  {
     int gardenFlower[]=new int [n+1];
     // index --> garden, gardenFlower[index]=color of the flower in that garden     
     
    HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();// create a HashMap to store all adjacent gardens
     
     for(int i=1;i<=n;i++) 
     adj.put(i,new ArrayList<>()); // initialize every garden with empty adjacent gardens 
     
    for(int path[] : paths)
    {    // since the paths are bidirectional 
         int garden_A = path[0]; 
         int garden_B = path[1];
         adj.get(garden_A).add(garden_B);
         adj.get(garden_B).add(garden_A);
     }   
     
     int ans[]=new int[n];   
        
     colorGarden(1,n,ans,adj,gardenFlower);
     return ans;   
    
    }
    
  static boolean colorGarden(int garden,int n,int[] ans,HashMap<Integer,ArrayList<Integer>> adj, int gardenFlower[])
  {
      // if we have flowered all n gardens succesfully then return true  
      if(garden==n+1) return true;  
      // try every flower of every color from 1 to 4 on this garden
      for(int color=1;color<=4;color++)
      {
        if(isPossible(color,garden,adj,gardenFlower)) 
        {
            gardenFlower[garden]=color;// mark the color of flowers of this garden
            ans[garden-1]=color;// add it to our ans 
            // check if we can color all the gardens succesfully 
            if(colorGarden(garden+1,n,ans,adj,gardenFlower)==true) 
            return true;
            else // backtracking in case we need to try different color for this garden
            {
             gardenFlower[garden]=0;
             ans[garden-1]=0;
            }
            
        }    
       
       }
        return false; // if we cannot color the garden with any of the 4 colors return false
  }
    
  static boolean isPossible (int color, int garden,HashMap<Integer,ArrayList<Integer>> adj, int gardenFlower[])
  {
        ArrayList<Integer> adjacentGardens= new ArrayList<>(); 
        adjacentGardens=adj.get(garden);// list of all adjacent gardens
        
        for(int garden_ : adjacentGardens) 
        { // if any of the adjacent gardens has already been colored with this color return false
            if(gardenFlower[garden_]==color) return false;
        }
        // if none of the adjacent gardens are colored with this color then we can successfully color this garden 
        return true;
  }
}
