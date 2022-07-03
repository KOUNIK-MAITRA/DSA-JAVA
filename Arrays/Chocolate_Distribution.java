import java.io.*;
import java.util.*;
 class Chocolate_Distribution
{
 public static void main (String args[])
 { 
     int arr[]={3, 4, 1, 9, 56, 7, 9, 12};
     int n=arr.length;
     int m=5;
     System.out.println(findMinDiff(arr,n,m));
    }
    
 public   static int findMinDiff(int arr[], int n, int m)
 {
     if(n==0||m==0)
     return 0;
     if(n<m)
     return -1;
     Arrays.sort(arr);
     int minDiff=Integer.MAX_VALUE;
     
     for(int i=0;i+m-1<n;i++)
     { int curr_minCandy=arr[i];
         int curr_maxCandy=arr[i+m-1];
         
         minDiff=Math.min(minDiff,curr_maxCandy-curr_minCandy);
         
        }
     return minDiff;
    }
}
