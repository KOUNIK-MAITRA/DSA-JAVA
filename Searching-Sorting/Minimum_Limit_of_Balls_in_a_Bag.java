import java.io.*;
import java.util.*;
 class Minimum_Limit_of_Balls_in_a_Bag
{
  public static void main(String args[])
  {
     int[]nums = {2,4,8,2};
     int maxOperations = 4;
     System.out.println(minimumSize(nums,maxOperations));
  }
  static int minimumSize(int[] nums, int maxOperations)
  { 
      Arrays.sort(nums);
      int res=0;  
      int low=1;
      int high=nums[nums.length-1];
      // we will check if what could be the max number as penalty using binary search  
      while(low<=high)
      {
          int mid=(low+high)/2;
          // check  if it is possible to achieve this maxNumber in maxOperations
          if(isPossible(nums,mid,maxOperations)) //if it is possible
          {
             res=mid;// this might be our probable ans
             high=mid-1; // try to minimize it 
          }
          else // try for a greater maxNumber
          {
              low=mid+1;
          }
      }
      return res;
  }    
  static boolean isPossible(int nums[], int maxNumber, int maxOperations)
  {
        int currOperations=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>maxNumber)
            {
                //important check
                if(nums[i]%maxNumber==0)
                currOperations+=nums[i]/maxNumber -1;
                else
                currOperations+=nums[i]/maxNumber;     
            }
            
            if(currOperations>maxOperations) return false;
        }
        return true;
   }
}
