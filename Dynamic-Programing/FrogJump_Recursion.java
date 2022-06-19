import java.io.*;
import java.util.*;
class FrogJump_Recursion
{
    public static void main(String args[])
    {
        int n=5;
        int []heights={10, 30, 40, 50, 20 };
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