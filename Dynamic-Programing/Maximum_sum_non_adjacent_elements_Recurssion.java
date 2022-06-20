import java.io.*;
import java.util.*;
class Maximum_sum_non_adjacent_elements_Recurssion
{
    public static void main(String args[])
    {
        int nums[]={1, 2, 3, 1, 3, 5, 8, 1, 9};
        int n=9;
        System.out.println(maxSum(nums,n-1));
    }
    
    public static int maxSum(int nums[],int index)
    { 
       if (index==0)
        return nums[index];
       if(index<0)
        return 0;
       
        int pick=nums[index]+maxSum(nums,index-2);
       int notPick=0+maxSum(nums,index-1);
       
       return Math.max(pick,notPick);
    }
}