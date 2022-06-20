import java.io.*;
import java.util.*;
class Maximum_sum_non_adjacent_elements_SpaceOptimization
{
    public static void main(String args[])
    {
        int nums[]={2,7,9,3,1};
        int n=nums.length;
        System.out.println(maxSum(nums,n));
    }
   
    public static int maxSum(int nums[],int n)
    { 
       int prev=nums[0],prev2=0;
       for(int i=1;i<n;i++)
       {   
           int take=nums[i];
           if(i>1)
            take=take+prev2;
           int notTake=0+prev;
           int curr=Math.max(take,notTake);
           prev2=prev;
           prev=curr;
        }
        return prev;
    }
}