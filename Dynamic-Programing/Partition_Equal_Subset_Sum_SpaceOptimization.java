import java.io.*;
import java.util.*;
class Partition_Equal_Subset_Sum_SpaceOptimization
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
   static boolean subsetSumToK(int n, int arr[], int k){ 
       boolean prev[]=new boolean[k+1]; 
       boolean curr[]=new boolean [k+1];
       prev[0]=true;
       if(arr[0]<=k)
        prev[arr[0]]=true; // if the target is equal to the value at arr[0]
        
       for(int ind=1;ind<n;ind++)
       {
           for(int target=1;target<=k;target++)
           {
               boolean notTake=prev[target];
               boolean take=false;
               if(arr[ind]<=target)
               { take=prev[target-arr[ind]];
                }
               
               curr[target]=notTake||take;
            }
            prev=curr;
        }
        return prev[k];
        
  }
}
