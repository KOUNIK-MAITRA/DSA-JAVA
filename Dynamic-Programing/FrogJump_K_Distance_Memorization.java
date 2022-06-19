import java.io.*;
import java.util.*;
 class FrogJump_K_Distance_Memorization
{
    public static void main (String args[])
    {
        int heights[]={10,30,40,50,20};
        int n=heights.length;
        int k=3;
        System.out.println(minimumEnergy(n-1,heights,k));
    }
    
    public static int minimumEnergy(int n, int heights[],int k)
    {
        if(n==0)
         return 0;
        int ans=Integer.MAX_VALUE;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;        
        if(dp[n]!=-1)
             return dp[n];
            else
            {
            
             for(int j=1;j<=k;j++)
              { int jump=Integer.MAX_VALUE;
                if(n-j>=0)
               { jump=Math.abs(heights[n]-heights[n-j])+minimumEnergy(n-j,heights,k);
                ans=Math.min(jump,ans);  
               }
             }
             }
        
         return dp[n]=ans;
    }
}
