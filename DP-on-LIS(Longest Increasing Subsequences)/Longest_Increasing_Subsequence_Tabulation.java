import java.io.*;
import java.util.*;
 class Longest_Increasing_Subsequence_Tabulation
{
    public static void main(String args[]){
        int nums[]={0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
      }
    static int lengthOfLIS(int nums[]){
     int n=nums.length;
     int dp[][]=new int[n+1][n+1];
     
     for(int index=n-1;index>=0;index--){
      for(int prev=index-1;prev>=-1;prev--){
        int notTake=0+dp[index+1][prev+1];
        int take=0;
        if(prev==-1 || nums[prev]<nums[index])
          take=1+dp[index+1][index+1];
          
           dp[index][prev+1]=Math.max(notTake,take);
        }
        }
      
     return dp[0][0];
    }

}
