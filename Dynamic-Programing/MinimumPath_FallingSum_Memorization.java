import java.io.*;
import java.util.*;
class MinimumPath_FallingSum_Memorization
{
   public static void main (String args[])
   {
      int matrix[][]={{2,1,3},
                      {6,5,4},
                      {7,8,9}};
       System.out.println(minFallingPathSum(matrix));               
    }
   static int minFallingPathSum(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int minSum=(int)1e9;
        
        int[][] dp=new int[rows][cols];
      
        for(int i=0;i<rows;i++)
        {for(int j=0;j<cols;j++)
                dp[i][j]=-1;
        }                                                
        
        for(int col=0;col<cols;col++)
        {
           int pathSum= minPathSum(matrix,rows-1,col,dp);
            minSum=Math.min(minSum,pathSum);
        }
        return minSum;
    }
    
   static int minPathSum(int grid[][],int row, int col,int dp[][])
    {
    if(col<0 || col>=grid[0].length)
            return (int)1e9;
    if(row==0)
          return grid[0][col];
    if(dp[row][col]!=-1)
         return dp[row][col];
        
    // if we go by the the path -> up  
      int path1=grid[row][col]+minPathSum(grid,row-1,col,dp);
    // if we go by the the path -> left diagonally up     
      int path2=grid[row][col]+minPathSum(grid,row-1,col-1,dp);
    // if we go by the the path -> right diagonally up
      int path3=grid[row][col]+minPathSum(grid,row-1,col+1,dp);
        
     return dp[row][col]=Math.min(path1,Math.min(path2,path3));   
     }
}
