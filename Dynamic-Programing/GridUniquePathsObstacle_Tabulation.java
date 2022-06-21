import java.io.*;
import java.util.*;
 class GridUniquePathsObstacle_Tabulation
{
   public static void main(String args[])
  { int [][]obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
    int m=obstacleGrid.length;
    int n=obstacleGrid[0].length;
    System.out.println(uniquePaths(m,n,obstacleGrid));
    }
  public static int uniquePaths(int m, int n, int obstacleGrid[][])
  { 
    
    int dp[][]=new int[m][n];
    
    for(int i=0;i<m;i++)
    { for(int j=0;j<n;j++)
        {
            if(obstacleGrid[i][j]==1)
             dp[i][j]=0;            
            else if(i==0 && j==0)
             dp[i][j]=1;
            else
            { 
                int up=0;
                int left=0;
               if(i>0)
                up=dp[i-1][j];
               if(j>0)
               left=dp[i][j-1];
               
               dp[i][j]=up+left;
            }            
        }
    }
     return dp[m-1][n-1];
    }
}
