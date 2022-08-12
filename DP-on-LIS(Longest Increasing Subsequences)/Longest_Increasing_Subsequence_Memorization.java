import java.io.*;
import java.util.*;
 class Longest_Increasing_Subsequence_Memorization
{
    public static void main(String args[]){
        int nums[]={0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
     }
    static int lengthOfLIS(int nums[]){
     int n=nums.length;
     int dp[][]=new int[n][n+1];
     for(int[] arr:dp)
      Arrays.fill(arr,-1);
      
     return maxLength(0,-1,n,nums,dp);
    }
    static int maxLength(int index, int prev,int n,int[] nums,int[][]dp){
        
        if(index==n)
         return 0;
         
        if(dp[index][prev+1]!=-1)
         return dp[index][prev+1];
         
        int notTake=0+maxLength(index+1,prev,n,nums,dp);
        int take=0;
        if(prev==-1 || nums[prev]<nums[index])
          take=1+maxLength(index+1,index,n,nums,dp);
          
          return dp[index][prev+1]=Math.max(notTake,take);
    }
}
