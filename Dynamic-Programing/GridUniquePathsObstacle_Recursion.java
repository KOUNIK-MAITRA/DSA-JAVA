import java.io.*;
import java.util.*;
 class GridUniquePathsObstacle_Recursion
{
   public static void main(String args[])
  { int [][]obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
    int m=obstacleGrid.length;
    int n=obstacleGrid[0].length;
    System.out.println(uniquePaths(m-1,n-1,obstacleGrid));
    }
  public static int uniquePaths(int i, int j, int obstacleGrid[][])
  { 
      if(i>=0 && j>=0 && obstacleGrid[i][j]==1)
      return 0;
      if(i==0 && j==0)
       return 1;
       
       if(i<0 || j<0)
        return 0;
       
        int up=uniquePaths(i-1,j,obstacleGrid);
        int left=uniquePaths(i,j-1,obstacleGrid);
        
        return up+left;
    }
}
