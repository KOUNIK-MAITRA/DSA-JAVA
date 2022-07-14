import java.io.*;
import java.util.*;
 class FirstAndLastOcurrence
{
   public static void main(String args[])
   { int nums[]={5,7,7,8,8,10}; int target = 8;
     System.out.println(Arrays.toString(searchRange(nums,target)));
    }
     static int[] searchRange(int[] nums, int target) {
   
     int first=firstOccurence (nums,target);
     int second=lastOccurence(nums,target);
     int ans[]=new int[2];
     ans[0]=first;
     ans[1]=second;
     
     return ans;
    
    }
    
    static int firstOccurence (int[] nums, int target)
    {
       int start=0;
       int end=nums.length-1;
       int ans=-1;
        while(start<=end)
        {
          int mid=start+(end-start)/2;
          if  (nums[mid]==target){
              ans=mid;
              end=mid-1;
          }
            else if(nums[mid]>target){
                end=mid-1;                
            }
            else{
                start=mid+1;
            }
        }
        
        return ans;
    }
    
    static int lastOccurence (int[] nums, int target)
     {
       int start=0;
       int end=nums.length-1;
       int ans=-1;
        while(start<=end)
        {
          int mid=start+(end-start)/2;
          if  (nums[mid]==target){
              ans=mid;
              start=mid+1;
          }
            else if(nums[mid]>target){
                end=mid-1;                
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}
