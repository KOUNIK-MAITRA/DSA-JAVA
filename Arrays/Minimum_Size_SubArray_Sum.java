import java.io.*;
import java.util.*;
class Minimum_Size_SubArray_Sum
{
  public static void main(String args[])
  {
     int target = 7;
     int[] nums = {2,3,1,2,4,3};
     System.out.println(minSubArrayLen(target,nums));
  }
  static int minSubArrayLen(int target, int[] nums) {
        int sum=0; // stores currSum
        int left=0; int right=0; // left and right to mark the window
        int minLen=Integer.MAX_VALUE;
        
        while(right<nums.length)
        {
            sum+=nums[right]; // add nums[right] to sum
            
            if(sum>=target) // if our sum target then it is a valid window
            {// we have to see if we can shrink this window
                while(sum>=target)// while the window is valid we shrink it
                {
                    sum-=nums[left]; // substract the nums[left] from sum to sum of curr shrinked window
                    left++;// increment the left pointer
                }
             // Note : when we come out of the loop the window is not a valid one
             // now sum<target
             // hence the last time the window was valid when our curr left pointer was at left-1
             // hence the valid window length = right-(left-1) + 1 => right-left+2   
               minLen=Math.min(minLen,right-left+2); 
            }
           
            right++; // increment the right pointer 
        }
        return minLen==Integer.MAX_VALUE? 0 : minLen ;
    }
}
