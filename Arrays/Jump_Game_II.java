import java.io.*;
import java.util.*;
class Jump_Game_II
{
 public static void main (String args[])
 { int [] nums={1,2,1,1,1};
    System.out.println(jump(nums));
    }
 static int jump(int[] nums)
 {
        int dp[]=new int [nums.length];
        Arrays.fill(dp,-1);
        int ans= jumpUtil(nums,0,0,dp);
        for(int ele : dp)
          System.out.print(ele+ " ");
          System.out.println();
          return ans;  
    }
 static int jumpUtil(int [] nums,int curr,int steps,int [] dp)
    {
      if(nums.length<=1)
            return 0;
       
      if(curr>=nums.length)
          return Integer.MAX_VALUE;
        
      if(curr==nums.length-1)
        {  
           return steps;
        }
        
      if(nums[curr]==0 )
          return Integer.MAX_VALUE;
      
      if(dp[curr]!=-1)
         return dp[curr];
        
        int minSteps=Integer.MAX_VALUE;
      for(int i=1;i<=nums[curr];i++)
      {
           minSteps=Math.min(minSteps,jumpUtil(nums,curr+i,steps+1,dp));
      }
      
        return dp[curr]=minSteps;
    }
}
