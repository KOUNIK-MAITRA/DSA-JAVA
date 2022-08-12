import java.io.*;
import java.util.*;
 class Longest_Increasing_Subsequence_Tabulation_II
{
    public static void main(String args[]){
        int nums[]={0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
       }
    static int lengthOfLIS(int nums[]){
        int n=nums.length;
        int dp[]=new int [n];//dp[i] stores the length of LIS ending with the number nums[i]
        
        Arrays.fill(dp,1); //each number can form a LIS of length 1 i.e itself
        
        for(int i=0;i<n;i++){
         int curr=i;
         // check for the prev elements before the curr elements
         for(int prev=0;prev<i;prev++){
            if(nums[prev]<nums[curr]) // if a prev element is smaller than curr elemnent
             dp[curr]=Math.max(dp[curr],1+dp[prev]); 
            }
        }
        
        int maxLengthLIS=0;
        for(int ele : dp)
         maxLengthLIS=Math.max(maxLengthLIS,ele);
        
         return maxLengthLIS;
     }

}
