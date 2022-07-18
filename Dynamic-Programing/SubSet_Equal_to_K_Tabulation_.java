import java.io.*;
import java.util.*;
 class SubSet_Equal_to_K_Tabulation_
{
  public static void main(String args[])
   { int arr[]={1,2,3,6};
     int n=arr.length;
     int k=5;
     System.out.println(subsetSumToK(n,arr,k));
    }
   static boolean subsetSumToK(int n, int arr[], int k){ 
    
       boolean dp[][]=new boolean[n][k+1]; 
       for(int i=0;i<n;i++)
       { dp[i][0]=true;
        }
       dp[0][arr[0]]=true; // if the target is equal to the value at arr[0]
        
       for(int ind=1;ind<n;ind++)
       {
           for(int target=1;target<=k;target++)
           {
               boolean notTake=dp[ind-1][target];
               boolean take=false;
               if(arr[ind]<=target)
               { take=dp[ind-1][target-arr[ind]];
                }
               
                dp[ind][target]=notTake||take;
            }
        }
        return dp[n-1][k];
        
  }
}
