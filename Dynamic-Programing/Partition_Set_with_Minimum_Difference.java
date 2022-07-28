import java.io.*;
import java.util.*;
class Partition_Set_with_Minimum_Difference
{
   public static void main(String args[]){
    int nums[]={8, 6, 5};
    System.out.println(minimumDifference(nums));
    }
   static int minimumDifference(int[] nums) {
        int totalSum=0;
        int n=nums.length;
        for(int ele : nums){
            totalSum+=ele;
        }
        
        int target=totalSum;
        boolean dp[][]=new boolean[n][target+1];
        
        for(int i=0;i<n;i++)
            dp[i][0]=true;
        
        if(nums[0]<=target)
        dp[0][target]=true;
        
        for(int index=1;index<n;index++)
        {
            for(int k=1;k<=target;k++)
            {
                boolean notTake=dp[index-1][k];
                boolean take=false;
                if(nums[index]<=k)
                take=dp[index-1][k-nums[index]];
                
                dp[index][k]=take || notTake;
            }
        }
        
        int min=(int)(1e9);
        for(int sum1=0;sum1<=totalSum;sum1++){
            if(dp[n-1][sum1])
            {
                int sum2=totalSum-sum1;
                min=Math.min(min,Math.abs(sum1-sum2));
            }
        }
        
        return min;
    }
}
