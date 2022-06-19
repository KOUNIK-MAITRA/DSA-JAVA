import java.io.*;
import java.util.*;
 class FrogJump_K_Distance_Recursion
{
    public static void main (String args[])
    {
        int heights[]={10,30,40,50,20};
        int n=heights.length;
        int k=3;
        System.out.println(minimumEnergy(n-1,heights,k));
    }
    
    public static int minimumEnergy(int n, int heights[],int k)
    {
        if(n==0)
         return 0;
        
       
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        { int jump=Integer.MAX_VALUE;
          if(n-i>=0)
          { jump=Math.abs(heights[n]-heights[n-i])+minimumEnergy(n-i,heights,k);
            ans=Math.min(jump,ans);  
            }
        }
        return ans;
    }
}
