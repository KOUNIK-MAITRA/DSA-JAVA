import java.io.*;
import java.util.*;
class FrogJump_Tabulation
{
    public static void main(String args[])
    {
        int n=8;
        int []heights={7, 4, 4, 2, 6, 6, 3, 4 };
       
        System.out.println(minimumEnergy(n-1,heights));
    }
    public static int minimumEnergy(int n,int heights[])
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        
        for(int i=1;i<=n;i++)
         {
             int oneJump=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
             int twoJump=Integer.MAX_VALUE;
             if(i>1)
               twoJump=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
             
             dp[i]=Math.min(oneJump,twoJump);
        }
        return dp[n];
    }
}