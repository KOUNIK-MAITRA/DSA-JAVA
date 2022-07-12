import java.io.*;
import java.util.*; 
class Search_an_element_in_an_Infinite_Sorted_array
{
    public static void main (String args[])
    {
        int [] nums={1,3,8,7,12,58,72,80,96,100,110,125,150};
        int key=58;
        System.out.println(searchInfinite(nums,key));
    }
    static boolean searchInfinite(int []nums,int key)
    {
        int low=0;
        int high=1;
        
        while(nums[high]<key)
        {
            low=high;
            high=2*high;
        }
        
        return binarySearch(nums,low,high,key);
    }
    
    static boolean binarySearch(int[] nums, int low, int high, int key)
    {
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==key)
             return true;
             else if(key<nums[mid])
             { high=mid-1;
                }
             else
             { low=mid+1;
                }
        }
        return false;
    }
}
