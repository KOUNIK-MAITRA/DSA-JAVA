import java.io.*;
import java.util.*;
class Find_Minimum_In_a_Sorted_Rotated_Array_II
{
    public static void main(String args[])
    {
        int nums[]={3,3,4,5,1,2,3,3};
        System.out.println(findMin(nums));
    }
    static int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
                
        while(low<high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[mid]>nums[high]) // pivot/min element is the right half
                low=mid+1;
            else if(nums[mid]<nums[high])// pivot/min element is the left half
                high=mid;
            else
             high--;
        }
        return nums[low];
     }
}
