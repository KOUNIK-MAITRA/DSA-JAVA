import java.io.*;
import java.util.*;
class Number_of_Dice_Rolls_With_Target_Sum_Memorization
{
  public static void main(String args[]){
      int n=2;
      int k=6;
      int target=7;
      System.out.println(numRollsToTarget(n,k,target));
  }
  static int numRollsToTarget(int n, int k, int target) {
        int mod=(int)(1e9+7);
        int [][]dp=new int[n+1][target+1];
        for(int[] arr : dp) 
         Arrays.fill(arr,-1);
        return possibleWays(n,k,target,mod,dp);
    }  
  static int possibleWays(int dice,int faces,int target,int mod,int[][]dp){
        
        if(target<0)
         return 0;
        if(dice==0 && target!=0)
         return 0;
        if(dice==0 && target==0)
         return 1;
        if(dp[dice][target]!=-1) 
         return dp[dice][target];
        int count=0;
        for(int i=1;i<=faces;i++)
          count=(count+possibleWays(dice-1,faces,target-i,mod,dp))%mod;
        
        return dp[dice][target]=count;
    }
}
