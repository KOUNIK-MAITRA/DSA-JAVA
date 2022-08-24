import java.io.*;
import java.util.*;
 class BurstBalloons_Memorization
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
        
     int dp[][]=new int [n+1][n+1];
     for(int arr[]:dp) Arrays.fill(arr,-1);   
        
     int left=1; int right=n;
     return maxCoins(left,right,balloons,dp);   
    }
    
    static int maxCoins(int left, int right, int[]balloons,int[][]dp){
       
        if(left>right) return 0;
       
        if(dp[left][right]!=-1) return dp[left][right];
        
        int maxCoins=Integer.MIN_VALUE;
       
        for(int i=left;i<=right;i++){
            int currCoins=balloons[left-1]*balloons[i]*balloons[right+1];
            int coinsLeft=maxCoins(left,i-1,balloons,dp);
            int coinsRight=maxCoins(i+1,right,balloons,dp);
            maxCoins=Math.max(maxCoins,currCoins+coinsLeft+coinsRight);
        }
        return dp[left][right]=maxCoins;
    }
}
