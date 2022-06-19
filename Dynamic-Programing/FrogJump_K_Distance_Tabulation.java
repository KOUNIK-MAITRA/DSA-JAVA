import java.io.*;
import java.util.*;
 class FrogJump_K_Distance_Tabulation
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
     
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;        
        for(int i=1;i<=n;i++)
        {   int minSteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            { if(i-j>=0){
                int jump=Math.abs(heights[i]-heights[i-j])+dp[i-j];
                minSteps=Math.min(minSteps,jump);} 
            }
            dp[i]=minSteps;
        }        
         return dp[n];
    }
}
