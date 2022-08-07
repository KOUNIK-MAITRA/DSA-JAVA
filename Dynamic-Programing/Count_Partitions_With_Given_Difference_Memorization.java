import java.io.*;
import java.util.*;
class Count_Partitions_With_Given_Difference_Memorization
{
  public static void main(String args[])
  {
     int[] arr={5,2,5,1};
     int n=4;
     int d=3;
     System.out.println(countPartitions(n,d,arr));
  } 
  public static int countPartitions(int n, int d, int[] arr)
   {
	int sum=0; 
        for(int ele: arr){
            sum+=ele;
        }
        //s1+s2=sum
        //s1-s2=d
        //sum-s2-s2=d
        //sum-2s2=d
        //(sum-d)/2=s2
        // there fore s2 must be even, s2 must be greater than 0
        if( (sum-d)<0 || (sum-d)%2!=0)
         return 0;
        int target= (sum-d)/2;
        int [][]dp=new int[n][target+1];
        for(int a[]:dp)
         Arrays.fill(a,-1);
        return count(n-1,arr,target,dp);
  }
  static int count(int index,int[] arr,int target,int[][]dp){
       
        if(index==0)
        {    
          if(target==0 && arr[0]==0)
             return 2;
          if(target==0 || target==arr[0])
               return 1;
            
            return 0;
        }
        if(dp[index][target]!=-1)
         return dp[index][target];
        
        int mod=(int)(1e9+7);
        int notPick=count(index-1,arr,target,dp);
        int pick=0;
        if(arr[index]<=target)
        {
            pick=count(index-1,arr,target-arr[index],dp);
        }
        
        return dp[index][target]=(pick+notPick)%mod;
    }
}
