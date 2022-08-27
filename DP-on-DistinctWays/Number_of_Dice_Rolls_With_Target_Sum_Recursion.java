import java.io.*;
import java.util.*;
class Number_of_Dice_Rolls_With_Target_Sum_Recursion
{
  public static void main(String args[]){
      int n=2;
      int k=6;
      int target=7;
      System.out.println(numRollsToTarget(n,k,target));
  }
  static int numRollsToTarget(int n, int k, int target) {
        int mod=(int)(1e9+7);
        return possibleWays(n,k,target,mod);
    }  
  static int possibleWays(int dice,int faces,int target,int mod){
        
        if(target<0) 
         return 0;
        if(dice==0 && target!=0)
         return 0;
        if(dice==0 && target==0)
         return 1;
        
        int count=0;
        for(int i=1;i<=faces;i++)
          count=(count+possibleWays(dice-1,faces,target-i,mod))%mod;
        
        return count;
    }
}
