import java.io.*;
import java.util.*;
class Number_Of_Subsets_with_sum_Target_Memorization
{
    public static void main(String args[]){
        int nums[]={1, 2, 2, 3};
        int target=3;
        System.out.println(findWays(nums,target));
    }
    static int findWays(int nums[], int target) {
        int n=nums.length;
        int dp[][]=new int[n][target+1];
        for(int []arr:dp)
         Arrays.fill(arr,-1);
        return countWays(nums,n-1,target,dp);
    }
    
    static int countWays(int nums[],int index,int target,int [][]dp){
        if(target==0)
            return 1;
        
         if(index==0)
        {
            if(nums[0]==target)
                return 1;
            else
                return 0;
        }
        
        if(dp[index][target]!=-1)
          return dp[index][target];
          
        int notPick=countWays(nums,index-1,target,dp);
        int pick=0;
        
        if(nums[index]<=target)
           pick=countWays(nums,index-1,target-nums[index],dp);
        
        return dp[index][target]=pick+notPick;
    }
}
