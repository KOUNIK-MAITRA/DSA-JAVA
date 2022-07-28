import java.io.*;
import java.util.*;
 class Partition_Equal_Subset_Sum_Recursion
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
    return subsetSumToK(n-1,arr,target);
  } 
   static boolean subsetSumToK(int indx, int arr[], int k){ 
       if(k==0)
        return true;
       
       if(indx==0)
       { return (arr[indx]==k);
        }
       
       boolean notTake= subsetSumToK(indx-1,arr,k);
       boolean take=false;
       if(arr[indx]<=k)
       { take=subsetSumToK(indx-1,arr,k-arr[indx]);
        }
       
        return (take)||(notTake);
  }
}
