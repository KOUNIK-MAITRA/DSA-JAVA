import java.io.*;
import java.util.*;
class Trapping_Rain_Water
{
    public static void main (String args[])
    {
        int heights[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    static int trap(int[] height) {
        int res=0;
        int n=height.length;
        int left =0;
        int right=n-1;
        int leftMax=0;
        int rightMax=0;
        while(left <= right)
        {
            if(height[left]<=height[right])
            {
                if(height[left]>=leftMax)
                    leftMax=height[left];
                else 
                    res+=leftMax-height[left];
                left++;
            }

            else
            {
                if(height[right]>=rightMax)
                    rightMax=height[right];
                else
                    res+=rightMax-height[right];
                right--;
            }
        }
        return res;
    }
}
