import java.io.*;
import java.util.*;
class Number_of_Dice_Rolls_With_Target_Sum_Tabulation
{
  public static void main(String args[]){
      int n=2;
      int k=6;
      int target=7;
      System.out.println(numRollsToTarget(n,k,target));
  }
  static int numRollsToTarget(int n, int k, int target) 
  {
       
        int mod=(int)(1e9+7);
        int [][]dp=new int[n+1][target+1];
        dp[0][0]=1;
       
        for(int dice=1;dice<=n;dice++)
        {
            for(int sum=1;sum<=target;sum++)
            {
                int count=0;
                for(int face=1;face<=k;face++)
                {
                 if(sum-face>=0)
                 count=(count+dp[dice-1][sum-face])%mod;
                }

                dp[dice][sum]=count; 
            }
        } 
        return dp[n][target];
    } 
}
