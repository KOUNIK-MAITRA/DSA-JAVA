import java.io.*;
import java.util.*;
 class GridUniquePaths_Memorization
{
    public static void main(String args[])
    {
        int m=3;
        int n=2;
        System.out.println(uniquePaths(m,n));
    }
    
    public static int uniquePaths(int m, int n)
    {
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++)
        { for(int j=0;j<n;j++)
            dp[i][j]=-1;
        }
        return uniquePathsUtility(m-1,n-1,dp);
    }
    
     public static int uniquePathsUtility(int m,int n,int[][]dp)
    {
        if(m==0 && n==0)
         return 1;
        
        if(m<0 || n<0)
         return 0;
         
         if(dp[m][n]!=-1)
         return dp[m][n];
         
         int temp1=uniquePathsUtility(m-1,n,dp);
         int temp2=uniquePathsUtility(m,n-1,dp);
         
         return dp[m][n]=temp1+temp2;
    }
}
