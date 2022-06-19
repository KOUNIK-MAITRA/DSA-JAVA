import java.io.*;
import java.util.*;
class ClimbingStairs
{
    public static void main(String args[])
    {
        int n=3;
        System.out.println(noOfWays(n));
    }
    public static int noOfWays(int n)
    { 
        if(n<=2)
        {return n;
        }
        int prev2=1;
        int prev1=2;
        int ans=0;
        for(int i=3;i<=n;i++)
        {
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
        }
        return ans;
    }
}