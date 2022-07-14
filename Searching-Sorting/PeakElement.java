import java.io.*;
import java.util.*;
class PeakElement
{
   public static void main(String args[])
   {
       int nums[] = {1,2,3,1};
       System.out.println("peak element is found at index "+ findPeakElement(nums));
    }
   static int findPeakElement(int[] nums) {
      int low=0;
      int high=nums.length-1;
      
      while(low<high)
      {
        int mid=low+(high-low)/2;
         if(nums[mid]>nums[mid+1]) // peak is in the left half
             high=mid;
          else // peak is in the right half 
              low=mid+1;
      }
        return low;
    }
}
