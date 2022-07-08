import java.io.*;
import java.util.*;
 class Jump_game_Memorization
{
   public static void main(String args[])
   { 
       int nums[]={3,2,1,0,4};
       System.out.println(canJump(nums));
    }
    static boolean canJump(int[] nums) 
   {        
        boolean dp[]=new boolean [nums.length];
        Arrays.fill(dp,false);
         return canJumpUtil(nums,0,dp);
        
    }
   static boolean canJumpUtil(int [] nums,int curr,boolean [] dp)
    {
        if(nums[curr]==0)
         return false;
         
        if(curr>=nums.length-1)
         return true;
        
         if(dp[curr]==true)
          return dp[curr];
         
         boolean ans=false;
         
        for(int i=1;i<=nums[curr];i++)
        {
            ans=canJumpUtil(nums,curr+i,dp);
            if(ans==true)
            break;
        }
        if(ans==true)
        return dp[curr]=true;
        else
        return dp[curr]=false;
    }
}
