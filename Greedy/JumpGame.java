import java.io.*;
import java.util.*;
class JumpGame
{
 public static void main (String args[]){
   int nums[]={2,3,1,1,4};
   System.out.println(canJump(nums));
 } 
 static boolean canJump(int[] nums) {
        
        if(nums.length==1)
        return true;
        
        if(nums[0]==0)
            return false;
        
        boolean zeroPresent=false;
        for(int ele : nums)
        {
            if(ele==0)
                zeroPresent=true;
        }
        
        if(zeroPresent==false)
            return true;
        
        int reachable=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>reachable)
                return false;
            reachable=Math.max(reachable,(i+nums[i]));
           
        }
        
        return true;
    }
}
