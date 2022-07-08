import java.io.*;
import java.util.*;
 class Jump_Game_Recursion
{
    public static void main(String args[])
   { 
       int nums[]={3,2,1,0,4};
       System.out.println(canJump(nums));
    }
   static boolean canJump(int[] nums) 
   {
       if(nums.length==0)
        return true;
       
      
        return canJumpUtil(nums,0);
    }
   static boolean canJumpUtil(int [] nums,int curr)
    {
        if(nums[curr]==0)
         return false;
         
        if(curr>=nums.length-1)
         return true;
        
         boolean ans=false;
         
        for(int i=1;i<=nums[curr];i++)
        {
            ans=canJumpUtil(nums,curr+i);
            if(ans==true)
            break;
        }
        if(ans==true)
        return true;
        else
        return false;
    }
}
