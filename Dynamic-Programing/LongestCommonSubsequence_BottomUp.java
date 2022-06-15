import java.io.*;
import java.util.*;
 class LongestCommonSubsequence_BottomUp
{
   public static void main (String args[])
    {
        String a="ABCAB"; 
        String b="AECB";
        int m=a.length();
        int n=b.length();
        System.out.println("length of the longest subsequence is "+LCS(m,n,a,b));
    }
   public static int LCS(int m,int n,String a, String b)
    {
         int[][] dp=new int[m+1][n+1];
            int ans =LCSutil(m,n,a,b,dp);
            return ans;
    }
   public static int LCSutil(int m, int n, String a, String b,int dp[][])
    {
       for(int i=1;i<=m;i++)
       {for(int j=1;j<=n;j++)
           { if(a.charAt(i-1)==b.charAt(j-1))
               dp[i][j]=1+dp[i-1][j-1];
               else
               dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}
