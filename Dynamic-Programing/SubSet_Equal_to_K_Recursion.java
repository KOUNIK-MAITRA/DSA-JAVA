import java.io.*;
import java.util.*;
 class SubSet_Equal_to_K_Recursion
{
  public static void main(String args[])
   { int arr[]={1,2,3,6};
     int n=arr.length;
     int k=15;
     System.out.println(subsetSumToK(n-1,arr,k));
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
