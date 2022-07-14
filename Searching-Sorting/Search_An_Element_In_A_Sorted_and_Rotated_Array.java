import java.io.*;
import java.util.*;
class Search_An_Element_In_A_Sorted_and_Rotated_Array
{
  public static void main (String args[])
  {
      int nums[]={4,5,6,7,0,1,2};
      int key=0;
      System.out.println(search(nums,key));
    }
  static int search(int nums[],int key)
  {
      int low=0;
      int  high=nums.length-1;
      
      while(low<=high)
      {
          int mid=(low+high)/2;
          if(nums[mid]==key)
           return mid;
          
          //left half is sorted
          if(nums[low]<nums[mid])
         { 
           if(key>=nums[low] && key<nums[mid])
              high=mid-1; 
             else
              low=mid+1; 
                }
          // right half is sorted  
          else
          { if(key>nums[mid] && key<=nums[high])
              low=mid+1;
            else
             high=mid-1;
            }  
        }
      return -1;
    }
}
