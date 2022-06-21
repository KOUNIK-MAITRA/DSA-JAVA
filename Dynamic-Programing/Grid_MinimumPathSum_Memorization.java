import java.io.*;
import java.util.*;
 class Grid_MinimumPathSum_Memorization
{
 public static void main(String args[])
    { int grid[][]={{5,9,6},{11,5,2}};
      int m=grid.length;
      int n=grid[0].length;
      int dp[][]=new int[m][n];
      for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++)
           dp[i][j]=-1;
        }
      System.out.println(minimumSum(m-1,n-1,grid,dp));
    }
 public static int minimumSum(int i, int j,int grid[][],int dp[][])
    {
        if(i==0 && j==0)
         return grid[i][j];
         
        if(i<0 || j<0)
        return 10000000;
        
        if(dp[i][j]!=-1)
         return dp[i][j];
        
        int up=grid[i][j]+minimumSum(i-1,j,grid,dp);
        int left=grid[i][j]+minimumSum(i,j-1,grid,dp);
        
        return dp[i][j]=Math.min(up,left);
    }
}
