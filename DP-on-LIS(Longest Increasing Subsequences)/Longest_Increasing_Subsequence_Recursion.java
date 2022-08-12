import java.io.*;
import java.util.*;
 class Longest_Increasing_Subsequence_Recursion
{
    public static void main(String args[]){
        int nums[]={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    static int lengthOfLIS(int nums[]){
     int n=nums.length;
     return maxLength(0,-1,n,nums);
    }
    static int maxLength(int index, int prev,int n,int[] nums){
        
        if(index==n)
        return 0;
        
        int notTake=0+maxLength(index+1,prev,n,nums);
        int take=0;
        if(prev==-1 || nums[prev]<nums[index])
          take=1+maxLength(index+1,index,n,nums);
          
          return Math.max(notTake,take);
    }
}
