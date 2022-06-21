import java.io.*;
import java.util.*;
 class GridUniquePathsObstacle_Memorization
{
   public static void main(String args[])
  { int [][]obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
    int m=obstacleGrid.length;
    int n=obstacleGrid[0].length;
    int dp[][]=new int[m][n];
    for(int i=0;i<m;i++)
    { for(int j=0;j<n;j++)
        dp[i][j]=-1;
    }
    System.out.println(uniquePaths(m-1,n-1,obstacleGrid,dp));
    }
  public static int uniquePaths(int i, int j, int obstacleGrid[][],int[][]dp)
  { 
      if(i>=0 && j>=0 && obstacleGrid[i][j]==1)
      return 0;
      if(i==0 && j==0)
       return 1;
       
       if(i<0 || j<0)
        return 0;
       
        if(dp[i][j]!=-1)
        return dp[i][j];
        
        int up=uniquePaths(i-1,j,obstacleGrid,dp);
        int left=uniquePaths(i,j-1,obstacleGrid,dp);
        
        return dp[i][j]=up+left;
    }
}
