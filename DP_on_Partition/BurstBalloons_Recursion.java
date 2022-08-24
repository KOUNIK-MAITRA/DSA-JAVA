import java.io.*;
import java.util.*;
 class BurstBalloons_Recursion
{
    public static void main(String args[]){
      int nums[]={3,1,5,8};  
      System.out.println(maxCoins(nums));
    }
    static int maxCoins(int[] nums){
      int n=nums.length;
      int[] balloons=new int[n+2];
      balloons[0]=1;
      balloons[balloons.length-1]=1;
      for(int i=0;i<n;i++)
       balloons[i+1]=nums[i];
      int left=1; int right=n; 
      return maxCoins(left,right,balloons);  
    }
    static int maxCoins(int left, int right, int[] balloons){
     if(left>right)
      return 0;
     int max=Integer.MIN_VALUE;
     for(int i=left;i<=right;i++){
      int currPoints=balloons[left-1]*balloons[i]*balloons[right+1];
      int coinsLeft=maxCoins(left,i-1,balloons);
      int coinsRight=maxCoins(i+1,right,balloons);
      max=Math.max(max,currPoints+coinsLeft+coinsRight);
     }
     return max;
    }
}
