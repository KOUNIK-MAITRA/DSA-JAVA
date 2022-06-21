import java.io.*;
import java.util.*;
 class GridUniquePathsObstacle_SpaceOptimization
{
   public static void main(String args[])
  { int [][]obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
    int m=obstacleGrid.length;
    int n=obstacleGrid[0].length;
    System.out.println(uniquePaths(m,n,obstacleGrid));
    }
  public static int uniquePaths(int m, int n, int obstacleGrid[][])
  { 
    
    int prev[]=new int[n];
    
    for(int i=0;i<m;i++)
    { int curr[]=new int[m];
        for(int j=0;j<n;j++)
        {
            if(obstacleGrid[i][j]==1)
             curr[j]=0;            
            else if(i==0 && j==0)
             curr[j]=1;
            else
            { 
                int up=0;
                int left=0;
               if(i>0)
                up=prev[j];
               if(j>0)
               left=curr[j-1];
               
               curr[j]=up+left;
            }            
        }
        prev=curr;
    }
     return prev[n-1];
    }
}
