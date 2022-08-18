import java.io.*;
import java.util.*;
 class Minimum_Score_Triangulation_of_Polygon_Recursion
 {
   public static void main(String args[]){
    int values[]={1,3,1,4,1,5};
   System.out.println(minScoreTriangulation(values));
  }
  static int minScoreTriangulation(int[] values) {
        int n=values.length;
        
        return minScore(0,n-1,values);
    }
    
  static int minScore(int i, int j, int[] values)
    {
        if(i+1==j)
            return 0;
                
        int score=Integer.MAX_VALUE;
        for(int k=i+1;k<=j-1;k++)
        {
            int currScore=(values[i]*values[k]*values[j])+minScore(i,k,values)+minScore(k,j,values);
            score=Math.min(score,currScore);
        }
        return score;
    }
}
