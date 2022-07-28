import java.io.*;
import java.util.*;
class Number_Of_Subsets_with_sum_Target_Tabulation
{
    public static void main(String args[]){
        int nums[]={12,1,3};
        int target=4;
        System.out.println(countWays(nums,nums.length,target));
    }
   
    
    static int countWays(int nums[],int n,int target){
      int dp[][]=new int[n][target+1];
      for(int i=0;i<n;i++){
        dp[i][0]=1;
        }
        
      if(nums[0]<=target){
         dp[0][nums[0]]=1;
        }
        
      for(int index=1;index<n;index++){
       for(int currTarget=1;currTarget<=target;currTarget++){
          int notPick=dp[index-1][currTarget];
          int pick=0;
          if(nums[index]<=currTarget)
          { pick=dp[index-1][currTarget-nums[index]];
            }
          
          dp[index][currTarget]=pick+notPick;
        }
        }
      return dp[n-1][target];
    }
}
