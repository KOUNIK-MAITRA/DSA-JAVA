import java.io.*;
import java.util.*;
class Matrix_Chain_Multiplication_Recursion
{
   public static void main(String args[]){
    int arr[]={10,20,30,40,50};
    int n= arr.length;
    System.out.println(MCM(arr,n));
    }
   static int MCM(int[] arr,int n){
       return minSteps(1,n-1,arr);
    }
   static int minSteps(int i, int j , int []arr){
       if(i==j)// i.e there is only matrix 
        return 0;
        int steps=Integer.MAX_VALUE;
       //run a loop for all possible partitions
       for(int k=i;k<j;k++){
           // possible partions are i-->k and k+1-->j
           // no.of steps to multiply the matrixes from i to j = arr(i-1)xarr(k)xarr(j)
           // since they will from matrixes of dimensions arr(i-1) X arr(k) and arr(k) X arr(j)
           int currSteps=(arr[i-1]*arr[k]*arr[j])+minSteps(i,k,arr)+minSteps(k+1,j,arr);
           steps=Math.min(steps,currSteps);
        }
        return steps;
    } 
}
