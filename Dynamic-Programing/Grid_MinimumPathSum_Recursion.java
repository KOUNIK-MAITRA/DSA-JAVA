import java.io.*;
import java.util.*;
class Grid_MinimumPathSum_Recursion
{
 public static void main(String args[])
    { int grid[][]={{5,9,6},{11,5,2}};
      int m=grid.length;
      int n=grid[0].length;
      System.out.println(minimumSum(m-1,n-1,grid));
    }
 public static int minimumSum(int i, int j,int grid[][])
    {
        if(i==0 && j==0)
         return grid[i][j];
         
        if(i<0 || j<0)
        return 10000000;
        
        int up=grid[i][j]+minimumSum(i-1,j,grid);
        int left=grid[i][j]+minimumSum(i,j-1,grid);
        
        return Math.min(up,left);
    }
}
