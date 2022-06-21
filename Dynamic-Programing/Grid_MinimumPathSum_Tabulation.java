import java.io.*;
import java.util.*;
 class Grid_MinimumPathSum_Tabulation
{
 public static void main(String args[])
    { int grid[][]={{5,9,6},{11,5,2}};
      int m=grid.length;
      int n=grid[0].length;
     
      System.out.println(minimumSum(m,n,grid));
    }
 public static int minimumSum(int m, int n,int grid[][])
    {
        int dp[][]=new int[m][n];
      for(int i=0; i<m ; i++){
        for(int j=0; j<n; j++){
            if(i==0 && j==0) dp[i][j] = grid[i][j];
            else{
                
                int up = grid[i][j];
                if(i>0)
                 up += dp[i-1][j];
                else 
                  up += (int)Math.pow(10,9);
                
                int left = grid[i][j];
                if(j>0)
                 left+=dp[i][j-1];
                else 
                 left += (int)Math.pow(10,9);
                
                dp[i][j] = Math.min(up,left);
            }
        }
    }
        
        return dp[m-1][n-1];
    }
}
