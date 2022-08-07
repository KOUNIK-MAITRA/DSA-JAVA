import java.io.*;
import java.util.*;
class Count_Partitions_With_Given_Difference_Tabulation
{
  public static void main(String args[])
  {
     int[] arr={5,2,6,4};
     int n=4;
     int d=3;
     System.out.println(countPartitions(n,d,arr));
  } 
  public static int countPartitions(int n, int d, int[] arr)
   {
	int sum=0;
	int mod=(int)(1e9+7);
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
       
        
        // if arr[0]==0 and the target==0 then there are 2 ways pick or not pick 
        //you will get your get if you pick 0 or not pick 0 
        //because target=target(0 not pick)
        // and target=target+0 (0 pick)
        if(arr[0]==0)
         dp[0][0]=2; 
        else 
        // arr[0] not equal to 0 but target=0 therefore only 1 way not pick
         dp[0][0]=1;
         
        // if target not equal to 0
        // then at index 0 only way if arr[0]=target hence dp[0][arr[0]=1;
        if(arr[0]!=0 && arr[0]<=target)
         dp[0][arr[0]]=1;
        
        for(int index=1;index<n;index++){
         for(int currTarget=0;currTarget<=target;currTarget++){
           int notPick=dp[index-1][currTarget];
           int pick=0;
           if(arr[index]<=currTarget)
           {
            pick=dp[index-1][currTarget-arr[index]];
           }
           
           dp[index][currTarget]=(pick+notPick)%mod;
            }
            
        }  
         
        return dp[n-1][target];
  }
}
