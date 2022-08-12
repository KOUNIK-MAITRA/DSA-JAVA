import java.io.*;
import java.util.*;
 class Count_Longest_Increasing_Subsequences
{
  public static void main(String args[]){
      int nums[]={1,3,5,4,7};
      System.out.println(findNumberOfLIS(nums));
  }
  static int findNumberOfLIS(int[] nums) {
      int n=nums.length;
      int dp[]=new int[n];
      
      int count[]=new int[n];

        
        int LISlength=0;
        int ans=0;
        
        for(int curr=0;curr<n;curr++){
          dp[curr]=count[curr]=1;
            for(int prev=0;prev<curr;prev++){
            
            if(nums[prev]<nums[curr]){
               
            if(dp[prev]+1==dp[curr])
                 count[curr]+=count[prev];    
                
            if(dp[prev]+1>dp[curr]){
                   dp[curr]=dp[prev]+1;
                   count[curr]=count[prev];
               }
                              
            }
           }
            
            if(dp[curr]==LISlength)
                ans+=count[curr];
            
            if(dp[curr]>LISlength){
                LISlength=dp[curr];
                ans=count[curr];
            }
            
            
            
        }
        return ans;
    }
}
