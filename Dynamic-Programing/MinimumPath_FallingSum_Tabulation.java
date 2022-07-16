import java.io.*;
import java.util.*;
class MinimumPath_FallingSum_Tabulation
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
      
        for(int col=0;col<cols;col++)
        {
            dp[0][col]=matrix[0][col];
        }
        
       for(int i=1;i<rows;i++)
        {
         for(int j=0;j<cols;j++)
          {
         
          int path1=matrix[i][j]+dp[i-1][j];  
         
          int path2=matrix[i][j];
          
            if(j>0)
              path2+=dp[i-1][j-1];
            else 
              path2+=(int)1e9;   
          
          int path3=matrix[i][j]  ; 
              
           if(j<cols-1) 
            path3+=dp[i-1][j+1];
             else 
             path3+=(int)(1e9);
                                            
          dp[i][j]=Math.min(path1,Math.min(path2,path3));                                  
         }
        }  
        
      for(int j=0;j<cols;j++)
      { minSum=Math.min(minSum,dp[rows-1][j]);}
        
      return minSum;   
    }
   
       
}
