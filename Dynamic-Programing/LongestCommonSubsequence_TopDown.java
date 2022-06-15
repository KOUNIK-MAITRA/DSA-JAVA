import java.io.*;
import java.util.*;
class LongestCommonSubsequence_TopDown
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
         for(int i=1;i<=m;i++)
           { for(int j=1;j<=n;j++)
               { dp[i][j]=-1;
                }
            }
          
            int ans =LCSutil(m,n,a,b,dp);
            return ans;
    }
    public static int LCSutil(int m, int n, String a, String b,int dp[][])
    {
        if(m==0 ||n==0)
         return 0;
         
        if(dp[m][n]!=-1)
        { return dp[m][n];
        }
        
        if(a.charAt(m-1)==b.charAt(n-1))
         return dp[m][n]=1+LCSutil(m-1,n-1,a,b,dp);
         else
         return dp[m][n]=Math.max(LCSutil(m-1,n,a,b,dp),LCSutil(m,n-1,a,b,dp));
    }
}
