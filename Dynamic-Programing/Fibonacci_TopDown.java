import java.util.*;
 class Fibonacci_TopDown
{
    public static void main (String args[])
    {
         int n=4;
         int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(n,dp));
    }
    public static int fib(int n,int dp[])
    { 
       
        if(n<=1)
        return dp[n]= n;
        else 
         { if (dp[n]!=-1)
             return dp[n];
             else
             return dp[n]=fib(n-1,dp)+fib(n-2,dp);
            }
     }
}
