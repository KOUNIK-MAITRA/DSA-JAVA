import java.io.*;
import java.util.*;
class Search_An_Element_In_A_Sorted_and_Rotated_Array_II
{
  public static void main (String args[])
  {
      int nums[]={4,5,6,7,0,1,2};
      int key=0;
      System.out.println(search(nums,key));
    }
    static boolean search(int[] nums, int target) {
        
        int low=0;
        int high=nums.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[mid]==target)
                return true;
            if(nums[mid]==nums[low] && nums[mid]==nums[high]) // cannot determine if part of left sorted or right sorted
            {
                high--;
                low++;
            }
             else if(nums[mid]>=nums[low])// left sorted part
            {
                if(target>=nums[low] && target<nums[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else if (nums[mid]<nums[low])// right sorted part
            {
                if(target>nums[mid] && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
            
        }
        
        return false;
    }
}
