import java.io.*;
import java.util.*;
class FrogJump_Recursion
{
    public static void main(String args[])
    {
        int n=8;
        int []heights={7, 4, 4, 2, 6, 6, 3, 4 };
        System.out.println(minimumEnergy(n-1,heights));
    }
    public static int minimumEnergy(int n,int heights[])
    {
        if(n==0)
         return 0;
        int twoStepJump=Integer.MAX_VALUE;
        int oneStepJump=Math.abs(heights[n]-heights[n-1])+minimumEnergy(n-1,heights);
        if(n!=1)
        {
            twoStepJump=Math.abs(heights[n]-heights[n-2])+minimumEnergy(n-2,heights);
        }
        
        return Math.min(oneStepJump,twoStepJump);
    }
}