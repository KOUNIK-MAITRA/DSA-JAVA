import java.io.*;
import java.util.*;
class Maximum_sum_non_adjacent_elements_Tabulation
{
    public static void main(String args[])
    {
        int nums[]={1, 2, 3, 1, 3, 5, 8, 1, 9};
       
        System.out.println(maxSum(nums,nums.length));
    }
    
    public static int maxSum(int nums[],int n)
     {  int dp[]=new int[n];
        dp[0]=nums[0];
        
        for(int i=1;i<n;i++)
        {  int pick=nums[i];
            if(i>1)
             pick+=dp[i-2];
           
           int notPick=0+dp[i-1];
           dp[i]=Math.max(pick,notPick);
        }
         return dp[n-1];
    }
}