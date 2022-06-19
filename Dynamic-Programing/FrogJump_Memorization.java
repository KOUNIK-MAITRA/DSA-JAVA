import java.io.*;
import java.util.*;
class FrogJump_Memorization
{
    public static void main(String args[])
    {
        int n=8;
        int []heights={7, 4, 4, 2, 6, 6, 3, 4 };
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(minimumEnergy(n-1,heights,dp));
    }
    public static int minimumEnergy(int n,int heights[],int dp[])
    {
        if(n==0)
         return 0;
        
        if(dp[n]!=-1)
          return dp[n];
          
        int twoStepJump=Integer.MAX_VALUE;
        int oneStepJump=Math.abs(heights[n]-heights[n-1])+minimumEnergy(n-1,heights,dp);
        if(n>1)
        {
            twoStepJump=Math.abs(heights[n]-heights[n-2])+minimumEnergy(n-2,heights,dp);
        }
        
        return dp[n]=Math.min(oneStepJump,twoStepJump);
    }
}