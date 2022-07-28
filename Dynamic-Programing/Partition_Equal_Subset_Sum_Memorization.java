import java.io.*;
import java.util.*;
 class Partition_Equal_Subset_Sum_Memorization
{
  public static void main(String args[]){
     int arr[] = {3,3,3,4,5};
     int n=arr.length;
     
     System.out.println(canPartition(arr));
   }
   static boolean canPartition(int[] arr) {
    int sum=0;
    int n=arr.length;
    for(int i=0; i<n;i++){
        sum+= arr[i];
    }
    if(sum%2==1)
     return false;
    
    int target=sum/2;
    int dp[][]=new int [n][target+1];
     for(int []a:dp)
     { Arrays.fill(a,-1);
        }
    return subsetSumToK(n-1,arr,target,dp);
  } 
   static boolean subsetSumToK(int indx, int arr[], int k,int[][]dp){ 
       if(k==0)
        return true;
       
       if(indx==0)
       { return (arr[indx]==k);
        }
       
       if(dp[indx][k]==1)
       return true;
        
       if(dp[indx][k]==0)
       return false;
       
       boolean notTake= subsetSumToK(indx-1,arr,k,dp);
       boolean take=false;
        if(arr[indx]<=k)
       { take=subsetSumToK(indx-1,arr,k-arr[indx],dp);
        }
       
       if((take)||(notTake))
           dp[indx][k]=1;
        else
            dp[indx][k]=0;
       
            return (take)||(notTake);
   }
}
