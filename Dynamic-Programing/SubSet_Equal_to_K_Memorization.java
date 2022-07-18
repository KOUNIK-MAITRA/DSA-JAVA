import java.io.*;
import java.util.*;
 class SubSet_Equal_to_K_Memorization
{
   public static void main(String args[])
   { int arr[]={1,2,3,6};
     int n=arr.length;
     int k=15;
     int dp[][]=new int [n][k+1];
     for(int []a:dp)
     { Arrays.fill(a,-1);
        }
     System.out.println(subsetSumToK(n-1,arr,k,dp));
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
