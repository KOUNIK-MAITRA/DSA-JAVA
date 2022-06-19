import java.io.*;
import java.util.*;
class FrogJump_SpaceOptimized
{
    public static void main(String args[])
    {
        int n=8;
        int []heights={7, 4, 4, 2, 6, 6, 3, 4 };
       
        System.out.println(minimumEnergy(n-1,heights));
    }
    public static int minimumEnergy(int n,int heights[])
    {
       
        int ans=0;
        int prev=0;
        int prev2=0;
        for(int i=1;i<=n;i++)
         {
             int oneJump=prev+Math.abs(heights[i]-heights[i-1]);
             int twoJump=Integer.MAX_VALUE;
             if(i>1)
               twoJump=prev2+Math.abs(heights[i]-heights[i-2]);
            
             ans=Math.min(oneJump,twoJump);
             prev2=prev;
             prev =ans;
        }
        return ans;
    }
} 