import java.io.*;
import java.util.*;
class Matrix_Chain_Multiplication_Tabulation
{
   public static void main(String args[]){
    int arr[]={10,20,30,40,50};
    int n= arr.length;
    System.out.println(MCM(arr,n));
     }
   static int MCM(int[] arr,int n){
       int dp[][]=new int[n][n];
       for(int i=0;i<n;i++)
         dp[i][i]=0;
       
       for(int i=n-1;i>=1;i--)
       {
          for(int j=i+1;j<n;j++)
          {
              int steps=Integer.MAX_VALUE;
               for(int k=i;k<j;k++){
               int currSteps=(arr[i-1]*arr[k]*arr[j])+dp[i][k]+dp[k+1][j];
               steps=Math.min(steps,currSteps);
              }
                dp[i][j]= steps;
         }
        }  
         
       return dp[1][n-1];
    }
   
}
