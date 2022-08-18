import java.io.*;
import java.util.*;
 class Minimum_Score_Triangulation_of_Polygon_Memorization
{
  public static void main(String args[]){
   int values[]={1,3,1,4,1,5};
   System.out.println(minScoreTriangulation(values));
  }
  static int minScoreTriangulation(int[] values) {
        int n=values.length;
        int dp[][]=new int[n][n];
        for(int arr[]:dp)
            Arrays.fill(arr,-1);
        return minScore(0,n-1,values,dp);
    }
    
  static int minScore(int i, int j, int[] values,int[][]dp)
    {
        if(i+1==j)
            return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        
        int score=Integer.MAX_VALUE;
        for(int k=i+1;k<=j-1;k++)
        {
            int currScore=(values[i]*values[k]*values[j])+minScore(i,k,values,dp)+minScore(k,j,values,dp);
            score=Math.min(score,currScore);
        }
        return dp[i][j]=score;
    }
}
