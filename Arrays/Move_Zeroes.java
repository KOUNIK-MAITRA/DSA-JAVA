import java.io.*;
import java.util.*;
 class Move_Zeroes
{
   public static void main(String args[])
   { 
       int [] nums={0,1,0,3,12};
       moveZeroes(nums);
       for(int ele : nums)
       System.out.print(ele+" ");
    }
   static void moveZeroes(int[] nums) {
        
        int lastZerofoundAt=0;
        
        for(int curr=0;curr<nums.length;curr++)
        {
            if(nums[curr]!=0)
            {
                int temp= nums[lastZerofoundAt];
                nums[lastZerofoundAt]=nums[curr];
                nums[curr]=temp;
                lastZerofoundAt++;
            }
        }
        
        
    } 
}
