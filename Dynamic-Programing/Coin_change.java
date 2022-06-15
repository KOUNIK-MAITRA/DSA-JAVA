import java.util.*;
import java.io.*;
class Coin_change
{ 
    static int minCoins(int n, int a[],int dp[])
    {
        if(n==0) 
          return 0;
         int ans=Integer.MAX_VALUE;
          
        for(int i=0;i<a.length;i++)
        {
            if (n-a[i]>=0) // if the denomination is less than the amount
            { int subAns=0; // ans for sub problem
                
               if(dp[n-a[i]]!=-1) // check if the ans to the sub problem already exists in the memory
                  subAns=dp[n-a[i]];
                 else
                  subAns=minCoins(n-a[i],a,dp); // if ans is not present then find the ans using a recursive call
               
               if(subAns!=Integer.MAX_VALUE && subAns+1<ans)
                 ans=subAns+1; //update the ans , +1 for the current coin we are using
                  
            }
        }
        dp[n]=ans;//store the ans to n coin problem in the nth index
        return ans;        
    }
    public static void main(String args[])
    {
        int n=18;
        int a[]={7,5,1};
        
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        
        System.out.println("minimum no.of coins to make Rs"+n+" is "+minCoins(n,a,dp));
    }
}