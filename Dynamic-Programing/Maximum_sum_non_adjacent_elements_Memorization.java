import java.io.*;
import java.util.*;
class Maximum_sum_non_adjacent_elements_Memorization
{
    public static void main(String args[])
    {
        int nums[]={1, 2, 3, 1, 3, 5, 8, 1, 9};
       
        System.out.println(Maximum_sum_non_adjacent_elements(nums));
    }
    public static int Maximum_sum_non_adjacent_elements (int nums[])
    {
        int n=nums.length;
        int dp[]=new int [n];
        Arrays.fill(dp,-1);
        return maxSum(nums,n-1,dp);
    }
    public static int maxSum(int nums[],int index,int dp[])
    { 
       if (index==0)
        return nums[index];
       if(index<0)
        return 0;
       
       if(dp[index]!=-1)
       return dp[index];
       
       int pick=nums[index]+maxSum(nums,index-2,dp);
       int notPick=0+maxSum(nums,index-1,dp);
       
       return Math.max(pick,notPick);
    }
}