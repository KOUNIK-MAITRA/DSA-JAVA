import java.io.*;
import java.util.*;
 class SubSet_Equal_to_K_SpaceOptimization
{
  public static void main(String args[])
   { int arr[]={1,2,3,6};
     int n=arr.length;
     int k=7;
     System.out.println(subsetSumToK(n,arr,k));
    }
   static boolean subsetSumToK(int n, int arr[], int k){ 
    
       boolean prev[]=new boolean[k+1]; 
     
       prev[0]=true;
      
       if(arr[0]<=k)
         prev[arr[0]]=true; // if the target is equal to the value at arr[0]
        
       for(int ind=1;ind<n;ind++)
       {   boolean curr[]=new boolean[k+1]; 
            curr[0]=true;
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
