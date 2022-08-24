import java.io.*;
import java.util.*;
 class BurstBalloons_Tabulation
{
    public static void main(String args[]){
      int nums[]={3,1,5,8};  
      System.out.println(maxCoins(nums));
     }
    static int maxCoins(int[] nums) {
     int n=nums.length;
     
     int balloons[]=new int[n+2];
     balloons[0]=1; balloons[balloons.length-1]=1;
     
     for(int i=0;i<n;i++)
     balloons[i+1]=nums[i];
        
     int dp[][]=new int [n+2][n+2];
        
     for(int left=n;left>=1;left--){
       for(int right=1;right<=n;right++){
         
           if(left>right) continue;
           int maxCoins=Integer.MIN_VALUE;
       
        for(int i=left;i<=right;i++){
            int currCoins=balloons[left-1]*balloons[i]*balloons[right+1];
            int coinsLeft=dp[left][i-1];
            int coinsRight=dp[i+1][right];
            maxCoins=Math.max(maxCoins,currCoins+coinsLeft+coinsRight);
        }
         dp[left][right]=maxCoins;  
       }  
     } 
        
     
     return dp[1][n];   
    }
    
}
